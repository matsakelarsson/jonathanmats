//package symbolic;
import java.io.StreamTokenizer;
import java.io.IOException;

//Parsing är när man översätter en sträng med tecken och ger den någon sorts mening.i. e en sekvens med tecken med olika operatorer. + = addition, * = multiplikation osv.

public class Parser{
    StreamTokenizer st;

    public Parser(){
        st = new StreamTokenizer(System.in);
        st.ordinaryChar('-');
        st.ordinaryChar('/');
        st.eolIsSignificant(true);
    }

    public Sexpr expression() throws IOException{
        Sexpr sum = term();
        while(st.nextToken() == '+'){
            sum = new Addition(sum, term());
        }
        st.pushBack();
        
        while(st.nextToken() == '-'){
            sum = new Subtraction(sum, term());
        }
        st.pushBack();
  
        return sum;

    }


    private Sexpr term() throws IOException{
        Sexpr prod = factor();
        while(st.nextToken() == '*'){
            prod = new Multiplication(prod, factor());
        }
        st.pushBack();

        while(st.nextToken() == '/'){
            prod = new Division(prod, factor());
        }
        st.pushBack();
        return prod;
    }

    private Sexpr factor() throws IOException{
        Sexpr result;
        if(st.nextToken() != '('){
            st.pushBack();
            if(st.nextToken() == st.TT_WORD){
                result = unary();
            }
            else{
                st.pushBack();
                result = number();
            }
        }
       
        else{
            result = expression();
            if(st.nextToken() != ')'){
                throw new SyntaxErrorException("expected ')'");
            }
        }
        return result;
    }

    private Sexpr number() throws IOException{
        if(st.nextToken() != st.TT_NUMBER){
            st.pushBack();
            if(st.nextToken() != st.TT_EOL){
                throw new SyntaxErrorException("Expected number!");
            }
        }
        return new Constant(st.nval);
    }

    private Sexpr unary() throws IOException{
        switch(st.sval){
        case "cos": st.nextToken();
            System.out.println("cos: " + st.nval);
            return new Constant(Math.cos(st.nval));
        case "sin": st.nextToken();
            return new Constant(Math.sin(st.nval));
            
        case "log": st.nextToken();
            return new Constant(Math.log(st.nval));
            
        case "exp": st.nextToken();
            return new Constant(Math.exp(st.nval));            

        return new Constant(st.nval);

    }
}





class SyntaxErrorException extends RuntimeException{
    public SyntaxErrorException(){
        super();
    }
    public SyntaxErrorException(String msg){
        super(msg);
    }
}

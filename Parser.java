//package symbolic;
import java.io.StreamTokenizer;
import java.io.IOException;

//Parsing är när man översätter en sträng med tecken och ger den någon sorts mening.i. e en sekvens med tecken med olika operatorer. + = addition, * = multiplikation osv.

public class Parser{
	StreamTokenizer st;

	public Parser(){
		st = new StreamTokenizer(System.in);
		st.ordinaryChar('-');
		st.eolIsSignificant(true);
	}

	public Sexpr expression() throws IOException{
		Sexpr sum = term();
		st.nextToken();
		while (st.nextToken() == '+' || st.nextToken() == '-'){
			if(st.ttype == '+'){
				sum = new Addition(sum, term());
			}else{
				sum = new Subtraction(sum, term());
			}
			st.nextToken();
		}
		st.pushBack();
		return sum;
	}

	private Sexpr term() throws IOException{
		Sexpr prod = factor();
		while (st.ttype == '*' || st.ttype == '/'){
			if(st.ttype == '*'){
				prod = new Multiplication(prod, factor());
			}else{
				prod = new Division(prod, factor());
			}
		}
		st.pushBack();
		return prod;
	}

	private Sexpr factor() throws IOException{
		Sexpr result;
		if(st.nextToken() != '('){
			st.pushBack();
			result = number();
		}else{
			result = expression();
			if(st.nextToken() != ')'){
				throw new SyntaxErrorException("expected ')'");
			}
		}
		st.pushBack();
		return result;
	}

	private Sexpr number() throws IOException{
		if(st.nextToken() != st.TT_NUMBER){
			throw new SyntaxErrorException("Expected number");
		}
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

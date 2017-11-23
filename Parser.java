import java.io.StreamTokenizer;
import java.io.IOException;

class Parser{
	StreamTokenizer st;

	public Parser(){
		st = new StreamTokenizer(System.in);
		st.ordinaryChar('-');
		st.eolIsSignificant(true);
	}

	public Sexpr expression() throws IOException{
		Sexpr sum = term();
		st.nextToken();
		while (st.ttype == '+' || st.ttype == '-'){
			int operation = st.ttype;
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
		while (st.nextToken() == '*' || st.nextToken() == '/'){
			if(st.ttype == '*'){
				sum = new Multiplication(sum, factor());
			}
			else{
				sum = new Division(sum, factor());
			}
			prod *= factor();
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
		return result;
	}

	private Sexpr number() throws IOException{
		if(st.nextToken() != st.TT_NUMBER){
			throw new SyntaxErrorException("Expected number");
		}
		return st.nval;
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

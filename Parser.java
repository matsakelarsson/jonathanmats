//package symbolic;
import java.io.*;

//Parsing är när man översätter en sträng med tecken och ger den någon sorts mening.i. e en sekvens med tecken med olika operatorer. + = addition, * = multiplikation osv.

public class Parser{
	StreamTokenizer st;

	public Parser(InputStream stream){
		st = new StreamTokenizer(stream);
		st.ordinaryChar('-');
		st.ordinaryChar('/');
		st.ordinaryChar('*');
		st.ordinaryChar('+');
		st.eolIsSignificant(true);
	}


	public Sexpr commands() throws IOException{
		st.nextToken();
		if (st.ttype == st.TT_WORD) {
			switch(st.sval) {
				case "ans":
					return new Variable("ans");
				case "vars":
					return new Vars();
				case "quit":
					return new Quit();
			}

		}
		st.pushBack();
		return assignment();
	}

	public Sexpr assignment() throws IOException{
		Sexpr ass = expression();
		st.nextToken();
		if (st.ttype == '=') {
			st.nextToken();
			if (st.ttype == st.TT_WORD && st.sval.length() == 1) {

				ass = new Assignment(ass, new Variable(st.sval));
			} else {
				throw new SyntaxErrorException ("Expected variable");
			}
		}

		return ass; 

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
		Sexpr result = null;
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
		if(st.nextToken() == st.TT_WORD) {
			st.pushBack();
			return variableUnary();
		}
		st.pushBack();
		if (st.nextToken() == '-') {
			if(st.nextToken() == '(') {
				st.pushBack();
				Sexpr argument = factor();
				return new Negation(argument);
			}
			st.pushBack();
			return new Negation(expression());
		}
		st.pushBack();


		if(st.nextToken() != st.TT_NUMBER){
			throw new SyntaxErrorException("Expected number");
		}

		return new Constant(st.nval);
	}


	private Sexpr variableUnary() throws IOException {
		if(st.nextToken() != st.TT_WORD && st.sval.length() != 3 && st.sval.length() != 1) {
			throw new SyntaxErrorException("Expected a variable or unirary expressio");
		}
		else if(st.sval.length() == 3) {
			switch(st.sval) {
				case "cos":
					return new Cos(factor());
				case "sin":
					return new Sin(factor());
				case "exp":
					return new Exp(factor());
				case "log":
					return new Log(factor());
				default:
					throw new SyntaxErrorException("Unknown expression");
			}

		}

		if(st.sval.length() == 1) {
			return new Variable(st.sval);
		}
		throw new SyntaxErrorException("Expected one character");

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

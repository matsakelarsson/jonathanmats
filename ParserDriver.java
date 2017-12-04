import java.io.IOException;

class ParserDriver{
	public static void main(String[] args){
		Parser p = new Parser();

		System.out.println("Welcome to the parser!");
		System.out.print("Please enter an expression: ");
		while (true)
			try{
				System.out.println("? ");
				Sexpr e = p.statement();
				System.out.println("Inläst uttryck: " + e);
				System.out.println(e.eval(variables));
			}catch(SyntaxErrorException e){
				System.out.print("Syntax Error: ");
				System.out.println(e.getMessage());
			}catch(IOException e){
				System.err.println("IO Exception!");
			}
	}
}

import java.util.*;
import java.io.IOException;

class ParserDriver{
	public static void main(String[] args){
		HashMap<String, Sexpr> variables = new HashMap<String, Sexpr>();


		System.out.println("Welcome to the parser!");
		System.out.print("Please enter an expression: ");
		while (true)
			try{
				Parser p = new Parser(System.in);
				System.out.print("\n? ");
				Sexpr e = p.commands();
				System.out.println("Inläst uttryck: " + e.toString());

				if(e.isQuit()){
					return;
				}
				else if (e.isVars()) {
					if(!variables.isEmpty()) {
						System.out.println(variables);
					}
					else {
						System.out.println("There are no stored variables");
					}
				}
				else{

				Sexpr evaluated = e.eval(variables);
				System.out.println(evaluated.toString());
				(new Assignment(evaluated, new Variable("ans"))).eval(variables);
				}
			}catch(SyntaxErrorException e){
				System.out.print("Syntax Error: ");
				System.out.println(e.getMessage());
			}catch(IOException e){
				System.err.println("IO Exception!");
			}
	}
}

import java.util.HashMap;

public class Sin extends Unary {
	public Sin (Sexpr arg) {	
		super(arg);
	}

	public String toString() {
		return "";
	}

	public String getName() {
		return "";
	}

	public Sexpr eval(HashMap<String, Sexpr> variables) {
		return Symbolic.sin(arg.eval(variables));
	}
}

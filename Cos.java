import java.util.HashMap;

public class Cos extends Unary {
	public Cos (Sexpr arg) {
		super(arg);
	}

	public String toString() {
		return "";
	}

	public String getName() {
		return "";
	}
	public Sexpr eval(HashMap<String, Sexpr> variables) {
		return Symbolic.cos(arg.eval(variables));
	}
}

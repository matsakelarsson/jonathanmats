import java.util.HashMap;

public class Negation extends Unary {
	public Negation (Sexpr arg) {
		super(arg);
	}

	public String toString() {
		return "";
	}

	public String getName() {
		return "";
	}

	public Sexpr eval(HashMap<String, Sexpr> variables) {
		return Symbolic.negation(arg.eval(variables));
	}
}

import java.util.HashMap;

public class Cos extends Unary {
	public Cos (Sexpr arg) {
		super(arg);
	}

	public Sexpr eval(HashMap<String, Sexpr> variables) {
		return Symbolic.cos(argument.eval(variables));
	}
}

import java.util.HashMap;

public class Log extends Unary {
	public Log (Sexpr arg) {
		super(arg);
	}

	public String toString() {
		return "";
	}

	public String getName() {
		return "";
	}

	public Sexpr eval(HashMap<String, Sexpr> variables) {
		return Symbolic.log(arg.eval(variables));
	}
}

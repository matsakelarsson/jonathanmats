import java.util.HashMap;

public class Exp extends Unary {
	public Exp(Sexpr arg) {
		super(arg);
	}

	public String getName() {
		return "";
	}

	public Sexpr eval(HashMap<String, Sexpr> variables) {
		return Symbolic.exp(arg.eval(varibles));
	}


}

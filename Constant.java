import java.util.*;

public class Constant extends Atom {
	private double value;

	public Constant(double variable) {
		this.value = variable;
	}

	public String getName() {
		return "";
	}

	public double getValue() {
		return this.value;
	}

	public Sexpr eval(HashMap<String, Sexpr> variables) {
		Sexpr result;
		return result;
	}

}

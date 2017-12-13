import java.util.*;

public class Constant extends Atom {
	private double value;

	public Constant(double variable) {
		this.value = variable;
	}

	public String getName() {
		return "" + this.value;
	}
	
	public double getValue() {
		return this.value;
	}

	public boolean isConstant() {
		return true;
	}

	public Sexpr eval(HashMap<String, Sexpr> variables) {
		return this;
	}

	

}

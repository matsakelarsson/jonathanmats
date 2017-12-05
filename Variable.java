import java.util.*;

public class Variable extends Atom {
	private String name;

	public Variable(String name) {
		this.name = name;
	}

	public boolean isConstant() {
		return false;
	}

	public String getName() {
		return name;
	}

	public Sexpr eval(HashMap<String, Sexpr> variables) {
		if (variables.containsKey(this.name)) {
			return variables.get(this.name);
		} else {
			return this;
		}
	}
}


import java.util.*;

public class Assignment extends Binary {
	public Assignment (Sexpr left, Sexpr right){	
		super(left, right);
	}

	public String getName() {
		return "";
	}

	public int priority() {
		return 0;
	}

	public Sexpr eval(HashMap<String, Sexpr> variables) {
		Sexpr assign = Symbolic.assignment(this.getLeft().eval(variables), this.getRight());
		String character = this.getRight().toString();
		if (variables.containsKey(character)) {
			variables.remove(character);
		}
		variables.put(this.getRight().toString(), this.getLeft().eval(variables));

		return assign; 
	}
}

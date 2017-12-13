import java.util.*;

public class Assignment extends Binary {
	public Assignment (Sexpr left, Variable right){	
		super(left, right);
	}

	public String getName() {
		return "=";
	}

	public int priority() {
		return 0;
	}



// param return: an Assignment Sexpr, where the left side is as evaluated as possible
// param variables: a Hashmap pf all varibles and assignment.
// Adds the assignment to map, or changes the value of a variable that is already part of the map.
//
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

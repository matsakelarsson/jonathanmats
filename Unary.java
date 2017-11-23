

package symbolic;

public abstract class Unary extends Sexpr {
	Sexpr argument;

	public Unary(sexpr a) {
		argument = a;
	}


	public String toString() {
		return getName() + "(" + argument.toString() + ")";
	}

	public priority() {

	}

}

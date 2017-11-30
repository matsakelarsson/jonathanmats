//package symbolic;
import java.util.*;

public abstract class Unary extends Sexpr {
	Sexpr argument;

	public Unary(Sexpr a) {
		this.argument = a;
	}


	public String toString() {
		return getName() + "(" + argument.toString() + ")";
	}

	//public priority() {
//
//	}

}

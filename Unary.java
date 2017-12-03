//package symbolic;
import java.util.*;

public abstract class Unary extends Sexpr {
	protected final Sexpr arg;

	public Unary(Sexpr a) {
		this.arg = a;
	}


	//public String toString() {
	//	return getName() + "(" + argument.toString() + ")";
	//}

	//public priority() {
//
//	}

}

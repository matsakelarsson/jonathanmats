//package symbolic;
import java.util.*;

public abstract class Unary extends Sexpr {
	Sexpr arg;

	public Unary(Sexpr arg) {
		this.arg = arg;
	}


	//public String toString() {
	//	return getName() + "(" + argument.toString() + ")";
	//}

	//public priority() {
//
//	}

}

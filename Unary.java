//package symbolic;
import java.util.*;

public abstract class Unary extends Sexpr {
	Sexpr arg;

	public Unary(Sexpr arg) {
		this.arg = arg;
	}

	public boolean isConstant() {
		return true;
	}


	public String toString() {
		return getName() + "(" + arg.toString() + ")";
	}

	//public priority() {
//
//	}

}

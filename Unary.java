//package symbolic;
import java.util.*;

public abstract class Unary extends Sexpr {
	Sexpr arg;

	public Unary(Sexpr arg) {
		this.arg = arg;
	}

	public boolean isVars() {
		return false;
	}

	public boolean isQuit() {
		return false;
	}

	public boolean isConstant() {
		return false;
	}


	public String toString() {
		return getName() + "(" + arg.toString() + ")";
	}

	//public priority() {
//
//	}

}

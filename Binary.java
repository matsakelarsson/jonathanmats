//package symbolic;
import java.util.*;

public abstract class Binary extends Sexpr {
	Sexpr left;
	Sexpr right;

	public Binary(Sexpr left, Sexpr right) {
		this.left = left;
		this.right = right;
	}

	public Sexpr getLeft() {
		return this.left;
	}

	public Sexpr getRight() {
		return this.right;
	}

	public String toString() {
		return getName() + "(" + left.toString() + right.toString() + ")";	
	}

}

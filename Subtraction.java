import java.util.HashMap;

public class Subtraction extends Binary {
	public Subtraction(Sexpr left, Sexpr right) {		//Vet ej vad som ska tas
		super (left, right);
	}

	public String toString() {
		return "";
	}

	public String getName() {
		return "";
	}

	public int priority() {
		return 0;
	}

	public Sexpr eval(HashMap<String, Sexpr> variables) {
		return Symbolic.subtraction(this.getLeft().eval(variables), this.getRight().eval(variables));
	}
}

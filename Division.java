import java.util.*;

public class Division extends Binary {
	public Division(Sexpr left, Sexpr right) {	//Vet ej vad som ska tas
		super(left, right);
	}

	public String getName() {
		return "";
	}

	public int priority() {
		return 0;
	}

	public Sexpr eval(HashMap<String, Sexpr> variables) {
		return Symbolic.division(this.getLeft().eval(variables), this.getRight().eval(variables));
	}

}

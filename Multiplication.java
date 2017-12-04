import java.util.*;

public class Multiplication extends Binary {

	public Multiplication(Sexpr left, Sexpr right) {	//Vet inte vad som ska tas
		super (left, right);
	}

	public String getName(){
		return "";
	}

	public int priority() {
		return 0;
	}

	public Sexpr eval(HashMap<String, Sexpr> variables) {
		return Symbolic.multiplication(this.getLeft().eval(variables), this.getRight().eval(variables));
	}

}


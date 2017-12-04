import java.util.*;

public class Assignment extends Binary {
	public Assignment (Sexpr left, Sexpr right){	
		super(left, right);
	}

	public String getName() {
		return "";
	}

	public int priority() {
		return 0;
	}

	public Sexpr eval(HashMap<String, Sexpr> variables) {
		Sexpr result;
		return result;
	}
}

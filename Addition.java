import java.util.*;

public class Addition extends Binary {
	public Addition(Sexpr left, Sexpr right) {		
		super (left, right);
	}

	public String getName() {
		return "+";
	}

	//public boolean isConstant() {
	//	return true;
	//}

	public int priority() {
		return 0;
	}
    
	public Sexpr eval(HashMap<String, Sexpr> variables) {
		return Symbolic.addition(this.getLeft().eval(variables), this.getRight().eval(variables));
	}
    
}



//package symbolic;
import java.util.*;
public abstract class Command extends Sexpr {

	public Sexpr eval (HashMap<String, Sexpr> variables) {
		return new Constant(0);
	}

	public boolean isConstant() {
		return false;
	}

	public String getName() {
		return "";
	}


}

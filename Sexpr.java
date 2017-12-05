//package symbolic;
import java.util.*;

public abstract class Sexpr {

	public abstract String getName();

	public double getValue(){
		throw new RuntimeException ("Illegal call to getValue()");
	}

	public int priority(){
		return 0;
	}

	public boolean isConstant() {
		return true;
	}

	public abstract Sexpr eval(HashMap<String, Sexpr> variables);


}


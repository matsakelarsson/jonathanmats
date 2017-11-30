//package symbolic;
import java.util.*;

public abstract class Sexpr {

	public abstract String getName();

	public double getValue(){
		return 0;
	}

	public int priority(){
		return 0;
	}


	public boolean isConstant(double value){
		return false;
	}

	public abstract Sexpr eval(Map<String, Sexpr> map);


}


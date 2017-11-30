import java.util.*;

public class Symbolic{
	
	public static Sexpr sin(Sexpr arg) {
		if (arg.isConstant()) {
			return new Constant(Math.sin(arg.getValue()));
		} else {
			return new Sin (arg);
		}
	}

}

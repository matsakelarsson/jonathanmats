//import java.util.*;
import java.lang.Math;

public class Symbolic{

	public static Sexpr sin(Sexpr arg) {
		if (arg.isConstant()) {
			return new Constant(Math.sin(arg.getValue()));
		} else {
			return new Sin(arg);
		}
	}

	public static Sexpr exp(Sexpr arg) {
		if (arg.isConstant()) {
			return new Constant(Math.exp(arg.getValue()));
		} else {
			return new Exp(arg);
		}
	}  

	public static Sexpr cos(Sexpr arg) {
		if (arg.isConstant()) {
			return new Constant(Math.cos(arg.getValue()));
		} else {
			return new Cos(arg);
		}
	}
}

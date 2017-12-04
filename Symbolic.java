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

	public static Sexpr addition(Sexpr left, Sexpr right) {
		if (left.isConstant() && right.isConstant()) {
			return new Constant(left.getValue() + right.getValue());
		} else {
			return new Addition(left, right);
		}
	}


	public static Sexpr subtraction(Sexpr left, Sexpr right) {
		if (left.isConstant() && right.isConstant()) {
			return new Constant(left.getValue() - right.getValue());
		} else {
			return new Subtraction(left, right);
		}
	}


	public static Sexpr multiplication(Sexpr left, Sexpr right) {
		if (left.isConstant() && right.isConstant()) {
			return new Constant(left.getValue() * right.getValue());
		} else {
			return new Multiplication(left, right);
		}
	}


	public static Sexpr division(Sexpr left, Sexpr right) {
		if (left.isConstant() && right.isConstant()) {
			return new Constant(left.getValue() / right.getValue());
		} else {
			return new Division(left, right);
		}
	}
}

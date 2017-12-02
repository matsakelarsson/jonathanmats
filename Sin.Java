import java.util.*;

public class Sin extends Unary {
	public Sin (Sexpr s) {			//vet ej vad som tas?
	}

	public Sexpr eval(HashMap<String, Sexpr> variables) {
		return Symbolic.sin(argument.eval(variables));
	}
}

//package symbolic;
import java.util.*;

public abstract class Atom extends Sexpr {
    
	public String toString(){
            return getName();
	}

	public boolean isQuit() {
		return false;
	}

	public boolean isVars() {
		return false;
	}
    
}

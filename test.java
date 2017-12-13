/*class Addition extends Expression {

	Expression lhs;
	Expresstion rhs;

	Addition(Expression l, Expression r) {
		this.lhs = l;
		this.rhs = r;

		
	public equals (Addition c) {
		return this.lhs.equals(a.lhs) && this.rhs.equals(a.rhs);
	}

	public equals (Object o) {
		if (o instanceof Addition) {
			return this.equals((Addition) o);
		} else{
			return false;
		}
	}
	}

}


class Constant extens Expression {
	final int value;

	Constant(int value) {
		this.value = value;
	}

	public equals (Constan c) {
		return this.value ==c.value;
	}

	public equals (Object o) {
		if (o instanceof Constant) {
			return this.equals((Constant) o);
		} else{
			return false;
		}
	}

}

public void number() throws IOEXeption {
	trace("number");
	if(lookingAtNumber()) {
		trace("Read number: '" + st.nval + "'");
		st.nextToken();
	}else {
		assert false : "expected number, gto something else";
*/

//input "13 + 17"
//
//new StreamTokenizer(new StringReader (13+17))
//new Addition( new Constant(17, new Constant(13))
//
//

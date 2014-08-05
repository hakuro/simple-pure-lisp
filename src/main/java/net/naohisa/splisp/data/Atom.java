package net.naohisa.splisp.data;

public class Atom implements Data {

	Type type;
	Object data;

	public Atom(Type type, Object data) {
		this.type = type;
		this.data = data;
	}

	public Type getType() {
		return type;
	}

	public Object getData() {
		return data;
	}

}

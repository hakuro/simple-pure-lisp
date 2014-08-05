package net.naohisa.splisp;

import net.naohisa.splisp.data.Atom;
import net.naohisa.splisp.data.Data;
import net.naohisa.splisp.data.List;
import net.naohisa.splisp.data.Type;

public class Parser {

	public boolean isParsable(String exp) {

		return false;
	}

	public String parse(String exp) {
		return "";
	}

	public Atom atom(Data data) {
		if (data instanceof Atom) {
			return t();
		}
		return nil();
	}

	public Atom eq(Atom a1, Atom a2) {
		if (a1.getType().equals(a2.getType())
				&& a1.getData().equals(a2.getData())) {
			return t();
		}
		return nil();
	}

	public Atom car(Atom a1, Atom a2) {
		return a1;
	}

	public Atom cdr(Atom a1, Atom a2) {
		return a2;
	}

	public List cons(Atom a1, Atom a2) {
		return new List(a1, a2);
	}

	private Atom t() {
		return new Atom(Type.T, true);
	}

	private Atom nil() {
		return new Atom(Type.NIL, null);
	}
}

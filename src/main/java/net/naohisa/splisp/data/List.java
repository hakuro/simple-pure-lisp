package net.naohisa.splisp.data;

public class List implements Data {

	private Data former;
	private Data latter;

	public List(Data f, Data l) {
		this.former = f;
		this.latter = l;
	}

	public Data getFormer() {
		return former;
	}

	public Data getLatter() {
		return latter;
	}

}

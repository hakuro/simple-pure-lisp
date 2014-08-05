package net.naohisa.splisp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Repl {

	private final static String BANNER = "*** Simple Pure Lisp ***\n"
			+ " help: (help), exit: (exit)";
	private final static String PROMPT = "splisp> ";

	private BufferedReader reader;
	private StringBuilder buffer;
	private Parser parser;

	public Repl() {
		reader = new BufferedReader(new InputStreamReader(System.in));
		buffer = new StringBuilder();
		parser = new Parser();
	}

	public void loop() {
		System.out.println(BANNER);
		System.out.print(PROMPT);

		Boolean isExit = false;
		while (!isExit) {
			String line = this.read();
			if (buffer != null && buffer.length() == 0 && "(exit)".equals(line)) {
				isExit = true;
			} else {
				this.eval(line);
				System.out.print(PROMPT);
			}
		}
	}

	private String read() {
		try {
			return reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	private void eval(final String line) {
		buffer.append(line);
		if (parser.isParsable(buffer.toString())) {
			System.out.println(parser.parse(buffer.toString()));
			buffer = new StringBuilder();
		}
	}
}

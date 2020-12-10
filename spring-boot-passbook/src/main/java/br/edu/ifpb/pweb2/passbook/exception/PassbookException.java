package br.edu.ifpb.pweb2.passbook.exception;

public class PassbookException extends Exception {
	private static final long serialVersionUID = 1L;

	public PassbookException() {
		super();
	}

	public PassbookException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public PassbookException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public PassbookException(String arg0) {
		super(arg0);
	}

	public PassbookException(Throwable arg0) {
		super(arg0);
	}
	
}
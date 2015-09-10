package com.nyx.mower.exception;

public class StorageException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8746318708492222974L;

	public StorageException(String message, Exception e) {
		super(message, e);
	}
}

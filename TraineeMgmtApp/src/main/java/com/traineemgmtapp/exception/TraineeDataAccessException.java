package com.traineemgmtapp.exception;

public class TraineeDataAccessException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TraineeDataAccessException(String message) {
		super(message);
	}
	
	public TraineeDataAccessException(String msg, Throwable cause) {
        super(msg, cause);
    }
}

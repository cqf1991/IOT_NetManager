package com.iotNM.exception;

/**
 * 基本异常, 继承自RuntimeException.
 * <br>从由Spring管理事务的函数中抛出时会触发事务回滚.
 * 
 * 

 */
@SuppressWarnings("serial")
public class BaseException extends RuntimeException {

	public BaseException() {
		super();
	}

	public BaseException(String message) {
		super(message);
	}

	public BaseException(Throwable cause) {
		super(cause);
	}

	public BaseException(String message, Throwable cause) {
		super(message, cause);
	}

}

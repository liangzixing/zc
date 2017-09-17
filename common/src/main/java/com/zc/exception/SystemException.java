package com.zc.exception;

/**
 * ϵͳ�쳣
 * 
 * @author wangbowangb
 *
 */
public class SystemException extends ServiceException {

	private static final long serialVersionUID = -2597835592314198271L;

	public SystemException() {
		super();
	}

	public SystemException(String message, Throwable cause) {
		super(message, cause);
	}

	public SystemException(String message) {
		super(message);
	}

	public SystemException(Throwable cause) {
		super(cause);
	}

	public SystemException(String exceptionCode, String message, Throwable cause) {
		super(exceptionCode, message, cause);
	}

	public SystemException(String exceptionCode, String message) {
		super(exceptionCode,message);
	}

}

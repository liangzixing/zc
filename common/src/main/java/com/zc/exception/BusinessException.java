package com.zc.exception;

/**
 * ÒµÎñÂß¼­Òì³£
 * 
 * @author chenhui.lich
 *
 */
public class BusinessException extends ServiceException {

	private static final long serialVersionUID = -6974825435534947893L;

	public BusinessException() {
		super();
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessException(String cause) {
		super(cause);
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}

	public BusinessException(String exceptionCode, String message, Throwable cause) {
		super(exceptionCode, message, cause);
	}

	public BusinessException(String exceptionCode, String message) {
		super(exceptionCode,message);
	}
}

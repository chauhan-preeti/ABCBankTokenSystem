package org.test.boot.http.utils;

import org.test.boot.http.model.BaseResponse;
import org.test.boot.http.model.BaseResponse.Status;

public class ResponseUtils {
	public static <T> BaseResponse<T> success(String message, T details) {
		BaseResponse<T> baseResponse = new BaseResponse<T>();
		baseResponse.setStatus(Status.SUCCESS);
		baseResponse.setMessage(message);
		baseResponse.setDetails(details);
		return baseResponse;
	}
	
	public static <T> BaseResponse<T> error(String errorMessage) {
		BaseResponse<T> baseResponse = new BaseResponse<T>();
		baseResponse.setStatus(Status.ERROR);
		baseResponse.setMessage(errorMessage);
		return baseResponse;
	}
	
	public static <T> BaseResponse<T> failure(String failureMessage) {
		BaseResponse<T> baseResponse = new BaseResponse<T>();
		baseResponse.setStatus(Status.ERROR);
		baseResponse.setMessage(failureMessage);
		return baseResponse;
	}
}

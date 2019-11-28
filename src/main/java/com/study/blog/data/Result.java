package com.study.blog.data;

import java.io.Serializable;

public class Result<T> implements Serializable {

	private static final long serialVersionUID = -3948389268046368059L;

	private Integer code;

	private String msg;

	private T data;

	public Result() {
	}

	public Result(Integer code, String msg) {
		this.setCode(code);
		this.setMsg(msg);
	}

	public static Result success() {
		Result result = new Result();
		result.setResultCode(ResultCode.SUCCESS);
		return result;
	}

	public static<T> Result<T> success(T data) {
		Result result = new Result();
		result.setResultCode(ResultCode.SUCCESS);
		result.setData(data);
		return result;
	}


	public static Result failure(ResultCode resultCode) {
		Result result = new Result();
		result.setResultCode(resultCode);
		return result;
	}

	/*
	前面的T是泛型声明
	java声明泛型方法的固定格式，在方法的返回值声明之前的位置，<T>定义该方法所拥有的泛型标识符，个数可以是多个
	前面的T的声明，跟类后面的 <T> 没有关系。
	方法前面的<T>是给这个方法级别指定泛型。
	 */
	public static<T> Result<T> failure(ResultCode resultCode, T data) {
		Result result = new Result();
		result.setResultCode(resultCode);
		result.setData(data);
		return result;
	}

	public void setResultCode(ResultCode code) {
		this.setCode(code.code());
		this.setMsg(code.message());
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
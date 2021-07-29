package com.lu.util;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Result {
	@ApiModelProperty(value = "状态码")
	private Integer code;

	@ApiModelProperty(value = "返回信息")
	private String msg;

	@ApiModelProperty(value = "是否成功")
	private Boolean success;

	@ApiModelProperty(value = "返回数据")
	private Map<String, Object> data = new HashMap<String, Object>();

	//构造方法私有
	private Result() {
	}

	public static Result ok() {
		Result result = new Result();
		result.setCode(ResultCode.success);
		result.setSuccess(true);
		result.setMsg("成功");
		return result;
	}

	public static Result error() {
		Result result = new Result();
		result.setCode(ResultCode.error);
		result.setSuccess(false);
		result.setMsg("失败");
		return result;
	}

	public Result success(Boolean success) {
		this.setSuccess(success);
		return this;
	}

	public Result msg(String msg) {
		this.setMsg(msg);
		return this;
	}

	public Result code(Integer code) {
		this.setCode(code);
		return this;
	}

	public Result data(String key, Object data) {
		this.data.put(key, data);
		return this;
	}

	public Result data(Map<String, Object> data) {
		this.setData(data);
		return this;
	}
}

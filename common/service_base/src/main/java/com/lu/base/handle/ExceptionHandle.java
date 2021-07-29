package com.lu.base.handle;

import com.lu.util.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
	//指定出现什么异常执行这个方法
	@ExceptionHandler(Exception.class)
	@ResponseBody //为了返回数据
	public Result error(Exception e) {
		e.printStackTrace();
		return Result.error().msg("执行了全局异常处理..");
	}
}

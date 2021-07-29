package com.lu.edu.controller;


import com.lu.edu.entity.Teacher;
import com.lu.edu.service.TeacherService;
import com.lu.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author testJava
 * @since 2021-07-27
 */
@Api(description = "讲师管理")
@RestController
@RequestMapping("/edu/teacher")
public class TeacherController {
	@Autowired
	TeacherService teacherService;

	@ApiOperation(value = "所有讲师")
	@GetMapping("list")
	public Result list() {
		List<Teacher> list = teacherService.list(null);
		return Result.ok().data("rows", list);
	}

	@ApiOperation(value = "新增讲师")
	@PostMapping("add")
	public Result add(@RequestBody Teacher teacher) {
		boolean save = teacherService.save(teacher);
		if (save) {
			return Result.ok().msg("新增讲师成功");
		}
		return Result.error().msg("新增讲师失败");
	}

	@ApiOperation(value = "编辑讲师")
	@PutMapping("edit")
	public Result edit(@RequestBody Teacher teacher) {
		boolean edit = teacherService.updateById(teacher);
		if (edit) {
			Result.ok().msg("编辑讲师成功");
		}
		return Result.error().msg("编辑讲师失败");
	}

	@ApiOperation(value = "删除讲师")
	@DeleteMapping("{id}")
	public Result delete(@ApiParam(name = "id", value = "讲师id", required = true) @PathVariable String id) {
		boolean delete = teacherService.removeById(id);
		if (delete) {
			return Result.ok().msg("删除讲师成功");
		}
		return Result.error().msg("删除讲师失败");
	}
}


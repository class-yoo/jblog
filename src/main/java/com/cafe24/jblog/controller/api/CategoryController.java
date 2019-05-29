package com.cafe24.jblog.controller.api;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.jblog.dto.JSONResult;
import com.cafe24.jblog.service.BlogService;

@Configuration("categoryAPIController")
@RequestMapping("category/api")
public class CategoryController {

	@Autowired
	private BlogService blogService;

	@ResponseBody
	@RequestMapping("/remove")
	public JSONResult remove(@RequestParam(value = "id", required = true, defaultValue = "-1") Long categoryNo) {
		
		Boolean result = blogService.removeCategory(categoryNo);
		if (!result || categoryNo == -1) {
			return JSONResult.success(false);
		}
		return JSONResult.success(result);
	}

}

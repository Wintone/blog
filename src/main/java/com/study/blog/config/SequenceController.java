package com.study.blog.config;

import com.study.blog.util.uid.IdTool;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("sequence")
@ResponseBody
public class SequenceController {

	@RequestMapping("new")
	public Map<String, Object> newId() {
		String id = IdTool.nextSmallId();

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("code", "200");
		map.put("msg", "保存成功");
		map.put("data", id);
		return map;
	}

}

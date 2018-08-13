package com.xxm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xxm.pojo.Student;
import com.xxm.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;

@Controller       //这个注解就是Controller的注解，加了这个注解，就相当于以前的servlet
public class DemoController {

	@Autowired
	public StudentServiceImpl studentService;


	//第一种，返回值是视图，视图就是jsp或者html
	//下面这个RequestMapping注解是代表url的请求路径映射，因为在springmvc.xml里配置了视图解析器，所以会自动找到配置目录里的welcome.jsp
	//url是 http://localhost:8080/SpringMvcDemo-build-by-jar/welcome 直接复制这个
	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
	
	//第二种，返回值是数据，就是一个接口
	//@ResponseBody代表的是返回值为数据
	//url是 http://localhost:8080/SpringMvcDemo-build-by-jar/data 浏览器显示的数据的格式就是json格式
	@RequestMapping("/data")
	@ResponseBody
	public Map<String, String> testData(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "mjw");
		return map;
	}
	
	//我以前用的最多的，当然也是比较通用的
	// http://localhost:8080/SpringMvcDemo-build-by-jar/json
	//此时时间是：2018-08-13 01:29:42 ....不用maven真是累死了，就这么一次了，以后都给你用maven构建
	@RequestMapping("/json")
	@ResponseBody
	public JSONObject testData2() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "mjw");
		jsonObject.put("age", 18);
		jsonObject.put("lang", "java");
		
		JSONObject json = new JSONObject();
		json.put("test1", "test1");
		json.put("test2", "test2");
		
		jsonObject.put("child", json);
		
		return jsonObject;
	}


	/**
	 * json格式的数据建议用格式化工具查看  https://www.sojson.com/simple_json.html 这个地址就可以，把数据复制到左边
	 * @return
	 */
	@RequestMapping(value = "/getStudent" , method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getStudent(){
		JSONObject jsonObject = new JSONObject();
		List<Student> list = studentService.getStudentList();
		jsonObject.put("status","success");
		jsonObject.put("code",200);
		jsonObject.put("data",list);
		return jsonObject;
	}

}

package com.xxm.springmvc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import net.sf.json.JSONObject;

@Controller       //���ע�����Controller��ע�⣬�������ע�⣬���൱����ǰ��servlet
public class DemoController {

	//��һ�֣�����ֵ����ͼ����ͼ����jsp����html
	//�������RequestMappingע���Ǵ���url������·��ӳ�䣬��Ϊ��springmvc.xml����������ͼ�����������Ի��Զ��ҵ�����Ŀ¼���welcome.jsp
	//url�� http://localhost:8080/SpringMvcDemo-build-by-jar/welcome ֱ�Ӹ������
	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
	
	//�ڶ��֣�����ֵ�����ݣ�����һ���ӿ�
	//@ResponseBody������Ƿ���ֵΪ����
	//url�� http://localhost:8080/SpringMvcDemo-build-by-jar/data �������ʾ�����ݵĸ�ʽ����json��ʽ
	@RequestMapping("/data")
	@ResponseBody
	public Map<String, String> testData(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "mjw");
		return map;
	}
	
	//����ǰ�õ����ģ���ȻҲ�ǱȽ�ͨ�õ�
	// http://localhost:8080/SpringMvcDemo-build-by-jar/json
	//��ʱʱ���ǣ�2018-08-13 01:29:42 ....����maven���������ˣ�����ôһ���ˣ��Ժ󶼸�����maven����
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
}

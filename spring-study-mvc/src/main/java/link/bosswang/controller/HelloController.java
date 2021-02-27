package link.bosswang.controller;

import link.bosswang.dto.HelloDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/hello")
public class HelloController {

	@RequestMapping(value = "/sayHello", method = RequestMethod.GET)
	@ResponseBody
	public static HelloDto<String> sayHello() {

		System.out.println("Hello Controller say Hello");


		return HelloDto.<String>build(200, "OK", true, "OK");
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public static String hello() {
		return "Hello";
	}

}

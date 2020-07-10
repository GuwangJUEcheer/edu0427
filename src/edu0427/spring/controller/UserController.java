package edu0427.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;

import edu0427.spring.service.UserService;
import edu0427.spring.vo.LoginInfo;
import edu0427.spring.vo.UserInfo;

@Controller // 拦截标签
@RequestMapping("/")
public class UserController {
	@Autowired // 注入
	private UserService userService;

	@RequestMapping(value = "/user/{loginId}", method = RequestMethod.GET)
	@ResponseBody
	public UserInfo getUserInfoByLoginId(@PathVariable String loginId) {
		return userService.getUserByLoginId(loginId);
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET) // 不可能有两个相同的GET和post请求
	public String login(ModelMap modelMap) {
		modelMap.put("user", new LoginInfo());
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(LoginInfo user, HttpSession session, ModelMap modelMap) {
        //TODO 如果成功，跳转到index页面，否则就返回登录界面，显示账号密码错误
		if (userService.loginValid(user, session)) {
			return "redirect:player/index?pageIndex=1&pageSize=10";
		}
		// 清空输入的密码,顯示账号或者密码错误
		user.setPassword(null);
		modelMap.put("user", user);
		modelMap.put("msg", "账号或密码错误");
		return "login";
	}
	@RequestMapping(value = "/permission/{loginId}", method = RequestMethod.GET)
	@ResponseBody
    public JSONArray getPermissons(@PathVariable String loginId) {
		//参数名字根据LOGINID查询所有权限关键字，返回值为JSON数组
    	return userService.getPermissonByLoginId(loginId);  	
	}
}

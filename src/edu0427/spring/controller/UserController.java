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

@Controller // ���ر�ǩ
@RequestMapping("/")
public class UserController {
	@Autowired // ע��
	private UserService userService;

	@RequestMapping(value = "/user/{loginId}", method = RequestMethod.GET)
	@ResponseBody
	public UserInfo getUserInfoByLoginId(@PathVariable String loginId) {
		return userService.getUserByLoginId(loginId);
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET) // ��������������ͬ��GET��post����
	public String login(ModelMap modelMap) {
		modelMap.put("user", new LoginInfo());
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(LoginInfo user, HttpSession session, ModelMap modelMap) {
        //TODO ����ɹ�����ת��indexҳ�棬����ͷ��ص�¼���棬��ʾ�˺��������
		if (userService.loginValid(user, session)) {
			return "redirect:player/index?pageIndex=1&pageSize=10";
		}
		// ������������,�@ʾ�˺Ż����������
		user.setPassword(null);
		modelMap.put("user", user);
		modelMap.put("msg", "�˺Ż��������");
		return "login";
	}
	@RequestMapping(value = "/permission/{loginId}", method = RequestMethod.GET)
	@ResponseBody
    public JSONArray getPermissons(@PathVariable String loginId) {
		//�������ָ���LOGINID��ѯ����Ȩ�޹ؼ��֣�����ֵΪJSON����
    	return userService.getPermissonByLoginId(loginId);  	
	}
}

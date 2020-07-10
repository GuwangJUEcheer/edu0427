package edu0427.spring.service.impl;

import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import edu0427.common.util.MD5Util;
import edu0427.spring.dao.mapper.UserMapper;
import edu0427.spring.service.UserService;
import edu0427.spring.vo.LoginInfo;
import edu0427.spring.vo.UserInfo;

@Component // spring管理类的标签
public class UserServiceImpl implements UserService {
	@Autowired // w是小写的
	private UserMapper userMapper;

	@Override
	public UserInfo getUserByLoginId(String loginId) {
		// TODO Auto-generated method stub
		return userMapper.getUserByLoginId(loginId);
	}// 要想调用MAPPER必须注入mapper

	@Override
	public boolean loginValid(LoginInfo login, HttpSession session) {
		if (StringUtils.isBlank(login.getLoginId())) {
			return false;
		}
		UserInfo user = getUserByLoginId(login.getLoginId());
		if (null != user) {
			// 判断密码是否正确
			if (user.getPassword().equals(MD5Util.textToMD5U16(login.getPassword()))) {
             //4 如果密码相同
				login.setUsername(user.getUserName());
				session.setAttribute("USER_SESSION", login);
				return true;
			}
		}
		return false;
	}

	@Override
	public JSONArray getPermissonByLoginId(String loginId) {
		// TODO Auto-generated method stub
		Set<String> set=userMapper.getPermissions(loginId);
		JSONArray array = new JSONArray();
		for (String a : set){
			array.add(a);
		}
		return array;
	}
	}


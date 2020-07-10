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

@Component // spring������ı�ǩ
public class UserServiceImpl implements UserService {
	@Autowired // w��Сд��
	private UserMapper userMapper;

	@Override
	public UserInfo getUserByLoginId(String loginId) {
		// TODO Auto-generated method stub
		return userMapper.getUserByLoginId(loginId);
	}// Ҫ�����MAPPER����ע��mapper

	@Override
	public boolean loginValid(LoginInfo login, HttpSession session) {
		if (StringUtils.isBlank(login.getLoginId())) {
			return false;
		}
		UserInfo user = getUserByLoginId(login.getLoginId());
		if (null != user) {
			// �ж������Ƿ���ȷ
			if (user.getPassword().equals(MD5Util.textToMD5U16(login.getPassword()))) {
             //4 ���������ͬ
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


package com.cafe24.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.jblog.repository.dao.UserDao;
import com.cafe24.jblog.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public boolean createUser(UserVo userVo) {
		return 1== userDao.insertUser(userVo);
	}

	public Boolean existId(String id) {
		return userDao.existId(id) != null;
	}

	public UserVo getUser(UserVo userVo) {
		return userDao.selectUser(userVo);
	}

}

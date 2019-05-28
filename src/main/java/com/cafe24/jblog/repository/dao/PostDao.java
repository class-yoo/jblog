package com.cafe24.jblog.repository.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.jblog.vo.PostVo;

@Repository
public class PostDao {

	
	@Autowired
	private SqlSession session;

	public int insertPost(PostVo postVo) {
		
		session.insert("");
		return 0;
	}
	
	
	
}

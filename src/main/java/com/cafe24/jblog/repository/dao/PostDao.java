package com.cafe24.jblog.repository.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.jblog.vo.PostVo;

@Repository
public class PostDao {
	
	@Autowired
	private SqlSession session;

	public int insertPost(PostVo postVo) {
		System.out.println(postVo);
		return session.insert("post.insert", postVo);
	}

	public PostVo selectPost(Long postNo) {
		
		return session.selectOne("post.select", postNo);
	}

	public List<PostVo> selectPosts(Long categoryNo) {
		
		return session.selectList("post.selectPostList", categoryNo);
	}

	public int deletePost(Long categoryNo) {
		
		return session.delete("post.delete", categoryNo);
	}

}

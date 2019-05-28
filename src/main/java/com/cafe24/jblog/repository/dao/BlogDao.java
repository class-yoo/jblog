package com.cafe24.jblog.repository.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.jblog.vo.BlogVo;
import com.cafe24.jblog.vo.CategoryVo;

@Repository
public class BlogDao {

	@Autowired
	private SqlSession session;
	
	public int update(BlogVo blogVo) {
		
		return session.update("blog.update", blogVo);
	}

	public BlogVo selectBlog(String id) {
		
		return session.selectOne("blog.select", id);
	}

	public List<CategoryVo> selectCategoryList(String id) {
		
		return session.selectList("blog.selectCategoryList", id);
	}

}

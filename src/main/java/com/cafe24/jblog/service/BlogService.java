package com.cafe24.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.jblog.repository.dao.BlogDao;
import com.cafe24.jblog.repository.dao.CategoryDao;
import com.cafe24.jblog.repository.dao.PostDao;
import com.cafe24.jblog.vo.BlogVo;
import com.cafe24.jblog.vo.CategoryVo;
import com.cafe24.jblog.vo.PostVo;

@Service
public class BlogService {

	@Autowired
	private BlogDao blogDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private PostDao postDao;
	
	public boolean modify(BlogVo blogVo) {
		return 1 == blogDao.update(blogVo);
	}

	public BlogVo getBlog(String id) {
		
		return blogDao.selectBlog(id);
	}

	public List<CategoryVo> getCategories(String id) {
		
		return categoryDao.selectCategoryList(id);
		
	}

	public void writePost(PostVo postVo) {
			
	}

}

package com.cafe24.jblog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cafe24.jblog.security.Auth;
import com.cafe24.jblog.service.BlogService;
import com.cafe24.jblog.service.FileUploadService;
import com.cafe24.jblog.vo.BlogVo;
import com.cafe24.jblog.vo.UserVo;

@Controller
@RequestMapping("/blog")
//@RequestMapping("/{id:(?assets).*)}")
public class BlogController {
	
	@Autowired
	private BlogService blogService;

	@Autowired
	private FileUploadService fileUploadService;
	
	
	@RequestMapping("/{id}")
	public String main(
			@PathVariable String id,
			Model model) {
		BlogVo blogVo = blogService.getBlog(id);
		model.addAttribute("blogVo", blogVo);
		return "blog/blog-main";
		
	}
	
	@Auth
	@RequestMapping("/management") //userId를 authUser를 보내서 사용하는게 낫나 Session에서 뽑아서 사용하는게 낫나 ?
	public String management(HttpSession session, Model model) {
		
//		service에서 사용자아이디를 이용해서 기본블로그 정보 불러오기
		String id= ((UserVo)session.getAttribute("authUser")).getId();
		BlogVo blogVo = blogService.getBlog(id);
		model.addAttribute("blogVo", blogVo);
		
		return "blog/blog-admin-basic";
	}
	
	@RequestMapping("/modify")
	public String modify(
			HttpSession session, 
			@RequestParam(value= "title", required=true, defaultValue="") String title,
			@RequestParam(value ="logoFile") MultipartFile multipartFile) {
		
		System.out.println(title);
		String saveFileName = fileUploadService.restore(multipartFile);
		String id= ((UserVo)session.getAttribute("authUser")).getId();
		BlogVo blogVo = new BlogVo(id ,title, saveFileName);
		blogService.modify(blogVo);
		
//		service에서 블로그 기본설정 수정하는 내용 넣기 및 멀티파트리졸버사용
		
		return "redirect:/blog/management";
	}
	
	@RequestMapping("/category")
	public String category(HttpSession session) {
		
		String id= ((UserVo)session.getAttribute("authUser")).getId();
		blogService.getCategories(id);
		
		return "/blog/blog-admin-category";
	}
	
	@RequestMapping("/write")
	public String write() {
		
		return "/blog/blog-admin-write";
		
	}
}

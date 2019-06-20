package com.lovo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.lovo.entity.PageEntity;
import com.lovo.entity.UserEntity;
import com.lovo.service.IUserService;
import com.lovo.uuid.Uuid;

@Controller
public class UserController {

	@Autowired
	private IUserService userService;

	@RequestMapping("login.lovo")
	public ModelAndView login(String username, String password) {
		ModelAndView mv = new ModelAndView("show3");
		List<UserEntity> list = userService.queryAlluserName();
		for (UserEntity u : list) {
			if (username.equals(u.getUsername())) {
				UserEntity user = userService.login(username, password);
				if (user == null) {
					mv.setViewName("login.jsp?error=yes");
					break;
				} else {
					return mv;
				}
			} else {

				mv.setViewName("login.jsp?error=no");
			}
		}
		return mv;
	}

	@RequestMapping("register.lovo")
	public ModelAndView register(String username, String password) {
		ModelAndView mv = new ModelAndView("login");
		UserEntity user = new UserEntity();
		if (username.equals("") || password.equals("")) {
			mv.setViewName("register");
		} else {
			user.setUsername(username);
			user.setPassword(password);
			userService.addUser(user);
		}
		return mv;
	}

	@RequestMapping("testing.lovo")
	public ModelAndView testing(String username, String password) {
		ModelAndView mv = new ModelAndView("register.jsp?error=yes");
		List<UserEntity> list = userService.queryAlluserName();
		for (UserEntity u : list) {
			if (username.equals(u.getUsername())) {
				return mv;
			}
		}
		RedirectView rv = new RedirectView("register.lovo?username=" + username + "&&password=" + password + "");
		mv.setView(rv);
		return mv;
	}

	@RequestMapping("delete.lovo")
	public ModelAndView delUser(Integer id) {
		ModelAndView mv = new ModelAndView("show3");
		userService.delUser(id);
		return mv;
	}

	@RequestMapping("show3.lovo")
	@ResponseBody
	public PageEntity<UserEntity> show3(Integer currentPage) {
		Integer totalPage = userService.getTotalPage();
		if (currentPage < 1) {
			currentPage = 1;
		} else if (currentPage > totalPage) {
			currentPage = totalPage;
		}
		List<UserEntity> list = userService.show3(currentPage);
		PageEntity<UserEntity> user = new PageEntity<UserEntity>();
		user.setList(list);
		user.setCurrentPage(currentPage);
		user.setTotalPage(totalPage);
		return user;
	}

	@RequestMapping("update.lovo")
	public ModelAndView update(String password, Integer id) {
		ModelAndView mv = new ModelAndView("show3");
		userService.update(password, id);
		return mv;
	}
}

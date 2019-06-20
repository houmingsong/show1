package com.lovo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lovo.entity.MesEntity;
import com.lovo.entity.MessageEntity;
import com.lovo.entity.PageEntity;
import com.lovo.service.IMessageService;

@Controller
public class MessageController {

	@Autowired
	private IMessageService messageService;

	@RequestMapping("show.lovo")
	@ResponseBody
	public PageEntity<MessageEntity> show(Integer currentPage,String yemian) {
		Integer totalPage = messageService.getTotalPage();
		if (currentPage < 1) {
			currentPage = 1;
		} else if (currentPage > totalPage) {
			currentPage = totalPage;
		}
		List<MessageEntity> Messagelist = messageService.show(currentPage);
		PageEntity<MessageEntity> page = new PageEntity<MessageEntity>();
		page.setList(Messagelist);
		page.setCurrentPage(currentPage);
		page.setTotalPage(totalPage);
		return page;
	}
	
	@RequestMapping("user.lovo")
	public ModelAndView show1(Integer id) {
		ModelAndView mv = new ModelAndView("show1");
		List<MesEntity> list = messageService.show1(id);
		mv.addObject("user", list);
		return mv;
	}
	
	@RequestMapping("poi.lovo")
	public ModelAndView poi() throws IOException {
		ModelAndView mv = new ModelAndView("show");
		List<MessageEntity> list = messageService.show2();
		Excle2.dbToExcle(list);
		return mv;		
	}
	
	@RequestMapping("QueryAllUsers.lovo")
	@ResponseBody
	public List<MessageEntity> QueryAllUsers(){
		List<MessageEntity> list = messageService.QueryAllUsers();		
		return list;		
	}
	
	@RequestMapping("exhibition.lovo")
	public ModelAndView exhibition(String[] kk) {
		ModelAndView mv = new ModelAndView("show2");
		for(String string:kk) {		
			mv.addObject("String", string);
		}
		return mv;		
	}
}

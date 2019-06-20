package com.lovo.service;

import java.util.List;

import com.lovo.entity.MesEntity;
import com.lovo.entity.MessageEntity;

public interface IMessageService {

	public List<MessageEntity> show(int currentpage);

	public int getTotalPage();
	
	public List<MesEntity> show1(Integer id);
	
	public List<MessageEntity> show2();
	
	public List<MessageEntity> QueryAllUsers();
}

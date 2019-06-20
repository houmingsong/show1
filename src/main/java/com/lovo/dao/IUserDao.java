package com.lovo.dao;

import java.util.List;

import com.lovo.entity.UserEntity;

public interface IUserDao {

	public UserEntity login(String username, String password);
	
	public void addUser(UserEntity user);
	
	public void delUser(Integer id);
	
	public List<UserEntity> show3(int currentpage);
	
	public int getTotalPage();
	
	public void update(String password,Integer id);
	
	public List<UserEntity> queryAlluserName();
}

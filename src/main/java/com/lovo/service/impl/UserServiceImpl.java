package com.lovo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lovo.dao.IUserDao;
import com.lovo.entity.UserEntity;
import com.lovo.service.IUserService;
@Service(value="userService")
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserDao userDao;
	
	@Override
	public UserEntity login(String username, String password) {
		
		return userDao.login(username, password);
	}

	@Override
	public void addUser(UserEntity user) {
		userDao.addUser(user);
		
	}

	@Override
	public void delUser(Integer id) {
		userDao.delUser(id);
		
	}

	@Override
	public List<UserEntity> show3(int currentpage) {
		currentpage = (currentpage - 1) * 4;
		List<UserEntity> list = userDao.show3(currentpage);
		return list;
	}

	@Override
	public int getTotalPage() {
		Integer totalCount = userDao.getTotalPage();
		Integer totalPage = (totalCount + 4 - 1) / 4;
		return totalPage;
	}

	@Override
	public void update(String password, Integer id) {
		userDao.update(password, id);
		
	}

	@Override
	public List<UserEntity> queryAlluserName() {
		
		return userDao.queryAlluserName();
	}

}

package demo.user.internal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.user.dao.UserDao;
import demo.user.entity.User;
import demo.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Transactional
	@Override
	public void insert(User user) {
		userDao.insert(user);
	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}


	@Override
	public User getById(int id) {
		return userDao.getById(id);
	}

}

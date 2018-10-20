package demo.user.dao;

import java.util.List;

import demo.user.entity.User;

public interface UserDao {
	void insert(User user);
	
	void update(User user);
	
	List<User> getAll();
	
	User getById(int id);
}

package demo.user.service;

import java.util.List;

import demo.user.entity.User;

public interface UserService {
	 void insert(User user);
	 List<User> getAll();
	 User getById(int id);
}

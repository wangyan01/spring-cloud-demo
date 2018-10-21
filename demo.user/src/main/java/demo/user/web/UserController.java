package demo.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import demo.user.entity.User;
import demo.user.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public Object getAll(){
		return userService.getAll();
	}
	
	@GetMapping(value = "/{id}")
	public Object getAll(@PathVariable("id") String id){
		return userService.getById(Long.parseLong(id));
	}
	
	@GetMapping(value = "/add")
	public Object insert(){
		User user = new User();
		int num = (int)(Math.random()*100);
		user.setAge(num);
		user.setName("zhangsan"+num);
		user.setTitle("张三"+num);
		user.setId(System.currentTimeMillis());
		userService.insert(user);
		return "success";
	}
	
	
}

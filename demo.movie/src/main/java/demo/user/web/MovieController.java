package demo.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import demo.user.pojo.User;

@RestController
public class MovieController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@GetMapping(value = "/users/{id}")
	public Object getAll(@PathVariable("id") String id){//1540020702194
		return restTemplate.getForObject("http://demo-user-app/users/"+id, User.class);
	}
	
	@GetMapping(value = "/users-instance")
	public Object showInstance(){//1540020702194
		return discoveryClient.getInstances("demo-user-app");
	}
}

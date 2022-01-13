package movie.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import movie.client.UserController;
import movie.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("movie")
public class MovieController {

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Autowired
	private UserController userController;

	@PostMapping("orderByOpenFeign")
	public String orderByOpenFeign() {
		Integer id = 1;
		User user = userController.findById(id);
		return user.toString();
	}

	@PostMapping("order")
	@HystrixCommand(fallbackMethod = "fallback")
	public String order() {
		Integer id = 2;
		User user = restTemplate.getForObject("http://microservice-user/user/" + id, User.class);

		assert user != null;
		return user.toString();
	}

	public String fallback() {
		return "失敗";
	}
}

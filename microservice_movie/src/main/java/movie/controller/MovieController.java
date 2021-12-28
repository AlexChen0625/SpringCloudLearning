package movie.controller;

import movie.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
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

	/**
	 * 購票
	 *
	 */
	@PostMapping("order")
	public String order() {
		String id = "1";
		User user = restTemplate.getForObject("http://localhost:9001/user/" + id, User.class);
		assert user != null;

		return user.toString();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}

package movie.controller;

import movie.client.UserController;
import movie.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movie")
public class MovieController {
	
	@Autowired
	private UserController userController;

	@PostMapping("orderByOpenFeign")
	public String orderByOpenFeign() {
		Integer id = 1;
		User user = userController.findById(id);
		return user.toString();
	}
}

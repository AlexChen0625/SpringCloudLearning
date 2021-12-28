package user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import user.pojo.User;
import user.service.UserService;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("")
	public List<User> findAll() {
		return userService.findAll();
	}

	@GetMapping(value = "{id}")
	public User findById(@PathVariable Integer id) {
		return userService.findById(id);
	}

	@PostMapping("save")
	public void save(@RequestBody User user) {
		userService.save(user);
	}

	@PutMapping(value = "{id}")
	public void update(@RequestBody User user, @PathVariable Integer id) {
		user.setId(id);
		userService.save(user);
	}

	@DeleteMapping(value = "{id}")
	public void delete(@PathVariable Integer id) {
		userService.deleteById(id);
	}
}

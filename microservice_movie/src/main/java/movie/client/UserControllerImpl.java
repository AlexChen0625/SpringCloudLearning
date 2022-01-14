package movie.client;

import movie.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class UserControllerImpl implements UserController {
	@Override
	public User findById(Integer id) {
		System.out.println("失敗熔斷");
		return null;
	}
}

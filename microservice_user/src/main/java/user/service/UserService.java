package user.service;

import user.pojo.User;

import java.util.List;

public interface UserService {
	public List<User> findAll();

	public User findById(Integer id);

	public void save(User user);

	public void deleteById(Integer id);
}

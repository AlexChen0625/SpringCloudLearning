package user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import user.pojo.User;

public interface UserRepository extends JpaRepository<User, Integer> {}

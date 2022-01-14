package movie.client;

import movie.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 用戶微服務介面
 * 1. @FeignClient 宣告需要調用的微服務,宣告要呼叫的方法
 * 2. 檢查Requestmapping路徑是否完整
 * 3. @Pathvariable需宣告完整參數名稱
 */
@FeignClient(value = "microservice-user", fallback = UserControllerImpl.class)
public interface UserController {
	@GetMapping(value = "/user/{id}")
	public User findById(@PathVariable(value = "id") Integer id);

}

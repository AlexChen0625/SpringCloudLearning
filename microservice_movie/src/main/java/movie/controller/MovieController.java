package movie.controller;

import movie.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("movie")
public class MovieController {

	@Autowired
	private DiscoveryClient discoveryClient;
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * 購票
	 *
	 */
	@PostMapping("order")
	public String order() {
		String id = "1";
		List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("MICROSERVICE-USER");
		//目前沒有使用負載均衡 直接使用第一個服務
		ServiceInstance serviceInstance = serviceInstanceList.get(0);

		User user = restTemplate.getForObject("http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/user/" + id, User.class);
		assert user != null;

		return user.toString();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}

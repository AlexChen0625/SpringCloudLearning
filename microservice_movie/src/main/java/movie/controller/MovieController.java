package movie.controller;

import movie.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("movie")
public class MovieController {

	//	@Autowired
	//	private DiscoveryClient discoveryClient;

	@Autowired
	private LoadBalancerClient loadBalancerClient;
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * 購票
	 *
	 */
	@PostMapping("order")
	public String order() {
		String id = "1";

		//沒有使用負載均衡 直接使用第一個服務
		//		List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("MICROSERVICE-USER");
		//		ServiceInstance serviceInstance = serviceInstanceList.get(0);

		//使用Ribbon實現負載均衡
		//ServiceInstance serviceInstance = loadBalancerClient.choose("MICROSERVICE-USER");
		User user = restTemplate.getForObject("http://microservice-user/user/" + id, User.class);

		assert user != null;

		return user.toString();
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}

# Spring Cloud

## properties

- 服務名稱

  ```spring.application.name```

- 是否將服務註冊到eureka,服務提供方必備

  ```eureka.client.register-with-eureka: true```

- 是否從eureka取得服務資訊,服務調用方必備

  ```fetch-registry: true```

## OpenFeign

- 再interface上宣告要調用對象的方法後使用

  ```@FeignClient(value = "microservice-user")```

## Hystrix

- 定義呼叫微服務失敗後的行為(e.g 調用失敗就執行fallback method)

  ```@HystrixCommand(fallbackMethod = "fallback")```


- 使用OpenFegin內建的Hystrix 先建立熔斷後要執行的類,並加入在原本FeignClient中

  ```@FeignClient(value = "microservice-user", fallback = UserControllerImpl.class)```

## Hystrix Dashboard 熔斷監控面板

- 新增一個module後 再啟動類加上

  ```@EnableHystrixDashboard```

- 在服務調用方得啟動類新增以下程式

  ```@EnableHystrix```
  ```
  @Bean
  public ServletRegistrationBean getServlet() {
    HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
    ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
    registrationBean.setLoadOnStartup(1);   	
    registrationBean.addUrlMappings("/hystrix.stream");
    registrationBean.setName("HystrixMetricsStreanServlet");
    return registrationBean;
  }
  ```
  在HystrixDahsboard(http://localhost:7777/hystrix) 輸入設定的url (http://localhost:9002/hystrix.stream)

## Zuul 動態路由

- 新建一個服務,再啟動類加上```@EnableZuulProxy``
- 配置application.yml路由規則
  ```yaml
  zuul:
    routes:
      microservice-movie:
        path: /m/**
        serviceId: microservice-movie
      microservice-user:
        path: /u/**
        serviceId: microservice-user
  ```
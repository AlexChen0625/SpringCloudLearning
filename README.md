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
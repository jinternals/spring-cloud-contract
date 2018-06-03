package com.jinternals.user.consumer.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.jinternals.user.consumer.client.MediaType.VND_USER_API_V2;

@FeignClient(name = "${feign.client.name}", url = "${feign.client.url}")
public interface UserClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/user/{id}", consumes = VND_USER_API_V2, produces = VND_USER_API_V2)
    User getUserById(@PathVariable("id") String id);

}

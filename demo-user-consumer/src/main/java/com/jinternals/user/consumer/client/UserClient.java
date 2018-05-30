package com.jinternals.user.consumer.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "${feign.client.name}", url = "${feign.client.url}")
public interface UserClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/user/{id}", consumes = " application/json;charset=UTF-8")
    User getUserById(@PathVariable("id") String id);

}

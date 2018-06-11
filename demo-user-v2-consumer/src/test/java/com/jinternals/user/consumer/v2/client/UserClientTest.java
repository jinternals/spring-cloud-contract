package com.jinternals.user.consumer.v2.client;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static com.jinternals.user.consumer.v2.client.User.Gender.MALE;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureStubRunner(ids = {"com.jinternals:demo-user:+:stubs:8012"}, workOffline = true)
@DirtiesContext
public class UserClientTest {

    @Autowired
    private UserClient service;

    @Test
    public void shouldSuccessfullyGetUserInformation() {
        // when:
        User user = service.getUserById("9febab1c-6f36-4a0b-88d6-3b6a6d81cd4a");
        // then:
        assertThat(user.getId()).isEqualTo("9febab1c-6f36-4a0b-88d6-3b6a6d81cd4a");
        assertThat(user.getEmail()).isEqualTo("pandeymradul@gmail.com");
        assertThat(user.getFirstName()).isEqualTo("mradul");
        assertThat(user.getLastName()).isEqualTo("pandey");
        assertThat(user.getGender()).isEqualTo(MALE);
    }
}
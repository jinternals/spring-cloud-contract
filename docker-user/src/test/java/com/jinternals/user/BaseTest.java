package com.jinternals.user;


import com.jinternals.user.commons.IDGenerator;
import com.jinternals.user.controllers.UserController;
import com.jinternals.user.domain.User;
import com.jinternals.user.services.UserService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

import static com.jinternals.user.commons.Gender.MALE;
import static java.util.Arrays.asList;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.MOCK;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = MOCK)
@DirtiesContext
public abstract class BaseTest {

    public static final User USER = new User("pandeymradul@gmail.com", "mradul", "pandey", MALE);
    @Autowired
    private UserController userController;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;


    @MockBean
    private UserService userService;


    @Before
    public void setup() {
        USER.setId(IDGenerator.generateID());
        Pageable pageable = new PageRequest(0, 20, null);
        PageImpl<User> users = new PageImpl<>(asList(USER), pageable, 1);

        when(this.userService.getAllUser(pageable)).thenReturn(users);
        when(this.userService.createUser(USER)).thenReturn(USER);
        when(this.userService.findById(anyString())).thenReturn(USER);

        StandaloneMockMvcBuilder standaloneMockMvcBuilder = MockMvcBuilders.standaloneSetup(userController);
        standaloneMockMvcBuilder.setCustomArgumentResolvers(pageableArgumentResolver);

        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);
    }

}

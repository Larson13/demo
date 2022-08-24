package com.ptp.web;

import com.ptp.dao.UserDao;
import com.ptp.mode.Duser;


import com.ptp.service.UserService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@DisplayName("这是一个测试类")
@SpringBootTest()
class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    @DisplayName("这是一个addTest")
    public void addTest() {

        Duser user = new Duser();
        user.setUserName("beihe");
        user.setAge(18);
        user.setPassword("1234");
        user.setId(14);
        int result = userService.add(user);
     //   Assertions.assertEquals("1",result);
        System.out.println(1);

    }


    @BeforeEach
    public void setup() {
        System.out.println("=====================setup====================");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("=====================tearDown====================");
    }

    @BeforeAll
    private static void before() {
        System.out.println("before-----------------");
    }

    @BeforeAll
    public static void end() {
        System.out.println("=====================结束测试====================");
    }

}

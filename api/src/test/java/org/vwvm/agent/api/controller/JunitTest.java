package org.vwvm.agent.api.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.vwvm.agent.AgentApplication;
import org.vwvm.agent.services.service.IMemberService;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Slf4j // 需要依赖 lombok ，之后可以使用 log对象来写日志
@SpringBootTest(classes = AgentApplication.class)
@ExtendWith(SpringExtension.class)
class JunitTest {

    @Resource
    IMemberService memberService;

    @Test
    void memberControllerTest() {
        System.out.println(memberService.list());
    }

    @BeforeAll
    static void begin() {
        log.info("********************************************");
        log.info("***** 测试模块：开始 ");
        log.info("********************************************");
    }

    @AfterAll
    static void end() {
        log.info("********************************************");
        log.info("***** 测试模块：结束 ");
        log.info("********************************************");
    }

    @BeforeEach
    void start() {
        log.info("--------------------------------------------");
        log.info("----- 测试方法：开始 ");
        log.info("--------------------------------------------");
    }

    @AfterEach
    void stop() {
        log.info("--------------------------------------------");
        log.info("----- 测试方法：结束 ");
        log.info("--------------------------------------------");
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @DisplayName("直接统计行数")
    @Test
    void countMember() {
        String sql = "select count(1) from member";
        Long num = jdbcTemplate.queryForObject(sql, Long.class);
        log.info("直接统计member的行数：" + num);
    }

    @DisplayName("三层统计行数")
    @Test
    void countMember2() {
        long num = memberService.count();
        log.info("三层统计member的行数：" + num);
    }


    @DisplayName("使用断言判断三层统计行数")
    @Test
    void countMember3() {
        Long expected = 9L;  // 期望值

        Long actual = memberService.count(); // 真实值

        // 断言：判断期望值和真实值是否相等。true则测试通过，false则测试未通过

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("simple assertion")
    public void simple() {
        Assertions.assertEquals(3, 1 + 2, "simple math");
        Assertions.assertNotEquals(3, 1 + 1);
        Assertions.assertNotSame(new Object(), new Object());
        Object obj = new Object();
        Assertions.assertSame(obj, obj);
        Assertions.assertFalse(1 > 2);
        Assertions.assertTrue(1 < 2);
        Assertions.assertNull(null);
        Assertions.assertNotNull(new Object());
    }

    @Test
    @DisplayName("array assertion")
    public void array() {
        Assertions.assertArrayEquals(new int[]{1, 2}, new int[]{1, 2});
    }

    @Test
    @DisplayName("assert all")
    public void all() {
        Assertions.assertAll("Math",
                () -> Assertions.assertEquals(2, 1 + 1),
                () -> Assertions.assertTrue(1 > 0)
        );
    }

    @Test
    @DisplayName("异常测试")
    public void exceptionTest() {
        ArithmeticException exception = Assertions.assertThrows(
                //扔出断言异常

                ArithmeticException.class, () -> System.out.println(1 % 0));
    }

    /**
     * 规定方法超时时间。超出时间测试出异常
     *
     * @throws InterruptedException
     */
    @DisplayName("超时测试")
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    @Test
    void testTimeout() throws InterruptedException {
        Thread.sleep(400); // 400 600

    }
}
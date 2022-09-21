package org.vwvm.agent.api.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.vwvm.agent.AgentApplication;
import org.vwvm.agent.services.service.IMemberService;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = AgentApplication.class)
@ExtendWith(SpringExtension.class)
class MemberControllerTest {

    @Resource
    IMemberService service;

    @Test
    void memberControllerTest(){
        System.out.println(service.list());
    }


}
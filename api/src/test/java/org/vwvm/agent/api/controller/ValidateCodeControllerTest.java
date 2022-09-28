package org.vwvm.agent.api.controller;

import com.liuvei.common.RandFun;
import com.liuvei.common.ValidateCodeFun;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.vwvm.agent.AgentApplication;
import org.vwvm.agent.commons.vo.UIConst;

import static org.junit.jupiter.api.Assertions.*;
import static org.vwvm.agent.api.controller.ValidateCodeController.getRandomStr;

@SpringBootTest(classes = AgentApplication.class)
@ExtendWith(SpringExtension.class)
class ValidateCodeControllerTest {


    @Test
    void ValiTest(){
        //1)生成4位随机数字组成的字符串

//         String strCode = RandFun.rand4Num().toString();

        String strCode = getRandomStr(4);
        //2)随机字符串放入会话
//        session.setAttribute(UIConst.BG_VALIDATE_CODE_KEY, strCode);
        //3)随机字符串转为图片
        java.awt.image.BufferedImage image = ValidateCodeFun.generalImage(strCode);
        System.out.println(image);
    }
}
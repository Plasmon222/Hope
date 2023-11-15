package com.plas.hope.controller;

import com.plas.hope.utils.JSONUtils;
import com.plas.hope.utils.OutputObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther:Plasmon222
 * @Date: 2023/11/3/10:46
 * @Description:
 */
//@CrossOrigin(origins = "*", maxAge = 3600) //解决跨域问题
@Controller
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);
    @ResponseBody
    @RequestMapping(value="/getSurveyTemplate",method = RequestMethod.POST ) //?surveyId={surveyId}
    public String index(String surveyId) { //@PathVariable("surveyId")
        logger.info("测试请求test1：");
        logger.info("surveyId:"+surveyId);

        String ccc="{\n" +
                "      \"beans\": [{\n" +
                "                  \"notesData\": \"输入正确的手机号\",\n" +
                "                  \"columnTag\": \"1\",\n" +
                "                  \"isSelect\": \"0\",\n" +
                "                  \"boxType\": \"0\",\n" +
                "                  \"boxData\": \"输入框\",\n" +
                "                  \"columnName\": \"电话号\"\n" +
                "            },\n" +
                "            {\n" +
                "                  \"notesData\": \"无注释\",\n" +
                "                  \"columnTag\": \"2\",\n" +
                "                  \"isSelect\": \"0\",\n" +
                "                  \"boxType\": \"1\",\n" +
                "                  \"boxData\": \"男；女；无性别\",\n" +
                "                  \"columnName\": \"姓别\"\n" +
                "            },\n" +
                "            {\n" +
                "                  \"notesData\": \"请输入年龄\",\n" +
                "                  \"columnTag\": \"3\",\n" +
                "                  \"isSelect\": \"0\",\n" +
                "                  \"boxType\": \"0\",\n" +
                "                  \"boxData\": \"输入框\",\n" +
                "                  \"columnName\": \"年龄\"\n" +
                "            },\n" +
                "            {\n" +
                "                  \"notesData\": \"请输入年龄\",\n" +
                "                  \"columnTag\": \"4\",\n" +
                "                  \"isSelect\": \"0\",\n" +
                "                  \"boxType\": \"0\",\n" +
                "                  \"boxData\": \"输入框\",\n" +
                "                  \"columnName\": \"年龄\"\n" +
                "            },\n" +
                "            {\n" +
                "                  \"notesData\": \"请输入年龄\",\n" +
                "                  \"columnTag\": \"5\",\n" +
                "                  \"isSelect\": \"0\",\n" +
                "                  \"boxType\": \"0\",\n" +
                "                  \"boxData\": \"输入框\",\n" +
                "                  \"columnName\": \"年龄\"\n" +
                "            },\n" +
                "            {\n" +
                "                  \"notesData\": \"请输入喜欢吃什么\",\n" +
                "                  \"columnTag\": \"6\",\n" +
                "                  \"isSelect\": \"1\",\n" +
                "                  \"boxType\": \"2\",\n" +
                "                  \"boxData\": \"牛奶；面包；可乐；土豆\",\n" +
                "                  \"columnName\": \"食物\"\n" +
                "            },\n" +
                "            {\n" +
                "                  \"notesData\": \"请输入喜欢吃什么\",\n" +
                "                  \"columnTag\": \"7\",\n" +
                "                  \"isSelect\": \"1\",\n" +
                "                  \"boxType\": \"2\",\n" +
                "                  \"boxData\": \"牛奶；面包；可乐；土豆\",\n" +
                "                  \"columnName\": \"食物\"\n" +
                "            }\n" +
                "      ],\n" +
                "      \"bean\": {\n" +
                "            \"total\": 0\n" +
                "      },\n" +
                "      \"object\": {\"surveyName\":\"This is Tittle.问卷题目\"},\n" +
                "      \"totalCount\": 0,\n" +
                "      \"returnMessage\": \"查询成功！\",\n" +
                "      \"returnCode\": \"0\"\n" +
                "}";
        return ccc;
    }
    @ResponseBody
    @RequestMapping(value="/saveSurveyTemplateData",method = RequestMethod.POST )
//    public String index2(@RequestBody Map<String, String> map) {
    public String index2(@RequestBody String params) {
        logger.info("保存请求save：params="+params);
//        for (String value : map.values()) {
//            System.out.println("Value: " + value);
//        }
//        logger.info("保存请求save："+save);
        String ccc="{    \"object\": null,\n" +
                "    \"totalCount\": 0,\n" +
                "    \"returnMessage\": \"查询成功！\",\n" +
                "   \"returnCode\": \"0\"}";
        return ccc;
    }
}

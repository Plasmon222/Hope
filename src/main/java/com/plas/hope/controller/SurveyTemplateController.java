package com.plas.hope.controller;

import com.plas.hope.utils.OutputObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.concurrent.atomic.AtomicInteger;


/**
 * @Auther:Plasmon222
 * @Date: 2023/11/3/10:46
 * @Description:
 */
//@CrossOrigin(origins = "*", maxAge = 3600) //解决跨域问题
@Controller
@ResponseBody
public class SurveyTemplateController {
    private static final Logger logger = LoggerFactory.getLogger(SurveyTemplateController.class);
    private final AtomicInteger count = new AtomicInteger(0);
    private Map<String, Object> pdcf = new HashMap<String, Object>();
    @RequestMapping(value = "/getSurveyTemplate", method = RequestMethod.POST) //?surveyId={surveyId}
    public OutputObject index(@RequestBody Map<String, Object> inmap) { //@PathVariable("surveyId")
        logger.info("---获取模版方法执行中---");
        OutputObject outputObject = new OutputObject();
        List<Map<String, Object>> beansList = new ArrayList<>();
        Map<String, Object> beans = new HashMap<String, Object>();
        Map<String, Object> beans2 = new HashMap<String, Object>();
        Map<String, Object> beans3 = new HashMap<String, Object>();
        try {
            logger.info("surveyId:" + inmap.get("surveyId"));
            beans.put("notesData", "输入正确的手机号");
            beans.put("columnTag", "1");
            beans.put("isSelect", "0");
            beans.put("boxType", "0");
            beans.put("boxData", "输入框");
            beans.put("columnName", "电话号");
            beansList.add(beans);
            beans2.put("notesData", "无注释");
            beans2.put("columnTag", "2");
            beans2.put("isSelect", "0");
            beans2.put("boxType", "0");
            beans2.put("boxData", "男；女；无性别");
            beans2.put("columnName", "性别");
            beansList.add(beans2);
            beans3.put("notesData", "请输入喜欢吃什么");
            beans3.put("columnTag", "3");
            beans3.put("isSelect", "1");
            beans3.put("boxType", "2");
            beans3.put("boxData", "牛奶；面包；可乐；土豆");
            beans3.put("columnName", "食物");
            beansList.add(beans3);
            outputObject.setBeans(beansList);
            Map<String, String> object = new HashMap<String, String>();
            object.put("surveyName", "问卷题目");
            object.put("gpTime", "2024-01-01");
            object.put("surveyType", "0");
            outputObject.setObject(object);
            outputObject.setRtnCode("0");
            outputObject.setRtnMsg("查询成功");
        } catch (Exception e) {
            outputObject.setRtnCode("9999");
            outputObject.setRtnMsg("查询失败");
        }
        return outputObject;
    }
    //获取用户是否在目标名单中没
    @RequestMapping(value = "/isExistSurveyType", method = RequestMethod.POST)
    public OutputObject isExistSurveyType(@RequestBody Map<String, Object> inmap) { //@PathVariable("surveyId")
        logger.info("---获取用户是否在调研名单方法执行中---");
        OutputObject outputObject = new OutputObject();
        List<Map<String, Object>> beansList = new ArrayList<>();
        try {
            logger.info("surveyType:" + inmap.get("surveyType"));
            logger.info("phoneNum:" + inmap.get("phoneNum"));
            Map<String, String> object = new HashMap<String, String>();
            if (inmap.get("phoneNum").equals("15102630646")) {
                object.put("isExist", "0");
                object.put("rtnMsg", "填写的号码在调研名单中");
            } else {
                object.put("isExist", "1");
                object.put("rtnMsg", "填写的号码不在调研名单中");
            }
            outputObject.setObject(object);
            outputObject.setRtnCode("0");
            outputObject.setRtnMsg("查询成功");
        } catch (Exception e) {
            outputObject.setRtnCode("9999");
            outputObject.setRtnMsg("查询失败");
        }
        return outputObject;
    }
    //获取用户三个月是否已经填写
    @RequestMapping(value = "/isWriteSurveyType", method = RequestMethod.POST)
    public OutputObject isWriteSurveyType(@RequestBody Map<String, Object> inmap) { //@PathVariable("surveyId")
        logger.info("---获取用户是否已经填写方法执行中---");
        OutputObject outputObject = new OutputObject();
        List<Map<String, Object>> beansList = new ArrayList<>();
        try {
            logger.info("surveyId:" + inmap.get("surveyId"));
            logger.info("phoneNum:" + inmap.get("phoneNum"));
            Map<String, String> object = new HashMap<String, String>();
            if(pdcf.get(inmap.get("phoneNum"))==null
                    ||
            pdcf.get(inmap.get("phoneNum")).equals("")){
                pdcf.put((String) inmap.get("phoneNum"),"0");
                //
            }else {
                pdcf.put((String) inmap.get("phoneNum"),"1");
            }
            if (pdcf.get(inmap.get("phoneNum")).equals("0")) {
                object.put("isWrite", "0");
                object.put("rtnMsg", "该号码用户三个月内未填写过问卷，请填写");
            } else {
                object.put("isWrite", "1");
                object.put("rtnMsg", "该号码用户三个月内填写过问卷，无法再填");
            }
            outputObject.setObject(object);
            outputObject.setRtnCode("0");
            outputObject.setRtnMsg("查询成功");
        } catch (Exception e) {
            outputObject.setRtnCode("9999");
            outputObject.setRtnMsg("查询失败");
        }
        return outputObject;
    }

    @RequestMapping(value = "/saveSurveyTemplateData", method = RequestMethod.POST)
    public String index2(@RequestBody Map<String, String> map) {
//    public String index2(@RequestBody String params) {
        logger.info("保存请求save：params=");
        System.out.println(map.toString());
        String ccc = "{    \"object\": null,\n" +
                "    \"totalCount\": 0,\n" +
                "    \"returnMessage\": \"查询成功！\",\n" +
                "   \"returnCode\": \"0\"}";
        return ccc;
    }
}

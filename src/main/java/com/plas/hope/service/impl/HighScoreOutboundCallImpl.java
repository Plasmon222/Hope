package com.plas.hope.service.impl;

import com.plas.hope.controller.TestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.style.ValueStyler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther:Plasmon222
 * @Date: 2023/11/16/14:29
 * @Description:
 */
public class HighScoreOutboundCallImpl {
    private static final Logger logger = LoggerFactory.getLogger(HighScoreOutboundCallImpl.class);

    public static void main(String[] args) {
        String details = "您对这次服务的整体感觉(9);话务员的服务态度(6分);话务员的服务技能(9分);本次通话，您的诉求（或问题）是否得到解决=否(是);Q7.业务办理规范性和便捷性≥9或为空(9分);";
        //业务推荐合理性≥9或为空(9分);业务办理规范性和便捷性≥9或为空(9分);

        List<String> list1 = new ArrayList<>();
        String fenshu = "";
        Pattern pattern = Pattern.compile("(?<=\\()[^\\)]+"); //无括号
        String[] QqSplit = details.split(";");
        for (int i = 0; i < QqSplit.length; i++) {
            //获取括号中内容
            Matcher matcher = pattern.matcher(QqSplit[i]);
            if (matcher.find()) {
                String str = matcher.group();
                str = str.replace("分", "");
                list1.add(str);
                fenshu = str;
            } else {
                list1.add("");
            }
        }

        Boolean pdshuzi = false;
        String isFilter = "1";
        for (int i = 0; i <list1.size() ; i++) {
            if (list1.get(i).equals("是")) {
                isFilter = "1";
                pdshuzi = false;
                break;
            } else {
                if (list1.get(i).equals("否")) continue;
                int fen = Integer.valueOf(list1.get(i));
                if (fen < 9) {
                    pdshuzi = false;
                    break;
                } else {
                    pdshuzi = true;
                }
            }
        }
        if (pdshuzi) {
            isFilter = "0";
        }

        System.out.println("list1=" + list1);
        System.out.println("isFilter===" + isFilter);

    }


}

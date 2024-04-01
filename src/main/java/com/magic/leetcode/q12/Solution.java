package com.magic.leetcode.q12;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;

/**
 * @author : yanzeyu
 * @program: DailyLeetcode
 * @description:
 * @create: 2022/11/17 17:51
 */
public class Solution {
    public static void main(String[] args) {
        String lastCancelTime = "2022-12-19 00:00:00";

        DateTime dateTime = DateUtil.parseDate(lastCancelTime);

        //LocalTime parse = LocalTime.parse(lastCancelTime);
        System.out.println(dateTime);

        Date now = new Date();
        boolean before = now.before(dateTime);
        System.out.println(before);

    }
}

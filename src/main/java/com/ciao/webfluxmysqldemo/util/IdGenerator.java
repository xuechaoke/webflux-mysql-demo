package com.ciao.webfluxmysqldemo.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import static java.lang.System.currentTimeMillis;

public class IdGenerator {
    private volatile static int count = 0;
    private static DecimalFormat format = new DecimalFormat("0000000");

    public static String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }

    /**
     * 获取绝对唯一id
     * @return 我的
     */
    public static String generateOrderNo() {
        return new SimpleDateFormat("yyyyMMddhhmmss").format(new Date(currentTimeMillis())) + _getCount();
    }

    /**
     * 获取自增序列
     *
     * @return 自增序列
     */
    private static synchronized String _getCount() {
        return format.format(count++);
    }
}

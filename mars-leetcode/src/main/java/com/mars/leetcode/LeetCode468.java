package com.mars.leetcode;

/**
 * @author shenchen
 * @version 1.0
 * @date 2022/2/8 8:57 下午
 */
public class LeetCode468 {

    public String validIPAddress(String queryIP) {
        if (queryIP.chars().filter(ch -> ch == '.').count() == 3) {
            return validateIPv4(queryIP);
        }
        if (queryIP.chars().filter(ch -> ch == ':').count() == 7) {
            return validateIPv6(queryIP);
        }
        return "Neither";
    }

    public String validateIPv4(String queryIP) {
        String[] nums = queryIP.split("\\.", -1);
        for (String num: nums) {
            // 排除不是1～3位的情况
            if (num.length() == 0 || num.length() > 3) {
                return "Neither";
            }
            // 排除开头为0的情况
            if (num.charAt(0) == '0' && num.length() > 1) {
                return "Neither";
            }
            // 排除不为数字的情况
            for (char ch: num.toCharArray()) {
                if (!Character.isDigit(ch)) {
                    return "Neither";
                }
            }
            // 排除大于255的情况
            if (Integer.parseInt(num) > 255) {
                return "Neither";
            }
        }
        return "IPv4";
    }

    public String validateIPv6(String queryIP) {
        String[] nums = queryIP.split(":", -1);
        String hexdigits = "0123456789abcdefABCDEF";
        for (String num: nums) {
            // 排除不是1～4位的情况
            if (num.length() == 0 || num.length() > 4) {
                return "Neither";
            }
            // 排除不为16进制字符情况
            for (char ch: num.toCharArray()) {
                if (hexdigits.indexOf(ch) == -1) {
                    return "Neither";
                }
            }
        }
        return "IPv6";
    }

}

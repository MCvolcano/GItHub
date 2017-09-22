package com.util;

/**
 * 字符串判空处理
 * @author Administrator
 *
 */
public class StringUtil {
	public static boolean strIsEmpty(String s) {
		if (s == null || s.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}

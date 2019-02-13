package com.peter.spring.offer.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateUtils {
	private static Map<String, DateFormat> FormatterPool = new HashMap<String, DateFormat>();
	public final static String PATTERN_yyyy_MM_dd = "yyyy-MM-dd";
	public final static String PATTERN_yyyy_MM_ddHHmmss = "yyyy-MM-dd HH:mm:ss";

	public static int differentDays(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);

		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		int day1 = cal1.get(Calendar.DAY_OF_YEAR);
		int day2 = cal2.get(Calendar.DAY_OF_YEAR);

		int year1 = cal1.get(Calendar.YEAR);
		int year2 = cal2.get(Calendar.YEAR);
		if (year1 != year2) { // 同一年
			int timeDistance = 0;
			for (int i = year1; i < year2; i++) {
				if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) { // 闰年
					timeDistance += 366;
				} else { // 不是闰年
					timeDistance += 365;
				}
			}
			return timeDistance + (day2 - day1);
		} else {// 不同年
			return day2 - day1;
		}
	}

	/**
	 * 获取当天的开始时间
	 * 
	 * @return
	 */
	public static Date getTodayStartTime() {
		Calendar today = Calendar.getInstance();
		today.setTime(new Date());
		today.set(Calendar.HOUR_OF_DAY, 0);
		today.set(Calendar.MINUTE, 0);
		today.set(Calendar.SECOND, 0);
		today.set(Calendar.MILLISECOND, 0);
		return today.getTime();
	}

	/**
	 * 获取当天的结束时间
	 * 
	 * @return
	 */
	public static Date getTodayEndTime() {
		Calendar today = Calendar.getInstance();
		today.set(Calendar.HOUR_OF_DAY, 23);
		today.set(Calendar.MINUTE, 59);
		today.set(Calendar.SECOND, 59);
		today.set(Calendar.MILLISECOND, 999);
		return today.getTime();
	}

	/**
	 * 获取过去某天的开始时间
	 * 
	 * @param past 过去的天数
	 * @return
	 */
	public static Date getPastStartTime(int past) {
		Calendar today = Calendar.getInstance();
		today.set(Calendar.DAY_OF_YEAR, today.get(Calendar.DAY_OF_YEAR) - past);
		today.set(Calendar.HOUR_OF_DAY, 0);
		today.set(Calendar.MINUTE, 0);
		today.set(Calendar.SECOND, 0);
		today.set(Calendar.MILLISECOND, 0);
		return today.getTime();
	}

	/**
	 * 获取未来某天的结束时间
	 * 
	 * @param future 将来的天数
	 * @return
	 */
	public static Date getFutrueEndTime(int future) {
		Calendar today = Calendar.getInstance();
		today.set(Calendar.DAY_OF_YEAR, today.get(Calendar.DAY_OF_YEAR) + future);
		today.set(Calendar.HOUR_OF_DAY, 23);
		today.set(Calendar.MINUTE, 59);
		today.set(Calendar.SECOND, 59);
		today.set(Calendar.MILLISECOND, 999);
		return today.getTime();
	}
	/**
	 * 获取未来某天的开始时间
	 * @param future 将来的天数
	 * @return
	 */
	public static Date getFutrueStartTime(int future) {
		Calendar today = Calendar.getInstance();
		today.set(Calendar.DAY_OF_YEAR, today.get(Calendar.DAY_OF_YEAR) + future);
		today.set(Calendar.HOUR_OF_DAY, 0);
		today.set(Calendar.MINUTE, 0);
		today.set(Calendar.SECOND, 0);
		today.set(Calendar.MILLISECOND, 0);
		return today.getTime();
	}
	/**
	 * 获取指定日期的开始时间
	 * @return
	 */
	public static Date getDateStartTime(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 获取指定日期的结束时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getDateEndTime(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTime();
	}
	/**
	 * 格式化日期
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String formatDate(Date date, String pattern) {
		final SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		return formatter.format(date);
	}

	/**
	 * 将秒转换成 天 时 分 秒
	 * 
	 * @param mss
	 * @return
	 */
	public static String formatDateTime(long second) {
		String DateTimes = null;
		long days = second / (60 * 60 * 24);
		long hours = (second % (60 * 60 * 24)) / (60 * 60);
		long minutes = (second % (60 * 60)) / 60;
		long seconds = second % 60;
		if (days > 0) {
			DateTimes = days + "天" + hours + "小时" + minutes + "分钟" + seconds + "秒";
		} else if (hours > 0) {
			DateTimes = hours + "小时" + minutes + "分钟" + seconds + "秒";
		} else if (minutes > 0) {
			DateTimes = minutes + "分钟" + seconds + "秒";
		} else {
			DateTimes = seconds + "秒";
		}
		return DateTimes;
	}
	
	/**
	 * 获取当前系统时间
	 * @return
	 */
	public static Date getCurrentTime() {
		return Calendar.getInstance().getTime();
	}
	
	/**
	 * @remark 根据时间，生成以年月日+毫秒计算的时间
	 * @return String
	 */
	public static String getDateTimeStr() {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		date.getTime();
		String formatdate = fmt.format(date);
		return String.valueOf(formatdate + date.getTime());
	}
	
	/**
	 * 转换指定时间的显示方式
	 * @param value
	 * @param pattern
	 * @return
	 * @throws ParseException
	 */
	public static Date parseTime(String value, String pattern) throws ParseException {
		return getFormatter(pattern).parse(value);
	}
	
	/**
	 作为格式转换用
	 * getFormatter(pattern).format(time)
	 * getFormatter(pattern).parse(value);
	 * @param pattern
	 * @return
	 */
	private static DateFormat getFormatter(String pattern) {
		DateFormat df = FormatterPool.get(pattern);
		if (df == null) {
			df = new SimpleDateFormat(pattern);
			FormatterPool.put(pattern, df);
		}
		return df;
	}
	
	/**
	 * 根据pattern返回当前时间
	 * @param pattern
	 * @return 
	 */
	public static String getCurrentTime(String pattern) {
		return formatTime(pattern, getCurrentTime());
	}
	
	/**
	 * 格式化指定时间的指定显示方式
	 */
	public static String formatTime(String pattern, Date time) {
		return getFormatter(pattern).format(time);
	}
}

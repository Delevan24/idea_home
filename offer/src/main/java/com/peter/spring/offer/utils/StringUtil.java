package com.peter.spring.offer.utils;


import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 工具类
 * @author blue
 *
 */
public class StringUtil {
	
	private static Pattern pattern = Pattern.compile("[\u0001-\u001F]");
	/**
	 * 客服回复的list
	 */
	
	/**
	 * 默认的日期格式
	 */
	private static final String DEFAULT_DATE_FAMAT = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 日期转字符串 默认格式
	 * 
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date) {
		return dateToString(date, DEFAULT_DATE_FAMAT);
	}

	/**
	 * 日期转字符串 指定格式
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String dateToString(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	/**
	 * 二进制转十进制
	 * @param s
	 * @return
	 */
	public static int convertAlgorism(String s){
		if(isEmptyStr(s)){
			return 0;
		}
		return convertAlgorism(s.toCharArray());
	}
	/**
	 * 二进制转十进制
	 * @param cars
	 * @return
	 */
	public static int convertAlgorism(char[] cars) {
		if(cars==null){
			return 0;
		}
		return Integer.parseInt(String.valueOf(cars),2);
	}
	/**
	 * 判断字符串是否为null
	 * 
	 * @param string
	 * @return
	 */
	public static boolean checkNull(String string) {
		if (string == null || "".equals(string.trim())
				|| "null".equalsIgnoreCase(string.trim())) {
			return true;
		}
		return false;
	}

	/**
	 * 判断字符串是否为空
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isEmptyStr(String string) {
		if (string == null || "".equals(string.trim())) {
			return true;
		}
		return false;
	}

	/***
	 * 判断字符串是不是数字
	 * @param s
	 * @return
	 */
	public static boolean isNum(String s){
		try {
			Integer.parseInt(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	/**
	 * 对字符串进行简单html编码,以便页面显示不会乱码
	 * 
	 * @param str
	 * @return
	 */
	public static String htmlEncode(String str) {
		if (str == null || str.length() == 0) {
			return "";
		}
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll(" ", "&#160;");
		str = str.replaceAll("\n", "&#160;");
		str = str.replaceAll("\"", "&quot;");
		Matcher m = pattern.matcher(str);
		str = m.replaceAll("");
		return str;
	}

	public static String htmlEncodeNick(String str) {
		if (str == null || str.length() == 0) {
			return "";
		}
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("#", "&#35;");
		str = str.replaceAll(",", "&#44;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll(" ", "&#160;");
		str = str.replaceAll("\n", "&#160;");
		str = str.replaceAll("\"", "&quot;");
		str = str.replaceAll("[|]", "&#124;");
		str = str.replaceAll("[$]", "");
		Matcher m = pattern.matcher(str);
		str = m.replaceAll("");
		return str;
	}

	/**
	 * 去除uc的token中+,/等url需编码的字符
	 * @param str
	 * @return
	 */
	public static String removeUrlChar(String str) {
		if (str == null || str.length() == 0) {
			return "";
		}
		str = str.replaceAll("[+]", "");
		str = str.replaceAll("[/]", "");
		return str;
	}

	/**
	 * 过滤sid中的攻击性字符
	 * @param str
	 * @return
	 */
	public static String filterBadChar(String str) {
		if (str == null || str.length() == 0) {
			return "";
		}
		str = str.replaceAll("[|]", "");
		str = str.replaceAll("[&]", "");
		str = str.replaceAll("[;]", "");
		str = str.replaceAll("[$]", "");
		str = str.replaceAll("[%]", "");
		str = str.replaceAll("[@]", "");
		str = str.replaceAll("[']", "");
		str = str.replaceAll("[\"]", "");
		str = str.replaceAll("[\\\\]", "");
		str = str.replaceAll("[<]", "");
		str = str.replaceAll("[>]", "");
		str = str.replaceAll("[(]", "");
		str = str.replaceAll("[)]", "");
		str = str.replaceAll("[+]", "");
		str = str.replaceAll("[\r]", "");
		str = str.replaceAll("[\n]", "");
		str = str.replaceAll("[,]", "");
		str = str.replaceAll("[ ]", "");
		return str;
	}

	/**
	 * 记录日志
	 * */
	public static void writeLog(String path, String content) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(path, true);
			BufferedWriter bfW = new BufferedWriter(fw);
			bfW.write(content);
			bfW.newLine();
			bfW.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	

	/**
	 * 分割字符串
	 * 
	 * @param original
	 * @param regex
	 * @return
	 */
	public static String[] splitString(String original, String regex) {
		// 取子串的起始位置
		int startIndex = 0;
		// 将结果数据先放入Vector中
		Vector<String> v = new Vector<String>();
		// 返回的结果字符串数组
		String[] str = null;

		// 存储取子串时起始位置
		int index = 0;
		if (original == null) {
			return null;
		}
		// 获得匹配子串的位置
		startIndex = original.indexOf(regex);
		// 如果起始字符串的位置小于字符串的长度，则证明没有取到字符串末尾。
		// -1代表取到了末尾
		while (startIndex < original.length() && startIndex != -1) {
			String temp = original.substring(index, startIndex);
			// 取子串
			v.addElement(temp);
			// 设置取子串的起始位置
			index = startIndex + regex.length();
			// 获得匹配子串的位置
			startIndex = original.indexOf(regex, index);
		}
		// 取结束的子串
		v.addElement(original.substring(index));
		// 将Vector对象转换成数组
		str = new String[v.size()];
		for (int i = 0; i < v.size(); i++) {
			str[i] = v.elementAt(i);
		}
		// 返回生成的数组
		return str;
	}
	
	/**
	 * 去除字符串中的逗号
	 * @param s
	 * @return
	 */
	public static  String getStringp(String s){
		String ss = "";
		String sss[] = StringUtil.splitString(s, ",");
		for(int i=0;i<sss.length;i++){
			ss = ss.concat(sss[i]);
		}
		return ss;
	} 
	
	/**
	 * 去掉空格、回车、换行符、制表符,html空格(&nbsp;)
	 * @param str
	 * @return
	 */
	public static String replaceBlank(String str) {
		String a= "";
		if (str!=null) {
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Matcher m = p.matcher(str);
			a= m.replaceAll("").replaceAll("&nbsp;","");
		}
		return a;
	}
	

	/**
	 * 生成uuid字符串，不带-
	 * @return
	 */
	public static String getUUID(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replaceAll("-", "");
	}

	/**
	 * 生成uuid字符串，带-
	 * @return
	 */
	public static String getUUIDWithMinus(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
	
	/**
     * 输入字符串是否为null或空字符串
     * @param s - 输入字符串 
     * @return
     */
    public static boolean IsNullOrEmpty(String s) 
    {
    	return s == null || s.length() == 0;
    }
	
	/**
	 * 验证密码是否过于简单 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public static boolean passwordVerification(String password){
		//必须包含字母大小写、数字、字符 至少3种
		int count=0;
		if(password.matches("^.*[a-z]+.*$")){
			count=count+1;
		}
		if(password.matches("^.*[A-Z]+.*$")){
			count=count+1;
		}
		if(password.matches("^.*[0-9]+.*$")){
			count=count+1;
		}
		if(password.matches("^.*[^a-zA-Z0-9]+.*$")){
			count=count+1;
		}
		if(count<2){
			return false;
		}
		//新密码过于简单
		if ("123456".equals(password) || "aly123456".equals(password)) {
			return false;
		}
		return true;
	}

	/**
	 * 自定义格式输出文本{0} {1}
	 * @param s
	 * @param objects
	 * @return
	 */
	public static String format(String s,Object ...objects){
		if(objects!=null&&objects.length>0){
			StringBuilder sb = new StringBuilder();
			int i=0;
			sb.append("{").append(i).append("}");
			int j = s.indexOf(sb.toString());
			while(j>=0){
				if(i<objects.length){
					s=s.replace(sb.toString(), objects[i]==null?"":objects[i].toString());
				}
				i++;
				sb = new StringBuilder();
				sb.append("{").append(i).append("}");
				j = s.indexOf(sb.toString());
			}
		}
		return s;
	}

	@SuppressWarnings("unchecked")
	private static <T> T to(String string,T defaultVal){
		T rt=defaultVal;
		try {
			if(defaultVal instanceof Integer){
				rt=(T)Integer.valueOf(string);
			}else if(defaultVal instanceof Short){
				rt=(T)Short.valueOf(string);
			}else if(defaultVal instanceof Float){
				rt=(T)Float.valueOf(string);
			}else if(defaultVal instanceof Long){
				rt=(T)Long.valueOf(string);
			}else if(defaultVal instanceof Double){
				rt=(T)Double.valueOf(string);
			}else if(defaultVal instanceof Byte){
				rt=(T)Byte.valueOf(string);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return rt;
	}
	/**
	 * 字符串转int
	 * @param string
	 * @return
	 */
	public static int toInt(String string){
		return toInt(string, 0);
	}
	/**
	 * 字符串转int
	 * @param string
	 * @param defaultVal
	 * @return
	 */
	public static int toInt(String string,int defaultVal){
		if(isEmptyStr(string)){
			return defaultVal;
		}
		return to(string, defaultVal);
	}
	/**
	 * 字符串转byte
	 * @param string
	 * @return
	 */
	public static byte toByte(String string){
		return toByte(string, (byte)0);
	}
	/**
	 * 字符串转byte
	 * @param string
	 * @param defaultVal
	 * @return
	 */
	public static byte toByte(String string,byte defaultVal){
		if(isEmptyStr(string)){
			return defaultVal;
		}
		return to(string, defaultVal);
	}
	/**
	 * 字符串转short
	 * @param string
	 * @return
	 */
	public static short toShort(String string){
		return toShort(string,(short)0);
	}
	/**
	 * 字符串转short
	 * @param string
	 * @param defaultVal
	 * @return
	 */
	public static short toShort(String string,short defaultVal){
		if(isEmptyStr(string)){
			return defaultVal;
		}
		return to(string, defaultVal);
	}
	/**
	 * 字符串转long
	 * @param string
	 * @return
	 */
	public static long toLong(String string){
		return toLong(string,0l);
	}
	/**
	 * 字符串转long
	 * @param string
	 * @param defaultVal
	 * @return
	 */
	public static long toLong(String string,long defaultVal){
		if(isEmptyStr(string)){
			return defaultVal;
		}
		return to(string, defaultVal);
	}
	/**
	 * 字符串转float
	 * @param string
	 * @return
	 */
	public static float toFloat(String string){
		return toFloat(string,0f);
	}
	/**
	 * 字符串转float
	 * @param string
	 * @param defaultVal
	 * @return
	 */
	public static float toFloat(String string,float defaultVal){
		if(isEmptyStr(string)){
			return defaultVal;
		}
		return to(string, defaultVal);
	}
	/**
	 * 字符串转double
	 * @param string
	 * @return
	 */
	public static double toDouble(String string){
		return toDouble(string, 0d);
	}
	/**
	 * 字符串转double
	 * @param string
	 * @param defaultVal
	 * @return
	 */
	public static double toDouble(String string,double defaultVal){
		if(isEmptyStr(string)){
			return defaultVal;
		}
		return to(string, defaultVal);
	}
	
	public static InputStream getResourceInputStream(String res){
		
		try {
			URL url = StringUtil.class.getClassLoader().getResource(res);
			return new FileInputStream(url.getPath());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String randomUUID(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replace("-", "");
	}
	
	public static String parseToSimpleString(String string){
		if (IsNullOrEmpty(string)) {
			return "";
		}
		return string.replace("[", "").replace("]", "");
	}
	
	public static String getStringNum(String str) {
		str = str.trim();
		StringBuilder sb = new StringBuilder();
		if (str != null && !"".equals(str)) {
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
					sb.append(str.charAt(i));
				}
			}

		}
		return sb.toString();
	}
	
	// 将数字转换成字母  
    public static String numToLetter(Integer num) {
        if (num <= 0) {
            return null;
        }
        String letter = "";
        num--;
        do {
            if (letter.length() > 0) {
                num--;
            }
            letter = ((char) (num % 26 + (int) 'A')) + letter;
            num = (int) ((num - num % 26) / 26);
        } while (num > 0);

        return letter;
    }
}

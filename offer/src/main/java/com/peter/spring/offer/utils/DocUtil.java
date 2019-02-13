package com.peter.spring.offer.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class DocUtil {
    /**
     * 根据Doc模板生成word文件
     * @param dataMap Map 需要填入模板的数据
     * @param fileName 文件名称
     * @param savePath 保存路径
     */
    @SuppressWarnings("deprecation")
	public static File createDoc(Map<String, Object> dataMap, String savePath){
    	try {
            //创建配置实例 
            Configuration configuration = new Configuration();
           
            //设置编码
                configuration.setDefaultEncoding("UTF-8");
                //ftl模板文件统一放至 com.lun.template 包下面
                configuration.setClassForTemplateLoading(DocUtil.class,"/com/yrys/common/util/");
                
                //获取模板 
                Template template = configuration.getTemplate("sqjy.ftl");
                
                //输出文件
                File outFile = new File(savePath);
                //如果输出目标文件夹不存在，则创建
                if (!outFile.getParentFile().exists()){
                    outFile.getParentFile().mkdirs();
                }
                
                //将模板和数据模型合并生成文件 
                Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile),"UTF-8"));


                //生成文件
                template.process(dataMap, out);
                
                //关闭流
                out.flush();
                out.close();
                
                return outFile;
            } catch (Exception e) {
                e.printStackTrace();
            }
    	
    	return null;
    }
    
    /** 
     * @param args 
     * @throws UnsupportedEncodingException  
     */  
    public static void main(String[] args) throws UnsupportedEncodingException {;  
  
        Map<String, Object> dataMap = new HashMap<String, Object>();  
        dataMap.put("zsdname", "知识点名称");
        dataMap.put("jxmb", "1、教学目标教学目标教学目标<w:br/>2、教学目标教学目标教学目标");
        dataMap.put("jxzd", "教学重点教学重点教学重点");
        dataMap.put("jxnd", "教学难点教学难点教学难点");
        dataMap.put("jxdr", "教学导入教学导入教学导入");
        dataMap.put("zsdjj", "知识点讲解知识点讲解知识点讲解知识点讲解");
        dataMap.put("wbk", "文本框文本框文本框文本框文本框");
        dataMap.put("mt", "母题母题母题母题母题");
        dataMap.put("bst", "变式题变式题变式题变式题变式题");
        dataMap.put("stlx", "随堂练习随堂练习随堂练习随堂练习随堂练习");
        dataMap.put("ysxj", "总结总结总结总结");
  
//        createDoc(dataMap, "/Users/blue/Downloads/word/outFile1.doc");  
        numToLetter("1");
    }  
  
 // 将数字转换成字母  
    public static void numToLetter(String input) {  
        System.out.print(String.valueOf((char) (input.getBytes()[0] + 48)).toUpperCase());  
    } 
}

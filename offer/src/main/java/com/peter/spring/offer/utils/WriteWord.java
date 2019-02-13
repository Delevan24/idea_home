package com.peter.spring.offer.utils;

import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.*;

public class WriteWord {

	
	public void htmlToWord2(String writePath, String inputBody) throws Exception {  
	    //InputStream bodyIs = new FileInputStream("E:\\巨人\\404.html");  
	    //InputStream cssIs = new FileInputStream("f:\\1.css");  
	    //String body = this.getContent(bodyIs);  
	    //String css = this.getContent(cssIs);  
	    //拼一个标准的HTML格式文档  
	    String content = "<html><head><meta http-equiv='Content-Type' content='text/html; charset=UTF-8'></head><body>" + inputBody + "</body></html>";  
	    InputStream is = new ByteArrayInputStream(content.getBytes("UTF-8")); //GBK 
	    OutputStream os = new FileOutputStream(writePath);  
	    this.inputStreamToWord(is, os);
	    //this.word(content, writePath);
	}  
	        
	
	public void word(String content,String writePath) throws IOException {
		 byte b[] = content.getBytes();
	     ByteArrayInputStream bais = new ByteArrayInputStream(b);
	     POIFSFileSystem poifs = new POIFSFileSystem();
	     DirectoryEntry directory = poifs.getRoot();
	     DocumentEntry documentEntry = directory.createDocument("WordDocument", bais);
	     FileOutputStream ostream = new FileOutputStream(writePath);
	     poifs.writeFilesystem(ostream);
	     bais.close();
	     ostream.close();
	}
	
	/** 
	* 把is写入到对应的word输出流os中 
	* 不考虑异常的捕获，直接抛出 
	* @param is 
	* @param os 
	* @throws IOException 
	*/  
	private void inputStreamToWord(InputStream is, OutputStream os) throws IOException {  
	    POIFSFileSystem fs = new POIFSFileSystem();  
	    //对应于org.apache.poi.hdf.extractor.WordDocument  
	    fs.createDocument(is, "WordDocument");  
	    fs.writeFilesystem(os);  
	    os.close();  
	    is.close();  
	}  
	        
	/** 
	* 把输入流里面的内容以UTF-8编码当文本取出。 
	* 不考虑异常，直接抛出 
	* @param ises 
	* @return 
	* @throws IOException 
	*/  
	private String getContent(InputStream... ises) throws IOException {  
	    if (ises != null) {  
	        StringBuilder result = new StringBuilder();  
	        BufferedReader br;  
	        String line;  
	        for (InputStream is : ises) {  
	            br = new BufferedReader(new InputStreamReader(is, "GBK"));  
	            while ((line=br.readLine()) != null) {  
	                result.append(line);  
	            }  
	        }  
	        return result.toString();  
	    }  
	    return null;  
	}  

	public static void main(String args[]) throws Exception {
		WriteWord t=new WriteWord();
		//t.htmlToWord2();
		
		
	}

}

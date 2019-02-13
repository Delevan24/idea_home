package com.peter.spring.offer.method;

public class MultiThreadReadByLine {
	public static void main(String[] args){
		// FileReader fileReader = new FileReader("D://暮光之城3：月食_hd.mp4",100,3);
		FileReader fileReader = new FileReader("D://新建文本文档.txt",100,3);
		fileReader.registerHanlder(new FileLineDataHandler());
		fileReader.startRead();
	}
}

package com.peter.spring.offer.method;

import com.peter.spring.offer.method.Interface.DataProcessHandler;

import java.io.UnsupportedEncodingException;

public class FileLineDataHandler implements DataProcessHandler {
	private String encode = "GBK";
	
	@Override
	public void process(byte[] data) {
		try {
			System.out.println(new String(data, encode).toString());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}

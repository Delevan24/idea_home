package com.peter.spring.offer.method;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	
	// 题目描述
	// 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
	// 请完成一个函数，
	// 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
	
	public boolean Find(int target, int[][] array) {
		if (array.length == 0 || array[0].length == 0) return false;
		int m = array[0].length - 1;
		int n = 0;
		int temp = array[n][m];
		
		while (target != temp) {
			if (m > 0 && n < array.length - 1) {
				if (target > temp) {
					n = n + 1;
				} else if (target < temp) {
					m = m - 1;
				}
				temp = array[n][m];
			} else {
				return false;
			}
		}
		return true;
	}
	
	
	// 题目描述 : 替换空格
	// 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
	// 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
	public String replaceSpace(StringBuffer str) {
		StringBuilder sb = new StringBuilder();
		int len = str.length() - 1;
		for (int i = len; i >= 0; i--) {
			if (str.charAt(i) == ' ') {
				sb.append("%20");
			} else {
				sb.append(str.charAt(i));
			}
		}
		return sb.reverse().toString();
	}
	
	
	// 题目描述
	// 输入一个链表，反转链表后，输出新链表的表头。
	public class ListNode {
		int val;
		ListNode next = null;
		
		ListNode(int val) {
			this.val = val;
		}
	}
	
	public ListNode ReverseList(ListNode head) {
		if (head == null)
			return null;
		ListNode pre = null;
		ListNode next = null;
		
		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}
	
	// 题目描述
	// 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
	// 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
	
	// 输入描述:
	// 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
	
	
	ArrayList<String> res = new ArrayList<>();
	
	public ArrayList<String> Permutation(String str) {
		if (str == null) {
			return res;
		}
		PermutationHelper(str.toCharArray(), 0);
		Collections.sort(res);
		return res;
	}
	
	private void PermutationHelper(char[] str, int i) {
		if (i == str.length - 1) {
			res.add(String.valueOf(str));
		} else {
			for (int j = i; j < str.length; j++) {
				if (j != i && str[i] == str[j])
					continue;
				swap(str, i, j);
				PermutationHelper(str, i + 1);
				swap(str, i, j);
			}
		}
	}
	
	public void swap(char[] str, int i, int j) {
		char temp = str[i];
		str[i] = str[j];
		str[j] = temp;
	}
	
	public void test() {
		String[] endings = {"st", "nd", "rd", "st"};
		
		int a = 1;
		String b = "c";
		// b = a;
	}
	
	public static void main(String[] args) throws IOException {
		
		int length = 0x8000000; // 128 Mb
		
		// 为了以可读可写的方式打开文件，这里使用RandomAccessFile来创建文件。
		FileChannel fc = new RandomAccessFile("D://暮光之城3：月食_hd.mp4", "rw").getChannel();
		//注意，文件通道的可读可写要建立在文件流本身可读写的基础之上
		MappedByteBuffer out = fc.map(FileChannel.MapMode.READ_WRITE, 0, length);
		//写128M的内容
		for (int i = 0; i < length; i++) {
			out.put((byte) 'x');
		}
		System.out.println("Finished writing");
		//读取文件中间6个字节内容
		for (int i = length / 2; i < length / 2 + 6; i++) {
			System.out.print((char) out.get(i));
		}
		fc.close();
		
		
		/*FileChannel in = null, out = null;
		try {
			in = new FileInputStream("D://暮光之城3：月食_hd.mp4").getChannel();
			out = new FileOutputStream("d://test/outFile.mp4").getChannel();
			long size = in.size();
			
			long timeStar = System.currentTimeMillis();// 得到当前的时间
			MappedByteBuffer buf = in.map(FileChannel.MapMode.READ_ONLY, 0, size);
			long timeEnd = System.currentTimeMillis();// 得到当前的时间
			System.out.println("Read time :" + (timeEnd - timeStar) + "ms");
			
			timeStar = System.currentTimeMillis();
			out.write(buf);
			timeEnd = System.currentTimeMillis();
			System.out.println("Write time :" + (timeEnd - timeStar) + "ms");
			
			in.close();
			out.close();
			// source.delete();//文件复制完成后，删除源文件
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			in.close();
			out.close();
		}*/
		
		
		
		
		/*ByteBuffer byteBuf = ByteBuffer.allocate(1024 * 14 * 1024);
		byte[] bbb = new byte[14 * 1024 * 1024];
		
		FileInputStream fis = new FileInputStream("D://暮光之城3：月食_hd.mp4");
		FileOutputStream fos = new FileOutputStream("d://test/outFile.mp4");
		FileChannel fc = fis.getChannel();
		long timeStar = System.currentTimeMillis();// 得到当前的时间
		// fc.read(byteBuf);// 1 读取
		MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
		System.out.println(fc.size() / 1024);
		long timeEnd = System.currentTimeMillis();// 得到当前的时间
		System.out.println("Read time :" + (timeEnd - timeStar) + "ms");
		timeStar = System.currentTimeMillis();
		// fos.write(bbb);//2.写入
		mbb.flip();
		timeEnd = System.currentTimeMillis();
		System.out.println("Write time :" + (timeEnd - timeStar) + "ms");
		fos.flush();
		fc.close();
		fis.close();
		
		*/
	}
	
	//文件复制
	public void copyFile(String filename, String srcpath, String destpath) throws IOException {
		File source = new File(srcpath + "/" + filename);
		File dest = new File(destpath + "/" + filename);
		FileChannel in = null, out = null;
		try {
			in = new FileInputStream(source).getChannel();
			out = new FileOutputStream(dest).getChannel();
			long size = in.size();
			MappedByteBuffer buf = in.map(FileChannel.MapMode.READ_ONLY, 0, size);
			out.write(buf);
			in.close();
			out.close();
			source.delete();//文件复制完成后，删除源文件
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			in.close();
			out.close();
		}
	}
	
}











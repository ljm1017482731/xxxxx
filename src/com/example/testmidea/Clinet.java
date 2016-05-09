package com.example.testmidea;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Clinet {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket();
			socket.connect(new InetSocketAddress("192.168.43.1", 8899),6000);
			//连接服务器 并设置连接超时为5秒  
		 
			//获取输入输出流
			OutputStream ou = socket.getOutputStream();
			BufferedReader bff = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			//向服务器发送信息
			String cmd = "4E 53 4E 47 30 30 30 30 43 41 44 37 31 30 30 31 41 30 31 36 39 31 36 34 31 35 32 38 4E 30 30 31 30 30 30 30 67 00 AA AA";
			byte[] data = hexStringToBytes(cmd.replace(" ", "").trim());
			ou.write(data);
			//ou.write("android clinetx hi server".getBytes("utf-8"));
			ou.flush();
			
			//读取发来服务器信息
			String line = null;
			String buffer="";
			while ((line = bff.readLine()) != null) {
				buffer = line + buffer;
			} 
			System.out.println("========="+buffer);
			
			//Thread.sleep(5000);
			//关闭各种输入输出流
			bff.close();
			ou.close();
			socket.close();
			
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static byte charToByte(char c) {
		return (byte) "0123456789ABCDEF".indexOf(c);
	} 
 
	public  static byte[] hexStringToBytes(String hexString) {
		if (hexString == null || hexString.equals("")) {
			return null;
		}
		hexString = hexString.toUpperCase();
		int length = hexString.length() / 2;
		char[] hexChars = hexString.toCharArray();
		byte[] d = new byte[length];
		for (int i = 0; i < length; i++) {
			int pos = i * 2;
			d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));

		}
		return d;
	}
	//4E 53 4E 47 30 30 30 30 43 41 44 37 31 30 30 31 41 30 31 36 39 31 36 34 31 35 32 38 4E 30 30 31 30 30 30 30 65 02 AA AA AA AA 
}

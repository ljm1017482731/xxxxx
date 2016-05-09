package com.example.testmidea;

import android.annotation.SuppressLint;
import java.io.IOException;
import java.io.InputStream;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Server {

	public static ServerSocket serverSocket;

	public static void service() {
		while (true) {
			Socket socket = null;
			try {
				socket = serverSocket.accept(); // 主线程获取客户端连接
				Thread workThread = new Thread(new Handler(socket)); // 创建线程
				workThread.start(); // 启动线程
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@SuppressLint("DefaultLocale")
	public static void main(String[] args) {
		try {
			serverSocket = new ServerSocket(8089);// , 10,
													// InetAddress.getByName("192.168.1.119"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (serverSocket != null) {
			System.out.println("启动服务...." + serverSocket.getInetAddress().getHostAddress().toLowerCase());
			service();
		}
	}
}

class Handler implements Runnable {
	private Socket socket;
	private InputStream mInputStream;
	private OutputStream mOutputStream;
	int [] is=new int[]{
		1,2,3	
	};
	public Handler(Socket socket) {
		this.socket = socket;
		try {
			this.socket.setSoTimeout(600000);
		} catch (SocketException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//读取返回数据超时时间
		try {
			mInputStream = socket.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mInputStream = null;
		}
		try {
			mOutputStream = socket.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mOutputStream = null;
		}
	}

	public void run() {
		try {
			System.out.println("新连接:" + socket.getInetAddress() + ":" + socket.getPort());

			Thread.sleep(1000);
			while (true) {
				byte[] data = new byte[255];
				int length = mInputStream.read(data,0,4);
				String head = new String(data);
				if (length != 4 && !head.equals("4553")) {
					System.out.println("error head");
					continue;
				}
				length = mInputStream.read(data,4,34);
				if(length != 34){
					System.out.println("error length");
					continue;
				}
				int valueSize = data[37]+2;
				length = mInputStream.read(data,38,valueSize);
				if(valueSize != length){
					System.out.println("error value");
					continue;
				}
				String result = "";
				for(int i=0; i < valueSize + 38; i++){
					result += "" + String.format("%02x", data[i]).toUpperCase()+ " ";
				}
				System.out.println("read: " + result);
				parseFramer(data, valueSize+38);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				System.out.println("关闭连接:" + socket.getInetAddress() + ":" + socket.getPort());
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void parseFramer(byte[] data, int length){
		
		switch (data[36]) {
		case FramerUtils.APP_SEND_IP:
			
			break;
		case FramerUtils.APP_GET_TEMPER:
			try {
				System.out.println("APP get temper");
				mOutputStream.write(data);
				mOutputStream.flush();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			break;
		case FramerUtils.APP_SEND_TEMPER:
			
			break;
 
		default:
			break;
		}
		
	}
}
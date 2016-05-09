

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		String s=null;
		Socket mysocket;
		DataInputStream in=null;
		DataOutputStream out=null;
		try {
			mysocket=new Socket("127.0.0.1",4331);
			
			in=new DataInputStream(mysocket.getInputStream());
			out=new DataOutputStream(mysocket.getOutputStream());
			for(int k=1;k<100;k=k+2){
				out.writeUTF(""+k);
				byte[] b=new byte[12];
//				s=in.read(b);
				System.out.println("客户收到"+s);
				Thread.sleep(500);
			}
		} catch (Exception e) {
			System.out.println("服务器已断开"+e);
		}
	}
}



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		ServerSocket server=null;
		Socket you=null;
		String s=null;
		DataOutputStream out=null;
		DataInputStream in=null;
		try {
			server=new ServerSocket(4331);
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			System.out.println("�ȴ��ͻ�����");
			you=server.accept();
			out=new DataOutputStream(you.getOutputStream());
			in=new DataInputStream(you.getInputStream());
			while(true){
				s=in.readUTF();
				int m=Integer.parseInt(s);
				out.writeUTF("���,���Ƿ�����");
				out.writeUTF("��˵������2����:"+2*m);
				System.out.println("�������յ�:"+s);
				Thread.sleep(500);
			}
		} catch (Exception e) {
			System.out.println("�ͻ����ѶϿ�"+e);
		}
	}
}

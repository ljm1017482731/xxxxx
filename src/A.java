import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class A {

	
	public static void main(String[] args) {

	
//		System.out.println(gg+"");
//		System.out.println("String:"+String.valueOf(byteToChar(bt)));
//		System.out.println("String:"+String.valueOf(getChars(bt)));
//		String.valueOf(getChars(bt));
//		System.out.println("a:"+a);
//		System.out.println("String:"+String.valueOf(byteToChar(c)));
//		writeMes();
//		String cmd = "4E 53 4E 47 30 30 30 30 43 41 44 37 31 30 30 31 41 30 31 36 39 31 36 34 31 35 32 38 4E 30 30 31 30 30 30 30 67 00 AA AA";
//		byte[] data = hexStringToBytes(cmd.replace(" ", "").trim());
//		ou.write(data);
		
//		getIp(b);
		String str="c0 a8 78 56";
		
		String string = str.toUpperCase();
		System.out.println("str:"+string);
		
	}
//	com.example.servicea
	
	  private static String intToIp(int i) {       
	         
          return (i & 0xFF ) + "." +       
        ((i >> 8 ) & 0xFF) + "." +       
        ((i >> 16 ) & 0xFF) + "." +       
        ( i >> 24 & 0xFF) ;  
     }
	  
	 public static char byteToChar(byte[] b) {
	        char c = (char) (((b[0] & 0xFF) <<8) | (b[1] & 0xFF));
	        return c;
	 }
//	 public static byte[] charToByte(char c) {
//	        byte[] b = new byte[2];
//	        b[0] = (byte) ((c & 0xFF00) >> 8);
//	        b[1] = (byte) (c & 0xFF);
//	        return b;
//	 }
	 private static char[] getChars (byte[] bytes) {
	      Charset cs = Charset.forName ("UTF-8");
	      ByteBuffer bb = ByteBuffer.allocate (bytes.length);
	      bb.put (bytes);
	                 bb.flip ();
	       CharBuffer cb = cs.decode (bb);
	  
	   return cb.array();
	}
//	 public static char byteToChar(byte[] b) {
//	        char c = (char) (((b[0] & 0xFF) << 8) | (b[1] & 0xFF));
//	        return c;
//	 }
	 
//	 
	 private static byte charToByte(char c) {
			return (byte) "0123456789ABCDEF".indexOf(c);
	} 

	 public static void writeMes() {
		  int i=0xc0;
		  System.out.println(i+"");
		  byte b=3;
		  
	}
	 public static void SToT() {
		 String string="c0a8178";
		
		  int i=Integer.parseInt(string,16);
		  System.out.println(i+"");
	 }
	 public static String getIp(byte[] b){
			String hex="";
			String string="";
			for(int i=0;i<4;i++){
				hex = Integer.toHexString(b[i] & 0xFF);
				int j=Integer.parseInt(hex,16);
				if(i==3){
					string=j+"";
				}
				string=string+j+".";
			}
		return string;
	}

}

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class B {
	public static void main(String[] args) throws Exception {
//       File file=new File("e:\\log1.txt");
//		while (true) {
		for(int i=0;i<10000;i++){
			
			method();
		}
//		}
	}
	public static void method(){
//        FileInputStream fin =null;
          FileOutputStream fout = null;
          String string="系统时间："+System.currentTimeMillis();
       
        try{
//            fin = new FileInputStream("e://d/from.txt");
        	File file=new File("e:\\to.txt");
        	if(!file.exists()){
        		file.createNewFile();
        	}
        	File file1=new File("e:\\too.txt");
        	if(!file1.exists()){
        		file1.createNewFile();
        	}
        	System.out.println("file.length():"+file.length());
        	System.out.println("file.length()"+file1.length());
        	if(file.length()<20000){
        	    fout = new FileOutputStream(file,true);
        	}else{
        		fout = new FileOutputStream(file1,true);
        	}
//        	file.length();
//            fout = new FileOutputStream("e:\\to1.txt");
            
            OutputStreamWriter writer=new OutputStreamWriter(fout);
//			BufferedWriter bf=new BufferedWriter(writer);
			writer.write(string+"\r\n");
			
			writer.flush();
			writer.close();
//			bf.write(string);
//			bf.newLine();
//			bf.flush();
			fout.close();
//			bf.close();
			System.out.println("finish");
        }catch(Exception e){
            System.out.println(e);
            
        }
        finally{            //关掉流
            try{
            	
//                fout.close();
//                fin.close();
            }catch(Exception e){
                System.out.println(e);
            }    
        }
    }

}

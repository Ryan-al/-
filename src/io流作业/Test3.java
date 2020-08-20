package io流作业;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class Test3 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		File file1 = new File("F:\\1.txt");
		File file2 = new File("F:\\2.txt");
		Test3 t = new Test3();
		Copy copy = t.new Copy();
		try {
			copy.copyFile(file1,file2);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		}
public class Copy{
	public  void copyFile(File source, File dest) throws IOException {    
	    InputStream input = null;    
	    OutputStream output = null;    
	    try {
	           input = new FileInputStream(source);
	           output = new FileOutputStream(dest);        
	           byte[] buf = new byte[1024];        
	           int bytesRead;        
	           while ((bytesRead = input.read(buf)) != -1) {
	               output.write(buf, 0, bytesRead);
	           }
	    } finally {
	        input.close();
	        output.close();
	    }
	}
}
}

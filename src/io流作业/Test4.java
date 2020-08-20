package ioÁ÷×÷Òµ;
import java.net.*;
import java.io.*;

public class Test4 {

	public static void main (String [] args) throws Exception {

		URL netchinaren=new URL ("https://www.csdn.net/");
		BufferedReader in = new BufferedReader(new InputStreamReader(netchinaren.openStream()));
	
		String inputline;
		while ((inputline=in.readLine())!=null) {
			System.out.println(inputline);		
		}
		in.close();
	}

}

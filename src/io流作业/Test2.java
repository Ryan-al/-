package io流作业;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Test2 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根


				File file = new File("F:\\笔记\\杂记.txt");
				if (!file.exists()) {
					try {
						file.createNewFile();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				try {
					// 创建输入流对象
					BufferedReader bReader = new BufferedReader(new FileReader("F:\\笔记\\杂记.txt"));
					// 创建输出流对象
					BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));

					// 进行数据的读写
					String lineString;// 用于存储读取到的数据
					while ((lineString = bReader.readLine()) != null) {
						bWriter.write(lineString);
						bWriter.newLine();
					}

					// 释放资源
					bWriter.close();
					bReader.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
}


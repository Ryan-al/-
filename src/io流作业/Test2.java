package io����ҵ;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Test2 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������


				File file = new File("F:\\�ʼ�\\�Ӽ�.txt");
				if (!file.exists()) {
					try {
						file.createNewFile();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				try {
					// ��������������
					BufferedReader bReader = new BufferedReader(new FileReader("F:\\�ʼ�\\�Ӽ�.txt"));
					// �������������
					BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));

					// �������ݵĶ�д
					String lineString;// ���ڴ洢��ȡ��������
					while ((lineString = bReader.readLine()) != null) {
						bWriter.write(lineString);
						bWriter.newLine();
					}

					// �ͷ���Դ
					bWriter.close();
					bReader.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
}


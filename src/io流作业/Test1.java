package io����ҵ;
import java.io.File;
public class Test1 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		File file1=new File("D:\\����\\��Ƶ");
		IteratorUtil.IteratorDir(file1);
	}
}
class IteratorUtil{
	private static int level=1;
	public static void IteratorDir(File file){
		if(file!=null){//������ļ����ļ��в�Ϊ�յ������
			//����Ŀ¼�µ������ļ������ļ��з��ڶ����������
			File[] files=file.listFiles();
			/*for(File f:files){
				System.out.println(f.getName());
			}*/
			//ѭ������������
			for(int i=0;i<files.length;i++){
				if(files[i].isDirectory()){
					System.out.println(getTab(level)+files[i].getName());
					level++;
					IteratorDir(files[i]);
				}else if(files[i].isFile()){
					System.out.println(getTab(level)+files[i].getName());
				}
			}
			level--;
		}
	}
	private static String getTab(int level){
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<level;i++){
			sb.append("\t");
		}
		return sb.toString();
	}
}




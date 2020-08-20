package io流作业;
import java.io.File;
public class Test1 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		File file1=new File("D:\\歌曲\\音频");
		IteratorUtil.IteratorDir(file1);
	}
}
class IteratorUtil{
	private static int level=1;
	public static void IteratorDir(File file){
		if(file!=null){//如果该文件或文件夹不为空的情况下
			//将该目录下的所有文件或是文件夹放在定义的数组中
			File[] files=file.listFiles();
			/*for(File f:files){
				System.out.println(f.getName());
			}*/
			//循环遍历该数组
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




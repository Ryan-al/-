package ʵ����;

import java.util.Scanner;

/*���һ��������Ϸ

  1.��10ƥ��ÿƥ���ڲ�ͬʱ����������·���в����Ҳ�ͬ������С��100ms��5~10m��С��200ms��15~25m������1000�ס�

  2.���ѡ����ƥ��ʼ����Ӯ�в�ͬ�������
  */
//�˴����������ԡ������뿳ɱս�š�
//�趨����֮����ÿ��һ����һ�����м�����30%��һ���˺�100-armor���ٷ�֮ʮ��ͷ������
//����֮����������ʱ����㣬�����������ӡ�����ʱ����������⣬����ǵ�������run()����д��
//ʱ���޷����ӣ����������д�������߳�ʱ�䣬���ݽ��������鷳��Ҫ��run����ķ���д���棬��Ҫ�趨����life��speed�ķ������򵥵��
//ÿ��100��һ���ϰ���ײ������Ϊ20-armor��armor�������ˣ�ÿ����һ�ξͼ�2���ٶȡ�
//���Ҫ�ٶȲ��������ͱ���������ٶ�������ٶ�,�������鷳����������¼�
public class Experiment3 {
	public static  double tm[] = new double[]{100,100,100,100,100,100,100,100,100,100};
	public static  int n=0;
	public static void main(String[] args) throws InterruptedException {
		// TODO �Զ����ɵķ������
		Scanner in = new Scanner(System.in);
		System.out.println("ѡ��һƥ��һ��Ϊһ�����ؼ�ս������Ϊ��ǿ���ؾ�������Ϊ��˳�ľ����ĺ�Ϊȳ�����ۼ�ս��\n"
				+ "���Ϊ���˱��Ŀ�������Ϊ�������ߺ�Ϊ�������˺�Ϊ�������ź�Ϊ������ʮ��Ϊȳ��������");
		System.out.println("����1~10");
		int num = in.nextInt();
		Thread t1 = new Thread(new Horse1());
		t1.start();
		t1.join();
		Thread t2 = new Thread(new Horse2());
		t2.start();
		t2.join();
		Thread t3 = new Thread(new Horse3());
		t3.start();
		t3.join();
		Thread t4 = new Thread(new Horse4());
		t4.start();
		t4.join();
		Thread t5 = new Thread(new Horse5());
		t5.start();
		t5.join();
		Thread t6 = new Thread(new Horse6());
		t6.start();
		t6.join();
		Thread t7 = new Thread(new Horse6());
		t7.start();
		t7.join();
		Thread t8 = new Thread(new Horse6());
		t8.start();
		t8.join();
		Thread t9 = new Thread(new Horse6());
		t9.start();
		t9.join();
		Thread t10 = new Thread(new Horse7());
		t10.start();
		t10.join();
		int winner = 0;
		double t=tm[0];
		for(int i=1;i<10;i++) {
				if(tm[i]<t) {winner=i;t=tm[i];}
		}
		System.out.println("$$$$"+winner);
		if(num==winner+1)System.out.println("�¶���");
		else System.out.println("�´���");
	}
	
}
class Horse implements Runnable{
	String name;
	int speed;
	int armor;
	int life;
	public Horse() {
	}
	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		int lengh = 1000;
		double time = 0;
		while(life>0&&lengh>0) {
			time += 100/speed;
			lengh -= 100;
			if(armor>20) {life-=20-armor;speed-=2;}
			if(Math.random()*10>7) {
					if(Math.random()*10>9)life = 0;
					life-=100-armor;
			}
		}
		if(life<=0) { System.out.println(name+"����");Experiment3.tm[Experiment3.n]=100;
		Experiment3.n += 1;
		//System.out.println("#####"+Experiment3.n);
		}
		if(life>0) {System.out.println("#####"+name+"������ȫ������ʱ��Ϊ"+time);
		Experiment3.tm[Experiment3.n]=time;Experiment3.n += 1;
		//System.out.println("#####"+Experiment3.n);
		}
	}
	
}
class Horse1 extends Horse{

	public Horse1() {
		this.name = "һ�����ؼ�ս��";
		this.speed = 44;
		this.armor = 68;
		this.life = 210;
		// TODO �Զ����ɵĹ��캯�����
	}

}
class Horse2 extends Horse{

	public Horse2() {
		this.name = "��ǿ���ؾ���";
		this.speed = 40;
		this.armor = 43;
		this.life = 180;
		// TODO �Զ����ɵĹ��캯�����
	}
	
}
class Horse3 extends Horse{

	public Horse3() {
		this.name = "��˳�ľ���";
		this.speed = 40;
		this.armor = 40;
		this.life = 165;
		// TODO �Զ����ɵĹ��캯�����
	}
	
}
class Horse4 extends Horse{

	public Horse4() {
		this.name = "ȳ�����ۼ�ս��";
		this.speed = 30;
		this.armor = 48;
		this.life = 175;
		// TODO �Զ����ɵĹ��캯�����
	}
	
}
class Horse5 extends Horse{

	public Horse5() {
		this.name = "���˱��Ŀ���";
		this.speed = 46;
		this.armor = 18;
		this.life = 110;
		// TODO �Զ����ɵĹ��캯�����
	}
	
}
class Horse6 extends Horse{

	public Horse6() {
		this.name = "������";
		this.speed = 45;
		this.armor = 12;
		this.life = 100;
		// TODO �Զ����ɵĹ��캯�����
	}
	
}
class Horse7 extends Horse{

	public Horse7() {
		this.name = "ȳ��������";
		this.speed = 35;
		this.armor = 12;
		this.life = 100;
		// TODO �Զ����ɵĹ��캯�����
	}
	
}
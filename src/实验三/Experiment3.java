package 实验三;

import java.util.Scanner;

/*设计一个赌马游戏

  1.有10匹马，每匹马在不同时间里内所跑路程有波动且不同（例如小白100ms跑5~10m，小黑200ms跑15~25m），跑1000米。

  2.玩家选择马匹后开始，输赢有不同的输出。
  */
//此处所用马来自《骑马与砍杀战团》
//设定飞来之箭：每到一百米一箭，中箭概率30%。一箭伤害100-armor，百分之十爆头即死。
//飞来之箭本来想以时间计算，并且数量增加。但是时间计算有问题，如果是单纯的在run()里面写，
//时间无法叠加，如果在外面写并计算线程时间，数据交换超级麻烦，要把run里面的方法写外面，还要设定更改life和speed的方法，简单点吧
//每过100米一个障碍，撞过受伤为20-armor，armor高则免伤，每受伤一次就减2点速度。
//如果要速度产生波动就必须有最低速度与最高速度,这样很麻烦，不如随机事件
public class Experiment3 {
	public static  double tm[] = new double[]{100,100,100,100,100,100,100,100,100,100};
	public static  int n=0;
	public static void main(String[] args) throws InterruptedException {
		// TODO 自动生成的方法存根
		Scanner in = new Scanner(System.in);
		System.out.println("选择一匹马，一号为一流的重甲战马，二号为倔强的重军马，三号为温顺的军马，四号为瘸腿重鳞甲战马，\n"
				+ "五号为伤了背的骏马，六号为旅行马，七号为旅行马，八号为旅行马，九号为旅行马，十号为瘸腿旅行马");
		System.out.println("输入1~10");
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
		if(num==winner+1)System.out.println("猜对了");
		else System.out.println("猜错了");
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
		// TODO 自动生成的方法存根
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
		if(life<=0) { System.out.println(name+"死了");Experiment3.tm[Experiment3.n]=100;
		Experiment3.n += 1;
		//System.out.println("#####"+Experiment3.n);
		}
		if(life>0) {System.out.println("#####"+name+"跑完了全程所用时间为"+time);
		Experiment3.tm[Experiment3.n]=time;Experiment3.n += 1;
		//System.out.println("#####"+Experiment3.n);
		}
	}
	
}
class Horse1 extends Horse{

	public Horse1() {
		this.name = "一流的重甲战马";
		this.speed = 44;
		this.armor = 68;
		this.life = 210;
		// TODO 自动生成的构造函数存根
	}

}
class Horse2 extends Horse{

	public Horse2() {
		this.name = "倔强的重军马";
		this.speed = 40;
		this.armor = 43;
		this.life = 180;
		// TODO 自动生成的构造函数存根
	}
	
}
class Horse3 extends Horse{

	public Horse3() {
		this.name = "温顺的军马";
		this.speed = 40;
		this.armor = 40;
		this.life = 165;
		// TODO 自动生成的构造函数存根
	}
	
}
class Horse4 extends Horse{

	public Horse4() {
		this.name = "瘸腿重鳞甲战马";
		this.speed = 30;
		this.armor = 48;
		this.life = 175;
		// TODO 自动生成的构造函数存根
	}
	
}
class Horse5 extends Horse{

	public Horse5() {
		this.name = "伤了背的骏马";
		this.speed = 46;
		this.armor = 18;
		this.life = 110;
		// TODO 自动生成的构造函数存根
	}
	
}
class Horse6 extends Horse{

	public Horse6() {
		this.name = "旅行马";
		this.speed = 45;
		this.armor = 12;
		this.life = 100;
		// TODO 自动生成的构造函数存根
	}
	
}
class Horse7 extends Horse{

	public Horse7() {
		this.name = "瘸腿旅行马";
		this.speed = 35;
		this.armor = 12;
		this.life = 100;
		// TODO 自动生成的构造函数存根
	}
	
}
package 实验四;

import java.util.Scanner;

public class Experiment4 implements buff_and_debuff {

	public static void main(String[] args) {
		System.out.println("选择英雄，1战士，2射手");
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		if(x==1) {
			game(new Solder());
		}
		if(x==2) {
			game(new Archer());
		}
		System.out.println("Game over");
		}
		public static void game(Hero hero) {
			while(hero.getHp()>0) {
				System.out.println("目前英雄属性：\nHP"+hero.getHp()+" Attack:"+hero.getAtt()+" defend:"+hero.getDef()+" Money:"+hero.getMoney());
				if(Math.random()>0.5) {
					System.out.println("得到增幅!");
					blessed(hero);
				}else {
					System.out.println("得到负面效果!");
					be_burned(hero);
				}
				System.out.println("是否买装备，买1，不买2");
				Scanner in1 = new Scanner(System.in);
				int x1 = in1.nextInt();
				if(x1==1) {
					System.out.println("1.剑 50money +10att\n2.盾 50money +5def \n3.药 100money +50Hp");
					Scanner in2 = new Scanner(System.in);
					int x2 = in2.nextInt();
					if(x2==1) {
						hero.setAtt(hero.getAtt()+10);
						hero.setMoney(hero.getMoney()-50);
					}
					if(x2==2) {
						hero.setDef(hero.getDef()+5);
						hero.setMoney(hero.getMoney()-50);
					}
					if(x2==3) {
						hero.setHp(hero.getHp()+50);
						hero.setMoney(hero.getMoney()-100);
					}
				}
				int num = (int) (Math.random()*10);
				System.out.println("现在开始打怪");
				if(num<6) {
					System.out.println("遇到猫");
					System.out.println("猫的属性：\nhp:100 att:15 def:5");
					Animals cat = new Cat();
					while(cat.getHp()>0) {
						if(hero.getAtt()>cat.getDef()) {
							System.out.println("你对猫进行攻击造成"+(hero.getAtt()-cat.getDef())+"点伤害");
							cat.setHp(cat.getHp()-(hero.getAtt()-cat.getDef()));
						}else System.out.println("你的攻击无效！");
						if(cat.getAtt()>hero.getDef()) {
							System.out.println("猫对你进行攻击造成"+(cat.getAtt()-hero.getDef())+"点伤害");
							hero.setHp(hero.getHp()-(cat.getAtt()-hero.getDef()));
						}else System.out.println("猫的攻击无效！");
					}
					System.out.println("战胜怪物，获得金币10");
					hero.setMoney(hero.getMoney()+10);
				}
				if(num>=6&&num<9) {
					System.out.println("遇到狗");
					System.out.println("狗的属性：\nhp:200 att:25 def:8");
					Animals dog = new Dog();
					while(dog.getHp()>0) {
						if(hero.getAtt()>dog.getDef()) {
							System.out.println("你对狗进行攻击造成"+(hero.getAtt()-dog.getDef())+"点伤害");
							dog.setHp(dog.getHp()-(hero.getAtt()-dog.getDef()));
						}else System.out.println("你的攻击无效！");
						if(dog.getAtt()>hero.getDef()) {
							System.out.println("狗对你进行攻击造成"+(dog.getAtt()-hero.getDef())+"点伤害");
							hero.setHp(hero.getHp()-(dog.getAtt()-hero.getDef()));
						}else System.out.println("狗的攻击无效！");
					}
					System.out.println("战胜怪物，获得金币15");
					hero.setMoney(hero.getMoney()+15);
				}
				if(num>9) {
					System.out.println("遇到猪");
					System.out.println("猪的属性：\nhp:300 att:30 def:15");
					Animals pig = new Pig();
					while(pig.getHp()>0) {
						if(hero.getAtt()>pig.getDef()) {
							System.out.println("你对猪进行攻击造成"+(hero.getAtt()-pig.getDef())+"点伤害");
							pig.setHp(pig.getHp()-(hero.getAtt()-pig.getDef()));
						}else System.out.println("你的攻击无效！");
						if(pig.getAtt()>hero.getDef()) {
							System.out.println("猪对你进行攻击造成"+(pig.getAtt()-hero.getDef())+"点伤害");
							hero.setHp(hero.getHp()-(pig.getAtt()-hero.getDef()));
						}else System.out.println("猪的攻击无效！");
					}
					System.out.println("战胜怪物，获得金币20");
					hero.setMoney(hero.getMoney()+20);
				}
			}
	}
		private static void blessed(Hero hero) {
			// TODO 自动生成的方法存根
			 hero.setAtt(hero.getAtt()+5);
		 hero.setHp(hero.getHp()+10);
		}
		private static void be_burned(Hero hero) {
			// TODO 自动生成的方法存根
			 hero.setHp(hero.getHp()-5);
		}
		
}
interface buff_and_debuff{
	   static void be_burned(Hero hero) {
		
	 }
	   static void blessed(Hero hero) {
		
	  }
}

class Solder extends Hero{
	public Solder() {
		setHp(200);
		setDef(10);
		setAtt(20);
		setMoney(100);
	}
	
}
class Archer extends Hero{
	public Archer() {
		setHp(150);
		setDef(5);
		setAtt(25);
		setMoney(100);
	}
}
abstract class Hero{
	private int Hp;
	private int Def;
	private int Att;
	private int Money;
	public Hero() {
		super();
		Hp=100;
		Def=0;
		Att=10;
		Money=100;
	}
	
	public Hero(int hp, int def, int att, int money) {
		super();
		Hp = hp;
		Def = def;
		Att = att;
		Money = money;
	}

	public int getHp() {
		return Hp;
	}
	public void setHp(int hp) {
		Hp = hp;
	}
	public int getDef() {
		return Def;
	}
	public void setDef(int def) {
		Def = def;
	}
	public int getAtt() {
		return Att;
	}
	public void setAtt(int att) {
		Att = att;
	}
	public int getMoney() {
		return Money;
	}
	public void setMoney(int money) {
		Money = money;
	}
	
	
}
class Cat extends Animals{
	public Cat() {
		setHp(100);
		setDef(5);
		setAtt(15);
	}
}
class Dog extends Animals{
	public Dog() {
		setHp(200);
		setDef(8);
		setAtt(25);
	}
}
class Pig extends Animals{
	public Pig() {
		setHp(300);
		setDef(15);
		setAtt(30);
	}
}
abstract class Animals{
	private int Hp;
	private int Def;
	private int Att;
	
	public Animals() {
		super();
	}
	public Animals(int hp, int def, int att) {
		super();
		Hp = hp;
		Def = def;
		Att = att;
	}
	public int getHp() {
		return Hp;
	}
	public void setHp(int hp) {
		Hp = hp;
	}
	public int getDef() {
		return Def;
	}
	public void setDef(int def) {
		Def = def;
	}
	public int getAtt() {
		return Att;
	}
	public void setAtt(int att) {
		Att = att;
	}
	
}
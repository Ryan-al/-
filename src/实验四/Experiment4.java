package ʵ����;

import java.util.Scanner;

public class Experiment4 implements buff_and_debuff {

	public static void main(String[] args) {
		System.out.println("ѡ��Ӣ�ۣ�1սʿ��2����");
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
				System.out.println("ĿǰӢ�����ԣ�\nHP"+hero.getHp()+" Attack:"+hero.getAtt()+" defend:"+hero.getDef()+" Money:"+hero.getMoney());
				if(Math.random()>0.5) {
					System.out.println("�õ�����!");
					blessed(hero);
				}else {
					System.out.println("�õ�����Ч��!");
					be_burned(hero);
				}
				System.out.println("�Ƿ���װ������1������2");
				Scanner in1 = new Scanner(System.in);
				int x1 = in1.nextInt();
				if(x1==1) {
					System.out.println("1.�� 50money +10att\n2.�� 50money +5def \n3.ҩ 100money +50Hp");
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
				System.out.println("���ڿ�ʼ���");
				if(num<6) {
					System.out.println("����è");
					System.out.println("è�����ԣ�\nhp:100 att:15 def:5");
					Animals cat = new Cat();
					while(cat.getHp()>0) {
						if(hero.getAtt()>cat.getDef()) {
							System.out.println("���è���й������"+(hero.getAtt()-cat.getDef())+"���˺�");
							cat.setHp(cat.getHp()-(hero.getAtt()-cat.getDef()));
						}else System.out.println("��Ĺ�����Ч��");
						if(cat.getAtt()>hero.getDef()) {
							System.out.println("è������й������"+(cat.getAtt()-hero.getDef())+"���˺�");
							hero.setHp(hero.getHp()-(cat.getAtt()-hero.getDef()));
						}else System.out.println("è�Ĺ�����Ч��");
					}
					System.out.println("սʤ�����ý��10");
					hero.setMoney(hero.getMoney()+10);
				}
				if(num>=6&&num<9) {
					System.out.println("������");
					System.out.println("�������ԣ�\nhp:200 att:25 def:8");
					Animals dog = new Dog();
					while(dog.getHp()>0) {
						if(hero.getAtt()>dog.getDef()) {
							System.out.println("��Թ����й������"+(hero.getAtt()-dog.getDef())+"���˺�");
							dog.setHp(dog.getHp()-(hero.getAtt()-dog.getDef()));
						}else System.out.println("��Ĺ�����Ч��");
						if(dog.getAtt()>hero.getDef()) {
							System.out.println("��������й������"+(dog.getAtt()-hero.getDef())+"���˺�");
							hero.setHp(hero.getHp()-(dog.getAtt()-hero.getDef()));
						}else System.out.println("���Ĺ�����Ч��");
					}
					System.out.println("սʤ�����ý��15");
					hero.setMoney(hero.getMoney()+15);
				}
				if(num>9) {
					System.out.println("������");
					System.out.println("������ԣ�\nhp:300 att:30 def:15");
					Animals pig = new Pig();
					while(pig.getHp()>0) {
						if(hero.getAtt()>pig.getDef()) {
							System.out.println("�������й������"+(hero.getAtt()-pig.getDef())+"���˺�");
							pig.setHp(pig.getHp()-(hero.getAtt()-pig.getDef()));
						}else System.out.println("��Ĺ�����Ч��");
						if(pig.getAtt()>hero.getDef()) {
							System.out.println("�������й������"+(pig.getAtt()-hero.getDef())+"���˺�");
							hero.setHp(hero.getHp()-(pig.getAtt()-hero.getDef()));
						}else System.out.println("��Ĺ�����Ч��");
					}
					System.out.println("սʤ�����ý��20");
					hero.setMoney(hero.getMoney()+20);
				}
			}
	}
		private static void blessed(Hero hero) {
			// TODO �Զ����ɵķ������
			 hero.setAtt(hero.getAtt()+5);
		 hero.setHp(hero.getHp()+10);
		}
		private static void be_burned(Hero hero) {
			// TODO �Զ����ɵķ������
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
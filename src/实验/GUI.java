package ʵ��;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;

public class GUI extends JFrame {

	/**�޸ģ�
	 * 1.�ĸĲ��� OK
	 * 2.����Ŵ�����  ���Ŵ��ڵĴ�С���в��ֶ������Ҳ���
		����˼����ǣ���ÿ�������ֵ��ʱ��Ӧ��д�������ǵȱ����ķŴ�Ȼ���ټ������ھͿ���ʵ��
		�õ��Ǿ��Բ��֣�����Ҳ���øģ���Դ���⣬�ṩ�Ĳ�������ϲ��

	 * 3.���ñ���ͼƬ  û�з���ʲô�������İ취��������������
	 * ���Ի������Ÿ�ͼ������
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		GUI gui = new GUI();
		
		
	}
	//@SuppressWarnings("deprecation")
	public GUI(){
		this.setTitle("ʵ���");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//���ñ����������⣨�ڸ���һЩ��ǩ��û�и������н��棩����һ����������д��ͼ����������
//		ImageIcon img = new ImageIcon("C:\\\\Users\\\\MECHREVO\\\\eclipse-workspace\\\\��ϰ\\\\����.jpg");
//		JLabel jl_bg = new JLabel(img); //����
//		jl_bg.setBounds(0, 0, 600, 400); //����λ�úʹ�С����setLayout(null)һ�¡�
//		this.getLayeredPane().add(jl_bg, Integer.MAX_VALUE);
//		((JPanel)this.getContentPane()).setOpaque(false); //����͸��
		Content();
		this.setLayout(null);
		this.setBounds(0, 0, 530, 410);
		//�趨��ʾ���м䣬Ҳ������c
		this.setLocationRelativeTo(null);
//		 ImageIcon icon=new ImageIcon("C:\\Users\\MECHREVO\\eclipse-workspace\\��ϰ\\����.jpg");
//	      JLabel label1=new JLabel(icon);
//	      label1.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
//	    //��label����frame�ĵײ�
//	      this.getLayeredPane().add(label1,Integer.MIN_VALUE);
//		
		this.setVisible(true);
		
//		try {
//			URL musicURL = new URL("src//���ٺơ�ICE - ����ԩ�� (Live).mp3");
//			AudioClip ac = Applet.newAudioClip(musicURL);
//			ac.loop();
//		} catch (MalformedURLException e) {
//			// TODO �Զ����ɵ� catch ��
//			e.printStackTrace();
//		}
//		
	}
	
	private void Content() {
		// TODO �Զ����ɵķ������
		//��getContentPane()�������JFrame���������
		Container TimeConer = this.getContentPane();
		TimeConer.setBackground(new Color(120,120,120));
		//Swing�е�JLabel��֧�ֻ�����HTML����ģ�
		//ͬ����JTextPane��JEditorPaneҲ֧�ּ򵥵�HTML���롣
		//JLabel�л�������ҪHTML��<br>��ǩ���л��еģ�������\nֱ�ӻ��С�
		Font tfont = new Font("����",Font.PLAIN,6);
		JLabel t1 = new JLabel("<html>Javaswing<br>�÷�");
		t1.setFont(tfont);
		t1.setBounds(10,-10,20,700);
		
		JLabel t2 = new JLabel("<html>��ҵ��<br>ѧ��ѧ��");
		t2.setFont(tfont);
		t2.setBounds(500,-10,20,700);
		
		JLabel t3 = new JLabel("�÷���swing����ʵ����ҵ");
		t3.setFont(new Font("����",Font.PLAIN,10));
		//setForeground():���ñ�ǩ������ɫ
		t3.setForeground(new Color(1,1,153));
		t3.setBounds(180,0,400,50);
		//�����ǩΪʱ����		
		Font TimeFont = new Font("ʱ����",Font.PLAIN,23);
		JLabel NowTimeJla = new JLabel();
		NowTimeJla.setBounds(2, 30, 400, 50);
		NowTimeJla.setForeground(new Color(0,50,102));
		NowTimeJla.setFont(TimeFont);
		
		JLabel Week = new JLabel(getWeekOfDate(new Date()));
		Week.setBounds(354, 31, 50, 50);
		Week.setForeground(new Color(0,50,102));
		Week.setFont(new Font("����",Font.PLAIN,15));
		
		JTextField plusDay = new JTextField("��������");
		plusDay.setBounds(407, 43, 90, 27);
		plusDay.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				plusDay.setText("");
			}
		});
		
		JTextField name = new JTextField("��������������");
		name.setBounds(410, 280, 70, 27);
		name.setFont(new Font("����",Font.PLAIN,9));
		name.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				name.setText("");
			}
		});
		
		JButton ce = new JButton("ռ��");
		ce.setBounds(410, 312, 68, 27);
		//JButtonͼ������Ȧ�����������border���������focus״̬��ʾ�� 
		//focus�ǽ���״̬��һ�������һ�β�������������ý��㡣
		//setFocusPainted(false)�����������Ǹ�focus�ķ�����ʾ��
		//setBorderPainted(false)��������border��������Ҳ����setBorder��һ����������ʽ
		ce.setFocusPainted(false);
		ce.setFont(new Font("ռ����ť",Font.PLAIN,9));
		//�ı�����״HAND_CURSOR ��״�������
		ce.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result();
			}
		});
		//���ͼƬ��Ҫ��Ū�����ı���ͼƬ
		//JLabel bg = new JLabel();
		//Image image1 = new ImageIcon("C:\\\\Users\\\\MECHREVO\\\\eclipse-workspace\\\\��ϰ\\\\����.jpg").getImage();
		//bg.setIcon(new ImageIcon(image1));
        //bg.setBounds(149,100,200,200);
		//������
		JLabel bg = new JLabel();
		Image image1 = new ImageIcon("C:\\Users\\MECHREVO\\eclipse-workspace\\java�γ���ҵ\\src\\ʵ��\\��������.jpg").getImage();
		bg.setIcon(new ImageIcon(image1));
		bg.setBounds(0,100,400,222);
		
		JButton sure = new JButton("��ת");
		sure.setBounds(426, 80, 50, 20);
		sure.setFocusPainted(false);
		sure.setFont(new Font("��ת��ť",Font.PLAIN,8));
		sure.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		sure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a = plusDay.getText();
				int b = Integer.parseInt(a);
				Plus(b);
			}
		});
		
		TimeConer.add(NowTimeJla);
		TimeConer.add(Week);
		TimeConer.add(plusDay);
		TimeConer.add(name);
		TimeConer.add(bg);
		TimeConer.add(ce);
		GUI.setTimer(NowTimeJla);
		TimeConer.add(t1);
		TimeConer.add(t2);
		TimeConer.add(t3);
		TimeConer.add(sure);
	
	}
	protected static void setTimer(JLabel TimeJ) {
		final JLabel varTime = TimeJ;
		Timer timeAction = new Timer(100,new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				long timemillis = System.currentTimeMillis();
				SimpleDateFormat df = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss:SSS");
				varTime.setText(df.format(new Date(timemillis)));
			}
			
		});
		timeAction.start();
	}
	
	
	protected void Plus(int n) {
	// TODO �Զ����ɵķ������
		Date d = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss:SSS");
		Calendar ca = Calendar.getInstance();
		ca.add(Calendar.DATE, n);
		d = ca.getTime();
		String enddate = format.format(d);
		JOptionPane.showConfirmDialog(null, enddate+""+getWeekOfDate(d),"result",JOptionPane.OK_CANCEL_OPTION);
	}
	private void result() {
	// �������Ե�����
			String[] fare = new String[] {"��","��","С��","����","��","С��"};
			int n = (int)(Math.random()*5);
			JOptionPane.showConfirmDialog(null, fare[n],"fare",JOptionPane.OK_CANCEL_OPTION);
	}
		

	private String getWeekOfDate(Date date) {
	// ��������
		String[] weekDays = {"������","����һ","���ڶ�","������","������","������","������"};
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int w = cal.get(Calendar.DAY_OF_WEEK)-1;
		if(w<0)w=0;
		return weekDays[w];
	}
	

}

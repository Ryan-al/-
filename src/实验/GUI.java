package 实验;

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

	/**修改：
	 * 1.改改布局 OK
	 * 2.解决放大问题  随着窗口的大小进行布局而不打乱布局
		核心思想就是，给每个组件设值的时候不应该写死，而是等比例的放大，然后再监听窗口就可以实现
		用的是绝对布局，所以也不好改，根源问题，提供的布局器不喜欢

	 * 3.设置背景图片  没有发现什么很完美的办法，技术还有问题
	 * 所以还是随便放个图。。。
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		GUI gui = new GUI();
		
		
	}
	//@SuppressWarnings("deprecation")
	public GUI(){
		this.setTitle("实验二");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//设置背景，有问题（遮盖了一些标签，没有覆盖所有界面）还有一个做法是重写画图方法，不大懂
//		ImageIcon img = new ImageIcon("C:\\\\Users\\\\MECHREVO\\\\eclipse-workspace\\\\练习\\\\飞鸟.jpg");
//		JLabel jl_bg = new JLabel(img); //背景
//		jl_bg.setBounds(0, 0, 600, 400); //设置位置和大小，先setLayout(null)一下。
//		this.getLayeredPane().add(jl_bg, Integer.MAX_VALUE);
//		((JPanel)this.getContentPane()).setOpaque(false); //设置透明
		Content();
		this.setLayout(null);
		this.setBounds(0, 0, 530, 410);
		//设定显示在中间，也可以填c
		this.setLocationRelativeTo(null);
//		 ImageIcon icon=new ImageIcon("C:\\Users\\MECHREVO\\eclipse-workspace\\练习\\飞鸟.jpg");
//	      JLabel label1=new JLabel(icon);
//	      label1.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
//	    //将label放入frame的底层
//	      this.getLayeredPane().add(label1,Integer.MIN_VALUE);
//		
		this.setVisible(true);
		
//		try {
//			URL musicURL = new URL("src//李荣浩、ICE - 王牌冤家 (Live).mp3");
//			AudioClip ac = Applet.newAudioClip(musicURL);
//			ac.loop();
//		} catch (MalformedURLException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
//		
	}
	
	private void Content() {
		// TODO 自动生成的方法存根
		//用getContentPane()方法获得JFrame的内容面板
		Container TimeConer = this.getContentPane();
		TimeConer.setBackground(new Color(120,120,120));
		//Swing中的JLabel是支持基本的HTML代码的，
		//同样的JTextPane、JEditorPane也支持简单的HTML代码。
		//JLabel中换行是需要HTML的<br>标签进行换行的，不能用\n直接换行。
		Font tfont = new Font("隶书",Font.PLAIN,6);
		JLabel t1 = new JLabel("<html>Javaswing<br>好烦");
		t1.setFont(tfont);
		t1.setBounds(10,-10,20,700);
		
		JLabel t2 = new JLabel("<html>作业靠<br>学长学姐");
		t2.setFont(tfont);
		t2.setBounds(500,-10,20,700);
		
		JLabel t3 = new JLabel("好烦的swing布局实验作业");
		t3.setFont(new Font("标题",Font.PLAIN,10));
		//setForeground():设置标签字体颜色
		t3.setForeground(new Color(1,1,153));
		t3.setBounds(180,0,400,50);
		//下面标签为时间条		
		Font TimeFont = new Font("时间条",Font.PLAIN,23);
		JLabel NowTimeJla = new JLabel();
		NowTimeJla.setBounds(2, 30, 400, 50);
		NowTimeJla.setForeground(new Color(0,50,102));
		NowTimeJla.setFont(TimeFont);
		
		JLabel Week = new JLabel(getWeekOfDate(new Date()));
		Week.setBounds(354, 31, 50, 50);
		Week.setForeground(new Color(0,50,102));
		Week.setFont(new Font("星期",Font.PLAIN,15));
		
		JTextField plusDay = new JTextField("输入天数");
		plusDay.setBounds(407, 43, 90, 27);
		plusDay.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				plusDay.setText("");
			}
		});
		
		JTextField name = new JTextField("输入姓名卜运势");
		name.setBounds(410, 280, 70, 27);
		name.setFont(new Font("无名",Font.PLAIN,9));
		name.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				name.setText("");
			}
		});
		
		JButton ce = new JButton("占卜");
		ce.setBounds(410, 312, 68, 27);
		//JButton图上有两圈方框，外面的是border，里面的是focus状态表示。 
		//focus是焦点状态，一般你最后一次操作过的组件会获得焦点。
		//setFocusPainted(false)可以让里面那个focus的方框不显示。
		//setBorderPainted(false)可以隐藏border，或者你也可以setBorder换一个其他的样式
		ce.setFocusPainted(false);
		ce.setFont(new Font("占卜按钮",Font.PLAIN,9));
		//改变光标形状HAND_CURSOR 手状光标类型
		ce.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result();
			}
		});
		//这个图片不要，弄个大点的背景图片
		//JLabel bg = new JLabel();
		//Image image1 = new ImageIcon("C:\\\\Users\\\\MECHREVO\\\\eclipse-workspace\\\\练习\\\\飞鸟.jpg").getImage();
		//bg.setIcon(new ImageIcon(image1));
        //bg.setBounds(149,100,200,200);
		//屈服了
		JLabel bg = new JLabel();
		Image image1 = new ImageIcon("C:\\Users\\MECHREVO\\eclipse-workspace\\java课程作业\\src\\实验\\巴黎铁塔.jpg").getImage();
		bg.setIcon(new ImageIcon(image1));
		bg.setBounds(0,100,400,222);
		
		JButton sure = new JButton("跳转");
		sure.setBounds(426, 80, 50, 20);
		sure.setFocusPainted(false);
		sure.setFont(new Font("跳转按钮",Font.PLAIN,8));
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
				// TODO 自动生成的方法存根
				long timemillis = System.currentTimeMillis();
				SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss:SSS");
				varTime.setText(df.format(new Date(timemillis)));
			}
			
		});
		timeAction.start();
	}
	
	
	protected void Plus(int n) {
	// TODO 自动生成的方法存根
		Date d = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss:SSS");
		Calendar ca = Calendar.getInstance();
		ca.add(Calendar.DATE, n);
		d = ca.getTime();
		String enddate = format.format(d);
		JOptionPane.showConfirmDialog(null, enddate+""+getWeekOfDate(d),"result",JOptionPane.OK_CANCEL_OPTION);
	}
	private void result() {
	// 返回算卦的内容
			String[] fare = new String[] {"大吉","吉","小吉","大凶","凶","小凶"};
			int n = (int)(Math.random()*5);
			JOptionPane.showConfirmDialog(null, fare[n],"fare",JOptionPane.OK_CANCEL_OPTION);
	}
		

	private String getWeekOfDate(Date date) {
	// 返回星期
		String[] weekDays = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int w = cal.get(Calendar.DAY_OF_WEEK)-1;
		if(w<0)w=0;
		return weekDays[w];
	}
	

}

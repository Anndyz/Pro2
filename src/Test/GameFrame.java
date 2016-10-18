package Test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * 测试窗口
 * @author Wulirt
 *
 */
public class GameFrame extends Frame{
	Image img=GameUtil.getImage("Images/photo.jpg");
	public void launchFrame(){
		setSize(500,500);
		setLocation(100,100);
		
		setVisible(true);
		new PaintThread().start();   //
		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
			
		});
	}
	//构造器初始化运行各个函数来加载文字
	private double x=100,y=100;
	
	
	public void paint(Graphics g){
		g.drawLine(100,100,200,200);
		g.drawRect(100, 100, 200, 200);
		g.drawOval(100, 100, 200, 200);
		
		//字体大小
		Font f= new Font("Black",Font.BOLD,100);
		g.setFont(f);
		g.drawString("Wulirt", 200, 200);
		//画笔颜色，用于后来画笔的还原
		Color c=g.getColor();
		g.fillRect(100, 100, 20, 20);
		g.setColor(Color.GREEN);
		g.fillOval(280, 280, 20,20);
		//还原画笔颜色
		g.setColor(c);
		
		g.drawImage(img,(int)x,(int)y,null);
		//??????????
		x+=3;
		y+=3;
	}
	/*
	 * 重画窗口的内部类
	 * @author Wulirt
	 */
	class PaintThread extends Thread{
		
		public void run(){
			while(true){
				repaint();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args){
		GameFrame gf=new GameFrame();
		gf.launchFrame();
	}
}

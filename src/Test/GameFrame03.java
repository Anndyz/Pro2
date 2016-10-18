package Test;

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
public class GameFrame03 extends Frame{
	Image img=GameUtil.getImage("Images/photo01.jpg");
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
	//private boolean left;
	//设置角度参数来实现触碰反转
	private double degree=3.14/3;
	//设置速度参数来实现减速停止
	//private double speed=20;
	public void paint(Graphics g){
		
		g.drawImage(img,(int)x,(int)y,null);
		
		 x=100+100*Math.cos(degree);
		 y=200+50*Math.sin(degree);
		 degree+=0.1;
		
		
		//??????????       ADD(move in x line or y line)
		/*if(left){
			x-=3;
		}else{
			x+=3;
		}
		if(x>500-30){
			left=true;
		}
		if(x<0){
			left=false;
		}*/
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
		GameFrame03 gf=new GameFrame03();
		gf.launchFrame();
	}
}
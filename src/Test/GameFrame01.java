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
public class GameFrame01 extends Frame{
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
	private boolean left;
	
	public void paint(Graphics g){
		
		g.drawImage(img,(int)x,(int)y,null);
		//??????????
		if(left){
			x-=3;
		}else{
			x+=3;
		}
		if(x>500-30){
			left=true;
		}
		if(x<0){
			left=false;
		}
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
		GameFrame01 gf=new GameFrame01();
		gf.launchFrame();
	}
}

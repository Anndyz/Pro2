package Test;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * ���Դ���
 * @author Wulirt
 *
 */
public class GameFrame02 extends Frame{
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
	//��������ʼ�����и�����������������
	private double x=100,y=100;
	//private boolean left;
	//���ýǶȲ�����ʵ�ִ�����ת
	private double degree=3.14/3;
	//�����ٶȲ�����ʵ�ּ���ֹͣ
	private double speed=20;
	public void paint(Graphics g){
		
		g.drawImage(img,(int)x,(int)y,null);
		
		if(speed>0){
			speed-=0.08;
		}else{
			speed=0;
		}
		x+=speed*Math.cos(degree);
		y+=speed*Math.sin(degree);
		
		if(y>500-33){
			degree=-degree;          //���������ĽǶ��жϸ���
		}
		if(y<0){
			degree=-degree;
		}
		if(x<0){
			degree=Math.PI-degree;
		}
		if(x>500-33){
			degree=Math.PI-degree;
		}
		
		
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
	 * �ػ����ڵ��ڲ���
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
		GameFrame02 gf=new GameFrame02();
		gf.launchFrame();
	}
}

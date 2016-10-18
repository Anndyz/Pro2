package Test;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/*
 * ���Կ�����Ϸ�Ĺ�����
 * @author Wulirt
 */
public class GameUtil {
	private GameUtil(){};       //˽�л������������⹤����ĵ���
	
	//static ������ȷ��������ķ��ʣ�����+static������
	//������ΪImage img=GameUtil.getImage("String path");
	public static Image getImage(String path){
		URL u=GameUtil.class.getClassLoader().getResource(path);
		BufferedImage img=null;
		try {
			img=ImageIO.read(u);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img;
	}
}

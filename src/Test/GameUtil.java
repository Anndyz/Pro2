package Test;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/*
 * 测试开发游戏的工具类
 * @author Wulirt
 */
public class GameUtil {
	private GameUtil(){};       //私有化构造器，避免工具类的调用
	
	//static 方法来确保工具类的访问（类名+static方法）
	//本类中为Image img=GameUtil.getImage("String path");
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

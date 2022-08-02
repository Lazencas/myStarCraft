package myStarCraft;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class StarCraft extends JFrame {
	
	//더블 버퍼링을 위해 이미지를 담는 인스턴스 두개
	 Image screenImage;
	 Graphics screenGraphic;
	
	// BufferedImage introBackground;
	 Image introBackground;
	
	 JLabel imgLabel;

	//클래스를 이용한 객체를 만들었을 때 가장먼저 실행되는 생성자. 자신의 클래스와 같은 이름을 가진 메소드.
	public StarCraft() {
		
		
		setTitle("StarCraft");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);	
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);		
	
		
	ImageIcon icon = new ImageIcon("images/StarCraft.jpg");
	introBackground = icon.getImage();
	
		
	
		
	

	
	}
	
public void paint(Graphics g) {
	screenImage = createImage(1600,900);
	screenGraphic = screenImage.getGraphics();
	screenDraw(screenGraphic);
	g.drawImage(screenImage, 0, 0, null);
}
public void screenDraw(Graphics g) {
	g.drawImage(introBackground, 0, 0, null);
	this.repaint();
}


}

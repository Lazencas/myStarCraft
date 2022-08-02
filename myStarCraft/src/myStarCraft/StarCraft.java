package myStarCraft;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class StarCraft extends JFrame {
	
	//���� ���۸��� ���� �̹����� ��� �ν��Ͻ� �ΰ�
	 Image screenImage;
	 Graphics screenGraphic;
	
	// BufferedImage introBackground;
	 Image introBackground;
	
	 JLabel imgLabel;

	//Ŭ������ �̿��� ��ü�� ������� �� ������� ����Ǵ� ������. �ڽ��� Ŭ������ ���� �̸��� ���� �޼ҵ�.
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

package myStarCraft1;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class StarCraft extends JFrame {

	// ���� ���۸��� ���� �̹����� ��� �ν��Ͻ� �ΰ�
	private Image screenImage;
	private Graphics screenGraphic;    
	private Image Mainbackground,Readybackground;
	private JLabel menuBar;
	private JButton exitButton, startButton, quitButton,readyStartButton;
	int st = 1;
	int mouseX, mouseY, x, y;
	//����ȭ��, �غ�ȭ��, �÷���ȭ�� ���� ��
	boolean isMain=true, isReady=false, isPlay=false;
	//���� ������������ �ʿ��� ������
	File MainBgmFile = new File("mp3/MainMenu.wav");
	AudioInputStream Maininputstream = AudioSystem.getAudioInputStream(MainBgmFile);
	Clip Mainclip = AudioSystem.getClip();
	//���� ������ ������
	//String myRace="",enemyRace=""; 
	int myRace=0,enemyRace=0;
	JComboBox myraceCombo,enemyraceCombo;
	
	

	// Ŭ������ �̿��� ��ü�� ������� �� ������� ����Ǵ� ������. �ڽ��� Ŭ������ ���� �̸��� ���� �޼ҵ�.
	public StarCraft() throws Exception {
		
        //�޴���
		ImageIcon menuBaricon = new ImageIcon("images/StarCraftMenuBar.png");
		menuBar = new JLabel(menuBaricon);
        //�޴��� X��ư
		ImageIcon exitButtonicon = new ImageIcon("images/exitButton.png");
		exitButton = new JButton(exitButtonicon); 
        //����ȭ�� ���۹�ư
		ImageIcon startButtonicon = new ImageIcon("images/startButton.png");
		startButton = new JButton(startButtonicon);
        //����ȭ�� �����ư
		ImageIcon quitButtonicon = new ImageIcon("images/quitButton.png");
		quitButton = new JButton(quitButtonicon);	
		//����ȭ�� ���۹�ư
		ImageIcon readyStartButtonicon = new ImageIcon("images/readystartButton.png");
		readyStartButton = new JButton(readyStartButtonicon);

		setUndecorated(true);
		setTitle("StarCraft");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0)); // ����Ʈ������Ʈ�� ����� ȸ���̾ƴ� �Ͼ������ �ٲ�
		exitButton.setBounds(1565, 0, 30, 30);	
		readyStartButton.setBounds(1300, 600, 200, 100);
		
		String [] race = {"�׶�", "�����佺"};
		JComboBox myraceCombo = new JComboBox(race);
		myraceCombo.setBounds(830, 160, 200, 50);
		add(myraceCombo);
		JComboBox enemyraceCombo = new JComboBox(race);
		enemyraceCombo.setBounds(830, 380, 200, 50);	
		add(enemyraceCombo);
		myraceCombo.setVisible(false);
		enemyraceCombo.setVisible(false);
	
		
		// ����ŸƮ��ư �׸� ���ִ� �ڵ��(�޴��� ������ ���� �ִ� X��ư)
		readyStartButton.setBorderPainted(false);
		readyStartButton.setContentAreaFilled(false);
		readyStartButton.setFocusPainted(false);
				// ����ŸƮ��ư ��ɱ���
		readyStartButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						readyStartButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						readyStartButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// ���� ���� �� ���� �̺�Ʈ, �޺��ڽ����� ������ �޾Ƽ� �����ϰ�
						isReady = false;
						isPlay = true;
						myRace = myraceCombo.getSelectedIndex();
						enemyRace = enemyraceCombo.getSelectedIndex();
						readyStartButton.setVisible(false);
						myraceCombo.setVisible(false);
						enemyraceCombo.setVisible(false);
						System.out.println(myRace);
						System.out.println(enemyRace);
						//, ȭ����ȯ�ϰ�
						
					}
				});
				add(readyStartButton);
				readyStartButton.setVisible(false);
	

		// ���˹�ư �׸� ���ִ� �ڵ��(�޴��� ������ ���� �ִ� X��ư)
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		// ���˹�ư ��ɱ���
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// Ŭ���� ����
				System.exit(0);
			}
		});
		add(exitButton);

		// ��ŸƮ��ư ����
		startButton.setBounds(600, 400, 400, 100);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// Ŭ���� ���� ���� �̺�Ʈ
				isMain = false;
				isReady = true;
				//Mainclip.stop();
				//����ȭ�鿡 �ִ� 2����ư ���ְ� ����ȭ�� �����޺��ڽ�, ���۹�ư Ȱ��ȭ
				quitButton.setVisible(false);
				startButton.setVisible(false);
				readyStartButton.setVisible(true);
				myraceCombo.setVisible(true);
				enemyraceCombo.setVisible(true);

			}
		});
		add(startButton);

		// ţ��ư ����
		quitButton.setBounds(600, 600, 400, 100);
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// Ŭ���� ����
				System.exit(0);
			}
		});
		add(quitButton);

		// �޴��� ��ġ, ũ�� ����
		menuBar.setBounds(0, 0, 1600, 30);
		add(menuBar);
		// �޴��� ��ɱ���
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});

		// �̹��� �����ܿ� �̹����� �ְ� �̹����� �̹����������� �����Ѵ�.
		ImageIcon icon = new ImageIcon("images/StarCraftTitle.jpg");
		Mainbackground = icon.getImage();
		
		//�غ�ȭ�� �̹��� �̸� ����
		ImageIcon Readybackgroundicon = new ImageIcon("images/readyBackground.png");
		Readybackground = Readybackgroundicon.getImage();		
		// ����������		 
	    System.out.println("üŰ���");		
		Mainclip.open(Maininputstream);
		Mainclip.start();		
		//�̰� ������ ���� �ȳ��´ٰ� �ؼ� ���f�µ� �����µ�?
		//Thread.sleep(c.getMicrosecondLength() / 1000);
		
		
		
		
					

		
		

	
		

	}
	

	public void paint(Graphics g) {
		screenImage = createImage(1600, 900);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		if(isMain) {
		g.drawImage(Mainbackground, 0, 0, null);	
		}
		if(isReady) {
			g.drawImage(Readybackground, 0, 0, null);	
		}
		if(isPlay){
			g.drawImage(Readybackground, 0, 0, null);	
		}
		paintComponents(g);
		this.repaint();
	}

}

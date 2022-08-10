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

	// 더블 버퍼링을 위해 이미지를 담는 인스턴스 두개
	private Image screenImage;
	private Graphics screenGraphic;    
	private Image Mainbackground,Readybackground;
	private JLabel menuBar;
	private JButton exitButton, startButton, quitButton,readyStartButton;
	int st = 1;
	int mouseX, mouseY, x, y;
	//메인화면, 준비화면, 플레이화면 상태 값
	boolean isMain=true, isReady=false, isPlay=false;
	//메인 배경음악재생에 필요한 변수들
	File MainBgmFile = new File("mp3/MainMenu.wav");
	AudioInputStream Maininputstream = AudioSystem.getAudioInputStream(MainBgmFile);
	Clip Mainclip = AudioSystem.getClip();
	//나와 상대방의 종족값
	//String myRace="",enemyRace=""; 
	int myRace=0,enemyRace=0;
	JComboBox myraceCombo,enemyraceCombo;
	
	

	// 클래스를 이용한 객체를 만들었을 때 가장먼저 실행되는 생성자. 자신의 클래스와 같은 이름을 가진 메소드.
	public StarCraft() throws Exception {
		
        //메뉴바
		ImageIcon menuBaricon = new ImageIcon("images/StarCraftMenuBar.png");
		menuBar = new JLabel(menuBaricon);
        //메뉴바 X버튼
		ImageIcon exitButtonicon = new ImageIcon("images/exitButton.png");
		exitButton = new JButton(exitButtonicon); 
        //메인화면 시작버튼
		ImageIcon startButtonicon = new ImageIcon("images/startButton.png");
		startButton = new JButton(startButtonicon);
        //메인화면 종료버튼
		ImageIcon quitButtonicon = new ImageIcon("images/quitButton.png");
		quitButton = new JButton(quitButtonicon);	
		//레디화면 시작버튼
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
		setBackground(new Color(0, 0, 0, 0)); // 페인트컴포넌트시 배경을 회색이아닌 하얀색으로 바꿈
		exitButton.setBounds(1565, 0, 30, 30);	
		readyStartButton.setBounds(1300, 600, 200, 100);
		
		String [] race = {"테란", "프로토스"};
		JComboBox myraceCombo = new JComboBox(race);
		myraceCombo.setBounds(830, 160, 200, 50);
		add(myraceCombo);
		JComboBox enemyraceCombo = new JComboBox(race);
		enemyraceCombo.setBounds(830, 380, 200, 50);	
		add(enemyraceCombo);
		myraceCombo.setVisible(false);
		enemyraceCombo.setVisible(false);
	
		
		// 레디스타트버튼 네모 없애는 코드들(메뉴바 오른쪽 위에 있는 X버튼)
		readyStartButton.setBorderPainted(false);
		readyStartButton.setContentAreaFilled(false);
		readyStartButton.setFocusPainted(false);
				// 레디스타트버튼 기능구현
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
						// 종족 선택 후 시작 이벤트, 콤보박스에서 종족값 받아서 저장하고
						isReady = false;
						isPlay = true;
						myRace = myraceCombo.getSelectedIndex();
						enemyRace = enemyraceCombo.getSelectedIndex();
						readyStartButton.setVisible(false);
						myraceCombo.setVisible(false);
						enemyraceCombo.setVisible(false);
						System.out.println(myRace);
						System.out.println(enemyRace);
						//, 화면전환하고
						
					}
				});
				add(readyStartButton);
				readyStartButton.setVisible(false);
	

		// 엑싯버튼 네모 없애는 코드들(메뉴바 오른쪽 위에 있는 X버튼)
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		// 엑싯버튼 기능구현
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
				// 클릭시 종료
				System.exit(0);
			}
		});
		add(exitButton);

		// 스타트버튼 구현
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
				// 클릭시 게임 시작 이벤트
				isMain = false;
				isReady = true;
				//Mainclip.stop();
				//메인화면에 있던 2개버튼 없애고 레디화면 종족콤보박스, 시작버튼 활성화
				quitButton.setVisible(false);
				startButton.setVisible(false);
				readyStartButton.setVisible(true);
				myraceCombo.setVisible(true);
				enemyraceCombo.setVisible(true);

			}
		});
		add(startButton);

		// 큇버튼 구현
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
				// 클릭시 종료
				System.exit(0);
			}
		});
		add(quitButton);

		// 메뉴바 위치, 크기 세팅
		menuBar.setBounds(0, 0, 1600, 30);
		add(menuBar);
		// 메뉴바 기능구현
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

		// 이미지 아이콘에 이미지를 넣고 이미지에 이미지아이콘을 세팅한다.
		ImageIcon icon = new ImageIcon("images/StarCraftTitle.jpg");
		Mainbackground = icon.getImage();
		
		//준비화면 이미지 미리 세팅
		ImageIcon Readybackgroundicon = new ImageIcon("images/readyBackground.png");
		Readybackground = Readybackgroundicon.getImage();		
		// 배경음악재생		 
	    System.out.println("체키라웃");		
		Mainclip.open(Maininputstream);
		Mainclip.start();		
		//이거 없으면 음악 안나온다고 해서 빼봣는데 나오는데?
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

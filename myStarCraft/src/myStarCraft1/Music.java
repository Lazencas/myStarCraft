package myStarCraft1;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music {
	
	
	while(true)
	{
		File a = new File("mp3/MainMenu.wav");
		AudioInputStream b = AudioSystem.getAudioInputStream(a);
		Clip c = AudioSystem.getClip();
		c.open(b);
		c.start();
		Thread.sleep(c.getMicrosecondLength()/1000);
	}



}
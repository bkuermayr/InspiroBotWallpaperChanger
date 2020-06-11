package bkuermayr.model;

import java.util.Timer;

import javax.swing.JOptionPane;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.win32.W32APIOptions;

public class WallpaperChanger {    
	private int interval;
	private InspiroBotDesktop ibot;
	private Timer time;
	
	public WallpaperChanger(int interval) {
		this.interval = interval;
		this.ibot = new InspiroBotDesktop();
		this.time = new Timer();
		this.time.schedule(this.ibot, 0, this.interval*1000);
	}
		
	public static interface User32 extends Library {
	     User32 INSTANCE = (User32) Native.load("user32",User32.class,W32APIOptions.DEFAULT_OPTIONS);        
	     boolean SystemParametersInfo (int one, int two, String s ,int three);         
	}
	
	public static void change(String path) {   
		   User32.INSTANCE.SystemParametersInfo(0x0014, 0, path , 1);
	}

	public void stop() {
		this.time.cancel();
		this.time = null;
	}
}

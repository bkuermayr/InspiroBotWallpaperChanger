package bkuermayr;

import java.io.IOException;
import java.util.Timer;

import javax.swing.JOptionPane;

public class Main {
	public static void main (String[] args) {
		int interval = 5;
		//int interval = Integer.parseInt(JOptionPane.showInputDialog(null,"Please input wallpaper changing intervall in seconds: ")); 
		InspiroBotDesktop ibot = new InspiroBotDesktop();
		Timer time = new Timer();
		time.schedule(ibot, 0, interval*1000);
	}
}

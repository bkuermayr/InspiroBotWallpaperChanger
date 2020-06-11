package bkuermayr.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import bkuermayr.model.WallpaperChanger;
import bkuermayr.view.StartFrame;
import bkuermayr.view.WallpaperChangerPanel;

/**
 * Controller connect model with view
 * @author Benjamin Kuermayr
 * @version 2020-06-11
 */
public class WallpaperChangerController implements ActionListener {
	private WallpaperChanger model;
	private JFrame frame;
	private WallpaperChangerPanel view;
	
	public WallpaperChangerController () {
		this.view = new WallpaperChangerPanel(this);
		this.frame = new StartFrame("InspiroBotWallpaperChanger",this.view);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		System.out.println(action);
		switch(action) {
			case "interval":
				this.model = new WallpaperChanger(this.view.getInterval());
				System.out.println("interval"+this.view.getInterval());
				break;
			case "run":
				System.out.println("run"+this.view.getInterval());
				this.model = new WallpaperChanger(this.view.getInterval());
				break;
			case "stop": 
				System.exit(0);
				break;
			}
	}
	
	/**
	 * start program
	 */
	public static void main (String[] args) {
		new WallpaperChangerController();
	}
}

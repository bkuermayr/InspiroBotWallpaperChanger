package bkuermayr.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bkuermayr.controller.WallpaperChangerController;
/**
 * View for WallpaperChanger-Program
 * @author Benjamin Kuermayr
 * @version 2020-06-11
 */
public class WallpaperChangerPanel extends JPanel {
	private JButton run, stop;
	private JTextField interval;

	public WallpaperChangerPanel(WallpaperChangerController control) {
		this.setBorder(BorderFactory.createMatteBorder(15,15,15,15,new Color(238,238,238)));
		this.setLayout(new BorderLayout());
		
		JPanel main = new JPanel();
		JPanel buttons = new JPanel(new GridLayout(1,2,10,10));

		main.setLayout(new GridLayout(3,1,10,10));
		//Titel und Worteingabe
	    Font f = new Font("Montserrat",Font.PLAIN,25);
	    Font d = new Font("Montserrat",Font.ITALIC,12);
	    Font p = new Font("Montserrat",Font.PLAIN,14);
	    
	    JLabel instructions = new JLabel("Please input wallpaper changing intervall in seconds: ");
		instructions.setBorder(BorderFactory.createMatteBorder(0,0,15,0,new Color(238,238,238)));

	    this.add(instructions,BorderLayout.PAGE_START);
	    this.interval = new JTextField("",10);
	    this.interval.setFont(p);
	    this.interval.setPreferredSize(new Dimension(-1, 30));
	    this.interval.setActionCommand("interval");
	    this.interval.addActionListener(control);
	    main.add(this.interval);
	    
	    this.run = new JButton("Run");
	    this.run.setActionCommand("run");
	    this.run.addActionListener(control);
	    this.run.setFont(p);
	    buttons.add(this.run);
	    
	    this.stop = new JButton("Terminate program");
	    this.stop.setActionCommand("stop");
	    this.stop.setFont(p);
	    this.stop.addActionListener(control);
	    buttons.add(this.stop);
	    main.add(buttons);

	    JLabel instructions2 = new JLabel("Close window to run program in the background.");
	    instructions2.setBorder(BorderFactory.createMatteBorder(15,0,0,0,new Color(238,238,238)));
	    instructions2.setFont(d);
	    this.add(main,BorderLayout.CENTER);
	    this.add(instructions2,BorderLayout.PAGE_END);
	}

	/**
	 * @return input wallpaper changing interval in seconds
	 */
	public int getInterval() {
		return Integer.parseInt(this.interval.getText());
	}
	
	
}

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
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
/**
 * View for WallpaperChanger-Program
 * @author Benjamin Kuermayr
 * @version 2020-06-11
 */
public class NiceGuiPanel extends JPanel {
	private JButton run, stop;
	private JTextField interval;

	public NiceGuiPanel (WallpaperChangerController control) {
		this.setBackground(Color.decode("#30332E"));
		this.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
		this.setLayout(new BorderLayout());
		
		JPanel main = new JPanel();
		main.setBackground(Color.decode("#30332E"));
		JPanel buttons = new JPanel(new GridLayout(1,2,10,10));
		buttons.setBackground(Color.decode("#30332E"));

		main.setLayout(new GridLayout(2,1,10,10));
		//Titel und Worteingabe
	    Font f = new Font("Montserrat",Font.PLAIN,25);
	    Font d = new Font("Montserrat",Font.ITALIC,12);
	    Font p = new Font("Montserrat",Font.PLAIN,14);
	    
	    JLabel instructions = new JLabel("Please input wallpaper changing intervall in seconds: ");
	    instructions.setForeground(Color.WHITE);
	    instructions.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		instructions.setBorder(BorderFactory.createEmptyBorder(0,0,15,0));

	    this.add(instructions,BorderLayout.PAGE_START);
	    this.interval = new JTextField("",10);
	    this.interval.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	    this.interval.setPreferredSize(new Dimension(-1, 30));
	    this.interval.setActionCommand("interval");
	    this.interval.addActionListener(control);
	    main.add(this.interval);
	    
	    this.run = new JButton("Run");
	    run.setBackground(Color.WHITE);
	    this.run.setActionCommand("run");
	    this.run.addActionListener(control);
	    this.run.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	    buttons.add(this.run);
	    
	    this.stop = new JButton("Terminate program");
	    stop.setBackground(Color.WHITE);
	    this.stop.setActionCommand("stop");
	    this.stop.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	    this.stop.addActionListener(control);
	    buttons.add(this.stop);
	    main.add(buttons);

	    JLabel instructions2 = new JLabel("Close window to run program in the background.");
	    instructions2.setForeground(Color.WHITE);
	    instructions2.setBorder(BorderFactory.createEmptyBorder(15,0,0,0));
	    instructions2.setFont(new Font("Segoe UI", Font.ITALIC, 14));
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

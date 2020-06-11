package bkuermayr.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Frame to start the GUI 
 * 
 * @author Benjamin Kuermayr
 * @version 2020-06-11
 */
public class StartFrame extends JFrame {
	public StartFrame(String titel, JPanel layoutPanel) {
		super(titel);
		this.add(layoutPanel);
		this.setBackground(Color.decode("#30332E"));
		URL imgURL = getClass().getResource("/images/wand.jpg");
		Image image = Toolkit.getDefaultToolkit().createImage(imgURL);
		this.setIconImage(image);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}

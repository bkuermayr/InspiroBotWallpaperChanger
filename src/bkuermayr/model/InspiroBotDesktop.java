package bkuermayr.model;

import java.io.*;
import java.net.*;
import java.util.*;

public class InspiroBotDesktop extends TimerTask {
	private String image;
	
	public InspiroBotDesktop() {
		this.image = "";
	}
	
	private void clear() {
		this.image = "";
        String property = "java.io.tmpdir";
        String destName = System.getProperty(property)+"/wallpaper.jpg";

	    File file = new File(destName);
	    file.delete();
	}
	
	private void loadImages() {
		this.clear();
		
		try {
			this.image = this.getImage();
			this.saveImage(this.image);
		} catch (IOException e) {
			e.printStackTrace();
			this.loadImages();
		}
	}
	
	public String getImage() throws IOException {
		URL url = new URL("https://inspirobot.me/api?generate=true&oy=vey");
		
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer content = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			content.append(inputLine);
		}
		in.close();

		con.disconnect();
		return content.toString();
	}
	
	public void saveImage(String imageUrl) throws IOException {
		URL url = new URL(imageUrl);

        String property = "java.io.tmpdir";
        String destName = System.getProperty(property)+"/wallpaper.jpg";

		
		System.out.println(destName);
		InputStream is = url.openStream();
		OutputStream os = new FileOutputStream(destName.toString());
		byte[] b = new byte[2048];
		int length;
		while ((length = is.read(b)) != -1) {
			os.write(b, 0, length);
		}
		is.close();
		os.close();
		

		WallpaperChanger.change(destName);
	}

	@Override
	public void run() {
		this.loadImages();
	}
}

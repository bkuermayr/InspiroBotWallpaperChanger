package bkuermayr.model;

import java.io.*;
import java.net.*;
import java.util.*;

public class InspiroBotDesktop extends TimerTask {
	private Set<String> images;
	
	public InspiroBotDesktop() {
		this.images = new TreeSet<>();
	}
	
	private void clear() {
		this.images.removeAll(this.images);
        String property = "java.io.tmpdir";
        String destName = System.getProperty(property)+"/wallpaper.jpg";

	    File file = new File(destName);
	    file.delete();
	}
	
	private void loadImages() {
		this.clear();

		int amount = 1;
		while(this.images.size() < amount) {
			try {
				String img = this.getImage();
				this.images.add(img);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		for(String imageUrl: this.images) {
			try {
				this.saveImage(imageUrl);
			} catch (IOException e) {
				e.printStackTrace();
			}
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

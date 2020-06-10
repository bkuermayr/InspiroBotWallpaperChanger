package bkuermayr;

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
		
	    File[] files = new File("./resource").listFiles();
	    if(files !=null) {
	        for(File f: files) {
	        	f.delete();
	        }
	    }
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
		String fileName = url.getFile();
		String destName = "./resource" + fileName.substring(fileName.lastIndexOf("/"));

		System.out.println(destName);
		InputStream is = url.openStream();
		OutputStream os = new FileOutputStream(destName);
		byte[] b = new byte[2048];
		int length;
		while ((length = is.read(b)) != -1) {
			os.write(b, 0, length);
		}
		is.close();
		os.close();
		
		File file = new File("getabsolutepath.txt");
		String absolutePath = file.getAbsolutePath().replace("getabsolutepath.txt", "") + "resource" + fileName.substring(fileName.lastIndexOf("/"));
		System.out.println(absolutePath);

		WallpaperChanger.change(absolutePath);
	}

	@Override
	public void run() {
		this.loadImages();
	}
}

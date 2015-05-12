package com.ezrebclan.assets;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import com.ezrebclan.assets.asset.ImageAsset;


public class Main {

	public static void main(String[] args) throws Exception {
		loadImageAsset();
	}
	
	private static void saveImageAsset() throws Exception {
		File testImageAsset = new File("test.asset");
		File testImage = new File("test.png");
		BufferedImage bi = ImageIO.read(testImage);
		ImageAsset ia = new ImageAsset("test", bi);
		ia.save(new FileOutputStream(testImageAsset));
	}
	private static void loadImageAsset() throws Exception {
		File assetFile = new File("test.asset");
		FileInputStream fis = new FileInputStream(assetFile);
		ImageAsset ia = new ImageAsset(fis);
		fis.close();
		JFrame jf = new JFrame();
		jf.setSize(500, 500);
		Canvas c = new Canvas() {
			private static final long serialVersionUID = 5818315609326383477L;
			@Override
			public void paint(Graphics g) {
				g.drawImage(ia.data, 0, 0, jf);
			}
		};
		c.setSize(300, 300);
		jf.setUndecorated(true);
		c.setLocation(100, 100);
		jf.setLayout(null);
		jf.add(c);
		jf.setVisible(true);
		Thread.sleep(10000);
	}

}

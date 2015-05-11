package com.ezrebclan.jvm2Dsolo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;

import com.ezrebclan.jvm2Dsolo.asset.ImageAsset;


public class Main {

	public static void main(String[] args) throws Exception {
		File testImageAsset = new File("test.zip");
		File testImage = new File("test.png");
		BufferedImage bi = ImageIO.read(testImage);
		ImageAsset ia = new ImageAsset("test", bi);
		ia.save(new FileOutputStream(testImageAsset));
	}

}

package com.ezrebclan.jvm2Dsolo.asset;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import org.json.JSONObject;

public class ImageAsset extends Asset<BufferedImage> {

	public ImageAsset(String name, BufferedImage image) {
		data = image;
		index = new AssetIndex(name, "image.png");
		JSONObject details = new JSONObject();
		details.put("X Resolution", image.getWidth());
		details.put("Y Resolution", image.getHeight());
		details.put("Resolution", image.getWidth()+"x"+image.getHeight());
		index.setDetails(details);
	}
	
	@Override
	protected void saveData(OutputStream output) throws Exception {
		ImageIO.write(data, "png", output);
	}

	@Override
	protected BufferedImage loadData(InputStream input) throws Exception {
		return ImageIO.read(input);
	}

}

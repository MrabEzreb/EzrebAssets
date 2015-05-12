package com.ezrebclan.asset;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import org.json.JSONObject;

/**
 * An ImageAsset holds a {@link BufferedImage} as its data.<br>
 * ImageAssets also includes extra data in its {@link AssetIndex#details AssetIndex}:
 * <ul>
 * <li>X Resolution (Width)</li>
 * <li>Y Resolution (Hieght)</li>
 * <li>Full Resolution (WidthxHieght)</li>
 * </ul>
 * @author Mrab Ezreb
 */
public class ImageAsset extends Asset<BufferedImage> {

	/**
	 * Creates an ImageAsset, assigns it a name, and stores the image in the {@link Asset#data data} field.
	 * @param name The image's name
	 * @param image A {@link BufferedImage} to store in this asset
	 */
	public ImageAsset(String name, BufferedImage image) {
		super(name, "image.png");
		JSONObject details = new JSONObject();
		data = image;
		details.put("X Resolution", image.getWidth());
		details.put("Y Resolution", image.getHeight());
		details.put("Resolution", image.getWidth()+"x"+image.getHeight());
		index.setDetails(details);
	}
	/**
	 * Loads an ImageAsset from an {@link InputStream}
	 * @param input An {@link InputStream} to load from.
	 */
	public ImageAsset(InputStream input) throws Exception {
		super(input);
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

package test;

import static org.junit.Assert.*;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import org.junit.Test;

import com.ezrebclan.asset.assetTypes.ImageAsset;

/**
 * JUnit tests for ImageAssets
 * @author Mrab Ezreb
 */
public class ImageAssetTests {

	/**
	 * Loads an image and creates an asset object.
	 * @throws Exception thrown from constructing an asset
	 */
	@Test
	public void packageAsset() throws Exception {
		File assetRaw = new File("test.png");
		BufferedImage bi = ImageIO.read(assetRaw);
		ImageAsset asset = new ImageAsset("image Test", bi);
		assertNotNull("Asset == Null", asset);
	}
	
	/**
	 * Saves an asset
	 * @throws Exception thrown from constructing an asset
	 */
	@Test
	public void exportAsset() throws Exception {
		File assetRaw = new File("test.png");
		BufferedImage bi = ImageIO.read(assetRaw);
		ImageAsset asset = new ImageAsset("image Test", bi);
		File assetF = new File("imageTest.asset");
		FileOutputStream f = new FileOutputStream(assetF);
		asset.save(f);
		f.close();
		assertTrue("File Not Existing", assetF.exists() && assetF.isFile());
	}
	
	/**
	 * Loads a saved asset
	 * @throws Exception thrown from constructing an asset
	 */
	@Test
	public void loadAsset() throws Exception {
		File assetRaw = new File("test.png");
		BufferedImage bi = ImageIO.read(assetRaw);
		ImageAsset asset = new ImageAsset("image Test", bi);
		File assetF = new File("imageTest.asset");
		asset.save(new FileOutputStream(assetF));
		FileInputStream fis = new FileInputStream(assetF);
		ImageAsset asset2 = new ImageAsset(fis);
		fis.close();
		assertNotNull("Loaded Asset == Null", asset2);
	}
	
	/**
	 * Displays the image on a JFrame
	 * @throws Exception thrown from constructing an asset
	 */
	public void displayAssets() throws Exception {
		File assetRaw = new File("test.png");
		BufferedImage bi = ImageIO.read(assetRaw);
		ImageAsset asset = new ImageAsset("image Test", bi);
		File assetF = new File("imageTest.asset");
		asset.save(new FileOutputStream(assetF));
		FileInputStream fis = new FileInputStream(assetF);
		ImageAsset asset2 = new ImageAsset(fis);
		fis.close();
		JFrame jf = new JFrame();
		jf.setSize(900, 500);
		Canvas c1 = new Canvas() {
			private static final long serialVersionUID = 5818315609326383477L;
			@Override
			public void paint(Graphics g) {
				g.drawImage(asset.data, 0, 0, jf);
			}
		};
		c1.setSize(300, 300);
		jf.setUndecorated(true);
		c1.setLocation(100, 100);
		jf.setLayout(null);
		jf.add(c1);
		Canvas c2 = new Canvas() {
			private static final long serialVersionUID = 5818315609326383477L;
			@Override
			public void paint(Graphics g) {
				g.drawImage(asset2.data, 0, 0, jf);
			}
		};
		c2.setSize(300, 300);
		jf.setUndecorated(true);
		c2.setLocation(500, 100);
		jf.setLayout(null);
		jf.add(c2);
		jf.setVisible(true);
	}

}

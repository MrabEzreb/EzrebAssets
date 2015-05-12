package com.ezrebclan.asset;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.json.JSONObject;
import org.json.JSONTokener;

/**
 * An Asset is anything that gets loaded by your code. Some examples are Images, Models, Plain Text, Raw Object Data, and Scripts.<br>
 * An Asset object holds two things, the data itself, and an {@link com.ezrebclan.asset.AssetIndex AssetIndex} object. The index object holds information about the data.<br><br>
 * Assets can be exported, by calling the {@link #save(OutputStream) save()} method and providing an {@link java.io.OutputStream OutputStream} to write to, which is typically a {@link FileOutputStream}, but could be anything.<br>
 * Assets can also be imported, by constructing them with an {@link java.io.InputStream InputStream} to get the data from. Again, this is typically a {@link FileInputStream}, but could be anything.<br><br>
 * Since the Asset class is abstract, you can't really use it very easily. Instead, use one of the subclasses:
 * <ul>
 * <li>{@link ImageAsset}</li>
 * <li>{@link SmallTextAsset}</li>
 * <li>{@link BigTextAsset}</li>
 * </ul>
 * @author Mrab Ezreb
 *
 * @param <Type>
 */
//<li>{@link }</li>
public abstract class Asset<Type> implements Saveable, Loadable {

	/**
	 * The actual data stored in the asset
	 */
	public Type data;
	/**
	 * An index object that holds info about the data.
	 * @see AssetIndex
	 */
	public AssetIndex index;
	
	/**
	 * @param input An {@link InputStream} to load from.
	 */
	protected Asset(InputStream input) throws Exception {
		this.load(input);
	}
	
	/**
	 * @param name The name of the asset
	 * @param type The type of the asset
	 */
	protected Asset(String name, String type) {
		index = new AssetIndex(name, type);
	}
	
	@Override
	public void save(OutputStream output) throws Exception {
		ZipOutputStream zos = new ZipOutputStream(output);
		ZipEntry indexZE = new ZipEntry("index.json");
		ZipEntry dataZE = new ZipEntry(index.getType());
		zos.putNextEntry(indexZE);
		zos.write(index.toJSONString().getBytes());
		zos.flush();
		zos.closeEntry();
		zos.putNextEntry(dataZE);
		saveData(zos);
		zos.flush();
		zos.closeEntry();
		zos.flush();
		zos.finish();
	}
	
	@Override
	public void load(InputStream input) throws Exception {
		ZipInputStream zis = new ZipInputStream(input);
		ZipEntry entry1 = zis.getNextEntry();
		if(entry1.getName().equals("index.json")) {
			loadIndex(zis);
			zis.closeEntry();
			zis.getNextEntry();
			data = loadData(zis);
			zis.closeEntry();
		} else {
			data = loadData(zis);
			zis.closeEntry();
			zis.getNextEntry();
			loadIndex(zis);
			zis.closeEntry();
		}
	}
	
	/**
	 * Loads index.json from an {@link ZipInputStream}
	 */
	private void loadIndex(InputStream input) throws Exception {
		JSONObject indexJSON = new JSONObject(new JSONTokener(input));
		index = new AssetIndex(indexJSON);
	}
	/**
	 * Called when saving the asset. Subclasses override this in order to save the asset's data into the asset object.
	 * @param output This is a direct reference to the asset's outputstream. Write the asset DIRECTLY to this parameter.
	 */
	protected abstract void saveData(OutputStream output) throws Exception;
	/**
	 * Called when loading the asset. Subclasses override this in order to load the asset's data into the asset object.
	 * @param input This is a direct reference to the asset's inputstream. Read the asset DIRECTLY from this parameter.
	 * @return The asset data
	 */
	protected abstract Type loadData(InputStream input) throws Exception;
}

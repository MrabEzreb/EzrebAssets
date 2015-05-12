package com.ezrebclan.jvm2Dsolo.asset;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.json.JSONObject;
import org.json.JSONTokener;

public abstract class Asset<Type> implements Saveable, Loadable {

	public Type data;
	public AssetIndex index;
	
	public Asset(InputStream input) throws Exception {
		this.load(input);
	}
	
	protected Asset(){}
	
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

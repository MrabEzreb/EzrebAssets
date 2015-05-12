package com.ezrebclan.asset.assetTypes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import com.ezrebclan.asset.core.Asset;

/**
 * A <i>Small</i> Text Asset is a single line of text.<br>
 * If you need to store multiple lines of text, look into a {@linkplain com.ezrebclan.asset.assetTypes.BigTextAsset Big Text Asset}.
 * @author Mrab Ezreb
 */
public class SmallTextAsset extends Asset<String> {

	/**
	 * Loads a SmallTextAsset from an {@link InputStream}
	 * @param input An {@link InputStream} to load from.
	 * @throws Exception Throws any exceptions
	 */
	public SmallTextAsset(InputStream input) throws Exception {
		super(input);
	}

	/**
	 * Creates a SmallTextAsset, assigns it a name, and sets the line of text.
	 * @param name The name of the asset
	 * @param text The text of the asset
	 */
	public SmallTextAsset(String name, String text) {
		super(name, "small.txt");
		data = text;
	}

	@Override
	protected void saveData(OutputStream output) throws Exception {
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(output));
		out.write(data);
		out.flush();
	}

	@Override
	protected String loadData(InputStream input) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(input));
		return in.readLine();
	}

}

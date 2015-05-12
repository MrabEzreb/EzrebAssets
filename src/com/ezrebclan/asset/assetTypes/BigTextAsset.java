package com.ezrebclan.asset.assetTypes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import com.ezrebclan.asset.core.Asset;

/**
 * A <i>Big</i> Text Asset is multiple lines of text, stored in a string array.<br>
 * If you need to store a single line of text, look into a {@linkplain com.ezrebclan.asset.assetTypes.SmallTextAsset Small Text Asset}.
 * @author Mrab Ezreb
 */
public class BigTextAsset extends Asset<String[]> {

	/**
	 * Loads a BigTextAsset from an {@link InputStream}
	 * @param input An {@link InputStream} to load from.
	 * @throws Exception Throws any exceptions
	 */
	public BigTextAsset(InputStream input) throws Exception {
		super(input);
	}

	/**
	 * Creates a BigTextAsset, assigns it a name, and sets the lines of text.
	 * @param name The name of the asset
	 * @param text A String[] with the lines of text
	 */
	public BigTextAsset(String name, String[] text) {
		super(name, "big.txt");
		data = text;
	}
	@Override
	protected void saveData(OutputStream output) throws Exception {
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(output));
		for (String string : data) {
			out.write(string);
			out.newLine();
		}
		out.flush();
	}

	@Override
	protected String[] loadData(InputStream input) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(input));
		String[] lines = new String[0];
		while(in.ready()) {
			String line = in.readLine();
			String[] lines2 = new String[lines.length + 1];
			System.arraycopy(lines, 0, lines2, 0, lines.length);
			lines2[lines.length] = line;
			lines = lines2;
		}
		return lines;
	}

}

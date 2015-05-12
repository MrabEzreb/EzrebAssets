package com.ezrebclan.asset;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * A Loadable class can be "loaded" (whatever that may mean is up to the class) using the {@link #load(InputStream)} method.
 * @see Saveable
 * @author Mrab Ezreb
 */
public interface Loadable {

	/**
	 * Loads a Loadable object from an {@link InputStream}
	 * @param input An {@link InputStream} to load from. This is typically a {@link FileInputStream}, but could be anything.
	 */
	public abstract void load(InputStream input) throws Exception;
}

package com.ezrebclan.asset;

import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * A Saveable class can be "saved" (whatever that may mean is up to the class) using the {@link #save(OutputStream)} method.
 * @see Loadable
 * @author Mrab Ezreb
 */
public interface Saveable {

	/**
	 * Saves a Saveable object to an {@link OutputStream}
	 * @param output An {@link OutputStream} to save to. This is typically a {@link FileOutputStream}, but could be anything.
	 */
	public abstract void save(OutputStream output) throws Exception;
}

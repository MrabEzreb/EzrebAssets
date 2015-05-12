package com.ezrebclan.assets.asset;

import java.io.OutputStream;

public interface Saveable {

	public abstract void save(OutputStream output) throws Exception;
}

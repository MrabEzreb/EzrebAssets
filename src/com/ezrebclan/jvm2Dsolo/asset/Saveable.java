package com.ezrebclan.jvm2Dsolo.asset;

import java.io.OutputStream;

public interface Saveable {

	public abstract void save(OutputStream output) throws Exception;
}

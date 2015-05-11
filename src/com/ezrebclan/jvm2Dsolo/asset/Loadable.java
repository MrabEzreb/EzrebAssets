package com.ezrebclan.jvm2Dsolo.asset;

import java.io.InputStream;

public interface Loadable {

	public abstract void load(InputStream input) throws Exception;
}

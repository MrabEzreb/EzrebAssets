package com.ezrebclan.assets.asset;

import java.io.InputStream;

public interface Loadable {

	public abstract void load(InputStream input) throws Exception;
}

package com.ezrebclan.jvm2Dsolo.asset;

import org.json.JSONObject;
import org.json.JSONString;

public class AssetIndex implements JSONString {

	private String assetName;
	private String type;
	private JSONObject details;
	
	/**
	 * Use this constructor to set the asset's name, storedname, and details all in one fell swoop.
	 * @param assetName
	 * @param type
	 * @param details
	 */
	public AssetIndex(String assetName, String type, JSONObject details) {
		this.assetName = assetName;
		this.type = type;
		this.details = details;
	}

	/**
	 * This constructor sets the asset's name and storedname, and it also sets the asset's details to a EmptyDetails object.
	 * @param assetName
	 * @param type
	 */
	public AssetIndex(String assetName, String type) {
		this.assetName = assetName;
		this.type = type;
		this.details = new JSONObject();
	}
	
	/**
	 * This constructor is used to get an AssetIndex object from an asset's index
	 * @param json A JSONObject ready for parsing
	 */
	public AssetIndex(JSONObject json) {
		this.assetName = json.getString("assetName");
		this.type = json.getString("type");
		this.details = json.getJSONObject("details");
	}

	@Override
	public String toJSONString() {
		JSONObject json = new JSONObject(this);
		return json.toString();
	}
	
	//Getters and Setters

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public JSONObject getDetails() {
		return details;
	}

	public void setDetails(JSONObject details) {
		this.details = details;
	}
}

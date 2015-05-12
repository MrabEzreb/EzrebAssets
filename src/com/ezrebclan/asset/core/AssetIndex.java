package com.ezrebclan.asset.core;

import org.json.JSONObject;
import org.json.JSONString;

/**
 * An AssetIndex is a JSON-Serializable object that holds information about an {@link Asset}, including the name and type of data.<br>
 * It also holds a {@link JSONObject}, {@link #details}, which can contain anything you want it to.
 * @author Mrab Ezreb
 */
public class AssetIndex implements JSONString {

	/**
	 * The name of the asset
	 */
	private String assetName;
	/**
	 * The asset's type
	 */
	private String type;
	/**
	 * Any extra details about the asset
	 * @see JSONObject
	 */
	private JSONObject details;
	
	/**
	 * Use this constructor to set the asset's name, storedname, and details all in one fell swoop.
	 * @param assetName the asset's name
	 * @param type the asset's type
	 * @param details details about the asset
	 */
	public AssetIndex(String assetName, String type, JSONObject details) {
		this.assetName = assetName;
		this.type = type;
		this.details = details;
	}

	/**
	 * This constructor sets the asset's name and storedname, and it also sets the asset's details to a EmptyDetails object.
	 * @param assetName the asset's name
	 * @param type the asset's type
	 */
	public AssetIndex(String assetName, String type) {
		this.assetName = assetName;
		this.type = type;
		this.details = new JSONObject();
	}
	
	/**
	 * This constructor is used to get an AssetIndex object from an asset's index.json file
	 * @param json A {@link JSONObject} ready for parsing
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

package test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;

import org.junit.Test;

import com.ezrebclan.asset.assetTypes.BigTextAsset;
import com.ezrebclan.asset.assetTypes.SmallTextAsset;

public class TextAssetTests {

	File smallTest = new File("smallTest.txt");
	File bigTest = new File("bigTest.txt");
	File smallAsset = new File("smallTest.asset");
	File bigAsset = new File("bigTest.asset");
	
	@Test
	public void packageSmallAsset() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(smallTest));
		SmallTextAsset sta = new SmallTextAsset("small Test", br.readLine());
		br.close();
		assertNotNull("SmallTextAsset1 == Null", sta);
	}
	
	@Test
	public void exportSmallAsset() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(smallTest));
		SmallTextAsset sta = new SmallTextAsset("small Test", br.readLine());
		br.close();
		FileOutputStream fos = new FileOutputStream(smallAsset);
		sta.save(fos);
		fos.close();
		assertTrue("FileNotExist", smallAsset.exists()&&smallAsset.isFile());
	}
	
	@Test
	public void loadSmallAsset() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(smallTest));
		SmallTextAsset sta = new SmallTextAsset("small Test", br.readLine());
		br.close();
		FileOutputStream fos = new FileOutputStream(smallAsset);
		sta.save(fos);
		fos.close();
		FileInputStream fis = new FileInputStream(smallAsset);
		SmallTextAsset sta2 = new SmallTextAsset(fis);
		assertNotNull("Sta2 == Null", sta2);
		assertNotNull("Data == Null", sta2.data);
	}
	

	@Test
	public void packageBigAsset() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(bigTest));
		BigTextAsset sta = new BigTextAsset("big Test", new String[] {br.readLine(), br.readLine(), br.readLine(), br.readLine()});
		br.close();
		assertNotNull("BigTextAsset1 == Null", sta);
	}
	
	@Test
	public void exportBigAsset() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(bigTest));
		BigTextAsset sta = new BigTextAsset("big Test", new String[] {br.readLine(), br.readLine(), br.readLine()});
		br.close();
		FileOutputStream fos = new FileOutputStream(bigAsset);
		sta.save(fos);
		fos.close();
		assertTrue("FileNotExist", bigAsset.exists()&&bigAsset.isFile());
	}
	
	@Test
	public void loadBigAsset() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(bigTest));
		BigTextAsset sta = new BigTextAsset("big Test", new String[] {br.readLine(), br.readLine(), br.readLine()});
		br.close();
		FileOutputStream fos = new FileOutputStream(bigAsset);
		sta.save(fos);
		fos.close();
		FileInputStream fis = new FileInputStream(bigAsset);
		BigTextAsset sta2 = new BigTextAsset(fis);
		assertNotNull("Sta2 == Null", sta2);
		assertNotNull("Data == Null", sta2.data);
	}

}

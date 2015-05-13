package com.ezrebclan.asset;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;

import javax.imageio.ImageIO;

import com.ezrebclan.asset.assetTypes.BigTextAsset;
import com.ezrebclan.asset.assetTypes.ImageAsset;
import com.ezrebclan.asset.assetTypes.SmallTextAsset;
import com.ezrebclan.asset.gui.WrongArgsHelp;

public class Main {

	/**
	 * This being the main method, it should run the things, right? Well, actually, it's a little more, eh, simple.<br>
	 * The main method actually checks the length of the args array, if it's &gt; 0, then it passes on the args to {@link #chooseMethod(String[])}, otherwise, it runs {@link #displayHelp()}.
	 * @param args The arguments passed through either the console or a shortcut.
	 */
	public static void main(String[] args) {
//		packageAssets(new String[] {"G:/asset test/**"});
		if(args.length > 0) {
			chooseMethod(args);
		} else {
			displayHelp();
		}
	}
	
	/**
	 * A pretty simple function, simply runs the {@link WrongArgsHelp#main(String[]) main} method in the {@link WrongArgsHelp} class.
	 */
	public static void displayHelp() {
		WrongArgsHelp.main(null);
	}
	
	/**
	 * This function utilizes a switch/case statement on args[0] to decide which method to call. It also chops the first string out of args before passing it to the next method.
	 * @param args the args passed from {@link #main(String[])}
	 */
	public static void chooseMethod(String[] args) {
		String[] argsPassed = new String[args.length-1];
		for (int i = 0; i < argsPassed.length; i++) {
			argsPassed[i] = args[i+1];
		}
		switch (args[0]) {
		case "help":
			displayHelp();
			break;
		case "package":
			packageAssets(argsPassed);
			break;
		default:
			displayHelp();
			break;
		}
	}
	
	/**
	 * This method iterates through the passed arguments and runs each one through {@link #packageAsset(String)}.
	 * @param args args passed from {@link #chooseMethod(String[])}
	 */
	public static void packageAssets(String[] args) {
		for (String string : args) {
			try {
				packageAsset(string);
			} catch (IOException e) {
				System.err.println("Error while packaging asset");
				System.err.println("Info: ");
				System.err.println("\t Original File Name: "+string);
				System.err.println("\t Error: "+e.getMessage());
				System.err.println("Stack Trace: ");
				System.err.println("");
				System.err.println("");
				System.err.println("");
				e.printStackTrace();
				System.err.println("");
				System.err.println("");
				System.err.println("");
				System.err.println("Continuing package operation...");
			}
		}
	}
	/**
	 * Figures out which operation to use, then uses that operation to run {@link #packageFile(Path, File)} however many times as needed.<br><br>
	 * This method looks at every argument given to it as a path to a file or folder. If the path ends with a /** and the path leads to a folder, it packages every file in every folder inside of the given folder. If a path ends with an /* and the path leads to a folder, then it packages all files within that folder. If the path does not end with a /* or /** and the path leads to a file, then it packages that file.
	 * @param path the path to the file or folder
	 * @throws IOException just as in {@link #packageFile(Path, File)}, simply sending the exceptions up the ladder.
	 */
	private static void packageAsset(String path) throws IOException {
		//Include all subdirectories
		if(path.endsWith("/**")) {
			final Path cutPath = new File(path.substring(0, path.indexOf("/**"))).toPath();
			final Path exportPath = new File(path.substring(0, path.indexOf("/**")).substring(0, path.substring(0, path.indexOf("/**")).lastIndexOf("/"))+"/packagedAssets").toPath();
			Files.createDirectories(exportPath, (FileAttribute<?>[]) new FileAttribute<?>[0]);
			System.out.println("Created output directory at "+exportPath.toString());
			FileVisitor<Path> fv = new FileVisitor<Path>() {
				
				@Override
				public FileVisitResult visitFileFailed(Path file, IOException exc)
						throws IOException {
					return FileVisitResult.CONTINUE;
					//throw new IOException("File @"+file.toString()+" visit failed");
				}
				
				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
						throws IOException {
					File newFile2 = new File(file.toFile().getAbsolutePath().substring(0, file.toFile().getAbsolutePath().length()-4)+".asset");
					File newFile = exportPath.resolve(cutPath.relativize(newFile2.toPath())).toFile();
					newFile.createNewFile();
					System.out.println("Packaging... "+newFile);
					packageFile(file, newFile);
					return FileVisitResult.CONTINUE;
				}
				
				@Override
				public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
						throws IOException {
					Path newDir = exportPath.resolve(cutPath.relativize(dir));
					newDir.toFile().mkdirs();
					return FileVisitResult.CONTINUE;
				}
				
				@Override
				public FileVisitResult postVisitDirectory(Path dir, IOException exc)
						throws IOException {
					return FileVisitResult.CONTINUE;
				}
			};
			Files.walkFileTree(cutPath, fv);
			Desktop.getDesktop().open(exportPath.toFile());
		//All files in directory
		} else if(path.endsWith("/*")) {
			final Path cutPath = new File(path.substring(0, path.indexOf("/*"))).toPath();
			final Path exportPath = new File(path.substring(0, path.indexOf("/*")).substring(0, path.substring(0, path.indexOf("/*")).lastIndexOf("/"))+"/packagedAssets").toPath();
			Files.createDirectories(exportPath, (FileAttribute<?>[]) new FileAttribute<?>[0]);
			System.out.println("Created output directory at "+exportPath.toString());
			DirectoryStream<Path> dsp = null;
			dsp = Files.newDirectoryStream(cutPath);
			for (Path path2 : dsp) {
				if(!path2.toString().startsWith("..")) {
					File newFile2 = new File(path2.toFile().getAbsolutePath().substring(0, path2.toFile().getAbsolutePath().length()-4)+".asset");
					File newFile = exportPath.resolve(cutPath.relativize(newFile2.toPath())).toFile();
					newFile.createNewFile();
					System.out.println("Packaging... "+newFile);
					packageFile(path2, newFile);
				}
			}
			dsp.close();
			Desktop.getDesktop().open(exportPath.toFile());
		//Single file
		} else {
			final Path cutPath = new File(path).toPath();
			final Path exportPath = new File(path.substring(0, path.substring(0, path.lastIndexOf("/")).lastIndexOf("/"))+"/packagedAssets").toPath();
			Files.createDirectories(exportPath, (FileAttribute<?>[]) new FileAttribute<?>[0]);
			System.out.println("Created output directory at "+exportPath.toString());
			File newFile = new File(exportPath.toFile(), path.substring(path.lastIndexOf("/"), path.lastIndexOf("."))+".asset");
			System.out.println("Packaging... "+newFile);
			packageFile(cutPath, newFile);
			Desktop.getDesktop().open(exportPath.toFile());
		}
	}
	
	/**
	 * Takes a single file, packages it, and saves the packaged asset.
	 * @param oldFile the original file that is being packaged
	 * @param newAsset the location of the packaged asset
	 * @return whether or not an error occured
	 * @throws IOException sends any {@link IOException IOExceptions} up the ladder for easier code reading due to less try/catchs everywhere.
	 */
	public static boolean packageFile(Path oldFile, File newAsset) throws IOException {
		if(oldFile.toFile().getName().endsWith(".png")) {
			try {
				new ImageAsset(oldFile.toFile().getName().substring(0, oldFile.toFile().getName().indexOf(".png")), ImageIO.read(oldFile.toFile())).save(new FileOutputStream(newAsset));
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		} else if(oldFile.toFile().getName().endsWith(".txt")) {
			File txt = oldFile.toFile();
			BufferedReader txtReader = new BufferedReader(new FileReader(txt));
			String[] lines = new String[0];
			while(txtReader.ready()) {
				String line = txtReader.readLine();
				String[] lines2 = new String[lines.length + 1];
				System.arraycopy(lines, 0, lines2, 0, lines.length);
				lines2[lines.length] = line;
				lines = lines2;
			}
			if(lines.length == 1) {
				try {
					new SmallTextAsset(oldFile.toFile().getName().substring(0, oldFile.toFile().getName().indexOf(".txt")), lines[0]).save(new FileOutputStream(newAsset));
				} catch (Exception e) {
					e.printStackTrace();
					txtReader.close();
					return false;
				}
			} else {
				try {
					new BigTextAsset(oldFile.toFile().getName().substring(0, oldFile.toFile().getName().indexOf(".txt")), lines).save(new FileOutputStream(newAsset));
				} catch (Exception e) {
					e.printStackTrace();
					txtReader.close();
					return false;
				}
			}
			txtReader.close();
		}
		return true;
	}

}

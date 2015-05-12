package com.ezrebclan.asset;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
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
import com.ezrebclan.asset.help.NoArgs;

public class Main {

	/**
	 * This being the main method, it should run the things, right? Well, actually, it's a little more, eh, simple.<br>
	 * The main method actually checks the length of the args array, if it's > 0, then it passes on the args to {@link #chooseMethod(String[])}, otherwise, it runs {@link #displayHelp()}.
	 * @param args The arguments passed through either the console or a shortcut.
	 */
	public static void main(String[] args) {
		packageAssets(new String[] {"G:/asset test/**"});
		if(args.length > 0) {
			chooseMethod(args);
		} else {
			displayHelp();
		}
	}
	
	/**
	 * A pretty simple function, simply runs the {@link NoArgs#main(String[]) main} method in the {@link NoArgs} class.
	 */
	public static void displayHelp() {
		NoArgs.main(null);
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
	 * This method looks at every argument given to it as a path to a file or folder. If the path ends with a /** and the path leads to a folder, it packages every file in every folder inside of the given folder. If a path ends with an /* and the path leads to a folder, then it packages all files within that folder. If the path does not end with a /* or /** and the path leads to a file, then it packages that file.
	 * @param args args passed from {@link #chooseMethod(String[])}
	 */
	public static void packageAssets(String[] args) {
		for (String string : args) {
			packageAsset(string);
		}
	}
	private static void packageAsset(String path) {
		if(path.endsWith("/**")) {
			final Path cutPath = new File(path.substring(0, path.indexOf("/**"))).toPath();
			final Path exportPath = new File(path.substring(0, path.indexOf("/**")).substring(0, path.substring(0, path.indexOf("/**")).lastIndexOf("/"))+"/packagedAssets").toPath();
			try {
				Files.createDirectories(exportPath, (FileAttribute<?>[]) new FileAttribute<?>[0]);
				System.out.println("Created output directory at "+exportPath.toString());
			} catch (IOException e1) {
				e1.printStackTrace();
				System.exit(-1);
			}
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
					if(file.toFile().getName().endsWith(".png")) {
						try {
							new ImageAsset(file.toFile().getName().substring(0, file.toFile().getName().indexOf(".png")), ImageIO.read(file.toFile())).save(new FileOutputStream(newFile));
						} catch (Exception e) {
							e.printStackTrace();
							return FileVisitResult.TERMINATE;
						}
					} else if(file.toFile().getName().endsWith(".txt")) {
						File txt = file.toFile();
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
								new SmallTextAsset(file.toFile().getName().substring(0, file.toFile().getName().indexOf(".txt")), lines[0]).save(new FileOutputStream(newFile));
							} catch (Exception e) {
								e.printStackTrace();
								txtReader.close();
								return FileVisitResult.TERMINATE;
							}
						} else {
							try {
								new BigTextAsset(file.toFile().getName().substring(0, file.toFile().getName().indexOf(".txt")), lines).save(new FileOutputStream(newFile));
							} catch (Exception e) {
								e.printStackTrace();
								txtReader.close();
								return FileVisitResult.TERMINATE;
							}
						}
						txtReader.close();
					}
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
			try {
				Files.walkFileTree(cutPath, fv);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				Desktop.getDesktop().open(exportPath.toFile());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if(path.endsWith("/*")) {
			
		} else {
			
		}
	}

}

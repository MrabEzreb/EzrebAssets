package com.ezrebclan.asset.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.text.Position.Bias;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

public class EzrebAssetsUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7116267346233549981L;
	private JPanel contentPane;
	private DefaultTreeModel fileTreeModel = new DefaultTreeModel(ftmtn.ftmtn);
	/**
	 * Launch the application.
	 * @param args should be null
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EzrebAssetsUI frame = new EzrebAssetsUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EzrebAssetsUI() {
		setResizable(false);
		try {
			UIManager.setLookAndFeel(WindowsLookAndFeel.class.getName());
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			System.exit(-1);
		} catch (InstantiationException e1) {
			e1.printStackTrace();
			System.exit(-1);
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
			System.exit(-1);
		} catch (UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
			System.exit(-1);
		}
		setPreferredSize(new Dimension(500, 300));
		setSize(new Dimension(500, 350));
		setBounds(new Rectangle(100, 100, 500, 500));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setSize(new Dimension(500, 300));
		contentPane.setBounds(new Rectangle(0, 0, 500, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane mainPane = new JTabbedPane(JTabbedPane.TOP);
		mainPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		contentPane.add(mainPane, BorderLayout.CENTER);
		
		JPanel infoPane = new JPanel();
		FlowLayout flowLayout = (FlowLayout) infoPane.getLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		mainPane.addTab("Info", null, infoPane, null);
		
		JLabel lblEzrebassetsIsMy = new JLabel("EzrebAssets is my java api, made for managing assets.");
		infoPane.add(lblEzrebassetsIsMy);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setPreferredSize(new Dimension(150, 0));
		infoPane.add(horizontalStrut);
		
		JLabel lblAnAssetIs = new JLabel("An asset is anything that gets loaded by your application.");
		infoPane.add(lblAnAssetIs);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1.setPreferredSize(new Dimension(100, 0));
		horizontalStrut_1.setMinimumSize(new Dimension(100, 0));
		infoPane.add(horizontalStrut_1);
		
		JLabel lblSomeExamplesAre = new JLabel("Some examples are Images, Models, Text, Object Data, Sounds, and Scripts.");
		infoPane.add(lblSomeExamplesAre);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		horizontalStrut_2.setPreferredSize(new Dimension(50, 0));
		infoPane.add(horizontalStrut_2);
		
		JLabel lblUsingMyApi = new JLabel("Using my api, you can easily save, load, and access these assets.");
		infoPane.add(lblUsingMyApi);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		horizontalStrut_3.setPreferredSize(new Dimension(100, 0));
		infoPane.add(horizontalStrut_3);
		
		JLabel lblHoweverMyApi = new JLabel("However, my api requires that assets be stored in a special format, as a .asset file.");
		infoPane.add(lblHoweverMyApi);
		
		JLabel lblButItIs = new JLabel("But, it is pretty easy to make an asset file.");
		infoPane.add(lblButItIs);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		horizontalStrut_4.setPreferredSize(new Dimension(200, 0));
		infoPane.add(horizontalStrut_4);
		
		JLabel lblJustHeadOn = new JLabel("<html><body>Head over to the <span style=\"color: purple;\">Package</span> tab to check it out!</body></html>");
		infoPane.add(lblJustHeadOn);
		
		JLabel lblYouCanAlso = new JLabel("You can also check out the javadoc, which is also packaged with this developer release.");
		infoPane.add(lblYouCanAlso);
		
		JLabel lblYouCanEven = new JLabel("Check out the other tabs of this window to learn a bit more about EzrebAssets.");
		infoPane.add(lblYouCanEven);
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		horizontalStrut_6.setPreferredSize(new Dimension(50, 0));
		infoPane.add(horizontalStrut_6);
		
		JLabel lblBtwThanksFor = new JLabel("<html>Btw, thanks for using EzrebAssets. If you encounter any bugs, report them <span style=\"color: blue;\">here</span>.</html>");
		infoPane.add(lblBtwThanksFor);
		
		JLabel lblHeyWhyIs = new JLabel("Hey! Why is that text blue? The text in this window is perfectly normal when it is black,");
		infoPane.add(lblHeyWhyIs);
		
		JLabel lblButWhenIt = new JLabel(" but when it is a different color, it can mean different things.");
		infoPane.add(lblButWhenIt);
		
		JLabel lblForExampleThat = new JLabel("For example, that blue text will open the github issues page in your default browser!");
		infoPane.add(lblForExampleThat);
		
		JLabel lblThatsWhatBlue = new JLabel("That's what blue text does. It opens up a web page.");
		infoPane.add(lblThatsWhatBlue);
		
		JLabel lblRedTextOpens = new JLabel("Red text opens up a window INSIDE of this window.");
		infoPane.add(lblRedTextOpens);
		
		JLabel lblGreenTextOpens = new JLabel("Green text opens a file or folder in the default program that opens that file.");
		infoPane.add(lblGreenTextOpens);
		
		JLabel lblAndFinallyYellow = new JLabel("Finally, purple text will direct your attention to something in this window.");
		infoPane.add(lblAndFinallyYellow);
		
		JLayeredPane realeasesPane = new JLayeredPane();
		realeasesPane.setPreferredSize(new Dimension(450, 415));
		mainPane.addTab("Releases", null, realeasesPane, "How EzrebAssets is released.");
		realeasesPane.setLayout(null);
		
		JScrollPane releasesScroll = new JScrollPane();
		releasesScroll.setBounds(9, 5, 450, 415);
		releasesScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		releasesScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		releasesScroll.setPreferredSize(new Dimension(450, 415));
		realeasesPane.add(releasesScroll);
		
		JEditorPane releasesHTML = new JEditorPane();
		releasesHTML.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		releasesHTML.setFont(new Font("Monospaced", Font.PLAIN, 11));
		releasesHTML.setEditable(false);
		releasesHTML.setPreferredSize(new Dimension(450, 190));
		releasesHTML.setContentType("text/html");
		releasesHTML.setText("<html>\r\n    <body>\r\n        EzrebAssets has a slightly strange way of getting released.<br>\r\n        A release is actually a zip file, rather than a jar. Inside of the zip file you will find a few folders. Those folders have stuff inside of them.<br>\r\n        <span style=\"color: red;\">File Tree</span><br>\r\n        <br><br>\r\n        Now, what are all of these different files and folders? Let's take a more in-depth look at all of this stuff.<br>\r\n        Firstly, we have the 3 main folders. Packager, Release, and Development. These three folders are, for all intents and purposes, completely seperate.<br>\r\n        <span style=\"color: purple;\">Packager</span> contains everything that you need to package assets into special .asset files, which are what EzrebAssets loads.<br>\r\n        <span style=\"color: purple;\">Release</span> contains everything that you need to include as dependencies when you release your application.<br>\r\n        <span style=\"color: purple;\">Development</span> contains everything that you need to include as a library during development of your application.<br>\r\n        <br>\r\n        Now, what is inside of all of these folders? Well, if you open up Packager, you will see a few different files.<br>\r\n        The first one is EzrebAssetsPackager.jar. This is the java portion of the asset packager.<br>\r\n        The second file is packassets.bat. This is a batch file that, when added to your computer's path, will allow you to package any asset, anywhere, any time.<br>\r\n        The third is a folder called libs. Inside of this folder are two files, EzrebAssets.jar, the actual EzrebAssets api, and EzrebExplorer.jar, an api that I made a while back that let's the user select a file.<br><br>\r\n        The release folder has two files. EzrebAssets.jar and JSON_Java8.jar. Just throw these into your classpath when you run your application's jar and you're good to go!<br><br>\r\n        The development folder has 2 files and a folder. EzrebAssets.jar, JSON_Java8.jar, and the javadoc folder. These are what you need when developing your application, as they contain the source files along with the compiled classes.<br><br>\r\n        So, I think that that is probobly it! Thanks for reading! :D\r\n    </body>\r\n</html>");
		releasesScroll.setViewportView(releasesHTML);
		releasesHTML.setCaretPosition(0);
		
		JInternalFrame fileTreeWindow = new JInternalFrame("File Tree");
		try {
			fileTreeWindow.setFrameIcon(new ImageIcon(ImageIO.read(EzrebAssetsUI.class.getClassLoader().getResourceAsStream("filetree.png"))));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		fileTreeWindow.setIconifiable(true);
		fileTreeWindow.setClosable(true);
		fileTreeWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		fileTreeWindow.setMaximizable(true);
		fileTreeWindow.setResizable(true);
		fileTreeWindow.setMaximumSize(new Dimension(400, 400));
		fileTreeWindow.setMinimumSize(new Dimension(100, 100));
		fileTreeWindow.setBounds(75, 10, 200, 150);
		realeasesPane.setLayer(fileTreeWindow, 1);
		realeasesPane.add(fileTreeWindow);
		
		JScrollPane fileTreePane = new JScrollPane();
		fileTreeWindow.getContentPane().add(fileTreePane, BorderLayout.CENTER);
		
		JTree fileTree = new JTree();
		fileTree.setModel(fileTreeModel);
		fileTree.setLargeModel(true);
		fileTree.setRowHeight(16);
		fileTreePane.setViewportView(fileTree);
		
		JPanel packagePane = new JPanel();
		packagePane.setPreferredSize(new Dimension(450, 415));
		mainPane.addTab("Package", null, packagePane, null);
		
		JScrollPane packageScroll = new JScrollPane();
		packageScroll.setPreferredSize(new Dimension(450, 415));
		packageScroll.setBounds(new Rectangle(9, 5, 450, 415));
		packageScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		packageScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		packagePane.add(packageScroll);
		
		JEditorPane packageHTML = new JEditorPane();
		packageHTML.setFont(new Font("Monospaced", Font.PLAIN, 11));
		packageHTML.setContentType("text/html");
		packageHTML.setPreferredSize(new Dimension(450, 415));
		packageHTML.setEditable(false);
		packageHTML.setText("<html>\r\n    <body>\r\n        So, you downloaded EzrebAssets, and you got into it, and you're just like, \"What the heck is going on???!?!?!!\" Don't worry, that's the objective of this api. :)<br><br>\r\n        But seriously, how do you work this thing? Well, the first step is to package your assets into something that I call an asset file. Wow, so original, isn't it? The file extension is .asset, again, very original.<br><br>\r\n        \"But Ezreb,\"<br>\r\n        \"No, please call me Mrab.\"<br>\r\n        \"Alright, Mrab, how do I obtain one of these 'asset' files? What even is an asset?\"<br>\r\n        I hear you! I hear you! You may be very confused! Head over to the <span style=\"color: purple;\">Assets</span> tab to learn about assets, but stay here if you just want to know how to get them!<br><br>\r\n        So, the first step is to know what files you need! In the downloaded zip file, go into the Packager folder, then run package.bat. This will then open a nifty gui that will let you package either a single file, a full folder, or a folder and all of it's subfolders! As I said, it is pretty nifty!<br><br>\r\n        So what are you waiting for? Head on over and package some assets!\r\n    </body>\r\n</html>");
		packageHTML.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		packageScroll.setViewportView(packageHTML);
		packageHTML.setCaretPosition(0);
		
		JPanel assetsPane = new JPanel();
		mainPane.addTab("Assets", null, assetsPane, null);
		
		JScrollPane assetsScroll = new JScrollPane();
		assetsScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		assetsScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		assetsScroll.setPreferredSize(new Dimension(450, 415));
		assetsScroll.setBounds(new Rectangle(9, 5, 450, 415));
		assetsPane.add(assetsScroll);
		
		JEditorPane assetsHTML = new JEditorPane();
		assetsHTML.setFont(new Font("Monospaced", Font.PLAIN, 11));
		assetsHTML.setContentType("text/html");
		assetsHTML.setPreferredSize(new Dimension(450, 415));
		assetsHTML.setText("<html>\r\n    <body>\r\n        Now, what exactly is an asset? I mean, only the first half of the api's name is narsiccistic, right? Yes, you are correct.<br><br>\r\n        An asset is anything that gets loaded by your code. Some common examples are Images, Models, Text, Object Data, Audio, and Scripts.<br>\r\n        Let's say that we have an image. We will call it image.png. <h3>Hello image.png!</h3> <h6>hello mrab!</h6> <h3>Now, image.png, how do you like being a png file?</h3> <h6>i HATE it. nobody knows anything about me! what if i am multiple sprites stiched together in a spritesheet! they will have no idea which sprites are which!</h6> <h3>Ah, I see. So, you need to have some information that can come with you, yes?</h3> <h6>yes! that would be amazing!</h6><br>\r\n        That is what an asset file is. It has an asset (say image.png) and it has another file, called index.json. An asset file has the .asset extension, but if you change it to have a .zip extension, you can see inside of it!\r\n        If you want to learn how to get these asset files, head over to the <span style=\"color: purple;\">Package</span> tab!\r\n    </body>\r\n</html>");
		assetsHTML.setEditable(false);
		assetsHTML.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		assetsScroll.setViewportView(assetsHTML);
		assetsHTML.setCaretPosition(0);

		fileTreeWindow.addInternalFrameListener(new InternalFrameAdapter() {
			private int oldHeight = fileTreeWindow.getHeight();
			private int oldWidth = fileTreeWindow.getWidth();
			@Override
			public void internalFrameIconified(InternalFrameEvent e) {
				oldHeight = fileTreeWindow.getHeight();
				oldWidth = fileTreeWindow.getWidth();
				fileTreeWindow.setSize(75, 25);
				fileTreeWindow.setMaximizable(false);
				fileTreeWindow.setResizable(false);
			}
			@Override
			public void internalFrameDeiconified(InternalFrameEvent e) {
				fileTreeWindow.setSize(oldWidth, oldHeight);
				fileTreeWindow.setMaximizable(true);
				fileTreeWindow.setResizable(true);
			}
		});
		releasesHTML.addMouseListener(new MouseTestAdapter() {
			Rectangle fileTreeHB = new Rectangle(3, 64, 50, 12);
			Rectangle packagerHitbox = new Rectangle(3,198,52,10);
			Rectangle releaseHitbox = new Rectangle(3,236,41,10);
			Rectangle developmentHitbox = new Rectangle(3,274,74,10);
			@Override
			public void mouseReleased(MouseEvent e) {
				if(fileTreeHB.contains(e.getPoint())) {
					fileTreeWindow.setVisible(true);
				} else if(packagerHitbox.contains(e.getPoint())) {
					fileTreeWindow.setVisible(true);
					collapseAll(fileTree);
					select(fileTree, "Packager");
				} else if(releaseHitbox.contains(e.getPoint())) {
					fileTreeWindow.setVisible(true);
					collapseAll(fileTree);
					select(fileTree, "Release");
				} else if(developmentHitbox.contains(e.getPoint())) {
					fileTreeWindow.setVisible(true);
					collapseAll(fileTree);
					select(fileTree, "Development");
				}
			}
		});
		releasesHTML.addMouseMotionListener(new MouseMotionAdapter() {
			Rectangle fileTreeHB = new Rectangle(3, 64, 50, 12);
			Rectangle packagerHitbox = new Rectangle(3,198,52,10);
			Rectangle releaseHitbox = new Rectangle(3,236,41,10);
			Rectangle developmentHitbox = new Rectangle(3,274,74,10);
			@Override
			public void mouseMoved(MouseEvent e) {
				Cursor newCursor = Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR);
				if(fileTreeHB.contains(e.getPoint())) {
					newCursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
				} else if(packagerHitbox.contains(e.getPoint())) {
					newCursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
				} else if(releaseHitbox.contains(e.getPoint())) {
					newCursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
				} else if(developmentHitbox.contains(e.getPoint())) {
					newCursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
				}
				EzrebAssetsUI.this.setCursor(newCursor);
			}
		});
		infoPane.addMouseMotionListener(new MouseMotionAdapter() {
			Rectangle gitIssuesHitbox = new Rectangle(371,178,21,8);
			@Override
			public void mouseMoved(MouseEvent e) {
				Cursor newCursor = null;
				if(gitIssuesHitbox.contains(e.getPoint())) {
					newCursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
				} else {
					newCursor = Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR);
				}
				EzrebAssetsUI.this.setCursor(newCursor);
			}
		});
		infoPane.addMouseListener(new MouseTestAdapter() {
			Rectangle gitIssuesHitbox = new Rectangle(371,178,21,8);
			Rectangle packageTabHitbox = new Rectangle(90,122,39,7);
			@Override
			public void mouseReleased(MouseEvent e) {
				if(gitIssuesHitbox.contains(e.getPoint())) {
					URI gitIssues;
					try {
						gitIssues = new URI("https://github.com/MrabEzreb/EzrebAssets/issues");
						Desktop.getDesktop().browse(gitIssues);
					} catch (URISyntaxException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else if(packageTabHitbox.contains(e.getPoint())) {
					mainPane.setSelectedIndex(2);
				}
			}
		});
		packageHTML.addMouseListener(new MouseTestAdapter() {
			Rectangle assetTabHB = new Rectangle(3,255,26,9);
			@Override
			public void mouseReleased(MouseEvent e) {
				if(assetTabHB.contains(e.getPoint())) {
					mainPane.setSelectedIndex(3);
				}
			}
		});
		assetsHTML.addMouseListener(new MouseTestAdapter() {
			Rectangle packageTabHitbox = new Rectangle(337,438,47,10);
			@Override
			public void mouseReleased(MouseEvent e) {
				if(packageTabHitbox.contains(e.getPoint())) {
					mainPane.setSelectedIndex(2);
				}
			}
		});
	}
	
	private void collapseAll(JTree fileTree) {
		for(int i = 1; i < fileTree.getRowCount(); i++) {
			fileTree.expandRow(i);
		}
		for (int i = fileTree.getRowCount(); i > 0; i--) {
			fileTree.collapseRow(i);
		}
	}
	@SuppressWarnings("unused")
	private void expand(JTree fileTree, String name) {
		fileTree.setExpandsSelectedPaths(true);
		fileTree.expandPath(fileTree.getNextMatch(name, 0, Bias.Forward));
	}
	private void select(JTree fileTree, String name) {
		fileTree.setExpandsSelectedPaths(true);
		fileTree.setSelectionPath(fileTree.getNextMatch(name, 0, Bias.Forward));
	}
}
class ftmtn {

	public static DefaultMutableTreeNode ftmtn = new DefaultMutableTreeNode("Zip File") {
		/**
		 * 
		 */
		private static final long serialVersionUID = 4717847929270970001L;

		{
			DefaultMutableTreeNode node_1;
			DefaultMutableTreeNode node_2;
			node_1 = new DefaultMutableTreeNode("Packager");
				node_1.add(new DefaultMutableTreeNode("EzrebAssetsPackager.jar"));
				node_1.add(new DefaultMutableTreeNode("packassets.bat"));
				node_2 = new DefaultMutableTreeNode("libs");
					node_2.add(new DefaultMutableTreeNode("EzrebAssets.jar"));
					node_2.add(new DefaultMutableTreeNode("EzrebExplorer.jar"));
				node_1.add(node_2);
			add(node_1);
			node_1 = new DefaultMutableTreeNode("Release Jar");
				node_1.add(new DefaultMutableTreeNode("EzrebAssets.jar"));
				node_1.add(new DefaultMutableTreeNode("JSON_Java8.jar"));
			add(node_1);
			node_1 = new DefaultMutableTreeNode("Development Jars");
				node_1.add(new DefaultMutableTreeNode("EzrebAssets.jar"));
				node_1.add(new DefaultMutableTreeNode("JSON_Java8.jar"));
				node_2 = new DefaultMutableTreeNode("doc");
					node_2.add(new DefaultMutableTreeNode("(javadoc)"));
				node_1.add(node_2);
			add(node_1);
		}
	};
}

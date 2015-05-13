package com.ezrebclan.asset.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import com.ezreb.filebrowser.FileBrowser;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

public class EzrebAssetsUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7116267346233549981L;
	private JPanel contentPane;
	private File openedFile = null;
	private JLabel lblNull;
	private JTextField textField;
	private JTextField textField_1;

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
		setSize(new Dimension(500, 300));
		setBounds(new Rectangle(100, 100, 500, 250));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setSize(new Dimension(500, 300));
		contentPane.setBounds(new Rectangle(0, 0, 500, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane mainPane = new JTabbedPane(JTabbedPane.LEFT);
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
		
		JLabel lblJustHeadOn = new JLabel("Just head on over to the Package tab to make some assets!");
		infoPane.add(lblJustHeadOn);
		
		JLabel lblYouCanAlso = new JLabel("You can also check out the javadoc, by clicking on its respective tab.");
		infoPane.add(lblYouCanAlso);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		horizontalStrut_5.setPreferredSize(new Dimension(75, 0));
		infoPane.add(horizontalStrut_5);
		
		JLabel lblYouCanEven = new JLabel("You can even check out the command line arguments, over in the CMD tab!");
		infoPane.add(lblYouCanEven);
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		horizontalStrut_6.setPreferredSize(new Dimension(50, 0));
		infoPane.add(horizontalStrut_6);
		
		JLabel lblBtwThanksFor = new JLabel("<html>Btw, thanks for using EzrebAssets. If you encounter any bugs, report them <u style=\"color: blue;\">here</u>.</html>");
		lblBtwThanksFor.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				Cursor newCursor = null;
				if(e.getX() > 365) {
					newCursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
				} else {
					newCursor = Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR);
				}
				EzrebAssetsUI.this.setCursor(newCursor);
			}
		});
		lblBtwThanksFor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.getX() > 365) {
					URI gitIssues;
					try {
						gitIssues = new URI("https://github.com/MrabEzreb/EzrebAssets/issues");
						Desktop.getDesktop().browse(gitIssues);
					} catch (URISyntaxException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		infoPane.add(lblBtwThanksFor);
		
		JPanel packagePane = new JPanel();
		packagePane.getLayout();
		mainPane.addTab("Package Assets", null, packagePane, null);
		
		JButton btnOpenFileBrowser = new JButton("Choose File To Package");
		btnOpenFileBrowser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileBrowser fb = new FileBrowser();
				File opened = fb.run();
				openedFile = opened;
				switch(openedFile.getName().substring(openedFile.getName().lastIndexOf(".")+1)) {
				case ".png":
					lblNull.setText("Image");
					break;
				case ".txt":
					lblNull.setText("Text");
					break;
				default:
					lblNull.setText("Unrecognized");
					break;
				}
			}
		});
		
		Component horizontalStrut_8 = Box.createHorizontalStrut(20);
		horizontalStrut_8.setPreferredSize(new Dimension(100, 0));
		packagePane.add(horizontalStrut_8);
		packagePane.add(btnOpenFileBrowser);
		
		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		horizontalStrut_7.setPreferredSize(new Dimension(100, 0));
		packagePane.add(horizontalStrut_7);
		
		Component horizontalStrut_10 = Box.createHorizontalStrut(20);
		horizontalStrut_10.setPreferredSize(new Dimension(100, 0));
		packagePane.add(horizontalStrut_10);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBorder(null);
		splitPane.setDividerSize(0);
		packagePane.add(splitPane);
		
		JLabel lblFileType = new JLabel("File Type: ");
		splitPane.setLeftComponent(lblFileType);
		
		lblNull = new JLabel("      ");
		splitPane.setRightComponent(lblNull);
		
		Component horizontalStrut_9 = Box.createHorizontalStrut(20);
		horizontalStrut_9.setPreferredSize(new Dimension(100, 0));
		packagePane.add(horizontalStrut_9);
		
		Component horizontalStrut_12 = Box.createHorizontalStrut(20);
		horizontalStrut_12.setPreferredSize(new Dimension(100, 0));
		packagePane.add(horizontalStrut_12);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setBorder(null);
		splitPane_1.setDividerSize(0);
		packagePane.add(splitPane_1);
		
		JLabel lblNewLabel = new JLabel("Asset Name: ");
		splitPane_1.setLeftComponent(lblNewLabel);
		
		textField = new JTextField();
		splitPane_1.setRightComponent(textField);
		textField.setColumns(10);
		
		Component horizontalStrut_11 = Box.createHorizontalStrut(20);
		horizontalStrut_11.setPreferredSize(new Dimension(100, 0));
		packagePane.add(horizontalStrut_11);
		
		Component horizontalStrut_14 = Box.createHorizontalStrut(20);
		horizontalStrut_14.setPreferredSize(new Dimension(25, 0));
		packagePane.add(horizontalStrut_14);
		
		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_2.setDividerSize(0);
		splitPane_2.setBorder(null);
		packagePane.add(splitPane_2);
		
		JLabel lbladvancedUseJson = new JLabel("(Advanced, use JSON) Asset Details: ");
		splitPane_2.setLeftComponent(lbladvancedUseJson);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		splitPane_2.setRightComponent(textField_1);
		
		Component horizontalStrut_13 = Box.createHorizontalStrut(20);
		horizontalStrut_13.setPreferredSize(new Dimension(25, 0));
		packagePane.add(horizontalStrut_13);
		
		JButton btnChooseFileLocation = new JButton("Choose File Location And Package");
		btnChooseFileLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileBrowser fb = new FileBrowser();
				fb.run();
				if(lblNull.getText().equals("Image")) {
					
				}
			}
		});
		packagePane.add(btnChooseFileLocation);
	}

	public JLabel getLblNull() {
		return lblNull;
	}
}

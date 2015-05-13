package com.ezrebclan.asset.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

public class WrongArgsHelp extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8588425470803699093L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 * @param args should be null
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WrongArgsHelp frame = new WrongArgsHelp();
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
	public WrongArgsHelp() {
		try {
			UIManager.setLookAndFeel(WindowsLookAndFeel.class.toString());
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
		setTitle("EzrebAssets Help");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 190);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		JPanel helpPanel = contentPane;
		JLabel line1 = new JLabel("EzrebAssets is an API, but it is also an application!");
		helpPanel.add(line1);
		line1.setLocation(25, 0);
		line1.setSize(350, 50);
		line1.setVisible(true);
		JLabel line2 = new JLabel("Simply add in whatever arguments, and you will be good to go!");
		helpPanel.add(line2);
		line2.setLocation(25, 25);
		line2.setSize(350, 50);
		JLabel line3 = new JLabel("Check out the javadoc for more information.");
		helpPanel.add(line3);
		line3.setLocation(25, 50);
		line3.setSize(350, 50);
		JLabel line4 = new JLabel("Have a great day!");
		helpPanel.add(line4);
		line4.setLocation(25, 75);
		line4.setSize(350, 50);
		JLabel line5 = new JLabel(":D");
		helpPanel.add(line5);
		line5.setLocation(25, 100);
		line5.setSize(350, 50);
	}

}

package com.ezrebclan.asset.help;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class NoArgs extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8588425470803699093L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NoArgs frame = new NoArgs();
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
	public NoArgs() {
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

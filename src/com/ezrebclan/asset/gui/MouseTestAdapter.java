package com.ezrebclan.asset.gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseTestAdapter extends MouseAdapter {

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.isShiftDown()) {
			System.out.println(e.getPoint());
		}
	}
}

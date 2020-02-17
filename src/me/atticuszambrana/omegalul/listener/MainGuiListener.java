package me.atticuszambrana.omegalul.listener;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import me.atticuszambrana.omegalul.common.util.F;

public class MainGuiListener implements WindowListener {

	@Override
	public void windowActivated(WindowEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent event) {
		// TODO Auto-generated method stub
		System.out.println(F.main("Window", "Closing..."));
	}

	@Override
	public void windowDeactivated(WindowEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent event) {
		// TODO Auto-generated method stub
		
	}

}

package dotterlib.classes.gui;

import java.awt.event.ActionListener;

public class DotterMenuItem {
	private ActionListener listener;
	private String title;
	
	public DotterMenuItem(String title, ActionListener listener) {
		this.title = title;
		this.listener = listener;
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public ActionListener getListener(){
		return this.listener;
	}
}

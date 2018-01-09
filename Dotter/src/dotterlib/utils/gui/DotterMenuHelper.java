package dotterlib.utils.gui;

import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import dotterlib.classes.gui.DotterMenuItem;

public class DotterMenuHelper {
	private ArrayList<DotterMenuItem> items = new ArrayList<>();
	
	public void addItems(DotterMenuItem... items){
		for(DotterMenuItem item : items){
			this.items.add(item);
		}
	}
	
	public void flush(JMenu menu){
		for(DotterMenuItem item : items){
			JMenuItem jItem = new JMenuItem(item.getTitle());
			jItem.addActionListener(item.getListener());
			
			menu.add(jItem);
		}
	}
	
	public void clear(){
		this.items.clear();
	}
}

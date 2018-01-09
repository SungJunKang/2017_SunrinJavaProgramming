package dotterlib.utils.gui;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class GraphicsTools {
	public void addComp(JFrame frame, JComponent... components){
		for(JComponent comp : components){
			frame.add(comp);
		}
	}
}

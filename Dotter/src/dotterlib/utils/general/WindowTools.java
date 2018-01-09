package dotterlib.utils.general;

import javax.swing.JFrame;

import dotterlib.classes.general.Vector2;

public class WindowTools {
	public static void initialSetup(JFrame frame, String title, Vector2 size, Boolean resizeable){
		frame.setSize(size.x, size.y);
		frame.setTitle(title);
		frame.setResizable(resizeable);
	}
}

package app.main;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import app.windows.file.NewWindow;
import app.windows.file.OpenWindow;
import app.windows.file.SaveWindow;
import app.windows.window.BrushColorWindow;
import app.windows.window.BrushSizeWindow;
import app.windows.window.ImageQualityWindow;
import app.windows.window.ImageResizeWindow;
import dotterlib.classes.gui.DotterMenuItem;
import dotterlib.utils.gui.DotterMenuHelper;

public class DotterMenuBar extends JMenuBar {
	public DotterMenuBar() {	
		JMenu fileMenu = new JMenu("File");
		JMenu settingsMenu = new JMenu("Window");
		
		// fileMenu Items
		DotterMenuItem newFile = new DotterMenuItem("New", new NewWindow(false));
		DotterMenuItem openFile = new DotterMenuItem("Open", new OpenWindow(false));
		DotterMenuItem saveFile = new DotterMenuItem("Save", new SaveWindow(false));
		
		// settingsMenu Items
		DotterMenuItem brushSizeWindow = new DotterMenuItem("Brush Size", new BrushSizeWindow(false));
		DotterMenuItem brushColorWindow = new DotterMenuItem("Brush Color", new BrushColorWindow(false));
		DotterMenuItem imageResizeWindow = new DotterMenuItem("Image Resize", new ImageResizeWindow(false));
		DotterMenuItem imageQualityWindow = new DotterMenuItem("Set Quality", new ImageQualityWindow(false));
		
		DotterMenuHelper helper = new DotterMenuHelper();
		helper.addItems(newFile, openFile, saveFile);
		helper.flush(fileMenu);
		helper.clear();
		
		helper.addItems(brushSizeWindow, brushColorWindow, imageResizeWindow, imageQualityWindow);
		helper.flush(settingsMenu);
		
		add(fileMenu);
		add(settingsMenu);
	}
}
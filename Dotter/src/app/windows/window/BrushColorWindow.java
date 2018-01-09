package app.windows.window;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;

import app.main.AppProperties;
import app.main.DotterApp;
import dotterlib.utils.general.WindowTools;

public class BrushColorWindow extends JFrame implements ActionListener{
	JColorChooser picker;
	
	public BrushColorWindow(Boolean set) {
		if(set){
			WindowTools.initialSetup(this, "Brush Color Options", AppProperties.COLOR_WINDOW_SIZE, false);
			setLayout(new FlowLayout());
			
			picker = new JColorChooser(DotterApp.board.currBrushColor);
			
			JButton apply = new JButton("Apply");
			apply.addActionListener(new ColorApplyListener());
			
			add(picker);
			add(apply);
			
			setVisible(true);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new BrushColorWindow(true);
	}
	
	class ColorApplyListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			DotterApp.board.currBrushColor = picker.getColor();
		}
	}

}

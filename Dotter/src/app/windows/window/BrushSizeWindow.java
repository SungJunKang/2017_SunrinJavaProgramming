package app.windows.window;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSlider;

import app.main.AppProperties;
import app.main.DotterApp;
import dotterlib.utils.general.WindowTools;

public class BrushSizeWindow extends JFrame implements ActionListener{
	JSlider brushSizeSlider;
	
	public BrushSizeWindow(Boolean set) {
		if(set){
			WindowTools.initialSetup(this, "Brush Size Options", AppProperties.SIZE_WINDOW_SIZE, false);
			
			setLayout(new FlowLayout());
			
			brushSizeSlider = new JSlider(0, 100, DotterApp.board.currBrushSize);
			
			brushSizeSlider.setPreferredSize(new Dimension(300, 50));
	
			brushSizeSlider.setMinorTickSpacing(5);
			brushSizeSlider.setMajorTickSpacing(10);
			
			brushSizeSlider.setPaintTicks(true);
			brushSizeSlider.setPaintLabels(true);
			
			JButton apply = new JButton("Apply");
			apply.addActionListener(new SizeApplyListener());
			
			add(brushSizeSlider);
			add(apply);
			
			setVisible(true);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new BrushSizeWindow(true);
	}
	
	class SizeApplyListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			DotterApp.board.currBrushSize = brushSizeSlider.getValue();
		}
	}
}
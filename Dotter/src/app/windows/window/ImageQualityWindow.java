package app.windows.window;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import app.main.AppProperties;
import app.main.DotterApp;
import dotterlib.classes.gui.JNumberField;
import dotterlib.utils.general.WindowTools;
import dotterlib.utils.image.ImageTools;

public class ImageQualityWindow extends JFrame implements ActionListener {
	public JNumberField widthField, heightField;
	
	public ImageQualityWindow(Boolean set) {
		if(set){
			WindowTools.initialSetup(this, "Image Resize", AppProperties.NEW_WINDOW_SIZE, false);
			setLayout(new FlowLayout());
			
			JLabel widthTitle = new JLabel("Width");
			add(widthTitle);
			
			widthField = new JNumberField();
			widthField.setPreferredSize(new Dimension(120, 20));
			add(widthField);
			
			JLabel heightTitle = new JLabel("Height");
			add(heightTitle);
			
			heightField = new JNumberField();
			heightField.setPreferredSize(new Dimension(120, 20));
			add(heightField);
			
			JButton apply = new JButton("Open");
			apply.addActionListener(new QualityListener());
			add(apply);
			
			setVisible(true);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		new ImageQualityWindow(true);
	}
	
	class QualityListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			int prevWidth = DotterApp.board.targetImage.getWidth();
			int prevHeight = DotterApp.board.targetImage.getHeight();
			
			int width = widthField.getValue();
			int height = heightField.getValue();
			
			DotterApp.board.newTarget(ImageTools.resize(ImageTools.resize(DotterApp.board.targetImage, width, height), prevWidth, prevHeight));
		}
	}
}

package app.windows.file;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import app.main.AppProperties;
import app.main.DotterApp;
import dotterlib.classes.gui.JNumberField;
import dotterlib.utils.general.WindowTools;

public class NewWindow extends JFrame implements ActionListener {
	public JNumberField widthField, heightField;
	
	public NewWindow(Boolean set) {
		if(set){
			WindowTools.initialSetup(this, "New Image", AppProperties.NEW_WINDOW_SIZE, false);
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
			apply.addActionListener(new NewApplyListener());
			add(apply);
			
			setVisible(true);
			}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new NewWindow(true);
	}
	
	NewWindow getOuter(){
		return this;
	}
	
	class NewApplyListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int width = widthField.getValue();
			int height = heightField.getValue();
			
			DotterApp.board.newTarget(new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB));
			DotterApp.board.fill(Color.WHITE);
			
			getOuter().dispose();
		}
	}
}

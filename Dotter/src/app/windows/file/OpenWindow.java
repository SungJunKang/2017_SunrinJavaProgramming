package app.windows.file;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import app.main.AppProperties;
import app.main.DotterApp;
import dotterlib.io.Image;
import dotterlib.utils.general.WindowTools;

public class OpenWindow extends JFrame implements ActionListener {
	public OpenWindow(Boolean set) {
		if(set){
			WindowTools.initialSetup(this, "Open", AppProperties.FINDER_WINDOW_SIZE, false);
			
			JFileChooser finder = new JFileChooser();
			finder.addActionListener(new OpenApplyListener());
			
			add(finder);
			
			setVisible(true);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new OpenWindow(true);
	}
	
	OpenWindow getOuter(){
		return this;
	}
	
	class OpenApplyListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals(JFileChooser.APPROVE_SELECTION)){
				JFileChooser fileChooser = (JFileChooser) e.getSource();
				String path = fileChooser.getSelectedFile().getPath();

				try {
					DotterApp.board.newTarget(Image.importImage(path));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				getOuter().dispose();
				
			} else if (e.getActionCommand().equals(JFileChooser.CANCEL_SELECTION)){
				getOuter().dispose();
			}
		}
	}
}

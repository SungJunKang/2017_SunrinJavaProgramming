package app.windows.file;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import app.main.AppProperties;
import app.main.DotterApp;
import dotterlib.utils.general.WindowTools;

public class SaveWindow extends JFrame implements ActionListener {
	public SaveWindow(Boolean set) {
		if(set){
			WindowTools.initialSetup(this, "Save", AppProperties.FINDER_WINDOW_SIZE, false);
	
			JFileChooser finder = new JFileChooser();
			
			finder.setApproveButtonText("Save");
			finder.addActionListener(new SaveButtonListener());
			
			add(finder);
			
			setVisible(true);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new SaveWindow(true);
	}
	
	SaveWindow getOuter(){
		return this;
	}
	
	class SaveButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals(JFileChooser.APPROVE_SELECTION)){
				JFileChooser fileChooser = (JFileChooser) e.getSource();
				String path = fileChooser.getSelectedFile().getPath();

				DotterApp.board.save(path);
				getOuter().dispose();
				
			} else if (e.getActionCommand().equals(JFileChooser.CANCEL_SELECTION)){
				getOuter().dispose();
			}
		}
	}
}

package app.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import dotterlib.utils.general.WindowTools;

public class DotterApp extends JFrame {
	private JMenuBar menuBar;
	public static PaintBoard board;

	public DotterApp(){
		WindowTools.initialSetup(this, AppProperties.APP_TITLE, AppProperties.APP_WINDOW_SIZE, true);
		setLayout(new BorderLayout());
		
		this.menuBar = new DotterMenuBar();
		add(this.menuBar, BorderLayout.NORTH);
		
		DotterApp.board = new PaintBoard(this, new BufferedImage(AppProperties.START_IMAGE_SIZE.x, AppProperties.START_IMAGE_SIZE.y, BufferedImage.TYPE_INT_ARGB));
		DotterApp.board.fill(Color.WHITE);
		
		add(DotterApp.board, BorderLayout.CENTER);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new DotterApp();
	}
}

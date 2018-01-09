package app.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import dotterlib.classes.general.Vector2;
import dotterlib.io.Image;

public class PaintBoard extends JPanel {
	private JFrame window;
	
	public BufferedImage targetImage;
	private Graphics2D g2d;
	
	private Vector2 centerPosition;
	
	public int currBrushSize = 10;
	public Color currBrushColor = Color.BLACK;
	
	public PaintBoard(JFrame window, BufferedImage image) {
		this.window = window;
		
		this.targetImage = image;
		this.g2d = this.targetImage.createGraphics();
		
		addMouseMotionListener(new MotionHandler());
	}
	
	public void newTarget(BufferedImage image){
		this.targetImage = image;
		this.g2d = this.targetImage.createGraphics();
		
		repaint();
	}
	
	void draw(Vector2 drawPos){
		this.g2d.setColor(this.currBrushColor);
		
		Vector2 absolutePos = new Vector2(drawPos.x - this.centerPosition.x, drawPos.y - this.centerPosition.y);
		
		Vector2 centerPos = new Vector2(absolutePos.x - this.currBrushSize / 2, absolutePos.y - this.currBrushSize / 2);
		this.g2d.fillOval(centerPos.x, centerPos.y, this.currBrushSize, this.currBrushSize);
		
		repaint();
	}
	
	public void save(String savePath){
		try {
			Image.exportImage(this.targetImage, savePath, "png");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void fill(Color fillColor){
		this.g2d.setColor(fillColor);
		this.g2d.fillRect(0, 0, this.targetImage.getWidth(), this.targetImage.getHeight());
		
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		this.centerPosition = new Vector2(this.getWidth() / 2 - this.targetImage.getWidth() / 2, this.getHeight() / 2 - this.targetImage.getHeight() / 2);
		
		g.drawImage(this.targetImage, centerPosition.x, centerPosition.y, null);
	}
	
	class MotionHandler extends MouseMotionAdapter{
		@Override
		public void mouseDragged(MouseEvent e) {
			super.mouseDragged(e);
			
			Vector2 drawPos = new Vector2(e.getX(), e.getY());
			draw(drawPos);
		}
	}
}

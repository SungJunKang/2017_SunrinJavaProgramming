package dotterlib.classes.general;

import java.awt.Color;

public class Brush {
	public int brushSize;
	public Color brushColor;
	public Vector2 drawPos;
	
	public Brush(int brushSize, Color brushColor, Vector2 drawPos) {
		this.brushSize = brushSize;
		this.brushColor = brushColor;
		this.drawPos = drawPos;
	}
}

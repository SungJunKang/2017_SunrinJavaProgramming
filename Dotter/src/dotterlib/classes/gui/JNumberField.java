package dotterlib.classes.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class JNumberField extends JTextField implements KeyListener {
	public JNumberField() {
		addKeyListener(this);
	}
	
	public int getValue(){
		int value = Integer.parseInt(this.getText());
		return value;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		char typed = e.getKeyChar();
		if(!Character.isDigit(typed)){
			e.consume();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
}

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JLabel;

public class GameBoard extends JLabel {
	
	private static final long serialVersionUID = 1L;
	private Plateau p;
	private Color color1, color2;
	private int step;
	
	public GameBoard(Plateau p) {
		super();
		this.p = p;
		this.color1 = Color.red;
		this.color2 = Color.black;
		this.step = 10;
		
		setLayout(null);
		setPreferredSize(new Dimension(p.getWidth()*step, p.getHeight()*step));
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (int x = 0; x < p.getWidth(); x++) {
			for (int y = 0; y < p.getHeight(); y++) {
				g.setColor(p.get(x, y) == 0 ? color1 : color2);
				g.fillRect(x*step, y*step, step, step);
			}
		}
	}
}

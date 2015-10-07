import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainWindow extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel panneau;
	private JLabel gameBoard;
	
	/** Constructeur */
	public MainWindow(Plateau p) {
		super();
		
		this.gameBoard = new GameBoard(p);
		
		panneau = new JPanel();
		panneau.setLayout(new BorderLayout());
		panneau.add(gameBoard, BorderLayout.CENTER);
		setContentPane(panneau);
		
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	
	public static void main(String[] args) {
		
		final Plateau p = new Plateau(50, 50);
		final JFrame fen = new MainWindow(p);
		fen.setVisible(true);
		
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(10);
						p.fight();
						fen.repaint();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		t.start();
	}
}

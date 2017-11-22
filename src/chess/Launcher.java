package chess;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Launcher extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Chess chess;

	// constructor
	public Launcher() {
		super("Chess");
		chess = new Chess();

		setLayout(new BorderLayout());
		setSize(chess.getLength(), chess.getWidth());
		setLocationRelativeTo(null);
		add(chess, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);

	}

	public static void main(String args[]) {
		Launcher launcher = new Launcher();
	}

}
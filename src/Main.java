import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public final class Main {

	private static JFrame frame;
	public static int frameHeight = 1000;
	public static int frameWidth = 1400;
	private static Game game;
	
	public static void main(String[] args) {
		openFrame();
		game = new Game(frame);
		game.start();
		
	}

	public static void openFrame() {
		frame = new JFrame("Flappy Bird");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(frameWidth, frameHeight);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				// leer
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					game.setIsSpacePressed(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					game.setIsSpacePressed(true);
				}
			}
		});
		frame.repaint();
	}
}

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

import javax.swing.JPanel;

public class DrawPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private Color backColor = new Color(175, 215, 255); // Hellblau
	private Color tubeColor = new Color(87, 209, 69); // Gruen
	private Color birdColor = new Color(255, 255, 0); // Gelb
	private Color tubeFancy = new Color(0, 153, 0); // duneklgruen
	private Color groundColor = new Color(202, 209, 103);
	private Color cloudColor = Color.WHITE;
	private Color birdEyeColor = Color.BLACK;
	private Color beakColor = new Color(255, 153, 51); // Orange // 255 153 51
	private Tube[] tubes;
	private Bird bird;
	int[] x = new int[3];
	int[] y = new int[3];
	
	public DrawPanel(Tube[] tubes, Bird bird) {
		this.tubes = tubes;
		this.bird = bird;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		super.paintComponent(g2d);
		setBackground(backColor);
		g2d.setColor(cloudColor);
		g2d.fillOval(300, 200, 350, 150);
		g2d.fillOval(320, 180, 180, 180);
		g2d.fillOval(420, 180, 180, 180);
		g2d.setColor(groundColor);
		g2d.fillRect(0, 800, getWidth(), 200);
		g2d.setColor(tubeColor);
		for(Tube t : tubes) {
			g2d.setColor(tubeColor);
			g2d.fillRect(t.getX(), t.getYtop(), t.getWidth(), t.getHeightTop());
			g2d.fillRect(t.getX(), t.getYbottom(), t.getWidth(), t.getHeightBottom());
			g2d.setColor(tubeFancy);
			g2d.fillRect(t.getX(), t.getHeightTop() - 50, t.getWidth(), 50);
			g2d.fillRect(t.getX(), t.getYbottom(), t.getWidth(), 50);
		}
		g2d.setColor(birdColor);
		g2d.fillOval(bird.xPos, bird.yPos, bird.diameter, bird.diameter);
		g2d.setColor(birdEyeColor);
		g2d.fillOval(bird.xPos + 25, bird.yPos + 10, 6, 6);
		g2d.setColor(beakColor);
		x[0] = bird.xPos + 38;
		x[1] = bird.xPos + 38;
		x[2] = bird.xPos + 58;
		y[0] = bird.yPos + 5;
		y[1] = bird.yPos + 25;
		y[2] = bird.yPos + 15;
		int n = 3;
		Polygon p = new Polygon(x, y, n);
		g2d.fillPolygon(p);
		//g2d.drawLine(100, 90, 400, 90);
	}
}

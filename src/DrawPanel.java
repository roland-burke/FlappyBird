import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

import javax.swing.JPanel;

public class DrawPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private final Color backColor = new Color(175, 215, 255); // lightblue
	private final Color tubeColor = new Color(87, 209, 69); // green
	private final Color birdColor = new Color(255, 255, 0); // yelloq
	private final Color tubeFancy = new Color(0, 153, 0); // darkgreen
	private final Color groundColor = new Color(202, 209, 103);
	private final Color cloudColor = Color.WHITE;
	private final Color birdEyeColor = Color.BLACK;
	private final Color beakColor = new Color(255, 153, 51); // Orange // 255 153 51
	private Tube[] tubes;
	private Bird bird;
	int[] xBeak = new int[3];
	int[] yBeak = new int[3];
	
	public DrawPanel(Tube[] tubes, Bird bird) {
		this.tubes = tubes;
		this.bird = bird;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		super.paintComponent(g2d);
		
		drawBackground(g2d);
		drawTubes(g2d);
		drawBird(g2d);
	}
	
	private void drawBackground(Graphics2D g2d) {
		setBackground(backColor);
		g2d.setColor(cloudColor);
		g2d.fillOval(300, 200, 350, 150);
		g2d.fillOval(320, 180, 180, 180);
		g2d.fillOval(420, 180, 180, 180);
		g2d.setColor(groundColor);
	}
	
	private void drawTubes(Graphics2D g2d) {
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
	}
	
	private void drawBird(Graphics2D g2d) {
		g2d.setColor(birdColor);
		g2d.fillOval(bird.getxPos(), bird.getyPos(), bird.getDiameter(), bird.getDiameter());
		g2d.setColor(birdEyeColor);
		g2d.fillOval(bird.getxPos() + 25, bird.getyPos() + 10, 6, 6);
		drawBeak(g2d);
	}
	
	private void drawBeak(Graphics2D g2d) {
		g2d.setColor(beakColor);
		xBeak[0] = bird.getxPos() + 34; // 38
		xBeak[1] = bird.getxPos() + 38; // 38
		xBeak[2] = bird.getxPos() + 56; // 58
		yBeak[0] = bird.getyPos() + 5; // 5
		yBeak[1] = bird.getyPos() + 27; // 25
		yBeak[2] = bird.getyPos() + 15; // 15
		int n = 3;
		Polygon p = new Polygon(xBeak, yBeak, n);
		g2d.fillPolygon(p);
		//g2d.drawLine(100, 90, 400, 90);
	}
	
}

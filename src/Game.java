
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JFrame;

public class Game {
	private boolean isSpacePressed;
	private JFrame frame;
	private DrawPanel dp;
	private boolean running;
	private Tube[] tubes = new Tube[100];
	private Bird bird;
	private int topTubeHeight;
	private int horizontalTubeGap = 330; // 330
	private double gravity = 0.1;
	private int yPosBird = 50;
	private int birdSpeed = 2;
	private int tubeWidth = 130; // 130
	
	public Game(JFrame frame) {
		this.frame = frame;
		init();
	}

	private void init() {
		bird = new Bird(birdSpeed, gravity, yPosBird);
		int x = 1000;
		for(int i = 0; i < 100; ++i) {
			topTubeHeight = ThreadLocalRandom.current().nextInt(80, 470);
			tubes[i] = new Tube(x, topTubeHeight, tubeWidth);
			x += horizontalTubeGap + tubeWidth;
		}
		dp = new DrawPanel(tubes, bird);
		frame.add(dp);
	}
	
	private void run() {
		while(running) {
			tick();
			render();
			try {
				Thread.sleep(5); //8
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void start() {
		running = true;
		run();

	}
	
	private void tick() {
		for(Tube t : tubes) {
			t.move();
		}
		bird.fall();
		if(CollisionDetection.bottomCollision(bird.getyPos())) {
			bird.reset();
		}
		if(CollisionDetection.topCollision(bird.getyPos())) {
			bird.setEnableJump(false);
		} else {
			bird.setEnableJump(true);
		}
		if(isSpacePressed) {
			bird.jump();
			isSpacePressed = false;
		}
//		if (isRPressed) {
//			reset();
//			isRPressed = false;
//		}
	}
	
	private void render() {
		frame.repaint();
	}
	
	public void setIsSpacePressed(boolean isPressed) {
		isSpacePressed = isPressed;
	}
}

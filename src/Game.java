
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JFrame;

public class Game {
	private boolean isSpacePressed;
	private JFrame frame;
	private DrawPanel dp;
	private boolean running;
	private Tube[] tubeBuffer = new Tube[100];
	private Bird bird;
	private int topTubeHeight;
	private int horizontalTubeGap = 330; // 330
	private double gravity = 0.1;
	private int yPosBird = 50;
	private int birdSpeed = 2;
	
	public Game(JFrame frame) {
		this.frame = frame;
		init();
	}

	private void init() {
		bird = new Bird(birdSpeed, gravity, yPosBird);
		int x = 1000;
		for(int i = 0; i < 100; ++i) {
			topTubeHeight = ThreadLocalRandom.current().nextInt(80, 470);
			tubeBuffer[i] = new Tube(x, topTubeHeight);
			x += horizontalTubeGap + Tube.width;
		}
		dp = new DrawPanel(tubeBuffer, bird);
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
		for(Tube t : tubeBuffer) {
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

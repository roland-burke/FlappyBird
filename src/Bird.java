
public class Bird {
	private final int xPos = 200;
	private int yPos;
	private int defaultYPos;
	private int diameter = 40;
	private double speed;
	private double defaultSpeed;
	private double gravity;
	private boolean enableJump;
	
	public Bird(double speed, double gravity, int yPos) {
		this.gravity = gravity;
		this.yPos = this.defaultYPos = yPos;
		this.speed = this.defaultSpeed = speed;
	}
	
	public void jump() {
		if(enableJump) {
			speed = -2.8 * defaultSpeed;
		}
	}
	
	public void fall() {
		speed += gravity;
		yPos += speed;
	}
	
	public void reset() {
		yPos = defaultYPos;
		speed = defaultSpeed;
	}
	
	public void setEnableJump(boolean bool) {
		enableJump = bool;
	}

	public int getyPos() {
		return yPos;
	}

	public int getDiameter() {
		return diameter;
	}

	public int getxPos() {
		return xPos;
	}
}

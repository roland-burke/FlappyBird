
public class Bird {
	public final int xPos = 200;
	public int yPos;
	public int defaultYPos;
	public int diameter = 40;
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
	
	public void fall(boolean down) {
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
}

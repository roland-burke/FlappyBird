
public class Tube {
	private final int width;
	private final int yPosTop = 0;
	private final int verticalGap = 230;
	private int xPos;
	private int heightTop;
	private int speed = 3;
	
	public Tube(int xPos, int height, int width) {
		this.xPos = xPos;
		this.heightTop = height;
		this.width = width;
	}
	
	public void move() {
		this.xPos -= speed;
	}
	
	public int getX() {
		return this.xPos;
	}
	
	public int getYtop() {
		return this.yPosTop;
	}
	
	public int getYbottom() {
		return heightTop + verticalGap;
	}
	
	public int getHeightTop() {
		return this.heightTop;
	}
	
	public int getHeightBottom() {
		return 800 - getYbottom();
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public void stop() {
		speed = 0;
	}
}

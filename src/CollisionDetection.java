
public final class CollisionDetection {
	private static final int bottomBorder = 800;
	
	public static boolean bottomCollision(int yPos) {
		if(yPos + 40 >= bottomBorder) {
			return true;
		}
		return false;
	}
	
	public static boolean topCollision(int yPos) {
		if(yPos <= 70) {
			return true;
		}
		return false;
	}
}

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball extends Rectangle {

	Random random;
	int xVelocity; // Horizontal Velocity of the ball
	int yVelocity; // vertical velocity of the ball
	int initialSpeed = 2; // initial speed
	private int speedIncrease = 1; // Speed increase after each hit

	// sets inital position of ball and speed
	Ball(int x, int y, int width, int height) {
		super(x, y, width, height);
		random = new Random();
		// inital horizontal direction randomly
		int randomXDirection = random.nextInt(2);
		if (randomXDirection == 0)
			randomXDirection--;
		setXDirection(randomXDirection * initialSpeed);
		// sets the inital vertical direction of the ball
		int randomYDirection = random.nextInt(2);
		if (randomYDirection == 0)
			randomYDirection--;
		setYDirection(randomYDirection * initialSpeed);
	}

	// sets the horizontal direction of the ball
	public void setXDirection(int randomXDirection) {
		xVelocity = randomXDirection;
	}

	// sets the vertical direction of the ball
	public void setYDirection(int randomYDirection) {
		yVelocity = randomYDirection;
	}

	// moves the ball based on its velocity
	public void move() {
		x += xVelocity;
		y += yVelocity;
	}

	// draws the ball on the screen
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(x, y, height, width);
	}

	// making the game more challenging by having the speed increase
	public void increaseSpeed() {
		if (xVelocity > 0) {
			xVelocity += speedIncrease;
		} else {
			xVelocity -= speedIncrease;
		}

		if (yVelocity > 0) {
			yVelocity += speedIncrease;
		} else {
			yVelocity -= speedIncrease;
		}
	}
}

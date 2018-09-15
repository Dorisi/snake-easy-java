import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class SNode {
	int x, y, width = 15, height = 15;
	Rectangle rect = new Rectangle(x, y, width, height);
	Color color;

	public SNode(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}

	public void draw(Graphics2D g2d) {
		g2d.setColor(color);
		g2d.drawRect(x, y, width, height);
	}

	public Rectangle getRect() {
		rect.x = x;
		rect.y = y;
		return rect;
	}
}

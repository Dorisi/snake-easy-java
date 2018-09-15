import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class Snake {

	public List<SNode> nodes = new ArrayList<SNode>();
	SnakeRun interFace;
	int dir = SnakeRun.R;
	
	public Snake(SnakeRun interFace) {
		this.interFace = interFace;
		nodes.add(new SNode(20 + 150, 40 + 150, Color.black));
		addNode();
	}
	
	public boolean hit(SNode node) {
		for (int i = 0; i < nodes.size(); i++) {
			if (nodes.get(i).getRect().intersects(node.getRect())) {
				addNode();
				return true;
			}
		}
		return false;
	}
	
	public void draw(Graphics2D g2d) {
		for (int i = 0; i < nodes.size(); i++) {
			nodes.get(i).draw(g2d);
		}
		move();
	}
	
	public void move() {
		nodes.remove((nodes.size() - 1));
		addNode();
	}
	
	public synchronized void addNode() {
		SNode nodeTempNode = nodes.get(0);
		switch (dir) {
		case SnakeRun.L:
			if (nodeTempNode.x <= 20) {
				nodeTempNode = new SNode(20 + 15 * 50, nodeTempNode.y, Color.black);
			}
			nodes.add(0, new SNode(nodeTempNode.x - nodeTempNode.width, nodeTempNode.y, Color.black));
			break;
		case SnakeRun.R:
			if (nodeTempNode.x >= 20 + 15 * 50 - nodeTempNode.width) {
				nodeTempNode = new SNode(20 - nodeTempNode.width, nodeTempNode.y, Color.black);
			}
			nodes.add(0, new SNode(nodeTempNode.x + nodeTempNode.width, nodeTempNode.y, Color.black));
			break;
		case SnakeRun.U:
			if (nodeTempNode.y <= 40) {
				nodeTempNode = new SNode(nodeTempNode.x, 40 + 15 * 35, Color.black);
			}
			nodes.add(0, new SNode(nodeTempNode.x, nodeTempNode.y - nodeTempNode.height, Color.black));
			break;
		case SnakeRun.D:
			if (nodeTempNode.y >= 40 + 15 * 35 - nodeTempNode.height) {
				nodeTempNode = new SNode(nodeTempNode.x, 40 - nodeTempNode.height, Color.black);
			}
			nodes.add(0, new SNode(nodeTempNode.x, nodeTempNode.y + nodeTempNode.height, Color.black));
			break;
		}
	}

	
}

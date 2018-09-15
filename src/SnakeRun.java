import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;


@SuppressWarnings("serial")
public class SnakeRun extends JFrame{
	public static final int WIDTH = 800, HEIGHT = 600, SLEEPTIME = 20, L = 1, R = 2, U = 3, D = 4;
	BufferedImage offersetImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_3BYTE_BGR);;
	Rectangle rect = new Rectangle(20, 40, 15 * 50, 15 * 35);
	Snake snake;
	SNode node;

	public SnakeRun() {
		snake = new Snake(this);
		createNode();
		this.setBounds(100, 100, WIDTH, HEIGHT);
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {
				switch (arg0.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					snake.dir = L;
					break;
				case KeyEvent.VK_RIGHT:
					snake.dir = R;
					break;
				case KeyEvent.VK_UP:
					snake.dir = U;
					break;
				case KeyEvent.VK_DOWN:
					snake.dir = D;
				}
			}
		});
		this.setTitle("Snake Game 1.0 ");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		new Thread(new ThreadUpadte()).start();
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) offersetImage.getGraphics();
		g2d.setColor(Color.white);
		g2d.fillRect(0, 0, WIDTH, HEIGHT);
		g2d.setColor(Color.black);
		g2d.drawRect(rect.x, rect.y, rect.width, rect.height);
		if (snake.hit(node)) {
			createNode();
		}
		snake.draw(g2d);
		node.draw(g2d);
		g.drawImage(offersetImage, 0, 0, null);
	}

	class ThreadUpadte implements Runnable {
		public void run() {
			while (true) {
				try {
					Thread.sleep(SLEEPTIME);
					repaint();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void createNode() {
		int x = (int) (Math.random() * 650) + 50, y = (int) (Math.random() * 500) + 50;
		node = new SNode(x, y, Color.blue);
	}
}

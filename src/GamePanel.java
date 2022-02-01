import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Rocketship rocket = new Rocketship(225, 450, 50, 50);
	Timer frameDraw;
	Timer alienSpawn;
	ObjectManager objectmanager = new ObjectManager(rocket);
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;

	void loadImage(String imageFile) {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}
	}

	Font titleFont = new Font("Arial", Font.PLAIN, 48);
	Font startFont = new Font("Arial", Font.PLAIN, 20);
	Font instructionFont = new Font("Arial", Font.PLAIN, 20);

	GamePanel() {

		Timer frameDraw = new Timer(1000 / 60, this);

		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
		if (needImage) {
			loadImage("space.png");
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}
	}

	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;

	int currentState = MENU;

	void updateMenuState() {
	}

	void updateGameState() {
		objectmanager.update();
		if (rocket.isActive == false) {
			currentState = END;
		}
	}

	void updateEndState() {
	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 20, 100);

		g.setFont(startFont);
		g.drawString("Press enter to start", 150, 250);

		g.setFont(instructionFont);
		g.drawString("Press space for instructions", 100, 400);

	}

	void drawGameState(Graphics g) {
		if (gotImage) {
			g.drawImage(image, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
		}
		objectmanager.draw(g);

	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("GAME OVER", 100, 100);

	}

	void startGame() {

		alienSpawn = new Timer(1000, objectmanager);
		alienSpawn.start();

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		if (currentState == MENU) {
			updateMenuState();
		}
		if (currentState == GAME) {
			updateGameState();
		}
		if (currentState == END) {
			updateEndState();
		}
		System.out.println("action");
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == MENU) {
				currentState = GAME;
				startGame();
			}
			
			if (currentState == END) {
				rocket.isActive = true;
				
			} 
			if (currentState == END) {
				currentState = MENU;
				alienSpawn.stop();
			}
			else {
				currentState++;
			}
		}

		if (arg0.getKeyCode() == KeyEvent.VK_UP) {
			if (rocket.y > HEIGHT) {
				rocket.up();
			}
		}
		if (arg0.getKeyCode() == KeyEvent.VK_DOWN) {
			if (rocket.y < 470) {
				rocket.down();
			}
		}
		if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (rocket.x < 450) {
				rocket.right();
			}
		}
		if (arg0.getKeyCode() == KeyEvent.VK_LEFT) {
			if (rocket.x > WIDTH) {
				rocket.left();
			}
		}

		if (arg0.getKeyCode() == KeyEvent.VK_SPACE) {
			if (currentState == GAME) {

				objectmanager.addProjectile(rocket.getProjectile());

			}
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}

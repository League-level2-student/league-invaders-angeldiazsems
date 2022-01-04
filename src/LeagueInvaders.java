import javax.swing.JFrame;

public class LeagueInvaders {

	public static void main(String[] agrs) {

		LeagueInvaders invader = new LeagueInvaders();
		invader.setup();
	}

	JFrame frame;
	GamePanel panel;

	LeagueInvaders() {
		this.frame = new JFrame();
		this.panel = new GamePanel();
	}

	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;

	void setup() {
		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(panel);
	}

}

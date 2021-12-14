import javax.swing.JFrame;

public class LeagueInvaders {
	
public static void main(String [] agrs) {
	
	LeagueInvaders invader = new LeagueInvaders();
	invader.setup();
}
JFrame frame = new JFrame();
GamePanel game = new GamePanel();


LeagueInvaders(){
	JFrame frame = new JFrame();
	GamePanel game = new GamePanel();
}


	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	
	
void setup() {
	frame.add(game);
	frame.setVisible(true);
	frame.setSize(WIDTH,HEIGHT);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
}


}

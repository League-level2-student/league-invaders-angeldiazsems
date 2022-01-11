import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {

	int rocket;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	Random random = new Random();

	ObjectManager(int Rocketship) {
		this.rocket = Rocketship;
	}

	void addProjectile(Projectile projectile) {

		projectiles.add(projectile);
	}

	void addAlien() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));

	}

	void update() {
		for (Alien a : aliens) {
			update();
			if (a.y > LeagueInvaders.HEIGHT) {
				a.isActive = false;
			}

		}

		for (Projectile p : projectiles) {
			update();
			if (p.y < 0) {
				p.isActive = false;
			}
		}

	}

	void draw(Graphics g) {

		
	}

}

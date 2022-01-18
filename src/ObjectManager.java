import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {

	Rocketship rocket;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	Random random = new Random();

	ObjectManager(Rocketship rocket) {
		this.rocket = rocket;
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
		rocket.draw(g);
		for(Alien a : aliens) {
			draw(g);
		}
		for(Projectile p : projectiles)
		draw(g);
	}


void PurgeObjects() {
	
	for(int i = 0; i < aliens.size(); i++) {
		Alien a = aliens.get(i);
		if(a.isActive == false) {
			aliens.remove(i);
		}
	}
	for(int i = 0; i < projectiles.size(); i++) {
		Projectile p = projectiles.get(i);
		if(p.isActive == false) {
		projectiles.remove(i);
		}
	}

}
}






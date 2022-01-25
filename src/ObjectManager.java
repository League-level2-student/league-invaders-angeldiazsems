import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener{

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
				a.update();
				if (a.y > LeagueInvaders.HEIGHT) {
					a.isActive = false;
				}
			}
			

			for (Projectile p : projectiles) {
				p.update();
				if (p.y < 0) {
					p.isActive = false;
				}
			} 
	 }
	 
		

	 
	

	void draw(Graphics g) {
		rocket.draw(g);
		for(Alien a : aliens) {
			a.draw(g);
		}
		for(Projectile p : projectiles) {
		p.draw(g);
		}
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

@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	addAlien();
}
}






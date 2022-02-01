import java.awt.Rectangle;

public class GameObject {

int x;
int y;
int height;
int width;
int speed = 0;
boolean isActive = true;
Rectangle collisionBox;


GameObject(int x,int y,int height,int width){
this.x = x;
this.y =y;
this.height = height;
this.width = width;
collisionBox = new Rectangle(x,y,width, height);

}

void update(){
	
	collisionBox.setBounds(x, y, width, height);
	
}

}


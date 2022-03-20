package objects;

import java.awt.image.BufferedImage;

public class Tile {

	public BufferedImage sprite;
        public String name;
        public int x,y;
        public int id;

	public Tile(String name, BufferedImage sprite) {
		this.sprite = sprite;
                this.name=name;
                if(name=="GRASS")id=2;
                else if(name=="WATER")id=0;
                else if(name=="ROCK")id=1;
                        
	}
        public Tile(String name, BufferedImage sprite, int x, int y) {
		this.sprite = sprite;
                this.name=name;
                this.x=x;
                this.y=y;
	}
        public String getName(){
            return name;
        }

	public BufferedImage getSprite() {
		return sprite;
	}

}

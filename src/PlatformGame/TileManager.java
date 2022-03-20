package PlatformGame;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import helpz.LoadSave;
import objects.Tile;

public class TileManager {

	public Tile GRASS, WATER, ROAD;
	public BufferedImage atlas;
	public ArrayList<Tile> tiles = new ArrayList<>();

	public TileManager() {

		loadAtalas();
		createTiles();

	}

	private void createTiles() {

		tiles.add(new Tile("WATER",getSprite(0,2)));
                tiles.add(new Tile("ROCK",getSprite(9,0)));
                tiles.add(new Tile("GRASS",getSprite(8,1)));

	}

	private void loadAtalas() {

		atlas = LoadSave.getSpriteAtlas();

	}

	public BufferedImage getSprite(int id) {
		return tiles.get(id).getSprite();
	}

	public BufferedImage getSprite(int xCord, int yCord) {
		return atlas.getSubimage(xCord * 32, yCord * 32, 32, 32);
	}


}

package enemies;

import java.awt.Rectangle;
import static helpz.Constants.Direction.*;
import static helpz.Constants.Tiles.*;
import helpz.TheMap;
import java.awt.Point;

public class Enemy {

    private float x, y;
    private Rectangle bounds;
    private int health;
    private int ID;
    private int enemyType;
    public int lastDir;
    private float speedx, speedy;
    private int dir;

    public Enemy(float x, float y, int ID, int enemyType) {
        this.x = x;
        this.y = y;
        this.ID = ID;
        this.enemyType = enemyType;
        bounds = new Rectangle((int) x, (int) y, 32, 32);
    }

    void move(int dir) {
        if
        lastDir = dir;
        if (x <= setDestination(dir).x) {
            x -= speedx;
        } else {
            x += speedx;
        }
        if (y <= setDestination(dir).x) {
            y -= speedy;
        } else {
            y += speedy;
        }
        

    }

    public void setDir(int lastDir) {
        switch (lastDir) {
            case LEFT:
                if (TheMap.map()[(int) (x - 1) / 32][(int) y / 32] == ROAD_TILE) {
                    dir = LEFT;

                } else if (TheMap.map()[(int) (x) / 32][(int) (y + 1) / 32] == ROAD_TILE) {
                    dir = DOWN;

                } else {
                    dir = UP;
                }

                break;
            case UP:
                if (TheMap.map()[(int) (x) / 32][(int) (y - 1) / 32] == ROAD_TILE) {
                    dir = UP;

                } else if (TheMap.map()[(int) (x + 1) / 32][(int) (y) / 32] == ROAD_TILE) {
                    dir = LEFT;

                } else {
                    dir = RIGHT;
                }

                break;
            case RIGHT:
                if (TheMap.map()[(int) (x + 1) / 32][(int) (y) / 32] == ROAD_TILE) {
                    dir = RIGHT;

                } else if (TheMap.map()[(int) (x) / 32][(int) (y + 1) / 32] == ROAD_TILE) {
                    dir = DOWN;

                } else {
                    dir = UP;
                }

                break;
            case DOWN:
                if (TheMap.map()[(int) (x) / 32][(int) (y + 1) / 32] == ROAD_TILE) {
                    dir = DOWN;

                } else if (TheMap.map()[(int) (x + 1) / 32][(int) (y) / 32] == ROAD_TILE) {
                    dir = RIGHT;

                } else {
                    dir = LEFT;
                }

                break;

        }
        this.x += x;
        this.y += y;
        lastDir = dir;
    }

    private Point setDestination(int dir) {
        Point point = new Point();
        if (dir == RIGHT) {
            point.x = (int) x + 1;
            point.x = (int) y;
            return new Point((int) x + 1, (int) y);
        } else if (dir == LEFT) {
            point.x = (int) x - 1;
            point.x = (int) y;

        } else if (dir == UP) {
            point.x = (int) x;
            point.x = (int) y - 1;

        } else if (dir == DOWN) {
            point.x = (int) x;
            point.x = (int) y + 1;

        }
        return point;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public int getHealth() {
        return health;
    }

    public int getID() {
        return ID;
    }

    public int getEnemyType() {
        return enemyType;
    }

}

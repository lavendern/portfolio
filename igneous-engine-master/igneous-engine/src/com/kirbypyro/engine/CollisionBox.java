package com.kirbypyro.engine;

public class CollisionBox {
	public Polygon poly;
	
	public CollisionBox(Polygon poly) {
		this.poly = poly;
	}
	
	public boolean isColliding(Polygon colliding) {
		if(colliding.x >= poly.x && colliding.x <= poly.x + poly.width) {
			int y2 = poly.y+poly.height;
			
			if(colliding.y >= poly.y && colliding.y <= y2) {
				return true;
			}
			
		}
		return false;
	}
	
	public boolean isColliding(Humanoid colliding, int dir) {
		if(colliding.body.x + dir >= poly.x && colliding.body.x + dir <= poly.x + poly.width) {
			int y2 = poly.y+poly.height;
			
			if(colliding.body.y >= poly.y && colliding.body.y <= y2) {
				return true;
			}
			
		}
		return false;
	}
	
	public static CollisionBox[] checkForCollisions(Polygon colliding, LevelLayout level) {
	CollisionBox[] collidesw = {};
		for (int i = 0; i < level.collisions.length; i++) {
			if(level.collisions[i].isColliding(colliding)) {
				collidesw[collidesw.length] = level.collisions[i];
			}
		}
			
		return collidesw;
	}
	
	public static CollisionBox checkForCollisions(Humanoid colliding, LevelLayout level, int direction) {
			for (int i = 0; i < level.collisions.length; i++) {
				if(level.collisions[i].isColliding(colliding, direction)) {
					return level.collisions[i];
				}
			}	
			return null;
		}
	
}

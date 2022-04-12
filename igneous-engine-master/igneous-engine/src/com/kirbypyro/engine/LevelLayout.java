package com.kirbypyro.engine;

import com.kirbypyro.engine.npc.NPC;
import com.kirbypyro.engine.npc.NPCType;
import com.kirbypyro.engine.render.Render;
import com.kirbypyro.engine.render.Sky;
import com.kirbypyro.engine.settings.Level;

public class LevelLayout {
	public Polygon[] polys;
	public Level level;
	public Sky sky;
	public Humanoid player;
	public CollisionBox[] collisions;
	public NPC[] npcs;
	
	
	public LevelLayout(Polygon[] polys, Humanoid player, NPC[] npcs, Level level, Sky sky, CollisionBox[] collisions) {
		this.polys = polys;
		this.level = level;
		this.sky = sky;
		this.player = player;
		this.collisions = collisions;
		this.npcs = npcs;
	}
	public void renderLevel() {
		Render.render(sky);
		for (int i = 0; i < polys.length; i++) {
			Render.render(polys[i]);
		} for(int i = 0; i < npcs.length; i++) {
			Render.render(npcs[i].humanoid);
			if(npcs[i].properties.rendering && npcs[i].type == NPCType.SPEAK) {
				npcs[i].properties.dialog.render();
			}
			
		}
		Render.render(player);
		
		
	}
}

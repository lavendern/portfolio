package com.kirbypyro.engine.npc;

import com.kirbypyro.engine.CollisionBox;
import com.kirbypyro.engine.Humanoid;

public class NPC {
	public Humanoid humanoid;
	public NPCType type;
	public NPCProperties properties;
	public CollisionBox headbox;
	public CollisionBox bodybox;
	
	
	public NPC(NPCType type, boolean collisions, String expression, NPCProperties properties) {
		this.humanoid = new Humanoid(100, 500, 70, 0, 1, 0, 1, expression);
		this.type = type;
		this.properties = properties;
		if (collisions == true ) {
		headbox = new CollisionBox(humanoid.head);
		bodybox = new CollisionBox(humanoid.body);
		}
		
		
		
	}
}

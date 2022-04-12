package com.kirbypyro.engine.player;

import com.kirbypyro.engine.Humanoid;
import com.kirbypyro.engine.LevelLayout;
import com.kirbypyro.engine.npc.NPC;
import com.kirbypyro.engine.npc.NPCType;

public class PlayerInteract {
	
	public static void interactWithNPC(NPC npc) {
		if (npc.type == NPCType.SPEAK)  {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			npc.properties.rendering = !npc.properties.rendering;
		} else if(npc.type == NPCType.SHOP) {
			
		} else if(npc.type == NPCType.ITEM) {
			
		}
	}
	
	public static NPC checkForInteractable(Humanoid player, LevelLayout level) {
		for(int i = 0; i < level.npcs.length; i++ ) {
		NPC npc = level.npcs[i];
		if(player.x <= npc.humanoid.x) {
			if(player.x+player.size >= npc.humanoid.x) {
				return npc;
			}
		} else if(player.x >= npc.humanoid.x) {
			if(player.x <= npc.humanoid.x+npc.humanoid.size) {
				return npc;
			}
		}
		
		}
		return null;
	}
}

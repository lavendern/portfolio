package com.kirbypyro.engine.npc;

import org.newdawn.slick.Color;

import com.kirbypyro.engine.player.Dialog;

public class NPCProperties {
public Dialog dialog;
public boolean rendering;

	public NPCProperties(String speaker, String[] message, Color color) {
			dialog = new Dialog(speaker, message, color);
	}
	
	/*public NPCProperties(String speaker, String[] message, Color color, Shop shop) { //TODO: Use this for shop method
		dialog = new Dialog(speaker, message, color);
	}*/
}

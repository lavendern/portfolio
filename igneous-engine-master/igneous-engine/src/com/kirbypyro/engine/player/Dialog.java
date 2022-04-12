package com.kirbypyro.engine.player;

import org.newdawn.slick.Color;

import com.kirbypyro.engine.Polygon;
import com.kirbypyro.engine.Text;
import com.kirbypyro.engine.render.Render;

public class Dialog {
	
public String[] message;
public String speaker;
public Color color;
public Polygon dialogbox;	
public Text speaker2;
public Text message1;
public Text message2;
public Text message3;


	public Dialog(String speaker, String[] message, Color color) {
		this.message = message;
		this.speaker = speaker;
		this.color = color;
		
		dialogbox = new Polygon(0, 0, 800, 200, "GL_QUADS", true, 1, 1, 1, .7f, 0);
		speaker2 = new Text(10, 10, speaker + ":" + message[0], color, 24, "Arial");
		if(message.length > 1) {
			message2 = new Text(10, 30, message[1], color, 24, "Arial");
			if(message.length > 2) {
				message3 = new Text(10, 50, message[2], color, 24, "Arial");
			}
		}
	}
	
	public void render() {
		Render.render(dialogbox);
		Render.render(speaker2);
		if(message.length > 1) {
			Render.render(message2);
			if(message.length > 2) {
				Render.render(message3);
			}
		}
	}
}

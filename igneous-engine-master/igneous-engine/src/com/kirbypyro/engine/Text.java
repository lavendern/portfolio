package com.kirbypyro.engine;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;

public class Text {
	public int x;
	public int y;
	public String text;
	public Color color;
	public int size;
	public TrueTypeFont font;
	
public Text(int x, int y, String text, Color color, int size, String fonttype) {
	Font awtFont = new Font(fonttype, Font.BOLD, size);
	TrueTypeFont font = new TrueTypeFont(awtFont, true);
	
	this.x = x;
	this.y = y;
	this.text = text;
	this.color = color;
	this.size = size;
	this.font = font;
	
}

}

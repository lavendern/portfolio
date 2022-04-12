package com.kirbypyro.engine;

import org.lwjgl.Sys;

public class Timer {
	public static long getTime() // Returns time in milliseconds
	{
		return (Sys.getTime() * 1000 / Sys.getTimerResolution());
	}
}

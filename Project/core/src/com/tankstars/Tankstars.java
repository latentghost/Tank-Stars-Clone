package com.tankstars;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tankstars.screens.Start;

public class Tankstars extends Game {
	public static final int width = 1920;
	public static final int height = 1080;

	public SpriteBatch batch;

	@Override
	public void create () {
		batch = new SpriteBatch();
		this.setScreen(new Start(this));
	}

	@Override
	public void render () {
		resize(width,height);
		super.render();
	}
}

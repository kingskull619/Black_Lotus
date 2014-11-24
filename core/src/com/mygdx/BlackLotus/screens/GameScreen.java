package com.mygdx.BlackLotus.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.BlackLotus.Ball;
import com.mygdx.BlackLotus.BlackLotusGame;
import com.mygdx.BlackLotus.LeftPaddle;
import com.mygdx.BlackLotus.Paddle;
import com.mygdx.BlackLotus.RightPaddle;

/**
 * Created by kingskull on 18/11/2014.
 */
public class GameScreen extends AbstractScreen {

    private SpriteBatch batch;
    private Texture texture;

    private Paddle paddleLeft;
    private Paddle paddleRght;
    private Ball ball;

    public GameScreen(BlackLotusGame main) {
        super(main);
    }

    @Override
    public void show() {
        batch = new SpriteBatch();

        texture = new Texture(Gdx.files.internal("fondo.jpg"));
        Texture texturePaddle = new Texture(Gdx.files.internal("padle.jpg"));
        Texture textureBall = new Texture(Gdx.files.internal("bola.png"));

        ball = new Ball(Gdx.graphics.getWidth()/2 - textureBall.getWidth()/2, Gdx.graphics.getHeight() - textureBall.getHeight()/2);
        paddleLeft = new LeftPaddle( 80, Gdx.graphics.getHeight()/2 - texturePaddle.getHeight()/2);
        paddleRght = new RightPaddle(Gdx.graphics.getWidth() - 100, Gdx.graphics.getHeight()/2 - texturePaddle.getHeight()/2, ball);
    }

    @Override
    public void render (float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        paddleLeft.update();
        paddleRght.update();
        ball.update(paddleLeft, paddleRght);

        batch.begin();
        batch.draw(texture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        ball.draw(batch);
        paddleLeft.draw(batch);
        paddleRght.draw(batch);
        batch.end();
    }

}

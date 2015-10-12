/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uco.shvosi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Action;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cody
 */
public class Skill{

    protected float elapsed;
    protected Animation animation;
    protected int damage;
    protected List<DamageEntity> damageEntities;
    protected int width;
    protected int height;
    
    public Skill(int x, int y, Animation animation) {
        this.animation = animation;
        this.elapsed = 0f;
        this.damageEntities = new ArrayList<DamageEntity>();
        this.width = 1;
        this.height = 1;
    }

    public void update() {
        elapsed += Gdx.graphics.getDeltaTime();
    }

    public boolean isAnimationFinished() {
        if (this.animation.isAnimationFinished(this.elapsed)) {
            this.elapsed = 0f;
            return true;
        } else {
            return false;
        }
    }
    
    public int getDamage() {
        return this.damage;
    }
    
    public void draw(Batch batch, float alpha, Entity entity) {
        this.update();
        if(entity.textureRegion.isFlipX()){
            TextureRegion temp = animation.getKeyFrame(elapsed);
            temp.flip(true, false);
            batch.draw(animation.getKeyFrame(elapsed), entity.getX() - Constants.TILEDIMENSION * width, entity.getY(), Constants.TILEDIMENSION * width, Constants.TILEDIMENSION * height);
            temp.flip(true, false);
        }
        else
            batch.draw(animation.getKeyFrame(elapsed), entity.getX() + Constants.TILEDIMENSION, entity.getY(), Constants.TILEDIMENSION * width, Constants.TILEDIMENSION * height);

    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uco.shvosi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 *
 * @author cody
 */
class SkillOne extends Skill {
     private Animation light;
    private float elapsedLight = 0f;
    
    public SkillOne() {
        super(0, 0, TextureLoader.skillOne,
                Gdx.audio.newSound(Gdx.files.internal("sounds/skill1.mp3")));
        this.damage = 10;
        this.width = 2;
        
        this.damageEntities.add(new DamageEntity(0, 0, this.damage));
        this.damageEntities.add(new DamageEntity(0, 0, this.damage));
        
        light = TextureLoader.light;
    }
    
     public void draw(Batch batch, float alpha, Entity entity) {
        this.update();
        if (entity instanceof Protagonist) {
            Protagonist bernard = (Protagonist) entity;
            if (bernard.getLightBarrierLimit() > 0) {
                elapsedLight += Gdx.graphics.getDeltaTime();
                batch.draw(light.getKeyFrame(elapsedLight), bernard.getX() + Constants.TILEDIMENSION, bernard.getY(), Constants.TILEDIMENSION * width, Constants.TILEDIMENSION * height);
                if (light.isAnimationFinished(elapsedLight)) {
                    bernard.setLightBarrierLimit(bernard.getLightBarrierLimit() - 1);
//                    String l = String.valueOf(bernard.getLightBarrierLimit());
//                    Gdx.app.log("LightBarrier", l);
                    if (bernard.getLightBarrierLimit() == 0) {
                        bernard.setExecuteLightBarrier(false);
                    }
                    elapsedLight = 0f;
                }
            }
        }
        if (entity.textureRegion.isFlipX()) {
            temp = animation.getKeyFrame(elapsed);
            temp.flip(true, false);
            batch.draw(animation.getKeyFrame(elapsed), entity.getX() - Constants.TILEDIMENSION * width, entity.getY(), Constants.TILEDIMENSION * width, Constants.TILEDIMENSION * height);
            temp.flip(true, false);
        } else {
            batch.draw(animation.getKeyFrame(elapsed), entity.getX() + Constants.TILEDIMENSION, entity.getY(), Constants.TILEDIMENSION * width, Constants.TILEDIMENSION * height);
        }
    }

    public int getDamage() {
        return this.damage;
    }
}

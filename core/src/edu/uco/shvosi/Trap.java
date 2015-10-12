/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uco.shvosi;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 *
 * @author admin
 */
public class Trap extends Entity{
    
    protected int state;
    protected float elapsed;
    protected boolean activate;
    protected Animation animation;
    protected int damage;

    public Trap(Texture texture, int cX, int cY) {
        super(Constants.EntityGridCode.TRAP, texture, cX, cY);
        animation = null;
        activate = false;
        elapsed = 0f;
        this.damage = 0;
        this.setVisible(false);
        this.state = 0;
        
        this.name = "Trap";
    }
}
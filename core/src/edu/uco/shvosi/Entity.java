package edu.uco.shvosi;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Entity extends Image{

    protected int cX; // Coordinate X
    protected int cY; // Coordinate Y
    protected int dCX; // Destination Coordinate X
    protected int dCY; // Destination Coordinate Y
	protected boolean dead; // Life state
	protected boolean turnFinished; // Used to check if all actions are finished
    protected Constants.EntityGridCode gridCode; //NONE if not on grid, has type otherwise
    protected TextureRegion textureRegion;
    
    protected String name;

    public Entity(Constants.EntityGridCode gridCode, Texture texture, int cX, int cY) {
        this.cX = cX;
        this.cY = cY;
        this.dCX = this.cX;
        this.dCY = this.cY;
        this.setX(this.cX * Constants.TILEDIMENSION);
        this.setY(this.cY * Constants.TILEDIMENSION);
		this.dead = false;
		this.turnFinished = true;
        setBounds(getX(),getY(),texture.getWidth(),texture.getHeight());
        this.gridCode = gridCode;
        textureRegion = new TextureRegion(texture);
    }
    
    public String getName() {
        return this.name;
    }

    public int getCX() {
        return this.cX;
    }
	
	public void setCX(int cX) {
        this.cX = cX;
    }

    public int getCY() {
        return this.cY;
    }
	
	public void setCY(int cY) {
        this.cY = cY;
    }

    public int getDCX() {
        return this.dCX;
    }
	
	public void setDCX(int dCX) {
        this.dCX = dCX;
    }

    public int getDCY() {
        return this.dCY;
    }

    public void setDCY(int dCY) {
        this.dCY = dCY;
    }
	
	public boolean isDead(){
		return this.dead;
	}
	
	public void setDead(boolean b) {
		this.dead = b;
	}
	
	public boolean turnFinished() {
		return this.turnFinished;
	}
	
	public void setTurnFinished(boolean b) {
		this.turnFinished = b;
	}
	
    public Constants.EntityGridCode getGridCode(){
        return this.gridCode;
    }
    
    public void flipTexture(Constants.Direction direction){
        switch(direction){
            case LEFT:
                if(!textureRegion.isFlipX()) {
                    textureRegion.flip(true, false);
                }
                break;
            case RIGHT:
                if(textureRegion.isFlipX()) {
                    textureRegion.flip(true, false);
                }
                break;
            default:
                //Do nothing
                break;
       }
    }
	
	public void performActions() {
    }
	
    @Override
    public void draw(Batch batch, float alpha){
        batch.draw(textureRegion,this.getX(),this.getY());
    }
	
    public void performDeath() {
            //Add death actions then remove itself from the stage
        this.remove();
    }
    
    public void collision(Entity entity) {
    }
}
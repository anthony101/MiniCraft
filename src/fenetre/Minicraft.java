package fenetre;

import Player.IPlayerControl;
import Player.PlayerControl;
import World.IMapControl;
import World.MapControl;

import com.jme3.app.SimpleApplication;
import com.jme3.scene.Node;
import com.jme3.bullet.BulletAppState;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.KeyTrigger;

public class Minicraft extends SimpleApplication {
	
	private IMapControl mapControl;
	private IPlayerControl playerControl;
	// Gestion de la physique
	private BulletAppState bulletAppState;
	
	@Override
	public void simpleInitApp() {
	    
		mapControl = new MapControl();
		mapControl.init(this);
		flyCam.setMoveSpeed(80);
		Node carte = mapControl.generateMap(16, 16, 1);
		rootNode.attachChild(carte);		
	    
		/** Initialise la physique (collisions) */
	    bulletAppState = new BulletAppState();
	    stateManager.attach(bulletAppState);
	    /** En cas de débugage **/
	    //bulletAppState.getPhysicsSpace().enableDebug(assetManager);
	    setUpKeys();
	    
	    playerControl = new PlayerControl(cam);
	    
	    // A décommenter lorsque la cate sera solide
	   // bulletAppState.getPhysicsSpace().add(carte);
	    bulletAppState.getPhysicsSpace().add(playerControl.getPlayer());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Minicraft minicraft = new Minicraft();
		minicraft.start();
	}

	/**
	 * Initialise la configuration des touches 
	 */
	private void setUpKeys() {
	    inputManager.addMapping("Left", new KeyTrigger(KeyInput.KEY_Q));
	    inputManager.addMapping("Right", new KeyTrigger(KeyInput.KEY_D));
	    inputManager.addMapping("Up", new KeyTrigger(KeyInput.KEY_Z));
	    inputManager.addMapping("Down", new KeyTrigger(KeyInput.KEY_S));
	    inputManager.addMapping("Jump", new KeyTrigger(KeyInput.KEY_SPACE));
	    inputManager.addListener(playerControl, "Left");
	    inputManager.addListener(playerControl, "Right");
	    inputManager.addListener(playerControl, "Up");
	    inputManager.addListener(playerControl, "Down");
	    inputManager.addListener(playerControl, "Jump");
	  }

  @Override
  public void simpleUpdate(float tpf)
  {
	  //playerControl.walk();
  }

}



package World;

import com.jme3.math.Vector3f;

/**
 * 
 * @author Benjamin
 *
 * Interface de gestion des blocs
 * 
 */
public interface IBlockControl {
	
	// public void removeBloc();
	
	public void put(Block block, Location location);
	public void newBlocNextTo(Block bloc, Vector3f direction);
	public boolean deleteBloc(Block bloc);
	
}

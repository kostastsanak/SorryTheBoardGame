package Model;

import java.util.LinkedList;

/**
 * @author kosta
 *Creates a list that contains all important info of our Player/Pawn. Such as Xpositionm,Yposition,Id and Graphics
 */
public class Handler {
	
	public LinkedList<GameObject> object = new LinkedList <GameObject>();
	
	

	/**
	 * Brings up the Graphics of every Single pawn
	 */
	public void render () {
		for (int i =0; i < object.size();i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.render();
		}
	}
	
	/**
	 * <Postcondition>: Adds an object to the list. Most specifficly adds a pawn's info to the list
	 * @param object
	 */
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	/**
	 * <Postcondition>: removes an object from the list. Most specifficly removes a pawn's info from the list
	 * @param object
	 */
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}


	
	
}

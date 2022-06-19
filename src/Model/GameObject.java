package Model;

public abstract class GameObject {
	protected int x,y ;
	protected ID id ;
	
	/**
	 * @param id contains our pawn's ID
	 */
	public GameObject(ID id) {
		this.id=id;

	}
	
	/**
	 * Renders all the graphic part through the handlerer.
	 */
	public abstract void render();
	

	/**
	 * <Postcondition> : Sets our players X position
	 * <Precondition> : When Called sets the Pawn's x coordinates
	 * @param x our pawn's X position
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * <Postcondition> : Sets our players Y position
	 * <Precondition> : When Called sets the Pawn's y coordinates
	 * @param y our pawn's Y position
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * <Postcondition> : Sets our players ID
	 * <Precondition> : When Called sets the Pawn's ID
	 * @param id contains our players ID
	 */
	public void setId(ID id) {
		this.id = id;
	}
	
	/**
	 * <Postcondition> : Gets our players X position
	 * <Precondition> : When Called returns the Pawn's x coordinates
	 * @return x our players X position
	 */
	public int getX() {
		return x;
	}
	/**
	 * <Postcondition> : Gets our players Y position
	 * <Precondition> : When Called returns the Pawn's y coordinates
	 * @return y our players Y position
	 */
	public int getY() {
		return y;
	}
	/**
	 * <Postcondition> : Gets our players ID
	 * <Precondition> : When Called returns the Pawn's
	 * @return our players ID
	 */
	public ID getId() {
		return id;
	}

	
	
}

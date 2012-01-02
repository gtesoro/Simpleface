package simpleface;

public class RDMAccelerometer {
	
	RDXAccelerometer wiimote;
	private int intInitialX;
	private int intInitialY;
	private int intInitialZ;
	
	public RDMAccelerometer (){
		wiimote = new RDXAccelerometer();
		intInitialX = this.getX();
		intInitialY = this.getY();
		intInitialZ = this.getZ();
	}
	public int getIncX(){
		return wiimote.getActX() - wiimote.getLastX();
	}
	public int getIncY(){
		return wiimote.getActY() - wiimote.getLastY();
	}
	public int getIncZ(){
		return wiimote.getActZ() - wiimote.getLastZ();
	}
	public int getX(){
		return wiimote.getActX();
	}
	public int getY(){
		return wiimote.getActY();
	}
	public int getZ(){
		return wiimote.getActZ();
	}
	public int getDeltaX(){
		return wiimote.getActX() - this.intInitialX;
	}
	public int getDeltaY(){
		return wiimote.getActY() - this.intInitialY;
	}
	public int getDeltaZ(){
		return wiimote.getActZ() - this.intInitialZ;
	}
}

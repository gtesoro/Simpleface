package Accelerometer;


public class Accelerometer {
	
	private RDMAccelerometer RDM;
	
	private int intTolerance = 10;
	
	
	private final int intRANGE = 100;
	
	public Accelerometer (){
		RDM = new RDMAccelerometer();

	}
	
	public boolean isMoving(){
		
		//Assume still position
		boolean bResult = false;
		
		//Check incs of the axis in order to know if the wiimote is still or not
		if ((RDM.getIncX() >= 0 + intTolerance) || (RDM.getIncX() <= 0 - intTolerance)){
			bResult = true;
		}
		if ((RDM.getIncY() >= 0 + intTolerance) || (RDM.getIncY() <= 0 - intTolerance)){
			bResult = true;
		}
		if ((RDM.getIncZ() >= 0 + intTolerance) || (RDM.getIncZ() <= 0 - intTolerance)){
			bResult = true;
		}
		return bResult;
	}
	
	public boolean isRolledLeft(){
		
		//Assume not rolled
		boolean bResult = false;
		
		//Check the variance on the X axis within the initial position
		if  ((RDM.getDeltaX() <= (-1*intRANGE + this.intTolerance)) && 
		     (RDM.getDeltaX() >= (-1*intRANGE - this.intTolerance)) ){
			bResult = true;
		}
		return bResult;
	}
	public boolean isRolledRight(){
		
		//Assume not rolled
		boolean bResult = false;
		
		//Check the variance on the X axis within the initial position
		if  ((RDM.getDeltaX() <= (intRANGE + this.intTolerance)) && 
		     (RDM.getDeltaX() >= (intRANGE - this.intTolerance)) ){
			bResult = true;
		}
		return bResult;
	}
	
	public int getRollDelta(){
		
		return RDM.getDeltaX();
	}
	
	public boolean isRollingRight(){
		
		//Assume not rolling
		boolean bResult = false;
		
		//Check X axis inc
		if (RDM.getIncX() >= 0 + intTolerance){
			//Check if the rest of axis are still
			if ((RDM.getIncY() <= 0 + intTolerance) || (RDM.getIncY() >= 0 - intTolerance)){
				if ((RDM.getIncZ() <= 0 + intTolerance) || (RDM.getIncZ() >= 0 - intTolerance)){
					bResult = true;
				}
			}
		}
		
		return bResult;
	}
	public boolean isRollingLeft(){
		
		//Assume not rolling
		boolean bResult = false;
		
		//Check X axis inc
		if (RDM.getIncX() <= 0 - intTolerance){
			//Check if the rest of axis are still
			if ((RDM.getIncY() <= 0 + intTolerance) || (RDM.getIncY() >= 0 - intTolerance)){
				if ((RDM.getIncZ() <= 0 + intTolerance) || (RDM.getIncZ() >= 0 - intTolerance)){
					bResult = true;
				}
			}
		}
		
		return bResult;
	}
	
	public void setTolerance(int intNewTolerance){
		
		this.intTolerance = intNewTolerance;
		
	}
	
	public int getPitchDelta(){
		
		return RDM.getDeltaY();
	}
	
	public int getYawDelta(){
		
		return RDM.getDeltaZ();
	}

}

package com.muneeb.fypsaa.model;

/**
 * Device is a Type of Ambient
 * Class overrides Enter/Exit to match Device constraints
 * Holds all functions specific to Device
 * @author Muneeb
 *
 */
public class Device extends Ambient implements Mobility{

	public Device(String Name) throws Exception  {
		// TODO Auto-generated constructor stub
		super(Name,"Device");
	}

	/**
	 * Additional check Hierarchy and Mobility
	 */
	@Override
	public boolean Enter(Ambient ambenter) {
		if(ConstraintCheck(ambenter)&&MobilityCheck(ambenter)) {
			return super.Enter(ambenter);
		}
		return false;
		
}
	/**
	 * Additional check Mobility
	 */
	@Override
	public boolean Exit(Ambient ambexit) {
		if(children.contains(ambexit)&&MobilityCheck(ambexit)){
			return super.Exit(ambexit);
		}	
		return false;
	}
	
	/**
	 * Checks Hierarchy constraints
	 * @param ambenter instance of ambient 
	 * @return True or Fales depending on whether it meets constraints
	 */
	private boolean ConstraintCheck(Ambient ambenter) {
		boolean ret = false;
		String str = ambenter.type; 
        switch(str) 
        {
            case "Device": 
            	ret = false;
                break; 
            case "Location": 
            	ret = false;
                break;
            case "Group": 
            	ret = true;
                break;
            case "Root": 
            	ret = false;
                break;
      
            default: 
            	ret = false;
        }
        
        return ret;
    } 
	
		/**
		 * Edited to check for Ambient type Device and Group 
		 * TODO Change to check if Mobility is implemented
		 * @param amb instance of Object
		 * @return True or False depending ambient properties
		 */
		public boolean MobilityCheck(Ambient amb) {
			if(amb.type.equals("Device")||amb.type.equals("Group")) {
				System.out.println("ret true");
				return true;
			}
			return false;
		}
	
	
}

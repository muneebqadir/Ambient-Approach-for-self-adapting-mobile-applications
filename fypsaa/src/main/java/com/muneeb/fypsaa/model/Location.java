package com.muneeb.fypsaa.model;
/**
 * Location is a type of Ambient
 * Class overrides Enter/Exit to match Location constraints
 * Holds all functions specific to Location
 * @author Muneeb
 *
 */
public class Location extends Ambient{

	public Location(String name) throws Exception {
		// TODO Auto-generated constructor stub
		super(name,"Location");
	}

	/**
	 * Additional check Hierarchy and Mobility
	 */
	@Override
	public boolean Enter(Ambient ambenter) {
		if(ConstraintCheck(ambenter)) {
			if(MobilityCheck(ambenter)==true)
			{
				return super.Enter(ambenter);
			}
		}
		return false;
		
}

	/**
	 * Additional check Hierarchy and Mobility
	 */
	@Override
	public boolean Exit(Ambient ambexit) {
		if(MobilityCheck(ambexit)){
			return super.Exit(ambexit);
		}	
		if(!children.contains(ambexit.name)) {
		}
		return false;
	}
	
	/**
	 * Set Location Hierarchy (only for Location ambients)
	 * @param ambenter Instance of Ambient
	 * @return True or False depending on Type and Parent
	 */
	public boolean SetLocationHeirachy(Ambient ambenter) {
		if(ambenter.parent.type.equals("Root")&&ambenter.type.equals("Location")){
			ambenter.parent = this;
			children.add(ambenter.name);
			return true;
		}
		return false;
	}

	/**
	 * Checks Hierarchy constraints
	 * @param ambenter Instance of Ambient 
	 * @return True or Fales depending on whether it meets constraints
	 */	private boolean ConstraintCheck(Ambient ambenter) {
		boolean ret = false;
		String str = ambenter.type; 
        switch(str) 
        { 
            case "Device": 
            	ret = true;
                break; 
            case "Location": 
            	ret = false;
                break;
            case "Group": 
            	ret = false;
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

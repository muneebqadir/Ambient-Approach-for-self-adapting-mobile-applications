package com.muneeb.fypsaa.model;
import java.util.ArrayList;
/**
 * Root is a type of Ambient
 * Class overrides Enter/Exit to match Root constraints
 * Holds all functions specific to Root
 * @author Muneeb
 */
public class RootAmbient extends Ambient{
	
	protected Ambient parent = this;
	public RootAmbient() throws Exception {
		super("root","Root");
		
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Removes Sibling checks
	 */
	@Override
	public boolean Enter(Ambient ambenter) {
		if(ConstraintCheck(ambenter)) {
			if(!children.contains(ambenter.name)) {
				children.add(ambenter.name);
				ambenter.parent=this;
				return true;
			}
		}
		return false;
		
}
	
	@Override
	public boolean Exit(Ambient ambexit) {
		if(children.contains(ambexit.name)){
			children.remove(ambexit.name);
			return true;
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
            	ret = true;
                break; 
            case "Location": 
            	ret = true;
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

}

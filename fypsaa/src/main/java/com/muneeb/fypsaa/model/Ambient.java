package com.muneeb.fypsaa.model;
import java.util.*;

/**
 * An instance of Ambient
 * Holds attributes and methods common to all types of ambients
 * @author Muneeb
 *
 */
public class Ambient{

	public String name;
	public Ambient parent;
	public ArrayList<String> children = new ArrayList<String>();
	public ArrayList<String> sibling = new ArrayList<String>();
	public ArrayList<Service> services = new ArrayList<Service>();
	public String type;
	
	/**
	 * Constructor to create Ambients used by Root,Loaction,Device and Application
	 * @param AmbientName name of Ambient, AmbientType type of Ambient
	 */
	protected Ambient(String AmbientName, String AmbientType) {
		
		name = AmbientName;
		type = AmbientType;
	
	}
	
	/**
	 * Default no param constructor for to/from JSON conversion
	 */
	public Ambient() {
		
	}
	
	/**
	 * Updates attribute siblings
	 */
	public void SiblingCheck(){
		if(sibling.equals(parent.children)==false)
		{
				sibling = parent.children;
		}
		
	}
	
	/**
	 * Gives location of Ambient in Heirarchy
	 * @return Parents name
	 */
	public String GetLocation(){
		
		return parent.name;
	}
	
	/**
	 * Used for Entering this Ambient
	 * @param ambenter Instance of Ambient that wants to be added
	 * @return True or False depending on whether ambient meets (Sibling)constraint
	 */
	public boolean Enter(Ambient ambenter) {
		SiblingCheck();
		if(sibling.contains(ambenter.name)||ambenter.parent.type.equals("Root")) {
			if(!children.contains(ambenter.name)) {
				Accept(ambenter);
				ambenter.parent=this;
				return true;
				//System.out.println("Ambient has entered");
			}
		}
		return false;
	}
		
	/**
	 * Used for Exiting this Ambient
	 * @param ambexit instance of ambient that wants to exit
	 * @return True or False depending on whether ambient was a child before
	 */
	public boolean Exit(Ambient ambexit) {
		if(children.contains(ambexit.name)) {
			children.remove(ambexit.name);
			
			return true;
			//System.out.println("Ambient has left");
		}
		return false;
	}
	
	

	/**
	 * Returns the type of ambient 
	 * @param amb instance of Ambient
	 * @return Root,Location,Device,Group depending on type of Ambient
	 */
	public String getType(Ambient amb) {
        	return type;
        }
		
	/**
	 * (Private) Accept Ambient into children ArrayList
	 * @param newchild instance of Ambient
	 */
	protected void Accept(Ambient newchild) {
		children.add(newchild.name);
	}
	
	/**
	 * Add a service to ArrayList Services
	 * @param n instance of Service object
	 */
	public void AddService(Service n) {
		services.add(n);
	}
	
	/**
	 * Removes a service from ArrayList Services
	 * @param d instance of Service object
	 */
	public void DeleteService(Service d) {
		services.remove(d);
	}
	
	
	/* Mobility Interface did not work with Rest interfaces
// 	MobilityCheckOld used to check if class was implementing interface Mobility but didnt work with Uris	
	public boolean MobilityCheck(Ambient amb) {
		if(Mobility.class.isInstance(amb)){
        	return true;
        }
		else {
			return false;
		}
	}
	*/
}

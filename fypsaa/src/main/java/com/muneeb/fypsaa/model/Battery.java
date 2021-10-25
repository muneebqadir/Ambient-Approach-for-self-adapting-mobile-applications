package com.muneeb.fypsaa.model;
import java.util.List;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.PowerSource;

/**
 * Battery Interface holds all Battery resource related functions
 * @author Muneeb
 *
 */
public interface Battery {
	
	/**
	 * Returns Battery Information
	 * Will return Total current cappacity if there is more than 1 battery 
	 * @return Current Capacity/Design Capacity or 200 if Battery is plugged in
	 */
	default long getBatteryInformation () {
		SystemInfo si = new SystemInfo();
		HardwareAbstractionLayer hal = si.getHardware();
		List<PowerSource> ps = hal.getPowerSources();
		long CurrentCapacity = 0, DesignCapacity=0;
		boolean isCharging = false;
		
		for(int i =0; i<ps.size();i++) {
			CurrentCapacity += ps.get(i).getCurrentCapacity();
			DesignCapacity +=ps.get(i).getDesignCapacity();
			isCharging = ps.get(i).isCharging();
		}
		
		if(isCharging) {
			return 200;
		}
		else {
			return CurrentCapacity/DesignCapacity;
		}
	}

}

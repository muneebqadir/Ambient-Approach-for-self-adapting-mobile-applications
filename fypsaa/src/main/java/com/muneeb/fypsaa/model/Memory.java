package com.muneeb.fypsaa.model;
import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;
/**
 * Memory Interface hold all Memory Resource related functions
 * @author Muneeb
 *
 */
public interface Memory {
	
	/**
	 * Memory usage by Thread UID
	 * @param pid Thread UID
	 * @return Memory used by Process (long)
	 */
	default long getMemoryUtilizationPerProcess(int pid) {
	    OSProcess process;
	    SystemInfo si = new SystemInfo();
	    OperatingSystem os = si.getOperatingSystem();
	    process = os.getProcess(pid);
	    //System.out.println("\nMemory Usage :");
	    return process.getResidentSetSize();
	}
	
	/**
	 * Free Memory of PC
	 * @return Used Memory (long)
	 */
	default long getTotalUsedMemory() {
		SystemInfo systemInfo = new SystemInfo();
        HardwareAbstractionLayer hardware = systemInfo.getHardware();
        GlobalMemory globalMemory = hardware.getMemory();
        long usedMemory = globalMemory.getTotal() - globalMemory.getAvailable();
        //System.out.println("Total memory: " + FormatUtil.formatBytes(globalMemory.getTotal()));
        //return globalMemory.getAvailable();
        return usedMemory;
	}

}

package com.muneeb.fypsaa.model;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;
import oshi.util.Util;

/**
 * Cpu information holds all CPU related methods
 * @author Muneeb
 *
 */
public interface Cpu {

	/**
	 * Checks cpu usage over 2 second intervals and then averages out cpu usage
	 * @param processId UID of Thread
	 * @return Double percentage of CPU the Thread is using 
	 */
	default double getCpuUtilizationPerProcess(int processId) {

		SystemInfo systemInfo = new SystemInfo();
        OperatingSystem operatingSystem = systemInfo.getOperatingSystem();
        CentralProcessor centralProcessor = systemInfo.getHardware().getProcessor();
        int cpuNumber = centralProcessor.getLogicalProcessorCount();
		double percentageSum = 0;
		int iter = 4;
		int pid = processId;
		OSProcess oldProcess= operatingSystem.getProcess(pid);
		for(int i =0;i<iter;i++) {
		    OSProcess osProcess = operatingSystem.getProcess(pid);
		    double res=osProcess.getProcessCpuLoadBetweenTicks(oldProcess);
		    oldProcess = osProcess;
		    //System.out.println("Percentage: "+(res/cpuNumber)+" %");
		    Util.sleep(2000);
		}
		
		return percentageSum/iter;
	}

	
}

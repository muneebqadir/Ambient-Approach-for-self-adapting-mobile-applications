package com.muneeb.fypsaa.model;

/**
 * Service Cost holds the cost of Services
 */
public class ServiceCost {
    public String serviceName;
    public double wlanCost;
    public double dataCost;
    public double utility;
    public int memory;

    public ServiceCost(String serviceName,double wlanCost, double dataCost, double utility){
        this.serviceName=serviceName;
        this.wlanCost=wlanCost;
        this.dataCost=dataCost;
        this.utility=utility;
    }





}

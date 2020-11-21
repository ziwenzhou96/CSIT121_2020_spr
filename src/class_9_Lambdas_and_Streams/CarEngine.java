package class_9_Lambdas_and_Streams;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fenghui
 */
public class CarEngine {
	private String engineName;
	private int cylinderVolumn; // example 2.4L
	private int numberOfCylinder;
	private String fuelType;
	
	public CarEngine(String engineName, int cylinderVolumn, int numberOfCylinder, String fuelType) {
		this.engineName = engineName;
		this.cylinderVolumn = cylinderVolumn;
		this.numberOfCylinder = numberOfCylinder;
		this.fuelType = fuelType;
	}
	
	public String getEngineName() {
		return engineName;
	}
	
	public void setEngineName(String engineName) {
		this.engineName = engineName;
	}

	public int getCylinderVolumn() {
		return cylinderVolumn;
	}

	public void setCylinderVolumn(int cylinderVolumn) {
		this.cylinderVolumn = cylinderVolumn;
	}

	public int getNumberOfCylinder() {
		return numberOfCylinder;
	}

	public void setNumberOfCylinder(int numberOfCylinder) {
		this.numberOfCylinder = numberOfCylinder;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

    @Override
    public String toString() {
        return "CarEngine{" + "engineName=" + engineName + ", cylinderVolumn=" + cylinderVolumn + ", numberOfCylinder=" + numberOfCylinder + ", fuelType=" + fuelType + '}';
    }
}

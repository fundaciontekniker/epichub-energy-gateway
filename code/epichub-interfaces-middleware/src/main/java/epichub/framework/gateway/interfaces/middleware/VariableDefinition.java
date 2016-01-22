package epichub.framework.gateway.interfaces.middleware;

import com.thalesgroup.it.ns.model.energy.EnergyDataUnit;

public class VariableDefinition {
	public String varId;
	public String name;
	public String typeId;
	public String parentId;
	public Integer samplingInterval;
	public Double absoluteMeasureError;
	public EnergyDataUnit energyDataUnit;
}

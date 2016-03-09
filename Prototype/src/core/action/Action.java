package core.action;

import core.location.Location;

public interface Action {
	Location getFinalPoint();
	double getEffort();
	Object getResult();
}

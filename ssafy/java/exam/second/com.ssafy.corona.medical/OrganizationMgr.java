package com.ssafy.corona.medical;

import java.util.List;

public interface OrganizationMgr {
	List<Organization> search();
	Organization search(Organization o);
}
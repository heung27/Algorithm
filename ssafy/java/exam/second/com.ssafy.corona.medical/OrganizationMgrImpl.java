package com.ssafy.corona.medical;

import java.util.ArrayList;
import java.util.List;

public class OrganizationMgrImpl implements OrganizationMgr {
	private List<Organization> orgs;
	
	public OrganizationMgrImpl() {
		orgs=new ArrayList<Organization>();
		
		// 질병관리청 생성
		orgs.add(new CDC("질병관리청", 200, "충북 청주시"));
		// 병원 생성
		orgs.add(new Hospital("싸피병원", 15, "101", 50, 5));
		orgs.add(new Hospital("대학병원", 10, "102", 30, 10));
		orgs.add(new Hospital("동네병원",  3, "501", 10, 2));
		orgs.add(new Hospital("가족병원", 10, "502", 15, 5));
	}
	
	@Override
	public List<Organization> search(){
		return orgs;
	}
	@Override
	public Organization search(Organization o){
		for(Organization org : orgs) {
			if(org.getName().equals(o.getName())) {
				return org;
			}
		}
		return null;
	}
}
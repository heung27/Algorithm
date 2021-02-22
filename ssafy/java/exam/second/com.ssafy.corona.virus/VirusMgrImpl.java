package com.ssafy.corona.virus;

import javax.management.RuntimeErrorException;

public class VirusMgrImpl implements VirusMgr {
	private Virus[] virus;
	private int index = 0;
	
	public VirusMgrImpl() {
		virus=new Virus[100];		
	}
	
	@Override
	public void add(Virus v) throws DuplicatedException {
		try {
			search(v.getName());
			throw new DuplicatedException(v.getName()+": 등록된 바이러스 입니다.");
		} catch (NotFoundException e) {
			virus[index++]=v;
		}
	}
	@Override
	public Virus[] search() {
		Virus[] temp = null;
		if (index > 0) {
			temp = new Virus[index];
			for (int i=0; i<index; i++) {
				temp[i] = virus[i];
			}
		}
		return temp;
	}
	@Override
	public Virus search(String name) throws NotFoundException{
		for(int i=0; i<index; i++) {
			if(virus[i].getName().equals(name)) return virus[i];
		}
		throw new NotFoundException(name+": 미등록 바이러스입니다.");
	}
}

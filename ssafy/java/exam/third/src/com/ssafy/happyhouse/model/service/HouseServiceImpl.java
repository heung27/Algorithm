package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.dao.HouseDao;
import com.ssafy.happyhouse.model.dao.HouseDaoImpl;
import com.ssafy.happyhouse.model.dto.EnviromentMapInfo;
import com.ssafy.happyhouse.model.dto.HouseDeal;
import com.ssafy.happyhouse.model.dto.HousePageBean;
import com.ssafy.happyhouse.model.dto.StoreMapInfo;

public class HouseServiceImpl implements HouseService{
	private HouseDao dao;

	public HouseServiceImpl() {
		 dao = new HouseDaoImpl();
	}
	/**
	 * 검색 조건(key) 검색 단어(word)에 해당하는 아파트 거래 정보(HouseInfo)를  검색해서 반환.  
	 * @param bean  검색 조건과 검색 단어가 있는 객체
	 * @return 조회한 주택 목록
	 */
	@Override
	public List<HouseDeal> searchAll(HousePageBean  bean){
		return dao.searchAll(bean);
	}
	
	/**
	 * 아파트 식별 번호에 해당하는 아파트 거래 정보를 검색해서 반환. 
	 * @param no	검색할 아파트 식별 번호
	 * @return		아파트 식별 번호에 해당하는 아파트 거래 정보를 찾아서 리턴한다, 없으면 null이 리턴됨
	 */
	@Override
	public HouseDeal search(int no) {
		
		// complete code #02
		// null 을 return 하면 안됩니다. Dao Layer 의 적절한 method를 호출하여 Business Logic 을 완성하세요.
		return dao.search(no);
	}
	
	@Override
	public List<EnviromentMapInfo> searchEnv(String dong) {
		return dao.searchEnv(dong);
	}
	
	@Override
	public List<StoreMapInfo> searchStore(String dong) {
		return dao.searchStore(dong);
	}
}

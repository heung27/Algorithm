//package com.ssafy.happyhouse.util;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.xml.sax.Attributes;
//import org.xml.sax.helpers.DefaultHandler;
//
//import com.ssafy.happyhouse.model.dto.EnviromentMapInfo;
//import com.ssafy.happyhouse.model.dto.HouseInfo;
//
//public class EnviromentMapSAXHandler extends DefaultHandler {
//	/**
//	 * 아파트 거래 정보를 식별하기 위한 번호로 차후 DB에서는 primary key로 대체하지만 
//	 * 현재 버전에서는 0번부터 순차 부여한다. 
//	 */
//	private int no;
//	/**환경 지도 점검 데이터 */
//	private Map<String,EnviromentMapInfo> enviroment;
//	/**파상힌 아파트 거래 정보*/
//	private HouseInfo house;
//	/**태그 바디 정보를 임시로 저장*/
//	private String temp;
//	
//	public EnviromentMapSAXHandler(){
//		enviroment = new HashMap<String,EnviromentMapInfo>();
//	}
//	
//	public void startElement(String uri, String localName
//			                           , String qName, Attributes att ){
//		if(qName.equals("item")){
//			house = new HouseInfo(no++);
//		}
//	}
//	
//	public void endElement(String uri, String localName, String qName){
//		if(qName.equals("지역코드")) { 
//			house.setCode(Integer.parseInt(temp));
//		}else if(qName.equals("아파트")) { 
//			house.setAptName(temp.trim());
//		}else if(qName.equals("법정동")) { 
//			house.setDong(temp.trim());
//		}else if(qName.equals("img")) { 
//			house.setImg(temp);
//		}else if(qName.equals("건축년도")) { 
//			house.setBuildYear(Integer.parseInt(temp));
//		}else if(qName.equals("지번")) { 
//			house.setJibun(temp);
//		}else if(qName.equals("item")) {
//			enviroment.put(house.getDong()+house.getAptName(), house);
//		}
//	}
//	
//	public void characters(char[]ch, int start, int length){
//		temp = new String(ch, start, length);
//	}
//	
//	public Map<String,EnviromentMapInfo> getHouseInfo() {
//		return enviroment;
//	}
//}

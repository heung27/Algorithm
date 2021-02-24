package com.ssafy.happyhouse.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.ssafy.happyhouse.model.dto.EnviromentMapInfo;
import com.ssafy.happyhouse.model.dto.HouseDeal;
import com.ssafy.happyhouse.model.dto.HouseInfo;
import com.ssafy.happyhouse.model.dto.StoreMapInfo;

/**
 * FoodNutritionSAXHandler와 FoodSAXHandler를 이용해서 식품 정보를 load하는 SAX Parser 프로 그램  
 *
 */
public class HouseSaxParser {
	private Map<String, List<HouseDeal>> deals;
	private Map<String, HouseInfo> houseInfo;
	private List<EnviromentMapInfo> envInfo;
	private List<StoreMapInfo> storeInfo;
	private int size;
	/**
	 * 아파트 거래 정보를 식별하기 위한 번호로 차후 DB에서는 primary key로 대체하지만 
	 * 현재 버전에서는 0번부터 순차 부여한다. 
	 */
	public static int no;
 	public HouseSaxParser() {
		loadData();
	}
 	
 	/**
 	 * HouseSAXHandler를 이용 파싱한 아파트 거래 내역을 추출한다. 
 	 */
	private void loadData() {
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		String aptInfoFilePath = "res/AptInfo.xml";
		String aptDealFilePath = "res/AptDealHistory.xml";
		String aptRentFilePath = "res/AptRentHistory.xml";
		String houseDealFilePath = "res/HouseDealHistory.xml";
		String houseRentFilePath = "res/HouseRentHistory.xml";
		String envMapFilePath = "res/EnviromentMap.csv";
		String storeMapFilePath = "res/StoreMap.csv";
		
		try{
			SAXParser parser = factory.newSAXParser();
			
//			EnviromentMapSAXHandler envHanler = new EnviromentMapSAXHandler();
//			parser.parse(envMapFilePath, envHanler);
//			EnvInfo = envHanler.getHouseInfo();
			
//			CSVReader reader = new CSVReader(new FileReader(envMapFilePath));
			envInfo = new ArrayList<EnviromentMapInfo>();
			BufferedReader in1 = new BufferedReader(new InputStreamReader(new FileInputStream(envMapFilePath), "euc-kr"));
			String str1 = in1.readLine();
			int no = 1;
			while ((str1 = in1.readLine()) != null) {
				String[] arr = str1.split(",");
				String[] temp = arr[12].split(" ");
				EnviromentMapInfo env = new EnviromentMapInfo(no++, arr[0], arr[3], arr[4], arr[7], arr[9], temp[2]);
				envInfo.add(env);
			}
			
			storeInfo = new ArrayList<StoreMapInfo>();
			BufferedReader in2 = new BufferedReader(new InputStreamReader(new FileInputStream(storeMapFilePath)));
			String str2 = in2.readLine();
			while ((str2 = in2.readLine()) != null) {
				String[] arr = str2.split(",");
				String[] temp = arr[0].split("\\|");
				if (temp.length < 10) continue;
				StoreMapInfo store = new StoreMapInfo(temp[0], temp[1], arr[0]);
				storeInfo.add(store);
			}
			
			HouseSAXHandler handler = new HouseSAXHandler();
			parser.parse(aptInfoFilePath, handler);
			houseInfo = handler.getHouseInfo();
			
			APTDealSAXHandler  aptDealHandler = new APTDealSAXHandler();
			parser.parse(aptDealFilePath, aptDealHandler);
			List<HouseDeal> aptDeals = aptDealHandler.getHouses();
			
			HouseDealSAXHandler  houseDealHandler = new HouseDealSAXHandler();
			parser.parse(houseDealFilePath, houseDealHandler);
			List<HouseDeal> houseDeals = houseDealHandler.getHouses();
			
			APTRentSAXHandler  aptRentHandler = new APTRentSAXHandler();
			parser.parse(aptRentFilePath, aptRentHandler);
			List<HouseDeal> aptRents = aptRentHandler.getHouses();
			
			HouseRentSAXHandler  houseRentHandler = new HouseRentSAXHandler();
			parser.parse(houseRentFilePath, houseRentHandler);
			List<HouseDeal> houseRents = houseRentHandler.getHouses();
			
			size = aptDeals.size() + houseDeals.size() + aptRents.size() + houseRents.size();
			
			deals = new HashMap<String, List<HouseDeal>>();
			
			deals.put(HouseDeal.APT_DEAL, aptDeals);
			deals.put(HouseDeal.APT_RENT, aptRents);
			deals.put(HouseDeal.HOUSE_DEAL, houseDeals);
			deals.put(HouseDeal.HOUSE_RENT, houseRents);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public Map<String, List<HouseDeal>> getDeals() {
		return deals;
	}
	public void setDeals(HashMap<String, List<HouseDeal>> deals) {
		this.deals = deals;
	}
	public Map<String, HouseInfo> getHouseInfo() {
		return houseInfo;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setHouseInfo(Map<String, HouseInfo> houseInfo) {
		this.houseInfo = houseInfo;
	}

	public List<EnviromentMapInfo> getEnvInfo() {
		return envInfo;
	}

	public void setEnvInfo(List<EnviromentMapInfo> EnvInfo) {
		envInfo = EnvInfo;
	}

	public List<StoreMapInfo> getStoreInfo() {
		return storeInfo;
	}

	public void setStoreInfo(List<StoreMapInfo> storeInfo) {
		this.storeInfo = storeInfo;
	}
	
//	public static void main(String[] args) {
//		new HouseSaxParser();
//	}
}

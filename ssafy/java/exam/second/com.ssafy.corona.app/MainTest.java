package com.ssafy.corona.app;

import java.util.*;
import com.ssafy.corona.medical.*;
import com.ssafy.corona.person.*;
import com.ssafy.corona.virus.*;

public class MainTest {
	public static void main(String[] args) {
		////////////////////////////////////////////////////////////
		// main() 메서드는 주석문 해제와 관련된 부분을 제외하고는 수정하는 부분이 없습니다! //
		////////////////////////////////////////////////////////////
		
		
		
		// 00.서술형 문제 //
		//
		//	서술형 문제의 정답은 프로젝트 폴더의 report.txt 파일에 
		//	내용을 작성하여 제출하세요!
		//
		
		
		
		// 10.질병관리 문제 //
		//
		//	아래 11~13번 주석을 해제하여
		//	"정상 출력 예" 와 같이 출력될 수 있도록 
		//	코드들을 디버깅 하세요!
		//
		System.out.println("10.질병관리(코로나,메르스) =================================");
		VirusMgr vmgr=new VirusMgrImpl();
		System.out.println();		
		
 //<- 주석 해제 후 작성 : start ////////////////////////////////
		System.out.println("11.코로나19 등록");
		// 정상 출력 예: 
		// 11.코로나19 등록
		// 코로나19: 등록된 바이러스입니다.
		try {
			vmgr.add(new Mers("메르스15", 2, 1.5));
			vmgr.add(new Corona("코로나19", 3, 2));
			vmgr.add(new Corona("코로나19", 2, 2));
		} catch (DuplicatedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
		
		
		System.out.println("12.바이러스 전체검색");
		// 정상 출력 예: 
		// 12.바이러스 전체검색
		// 메르스15	2	1.5
		// 코로나19	3	2
		Virus[] virus=vmgr.search();
		for(Virus v:virus) {
			System.out.println(v);
		}
		System.out.println();
		
		
		System.out.println("13.코로나15 조회");
		// 정상 출력 예: 
		// 13.코로나15 조회
		// 코로나15: 미등록 바이러스입니다.
		try {
			Virus v=vmgr.search("코로나15");
			System.out.println(v);
		} catch (NotFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
 //<- 주석 해제 후 작성 : end /////////////////////////////////
		
		
		
		// 20.의료진관리 문제 //
		//
		//	아래 21~25번 주석을 해제하여
		//	"정상 출력 예" 와 같이 출력될 수 있도록 
		//	코드들을 디버깅 하세요!
		//
		System.out.println("20.의료진관리(의사,환자) ==================================");
		PersonMgr pmgr=PersonMgrImpl.getInstance();
		System.out.println();		
		
 //<- 주석 해제 후 작성 : start ////////////////////////////////
		System.out.println("21.의사,환자 등록");
		// 정상 출력 예: 
		// 21.의사,환자 등록
		// 등록정상
		pmgr.add(new Doctor( "오싸피",41,"010-1010-0010","101","li001"));
		pmgr.add(new Patient("오싸피",35,"010-0505-0005","두통","101",true));
		pmgr.add(new Doctor( "이닥터",42,"010-2020-0020","101","li002"));
		pmgr.add(new Doctor( "김닥터",43,"010-3030-0030","102","li003"));
		pmgr.add(new Patient("이환자",32,"010-0202-0002","과음","901",false));
		pmgr.add(new Patient("강환자",23,"010-0303-0003","오한","902",true));
		System.out.println("등록정상");
		System.out.println();
		
		
		System.out.println("22.의료진 전체검색");
		// 정상 출력 예: 수정 내용 없음
		// 22.의료진 전체검색
		//오싸피	41	010-1010-0010	101	li001
		//오싸피	35	010-0505-0005	두통	101	true
		//이닥터	42	010-2020-0020	101	li002
		//김닥터	43	010-3030-0030	102	li003
		//이환자	32	010-0202-0002	과음	901	false
		//강환자	23	010-0303-0003	오한	902	true
		List<Person> people=pmgr.search();
		for(Person p : people) {
			System.out.println(p);
		}
		System.out.println();
		
		
		System.out.println("23.오싸피 이름 모두 삭제");
		// 정상 출력 예: 
		// 23.오싸피 이름 모두 삭제
		// 이닥터	42	010-2020-0020	101	li002
		// 김닥터	43	010-3030-0030	102	li003
		// 이환자	32	010-0202-0002	과음	901	false
		// 강환자	23	010-0303-0003	오한	902	true
		pmgr.delete("오싸피");
		for(Person p : pmgr.search()) System.out.println(p);
		System.out.println();
		
		
		System.out.println("24.의료진 정보 people.dat 파일에 저장");
		// 정상 출력 예: 
		// 24.의료진 정보 people.dat 파일에 저장
		// 저장정상
		pmgr.save();
		System.out.println("저장정상");
		System.out.println();
		
		
		System.out.println("25.의료진 정보 people.dat 파일에서 로드");
		// 정상 출력 예: 
		// 25.의료진 정보 people.dat 파일에서 로드
		// 이닥터	42	010-2020-0020	101	li002
		// 김닥터	43	010-3030-0030	102	li003
		// 이환자	32	010-0202-0002	과음	901	false
		// 강환자	23	010-0303-0003	오한	902	true
		pmgr.load();
		for(Person p : pmgr.search()) System.out.println(p);
		System.out.println();
 //<- 주석 해제 후 작성 : end /////////////////////////////////
		
		
		
		// 30.기관관리 문제 //
		//
		//	아래 31~33번 주석을 해제하여
		//	"정상 출력 예" 와 같이 출력될 수 있도록 
		//	코드들을 디버깅 하세요!
		//
		System.out.println("30.기관관리(질병관리청,병원) ===============================");
		OrganizationMgr omgr=new OrganizationMgrImpl();
		System.out.println();
		
 //<- 주석 해제 후 작성 : start ////////////////////////////////
		System.out.println("31.기관 전체검색");
		// 정상 출력 예: 
		// 31.기관 전체검색
		// 질병관리청	200	충북 청주시
		// 싸피병원	15	101	50	5
		// 대학병원	10	102	30	10
		// 동네병원	3	501	10	2
		// 가족병원	10	502	15	5
		List<Organization> orgs=omgr.search();
		for(Organization org : orgs) {
			System.out.println(org);
		}
		System.out.println();
		
	
		System.out.println("32.기관명 오름(가,나,다...)차순 정렬");
		// 정상 출력 예: 
		// 32.기관명 오름(가,나,다...)차순 정렬
		// 가족병원	10	502	15	5
		// 대학병원	10	102	30	10
		// 동네병원	3	501	10	2
		// 싸피병원	15	101	50	5
		// 질병관리청	200	충북 청주시
		Collections.sort(orgs);
		for(Organization org : orgs) {
			System.out.println(org);
		}
		System.out.println();
		
		
		System.out.println("33.싸피병원 조회(기관 이름이 같으면 조회)");
		// 정상 출력 예: 
		// 33.싸피병원 조회(기관 이름이 같으면 조회)
		// 싸피병원	15	101	50	5
		Organization org=omgr.search(new Hospital("싸피병원", 15, "001", 50, 5));
		System.out.println(org);
		System.out.println();
 //<- 주석 해제 후 작성 : end /////////////////////////////////
		
	}
}

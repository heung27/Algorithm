package com.ssafy.happyhouse.view;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.ssafy.happyhouse.model.dto.EnviromentMapInfo;
import com.ssafy.happyhouse.model.dto.HouseDeal;
import com.ssafy.happyhouse.model.dto.HousePageBean;
import com.ssafy.happyhouse.model.dto.StoreMapInfo;
import com.ssafy.happyhouse.model.service.HouseService;
import com.ssafy.happyhouse.model.service.HouseServiceImpl;


public class HouseInfoView{
	
	/**model들 */
	private HouseService 		houseService;
	
	/** main 화면 */
	private JFrame frame;
	private JFrame frame2;
	private JFrame frame3;
	
	/** 주택 목록 화면*/
	// JFrame owner;
	

	/**창 닫기 버튼*/
	//private JButton  closeBt;
	
	/**주택 이미지 표시 Panel*/
	private JLabel	 			imgL;
	private JLabel[] 			houseInfoL;
	
	/**조회 조건*/
	private JCheckBox[]		  	chooseC;
	private JComboBox<String> 	findC; 
	private JTextField		  	wordTf;
	private JButton			  	searchBt;
	
	/**조회 내용 표시할 table*/
	private DefaultTableModel 	houseModel;
	private JTable			  	houseTable;
	private JScrollPane		  	housePan;
	private String[]		  	title = { "번호", "동", "아파트이름", "거래금액", "거래종류" };
	private String[]		  	title2 = { "번호", "업체명", "업종명", "점검일자", "점검구분", "점검사항", "주소" };
	private String[]		  	title3 = { "상가번호", "상호명", "상가정보" };
	
	private DefaultTableModel 	houseModel2;
	private JTable			  	houseTable2;
	private JScrollPane		  	housePan2;
	
	private DefaultTableModel 	houseModel3;
	private JTable			  	houseTable3;
	private JScrollPane		  	housePan3;
	
	/**검색  조건*/
	private String	key;
	
	/**검색할 단어*/
	private String  word;
	private boolean[] searchType = { true, true, true, true };
	private String[] choice = { "all", "dong", "name" };
	
	/**화면에 표시하고 있는 주택*/
	private HouseDeal curHouse;

	
	private void showHouseInfo(int code) {
		
		curHouse = houseService.search(code);
		System.out.println(curHouse);
		
		//foodInfoL[0].setText(""+curfood.getCode());
		houseInfoL[0].setText("");
		houseInfoL[1].setText("");
		houseInfoL[2].setText(curHouse.getAptName());
		houseInfoL[3].setText(""+curHouse.getDealAmount());
		String rent = curHouse.getRentMoney();
		if(rent == null) {
			houseInfoL[4].setText("없음");
		}else {
			houseInfoL[4].setText(curHouse.getRentMoney());
		}
		houseInfoL[5].setText(""+curHouse.getBuildYear());
		houseInfoL[6].setText(curHouse.getArea()+"");
		houseInfoL[7].setText(String.format("%d년 %d월 %d일"
											,curHouse.getDealYear()
											,curHouse.getDealMonth()
											,curHouse.getDealDay()
											));
		houseInfoL[8].setText(curHouse.getDong());
		houseInfoL[9].setText(curHouse.getJibun());
		
		//System.out.println("###############" + curHouse.getImg());
		
		ImageIcon icon = null;
		if( curHouse.getImg() != null && curHouse.getImg().trim().length() != 0) {
			icon = new ImageIcon("img/" + curHouse.getImg());
			System.out.println("#####" + icon.toString() + "####");
		}else {
			icon = new ImageIcon("img/다세대주택.jpg");
		}

		imgL.setIcon(icon);
		  
		  
		Image img = null;
		try {
			img = ImageIO.read(new File("img/"+curHouse.getImg()));
         } catch (IOException ex) {
        	 try {
        		 img = ImageIO.read(new File("img/다세대주택.jpg"));
			} catch (Exception e) {
			}
         }
		img = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		imgL.setIcon(new ImageIcon(img));
	}
	
	public HouseInfoView(){
		/*Service들 생성 */
		houseService = new HouseServiceImpl();
		
		/*메인 화면 설정 */
		frame = new JFrame("HappyHouse -- 아파트 거래 정보");
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				frame.dispose();
			}
		});
		
		setMain();
		
		frame.setSize(1200, 800);
		frame.setResizable(true);
		frame.setVisible(true);
		showHouseInfo(1);
		//showHouses();
	}
	
	public void EnviromentView(String dong){
		frame2 = new JFrame("HappyHouse -- 환경 지도 점검 내역");
		frame2.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				frame2.dispose();
			}
		});
		
		frame2.setSize(600, 800);
		frame2.setResizable(true);
		frame2.setVisible(true);
		
		JPanel rightCenter = new JPanel(new BorderLayout());
		houseModel2 = new DefaultTableModel(title2,20);
		houseTable2 = new JTable(houseModel2);
		housePan2 = new JScrollPane(houseTable2);
		houseTable2.setColumnSelectionAllowed(true);
		rightCenter.add(housePan2,"Center");
		
		List<EnviromentMapInfo> envs = houseService.searchEnv(dong);
		if(envs!=null){
			int i=0;
			String[][]data = new String[envs.size()][7];
			for (EnviromentMapInfo env: envs) {
				data[i][0]= ""+env.getNo();
				data[i][1]= env.getSname();
				data[i][2]= env.getUname();
				data[i][3]= env.getData();
				data[i][4]= env.getGubun();
				data[i][5]= env.getMemo();
				data[i++][6]= env.getAddress();
			}
			houseModel2.setDataVector(data, title2);
		}
		
		frame2.add(rightCenter,"Center");
	}
	
	public void StoreView(String dong){
		frame3 = new JFrame("HappyHouse -- ["+dong+"] 상가 정보");
		frame3.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				frame3.dispose();
			}
		});
		
		frame3.setSize(800, 400);
		frame3.setResizable(true);
		frame3.setVisible(true);
		
		JPanel rightCenter = new JPanel(new BorderLayout());
		houseModel3 = new DefaultTableModel(title3,20);
		houseTable3 = new JTable(houseModel3);
		housePan3 = new JScrollPane(houseTable3);
		houseTable3.setColumnSelectionAllowed(true);
		rightCenter.add(housePan3,"Center");
		
		List<StoreMapInfo> stores = houseService.searchStore(dong);
		if(stores!=null){
			int i=0;
			String[][]data = new String[stores.size()][3];
			for (StoreMapInfo store: stores) {
				data[i][0]= ""+store.getNumber();
				data[i][1]= store.getSname();
				data[i++][2]= store.getAddress();
			}
			houseModel3.setDataVector(data, title3);
		}
		
		frame3.add(rightCenter,"Center");
	}

	/**메인 화면인 주택 목록을 위한 화면 셋팅하는 메서드  */
	public void setMain(){
		
		/*왼쪽 화면을 위한 설정 */
		JPanel left = new JPanel(new BorderLayout());
		JPanel leftCenter = new JPanel(new GridLayout(1, 2));
		JPanel leftR = new JPanel(new GridLayout(10, 2));
		leftR.setBorder(BorderFactory.createEmptyBorder(0 , 10 , 10 , 10));
		
		String[] info= {"","","주택명","거래금액","월세금액","건축연도","전용면적","거래일","법정동","지번"};
		int size = info.length;
		JLabel infoL[] = new JLabel[size];
		houseInfoL = new JLabel[size];
		for (int i = 0; i <size; i++) {
			infoL[i] = new JLabel(info[i]);
			houseInfoL[i]=new JLabel("");
			leftR.add(infoL[i]);
			leftR.add(houseInfoL[i]);
		}
		imgL = new JLabel();
		leftCenter.add(imgL);
		leftCenter.add(leftR);
		
		left.add(new JLabel("아파트 거래 정보", JLabel.CENTER),"North");
		left.add(leftCenter,"Center");
		
		
		/*오른쪽 화면을 위한 설정 */
		JPanel right = new JPanel(new BorderLayout());
		JPanel rightTop = new JPanel(new GridLayout(4, 2));
		JPanel rightTop1 = new JPanel(new GridLayout(1, 4));
		String[] chooseMeg= { "아파트 매매", "아파트 전월세", "주택 매매", "주택 전월세"};
		chooseC = new JCheckBox[chooseMeg.length];
		for (int i = 0, len= chooseMeg.length; i < len; i++) {
			chooseC[i] = new JCheckBox(chooseMeg[i], true);
			rightTop1.add(chooseC[i]);
		}
		
		
		JPanel rightTop2 = new JPanel(new GridLayout(1, 3));
		String[] item = {"---all---","동","아파트 이름"}; 
		findC = new JComboBox<String>(item);
		wordTf = new JTextField();
		searchBt = new JButton("검색");
		
		rightTop2.add(findC);
		rightTop2.add(wordTf);
		rightTop2.add(searchBt);
		
		rightTop.add(new Label(""));
		rightTop.add(rightTop1);
		rightTop.add(rightTop2);		
		rightTop.add(new Label(""));
		
		JPanel rightCenter = new JPanel(new BorderLayout());
		houseModel = new DefaultTableModel(title,20);
		houseTable = new JTable(houseModel);
		housePan = new JScrollPane(houseTable);
		houseTable.setColumnSelectionAllowed(true);
		rightCenter.add(new JLabel("거래 내역", JLabel.CENTER),"North");
		rightCenter.add(housePan,"Center");
		
		right.add(rightTop,"North");
		right.add(rightCenter,"Center");
		
		JPanel mainP = new JPanel(new GridLayout(1, 2));
		
		mainP.add(left);
		mainP.add(right);
		
		mainP.setBorder(BorderFactory.createEmptyBorder(20 , 10 , 10 , 10));
		frame.add(mainP,"Center");
		
		/*이벤트 연결*/

		houseTable.addMouseListener( new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int row =  houseTable.getSelectedRow();
				System.out.println("선택된 row : " + row);
				System.out.println("선택된 row의 column 값 :"+houseModel.getValueAt(row, 0));
				int code = Integer.parseInt(((String)houseModel.getValueAt(row, 0)).trim());
				showHouseInfo(code);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				int row =  houseTable.getSelectedRow();
				String dong = ((String)houseModel.getValueAt(row, 1)).trim();
				EnviromentView(dong);
				StoreView(dong);
			}
		});
		
		// complete code #01
		// 아래의 코드를 참조하여 아래 라인을 uncomment 하고 searchBt.addActionList() 를 Lambda 표현식으로 바꾸세요.
		searchBt.addActionListener(e -> searchHouses());
		
		// 참조코드 시작 - 위 코드를 완성 후 삭제 또는 comment 처리하세요.
//		ActionListener buttonHandler = new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				searchHouses();
//			}
//		};
//		
//		searchBt.addActionListener( buttonHandler );
		// 참조코드 종료
		
		showHouses();
	}
	
	
	/**검색 조건에 맞는 주택 정보 검색 */
	private void searchHouses() {
		for(int i = 0, size = chooseC.length; i<size; i++) {
			if(chooseC[i].isSelected()) {
				searchType[i] = true;
			}else {
				searchType[i] = false;
			}
		}
		word = wordTf.getText().trim();
		key = choice[findC.getSelectedIndex()];
		System.out.println("word:"+word+" key:"+key);
		showHouses();		
	}
	/**
	 * 주택 목록을  갱신하기 위한 메서드 
	 */
	public void showHouses(){
		HousePageBean  bean = new HousePageBean();
		bean.setSearchType(searchType);
		if(key !=null) {
			if(key.equals("dong")) {
				bean.setDong(word);
			}else if(key.equals("name")) {
				bean.setAptname(word);
			}
		}
		
		List<HouseDeal> deals = houseService.searchAll(bean);
		if(deals!=null){
			int i=0;
			String[][]data = new String[deals.size()][5];
			for (HouseDeal deal: deals) {
				data[i][0]= ""+deal.getNo();
				data[i][1]= deal.getDong();
				data[i][2]= deal.getAptName();
				data[i][3]= deal.getDealAmount();
				data[i++][4]= deal.getType();
			}
			houseModel.setDataVector(data, title);
		}
	}
//	public static void main(String[] args) {
//		new HouseInfoView();
//	}
	
}



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		LinkedList<String> list1 = new LinkedList<>();
		
		list.remove(120000);
		list1.get(120000);
//		배열 : 메모리 최적화, 선택작업 무지막지 많음, 삽입 삭제에 불리
//		리스트 : 메모리 낭비, 선택작업 별로 없음, 삽입 삭제가 많으면 유리
	}
}

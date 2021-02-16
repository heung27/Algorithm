import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
10
1 1 4
2 1 6
3 6 10
4 5 7
5 3 8
6 5 9
7 3 5
8 8 11
9 2 13
10 12 14
 */
public class MeetingRoomTest {
	
	static class MeetingRoom implements Comparable<MeetingRoom> {
		int no, start, end;

		public MeetingRoom(int no, int start, int end) {
			super();
			this.no = no;
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(MeetingRoom o) {
			int diff = this.end - o.end;
			return diff != 0 ? diff : this.start-o.start; 
		}

		@Override
		public String toString() {
			return "MeetingRoom [no=" + no + ", start=" + start + ", end=" + end + "]";
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N =  sc.nextInt();
		MeetingRoom[] m = new MeetingRoom[N];
		
		for (int i=0; i<N; i++) {
			m[i] = new MeetingRoom(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		
		List<MeetingRoom> list = getSchedule(m);
		for (MeetingRoom meetingroom : list) {
			System.out.println(meetingroom);
		}
	}
	
	static List<MeetingRoom> getSchedule(MeetingRoom[] m) {
		ArrayList<MeetingRoom> list = new ArrayList<MeetingRoom>();
		
		Arrays.sort(m);
		list.add(m[0]); // 첫 회의는 무조건 배정
		for (int i=1, size=m.length; i<size; i++) {
			if (list.get(list.size()-1).end <= m[i].start) {
				list.add(m[i]);
			}
		}
		return list;
	}
}


public class CountingSort {
	
	public static void countingSort(int[] list) {
		final int SIZE = list.length;
		int[] result = new int[SIZE];
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for (int i=0; i<SIZE; i++) {
			if (list[i] < min) min = list[i];
			if (list[i] > max) max = list[i];
		}
		
		// 배열 원소의 최대값 표현 가능한 크기의 카운팅 배열 생성
		int[] count = new int[max+1];
		
		// 배열 원소 카운팅
		for (int i=0; i<SIZE; i++) {
			count[list[i]]++;
		}
		
		// 카운팅 병형: 누적합
		for (int i=min+1; i<=max; i++) {
			count[i] = count[i-1] + count[i];
		}
		
		// 배열 원소 하나씩 들여다보며 결과 배열의 각 원소값에 해당하는 위치에 채움
		for (int i=SIZE-1; i>=0; i--) {
			result[--count[list[i]]] = list[i];
		}
		
		System.arraycopy(result, 0, list, 0, SIZE);
	}
}

/*
[정렬]

버블 정렬 : N^2

선택 정렬 : N^2

개수 정렬(카운팅 정렬) : N + K
학생은 수만명인데, 점수는 0~10점 => 배열 첨자가 값으로 값이 배열 첨자로
영화 평점 5점 만점 => 천 만점 정렬

삽입 정렬 : N => N^2 => 이미 정렬된 상태의 배열에 새로운 항목 추가 정렬 (도서명 정렬)

병합 정렬 : NlogN 보장

퀵 정렬 : 평균 - NlogN, 최악 N^2 => 오름차순 정보를, 내림차순으로 만들때 

*/
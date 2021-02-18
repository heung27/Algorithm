# 1828. 냉장고

### classification
* Greedy

### solution
* 입력되는 화학 물질의 최저 보관 온도와 최고 보관 온도를 배열에 저장
* 최고 보관 온도가 낮은 순서로 정렬
* 최고 보관 온도가 같을 경우 최저 보관 온도가 낮은 순서로 정렬
* 배열의 처음부터 끝까지 탐색을 진행
* (현재 최고 보관 온도 < 다음 최저 보관 온도) 이면 cnt + 1하고 다음 화학 물질은 현재 화학 물질이 됨

### remind
* Greedy algorithm
* Sort

### link
http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1101&sca=99&sfl=wr_subject&stx=%EB%83%89%EC%9E%A5%EA%B3%A0
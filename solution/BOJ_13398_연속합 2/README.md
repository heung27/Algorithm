# 13398. 연속합 2

### classification
* Dynamic programming
* Prefix sum

### solution
* 왼쪽부터 오른쪽으로, 오른쪽에서 왼쪽으로 가는 누적합을 각각 구함
* left[i] = Math.max(numbers[i], left[i-1] + numbers[i]);
* right[j] = Math.max(numbers[j], right[j+1] + numbers[j]);
* 어떤 한 수를 제거하지 않는 경우도 있기 때문에 left또는 right에서 가장 큰 수를 max로 초기화
* 어떤 한 수를 제거하는 경우는 양 옆의 누적합을 더해주면 알 수 있음 (left[i-1] + right[i+1])
* 인덱스 1부터 N-2까지 수를 제거해보고 최댓값을 갱신함

### link
https://www.acmicpc.net/problem/13398
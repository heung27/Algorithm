# [Level4] 가사 검색

## Classification
* 문자열
* 트라이 구조

## Code
```java
import java.util.*;

public class programmers_가사_검색 {
	class Solution {
	    public int[] solution(String[] words, String[] queries) {

	        Trie prefix = new Trie();
			Trie suffix = new Trie();
	        
	        for (int i=0; i<words.length; i++) {
				prefix.insert(words[i]);
				
				StringBuilder rev = new StringBuilder(words[i]).reverse();
				suffix.insert(rev.toString());
			}
			
			int[] answer = new int[queries.length];
	        
			for (int i=0; i<queries.length; i++) {
				if (queries[i].charAt(0) != '?') {
					answer[i] = prefix.contains(queries[i]);
				}
				else {
					StringBuilder rev = new StringBuilder(queries[i]).reverse();
					answer[i] = suffix.contains(rev.toString());
				}
			}
	        return answer;
	    }
	}

	class Node {
		private Map<Character, Node> childNodes;
		private Map<Integer, Integer> cnt;
		
		public Node() {
			this.childNodes = new HashMap<>();
			this.cnt = new HashMap<>();
		}

		public Map<Character, Node> getChildNodes() {
			return childNodes;
		}
		
		public Map<Integer, Integer> getCnt() {
			return cnt;
		}
	}

	class Trie {
		private Node rootNode;

		public Trie() {
			this.rootNode = new Node();
		}
		
		public void insert(String word) {
			Node node = this.rootNode;
			node.getCnt().put(word.length(), node.getCnt().getOrDefault(word.length(), 0)+1);
			
			for (int i=0; i<word.length(); i++) {
				node = node.getChildNodes().computeIfAbsent(word.charAt(i), key -> new Node());
				node.getCnt().put(word.length(), node.getCnt().getOrDefault(word.length(), 0)+1);
			}
		}
		
		public int contains(String word) {
			Node node = this.rootNode;
			
			for (int i=0; i<word.length(); i++) {
				char c = word.charAt(i);
				if (c == '?') break;
				                                                                                                                                     
				Node temp = node.getChildNodes().get(c);
				
				if (temp == null) return 0;
				node = temp;
			}
			
			return node.getCnt().getOrDefault(word.length(), 0);
		}
	}
}
```

## Link
> https://programmers.co.kr/learn/courses/30/lessons/60060

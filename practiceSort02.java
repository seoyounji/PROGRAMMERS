package PROGRAMMERS;

import java.util.Arrays;
import java.util.Comparator;

//프로그래머스 코딩테스트 연습 / 정렬 / 가장 큰 수
public class practiceSort02 {

	public String solution(int[] numbers) {
		String[] result = new String[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			result[i] = String.valueOf(numbers[i]);
		}
		Arrays.sort(result, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2+o1).compareTo(o1+o2);
			}
		});
		String answer = "";
		if(result[0].equals("0")) answer = "0";
		else {
			for(String i : result) answer += i;
		}
		return answer;
	}

}

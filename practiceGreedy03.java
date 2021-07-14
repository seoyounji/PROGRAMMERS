package PROGRAMMERS;

//프로그래머스 코딩테스트 연습 / 탐욕법 / 큰 수 만들기
public class practiceGreedy03 {

	public String solution(String number, int k) {
        int[] numbers = new int[number.length()];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = number.charAt(i) - '0';
		}
        String answer = "";
        int nums = number.length() - k;
        int num = number.length() - nums;
        StringBuilder sb = new StringBuilder();

        int index = -1;

        for (int i = 0; i < nums; i++) {
            int max = -1;
            int tmp = 0;
            for (int j = index+1; j <= num+i; j++) {
                if(max < numbers[j]) {
                    max = numbers[j];
                    tmp = j;
                }
            }
            index = tmp;
            sb.append(max);
        }
        answer = sb.toString();
		return answer;
    }
}

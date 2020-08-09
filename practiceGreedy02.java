package PROGRAMMERS;

import java.util.Arrays;

//프로그래머스 코딩테스트 연습 / 탐욕법 / 조이스틱
public class practiceGreedy02 {
	
	char[] tar;
    char[] cur;
    int min = 10000;
    int len;

    void dfs(int position, int count) {
        boolean check = true;
        cur[position] = tar[position];
        for (int i = 0; i < tar.length; i++) {
            if (tar[i] != cur[i]) {
                check = false;
                break;
            }
        }
        if (check) {
            min = Math.min(min, count);
        } else {
            int right = 1;
            while (true) {
                int pos = position + right < len ? position + right : position + right - len;
                if (tar[pos] != cur[pos]) {
                    break;
                } else {
                    right++;
                }
            }
            int left = 1;
            while (true) {
                int pos = position - left >= 0 ? position - left : len + position - left;
                if (tar[pos] != cur[pos]) {
                    break;
                } else {
                    left++;
                }
            }
            if (right < left) {
                int pos = position + right < len ? position + right : position + right - len;
                dfs(pos, count + right);
            } else if (right > left) {
                int pos = position - left >= 0 ? position - left : len + position - left;
                dfs(pos, count + left);
            } else {

                int rightPosition = position + right < len ? position + right : position + right - len;
                int leftPosition = position - left >= 0 ? position - left : len + position - left;
                if (rightPosition != leftPosition) {
                    dfs(rightPosition, count + right);
                    dfs(leftPosition, count + left);
                } else {
                    dfs(rightPosition, count + right);
                }
            }
        }

        cur[position] = 'A';
    }

    public int count(char target) {
        int value = target - 'A';
        return value < 14 ? value : 26 - value;
    }

    public int solution(String name) {

        this.tar = name.toCharArray();
        this.cur = new char[tar.length];
        this.len = tar.length;
        Arrays.fill(cur, 'A');
        int answer = 0;
        for (char c : tar) {
            answer += count(c);
        }

        dfs(0, 0);

        answer += min;

        return answer;
    }
}

public class BaseProblem {
    //    https://school.programmers.co.kr/learn/courses/30/lessons/68935
    public static void main(String[] args) {
        int n = 125;
        int answer = 0;

        String temp = "";
        while (n > 0) {
            temp += Integer.toString(n % 3);
            n /= 3;
        }
        int temp_len = temp.length() - 1;
        for (int i = 0; i < temp.length(); i++) {
            answer += Integer.parseInt(String.valueOf(temp.charAt(i))) * (int) Math.pow(3, temp_len);
            temp_len--;
        }
        System.out.println(answer);
    }
}

//또는 한 줄로 해결 가능 -> 하지만 요건 응용하기 어려움
//return Integer.parseInt(new StringBuilder(Integer.toString(n, 3)).reverse().toString(), 3);
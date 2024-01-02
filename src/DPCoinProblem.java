public class DPCoinProblem {
    //    DP = 기억 알고리즘, memoization
//    점화식과 memoization
//    ex) 계단 오르기의 경우의 수
    public static void main(String[] args) {
//        1, 4, 5원의 동전이 있을 때 13원이 되게 하는 최소의 동전의 개수 -> DP 활용!
        int amount = 13;
        int[] coins = {1, 4, 5};

        int[] arr = new int[amount + 1];

        arr[1] = 1;
        for (int i = 2; i <= amount; i++) {
            int min = amount;
            for (int c : coins) {
                if(i-c<0) continue;
                if(min > arr[i-c]){
                    min = arr[i-c];
                }
            }
            arr[i] = min + 1;
        }
        System.out.println(arr[13]);

//        for (int i = 1; i <= 13; i++) {
//            if (i == 1 || i == 2 || i == 3) {
//                arr[i] = 1;
//            } else if (i == 4) {
//                arr[i] = 4;
//            } else if (i == 5) {
//                arr[i] = 5;
//            } else {
//                arr[i] = Math.min(Math.min(arr[i - 1], arr[i - 4]), arr[i - 5]) + 1;
//            }
//        }
//        System.out.println(arr[13]);


    }
}

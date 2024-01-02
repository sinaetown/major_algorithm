public class GreedyCoinProblem {
    public static void main(String[] args) {
        int[] coins = {1, 5, 10, 25};
        int amount = 99;
//        최소동전의 개수 산출
        int sumOfCoins = 0;
        int c = 0;
        if (amount / 25 != 0) {
            c = amount / 25;
            amount -= 25 * c;
            sumOfCoins += c;
        }
        if (amount / 10 != 0) {
            c = amount / 10;
            amount -= 10 * c;
            sumOfCoins += c;
        }
        if (amount / 5 != 0) {
            c = amount / 5;
            amount = 5 * c;
            sumOfCoins += c;
        }
        sumOfCoins += amount / 1;
        System.out.println(sumOfCoins);
    }
}

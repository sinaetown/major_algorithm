public class BinarySearch {
    public static void main(String[] args) {
//        정렬이 되어있어야 이분탐색 가능
        int[] numbers = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int start = 0;
        int end = numbers.length - 1;
        int find = 7;

        while (start <= end) {
            int middle = (start + end) / 2;
            if (find == numbers[middle]) {
                System.out.println(middle);
                break;
            }
            if (find < numbers[middle]) {
                end = middle + 1;
            } else if (find > numbers[middle]) {
                start = middle - 1;
            }
        }
    }

}

import java.util.*;

public class HeapSort {
    public static void main(String[] args) {
//        7
//       6 5
//      8 3 5 9
//     1 7
        int[] arr = {7, 6, 5, 8, 3, 5, 9, 1, 7};
//        최초 힙구성 : n/2번만큼 heapify
        int n = arr.length;
        for (int i = (n) / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }

//        최초 heap구성 이후에 root node와 마지막 node를 change
        for (int j = n - 1; j > 0; j--) {
            int temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            heapify(arr, 0, j);
        }
        System.out.println(Arrays.toString(arr));
    }

    //    신애 코드!
    static void heapify(int[] arr, int root, int n) {
        boolean isChanged = false;
        int maxInd = 0;
//    xx조건의 경우에 change : right left 비교해서 자리 change && 자식이 있는지 없는지 체크 (arr의 length보다 작아야!)
        if (2 * root + 2 < n) {
            if (arr[2 * root + 1] > arr[2 * root + 2]) maxInd = 2 * root + 1;
            else maxInd = 2 * root + 2;
            if (arr[maxInd] > arr[root]) {
                int temp = arr[root];
                arr[root] = arr[maxInd];
                arr[maxInd] = temp;
                isChanged = true;
            }
        }
        if (isChanged) {
            heapify(arr, maxInd, n);
        }
    }


//    강사님 heapify 코드 !
//    static void heapify(int[] arr, int root, int n) {
////        xx조건의 경우에 change로직 : left와 right비교해서 자리 change
//        int max_index = root;
//        int left = root * 2 + 1;
//        int right = root * 2 + 2;
//        if (left < n && arr[max_index] < arr[left]) {
//            max_index = left;
//        }
//        if (right < n && arr[max_index] < arr[right]) {
//            max_index = right;
//        }
//        if (max_index != root) {
//            int temp = arr[root];
//            arr[root] = arr[max_index];
//            arr[max_index] = temp;
//            heapify(arr, max_index, n);
//        }
//    }
}

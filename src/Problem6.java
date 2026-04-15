import java.util.*;

public class Problem6 {

    static boolean linearSearch(int[] arr, int target) {
        int comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == target) {
                System.out.println("Linear: Found at index " + i);
                System.out.println("Comparisons: " + comparisons);
                return true;
            }
        }

        System.out.println("Linear: Not found");
        System.out.println("Comparisons: " + comparisons);
        return false;
    }

    static void binaryFloorCeiling(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int floor = -1, ceiling = -1;
        int comparisons = 0;

        while (low <= high) {
            comparisons++;
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                floor = ceiling = arr[mid];
                break;
            } else if (arr[mid] < target) {
                floor = arr[mid];
                low = mid + 1;
            } else {
                ceiling = arr[mid];
                high = mid - 1;
            }
        }

        System.out.println("Binary Floor: " + floor);
        System.out.println("Binary Ceiling: " + ceiling);
        System.out.println("Comparisons: " + comparisons);
    }

    static int findInsertionPoint(int[] arr, int target) {
        int low = 0, high = arr.length;

        while (low < high) {
            int mid = (low + high) / 2;

            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public static void main(String[] args) {

        int[] risks = {10, 25, 50, 100};

        linearSearch(risks, 30);

        binaryFloorCeiling(risks, 30);

        int pos = findInsertionPoint(risks, 30);
        System.out.println("Insertion index for 30: " + pos);
    }
}
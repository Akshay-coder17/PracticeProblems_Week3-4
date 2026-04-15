import java.util.*;

class Problem1 {

    static class Transaction {
        String id;
        double fee;
        String timestamp;

        Transaction(String id, double fee, String timestamp) {
            this.id = id;
            this.fee = fee;
            this.timestamp = timestamp;
        }

        public String toString() {
            return id + ":" + fee + "@" + timestamp;
        }
    }

    static void bubbleSort(List<Transaction> list) {
        int n = list.size();
        int passes = 0, swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            passes++;

            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).fee > list.get(j + 1).fee) {
                    Collections.swap(list, j, j + 1);
                    swaps++;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }

        System.out.println(list);
    }

    public static void main(String[] args) {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("id1", 10.5, "10:00"));
        transactions.add(new Transaction("id2", 25.0, "09:30"));
        transactions.add(new Transaction("id3", 5.0, "10:15"));

        bubbleSort(transactions);
    }
}

class Problem2 {

    static class Client {
        String name;
        int riskScore;
        double accountBalance;

        Client(String name, int riskScore, double accountBalance) {
            this.name = name;
            this.riskScore = riskScore;
            this.accountBalance = accountBalance;
        }

        public String toString() {
            return name + ":" + riskScore;
        }
    }

    static void insertionSort(Client[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Client key = arr[i];
            int j = i - 1;

            while (j >= 0 &&
                    (arr[j].riskScore < key.riskScore ||
                            (arr[j].riskScore == key.riskScore &&
                                    arr[j].accountBalance < key.accountBalance))) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Client[] clients = {
                new Client("clientC", 80, 5000),
                new Client("clientA", 20, 2000),
                new Client("clientB", 50, 3000)
        };

        insertionSort(clients);
    }
}

class Problem3 {

    static class Trade {
        String id;
        int volume;

        Trade(String id, int volume) {
            this.id = id;
            this.volume = volume;
        }

        public String toString() {
            return id + ":" + volume;
        }
    }

    static void mergeSort(Trade[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    static void merge(Trade[] arr, int l, int m, int r) {
        Trade[] temp = new Trade[r - l + 1];
        int i = l, j = m + 1, k = 0;

        while (i <= m && j <= r) {
            if (arr[i].volume <= arr[j].volume) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }

        while (i <= m) temp[k++] = arr[i++];
        while (j <= r) temp[k++] = arr[j++];

        for (i = l, k = 0; i <= r; i++, k++) arr[i] = temp[k];
    }

    public static void main(String[] args) {
        Trade[] trades = {
                new Trade("t1", 500),
                new Trade("t2", 100),
                new Trade("t3", 300)
        };

        mergeSort(trades, 0, trades.length - 1);
        System.out.println(Arrays.toString(trades));
    }
}

class Problem4 {

    static class Asset {
        String name;
        double returnRate;
        double volatility;

        Asset(String name, double returnRate, double volatility) {
            this.name = name;
            this.returnRate = returnRate;
            this.volatility = volatility;
        }

        public String toString() {
            return name + ":" + returnRate;
        }
    }

    static void quickSort(Asset[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(Asset[] arr, int low, int high) {
        Asset pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].returnRate > pivot.returnRate) {
                i++;
                Asset t = arr[i]; arr[i] = arr[j]; arr[j] = t;
            }
        }

        Asset t = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = t;
        return i + 1;
    }

    public static void main(String[] args) {
        Asset[] assets = {
                new Asset("A", 12, 5),
                new Asset("B", 8, 7),
                new Asset("C", 15, 4)
        };

        quickSort(assets, 0, assets.length - 1);
        System.out.println(Arrays.toString(assets));
    }
}

class Problem5 {

    static int binarySearch(String[] arr, String target) {
        int l = 0, h = arr.length - 1;

        while (l <= h) {
            int m = (l + h) / 2;
            int cmp = arr[m].compareTo(target);

            if (cmp == 0) return m;
            else if (cmp < 0) l = m + 1;
            else h = m - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] logs = {"accA", "accB", "accC"};
        System.out.println(binarySearch(logs, "accB"));
    }
}

class Problem6 {

    static int findInsertionPoint(int[] arr, int target) {
        int low = 0, high = arr.length;

        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] < target) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] arr = {10, 25, 50, 100};
        System.out.println(findInsertionPoint(arr, 30));
    }
}

public class AllProblems {

    public static void main(String[] args) {

        System.out.println("Problem1:");
        Problem1.main(args);

        System.out.println("\nProblem2:");
        Problem2.main(args);

        System.out.println("\nProblem3:");
        Problem3.main(args);

        System.out.println("\nProblem4:");
        Problem4.main(args);

        System.out.println("\nProblem5:");
        Problem5.main(args);

        System.out.println("\nProblem6:");
        Problem6.main(args);
    }
}

import java.util.*;

class Main {

    class Pair {
        int val, index;
        Pair(int v, int i) {
            val = v;
            index = i;
        }
    }

    int[] result;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        result = new int[n];

        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], i);
        }

        mergeSort(arr, 0, n - 1);

        List<Integer> ans = new ArrayList<>();
        for (int x : result) ans.add(x);
        return ans;
    }

    void mergeSort(Pair[] arr, int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    void merge(Pair[] arr, int left, int mid, int right) {
        List<Pair> temp = new ArrayList<>();

        int i = left;
        int j = mid + 1;
        int count = 0;

        while (i <= mid && j <= right) {
            if (arr[j].val < arr[i].val) {
                count++;
                temp.add(arr[j]);
                j++;
            } else {
                result[arr[i].index] += count;
                temp.add(arr[i]);
                i++;
            }
        }

        while (i <= mid) {
            result[arr[i].index] += count;
            temp.add(arr[i]);
            i++;
        }

        while (j <= right) {
            temp.add(arr[j]);
            j++;
        }

        for (int k = left; k <= right; k++) {
            arr[k] = temp.get(k - left);
        }
    }
}
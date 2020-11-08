package Problem1;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static List<List<Integer>> permute(int[] nums) {
        if (nums == null) {
            return null;
        }
        List<List<Integer>> bigList = new ArrayList<>();
        if (nums.length == 0) {
            ArrayList<Integer> emptyList = new ArrayList<>();
            bigList.add(emptyList);
            return bigList;
        }



        return partialPermute(nums, 0, nums.length - 1, bigList);
    }

    //This algorithm based on https://stackoverflow.com/questions/28794268/go-through-all-permutations-of-an-array-recursively
    private static List<List<Integer>> partialPermute(int[] nums, int i, int end, List<List<Integer>> bigPermuteList) {
        int j;
        if (i == end) {
            bigPermuteList.add(convertArraytoArrayList(nums));
        } else {
            for ( j = i; j <= end; j++) {
                swap(nums, i, j);
                partialPermute(nums, i + 1, end, bigPermuteList);
                swap(nums, i, j);
            }
        }
        return bigPermuteList;
    }

    private static ArrayList<Integer> convertArraytoArrayList (int[] nums) {
        ArrayList<Integer> arrayList = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            arrayList.add(nums[i]);
        }
        return arrayList;
    }

    private static void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;

    }
}

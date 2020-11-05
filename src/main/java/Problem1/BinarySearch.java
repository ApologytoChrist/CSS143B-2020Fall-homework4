package Problem1;

public class BinarySearch {

    // This is to be done recursively
    // Do not change signature (return type, function name, parameter types)
    // Add a helper function for recursion calls
    public static int binarySearch(int[] data, int target) {
        // homework
        if (data != null && data.length >= 1) {
            int low = 0;
            int high = data.length - 1;

            return partialBinarySearch(data,target,low, high);


        } return -1;
    }

    private static int partialBinarySearch(int[] data, int target, int low, int high) {
        int median = low + (high - low) / 2;
        if (data[median] == target) {
            return median;
        } else if (low == high) {
            return -1;
        } else if (target < data[median]) {
            return partialBinarySearch(data, target, low, median - 1);

        } else if (target > data[median]) {
            return partialBinarySearch(data, target, median + 1, high);
        }
        return -1;
    }
}

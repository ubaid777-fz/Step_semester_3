public class PlacementCutoff {
    static int kthHighest(int[] marks, int k) {
        int target = marks.length - k;
        int left = 0, right = marks.length - 1;
        while (left <= right) {
            int pivotIndex = partition(marks, left, right);
            if (pivotIndex == target) return marks[pivotIndex];
            else if (pivotIndex > target) right = pivotIndex - 1;
            else left = pivotIndex + 1;
        }
        return -1;
    }
    static int partition(int[] marks, int left, int right) {
        int pivot = marks[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (marks[j] <= pivot) {
                int temp = marks[i];
                marks[i] = marks[j];
                marks[j] = temp;
                i++;
            }
        }
        int temp = marks[i];
        marks[i] = marks[right];
        marks[right] = temp;
        return i;
    }
    public static void main(String[] args) {
        int[] marks = {72, 95, 60, 88, 79};
        System.out.println(kthHighest(marks, 2));
    }
}
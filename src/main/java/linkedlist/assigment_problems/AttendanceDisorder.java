public class AttendanceDisorder {
    static long countInversions(int[] roll) {
        int[] temp = new int[roll.length];
        return mergeSort(roll, temp, 0, roll.length - 1);
    }
    static long mergeSort(int[] roll, int[] temp, int left, int right) {
        if (left >= right) return 0;
        int mid = (left + right) / 2;
        long count = 0;
        count += mergeSort(roll, temp, left, mid);
        count += mergeSort(roll, temp, mid + 1, right);
        count += merge(roll, temp, left, mid, right);
        return count;
    }
    static long merge(int[] roll, int[] temp, int left, int mid, int right) {
        int i = left, j = mid + 1, k = left;
        long count = 0;
        while (i <= mid && j <= right) {
            if (roll[i] <= roll[j]) temp[k++] = roll[i++];
            else {
                temp[k++] = roll[j++];
                count += mid - i + 1;
            }
        }
        while (i <= mid) temp[k++] = roll[i++];
        while (j <= right) temp[k++] = roll[j++];
        for (i = left; i <= right; i++) roll[i] = temp[i];
        return count;
    }
    public static void main(String[] args) {
        int[] roll = {2, 4, 1, 3, 5};
        System.out.println(countInversions(roll));
    }
}
public class WarehouseSummary {

    public static Object[] warehouseSummary(int[][] grid) {
        int totalItems = 0;
        int max = grid[0][0];
        int maxRow = 0;
        int maxCol = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                totalItems += grid[i][j];

                if (grid[i][j] > max) {
                    max = grid[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        return new Object[]{totalItems, new int[]{maxRow, maxCol}};
    }

    public static void main(String[] args) {
        int[][] grid = {
            {4, 9, 2},
            {7, 1, 6},
            {3, 12, 5}
        };

        Object[] result = warehouseSummary(grid);

        System.out.println("(" + result[0] + ", (" +
                ((int[]) result[1])[0] + ", " +
                ((int[]) result[1])[1] + "))");
    }
}

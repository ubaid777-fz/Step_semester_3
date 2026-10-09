import java.util.HashMap;

public class PopularCanteenOrder {

    public static Object[] mostPopular(String[] orders) {
        HashMap<String, Integer> frequency = new HashMap<>();

        for (String item : orders) {
            frequency.put(item, frequency.getOrDefault(item, 0) + 1);
        }

        String popularItem = orders[0];
        int maxCount = frequency.get(popularItem);

        for (String item : orders) {
            int count = frequency.get(item);

            if (count > maxCount) {
                maxCount = count;
                popularItem = item;
            }
        }

        return new Object[]{popularItem, maxCount};
    }

    public static void main(String[] args) {
        String[] orders = {
            "dosa", "idli", "vada", "dosa",
            "idli", "dosa", "tea"
        };

        Object[] result = mostPopular(orders);
        System.out.println("(" + result[0] + ", " + result[1] + ")");
    }
}

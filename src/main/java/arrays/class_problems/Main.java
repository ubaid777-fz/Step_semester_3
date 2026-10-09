public class Main {

    public static String findBook(String[][] catalog, String targetIsbn) {
        int low = 0;
        int high = catalog.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int result = catalog[mid][0].compareTo(targetIsbn);

            if (result == 0) {
                return catalog[mid][1];
            } else if (result < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return "Not Found";
    }

    public static void main(String[] args) {
        String[][] catalog = {
            {"0001234567", "Book A"},
            {"0003334445", "Classic Mythology"},
            {"0005656567", "Book C"}
        };

        System.out.println(findBook(catalog, "0003334445"));
        System.out.println(findBook(catalog, "0009998887"));
    }
}

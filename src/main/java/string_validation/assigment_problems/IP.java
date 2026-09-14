import java.util.*;

public class IP {
    static void parseInventoryRecord(String csvLine) {
        String[] fields = csvLine.split(",");
        if (fields.length != 3) { System.out.println("Invalid Record"); return; }
        String product = fields[0].trim(), sku = fields[1].trim(), quantity = fields[2].trim();
        System.out.println("Product: " + product + " | SKU: " + sku + " | Qty: " + quantity);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); System.out.print("Enter inventory record: "); String csvLine = sc.nextLine();
        parseInventoryRecord(csvLine); sc.close();
    }
}
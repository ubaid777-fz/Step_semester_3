import java.util.*;

class Account {
    String id;
    int balance;
    Account(String id, int balance) { this.id = id; this.balance = balance; }
    boolean withdraw(int amount) { return false; }
}

class Savings extends Account {
    Savings(String id, int balance) { super(id, balance); }
    boolean withdraw(int amount) {
        if (balance - amount >= 1000) { balance -= amount; return true; }
        return false;
    }
}

class Current extends Account {
    Current(String id, int balance) { super(id, balance); }
    boolean withdraw(int amount) {
        if (balance - amount >= -5000) { balance -= amount; return true; }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Account> accounts = new HashMap<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] p = line.split(" ");

            if (p[0].equals("Savings"))
                accounts.put(p[1], new Savings(p[1], Integer.parseInt(p[2])));
            else if (p[0].equals("Current"))
                accounts.put(p[1], new Current(p[1], Integer.parseInt(p[2])));
            else if (p[0].equals("WITHDRAW")) {
                String id = p[1];
                int amount = Integer.parseInt(p[2]);
                if (!accounts.containsKey(id)) {
                    System.out.println("Account not found");
                    continue;
                }
                Account a = accounts.get(id);
                if (a.withdraw(amount)) System.out.println(id + " balance " + a.balance);
                else if (a instanceof Savings) System.out.println(id + " rejected: minimum balance 1000");
                else System.out.println(id + " rejected: overdraft limit 5000");
            }
        }
    }
}
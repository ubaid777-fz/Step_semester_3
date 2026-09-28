import java.util.ArrayList;
class Customer { String name; Customer(String n){name=n;} }
class Product { String name; double price; Product(String n,double p){name=n;price=p;} }
class OrderItem { Product product; int quantity; OrderItem(Product p,int q){product=p;quantity=q;} double getTotal(){return product.price*quantity;} }
interface PaymentMethod { boolean processPayment(double amount); }
class CreditCardPayment implements PaymentMethod { public boolean processPayment(double amount){return true;} }
class PayPalPayment implements PaymentMethod { public boolean processPayment(double amount){return false;} }
class BankTransferPayment implements PaymentMethod { public boolean processPayment(double amount){return true;} }
class Order {
    Customer customer; ArrayList<OrderItem> items; private String status;
    Order(Customer c){customer=c;items=new ArrayList<>();status="Pending";}
    void addProduct(Product p,int q){items.add(new OrderItem(p,q));}
    double getTotal(){double total=0;for(OrderItem i:items)total+=i.getTotal();return total;}
    void pay(PaymentMethod method,String methodName){
        if(items.isEmpty()){System.out.println("Cannot process payment for an empty order.");return;}
        System.out.println("Payment initiated via "+methodName+" for Order "+customer.name+".");
        boolean success=method.processPayment(getTotal());
        if(success){status="Paid";System.out.println("Payment for Order "+customer.name+" successful.");System.out.println("Order status: Paid.");}
        else{System.out.println("Payment for Order "+customer.name+" failed.");System.out.println("Order status: "+status+".");}
    }
}
public class PaymentDemo {
    public static void main(String[] args){
        Customer x=new Customer("X"); Product a=new Product("Product A",100),b=new Product("Product B",200);
        Order orderX=new Order(x);orderX.addProduct(a,2);orderX.addProduct(b,1);
        System.out.println("Order created for Customer X.");orderX.pay(new CreditCardPayment(),"Credit Card");
        Customer y=new Customer("Y");Order orderY=new Order(y);orderY.pay(new CreditCardPayment(),"Credit Card");
        Customer z=new Customer("Z");Product c=new Product("Product C",300);Order orderZ=new Order(z);orderZ.addProduct(c,1);
        System.out.println("Order created for Customer Z.");orderZ.pay(new PayPalPayment(),"PayPal");
    }
}
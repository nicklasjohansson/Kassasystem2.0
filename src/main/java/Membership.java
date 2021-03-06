import java.util.ArrayList;

public class Membership {

    private final StaticDiscount NO_DISCOUNT = new StaticDiscount(0, this);
    private final Customer customer;
    private Points points = new Points();
    private StaticDiscount discount = NO_DISCOUNT;
    private ArrayList<Receipt> receipts = new ArrayList<>();

    public Membership(Customer customer) {
        this.customer = customer;
    }

    public void removeDiscount() {
        discount = NO_DISCOUNT;
    }

    public void buyStaticDiscount() {
        if(points.getAmount() < 1000){
            throw new IllegalStateException("You have too few points to get a discount");
        }
        if(discount.getDiscount() != 0){
            throw new IllegalStateException("You already have a discount saved");
        }
        StaticDiscount newStaticDiscount = new StaticDiscount((int) points.getAmount() / 1000, this);
        discount = newStaticDiscount;
        points.removePoints(points.getAmount());
    }

    public void addReceipt(Receipt receipt) {
        receipts.add(receipt);
    }

    public Points getPoints() {
        return points;
    }

    public Customer getCustomer() {
        return customer;
    }

    public StaticDiscount getDiscount() {
        return discount;
    }
}

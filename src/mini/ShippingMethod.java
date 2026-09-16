package mini;

enum ShippingMethod {
    STANDARD(10), NEXT_DAY(25);

    private final double cost;

    ShippingMethod(double cost) {
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }
}
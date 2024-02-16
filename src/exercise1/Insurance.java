package exercise1;

abstract class Insurance {
    private String type;
    double monthlyCost;

    public Insurance(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public double getMonthlyCost() {
        return monthlyCost;
    }

    public abstract void setInsuranceCost(double cost);

    public abstract void displayInfo();
}

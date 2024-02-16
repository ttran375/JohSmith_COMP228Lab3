package exercise1;

class Health extends Insurance {
    public Health(String type) {
        super(type);
    }

    @Override
    public void setInsuranceCost(double cost) {

        super.monthlyCost = cost;
    }

    @Override
    public void displayInfo() {
        System.out.println("Health Insurance: Type - " + getType() + ", Monthly Cost - $" + getMonthlyCost());
    }
}

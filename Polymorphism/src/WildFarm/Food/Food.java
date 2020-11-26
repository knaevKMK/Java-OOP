package WildFarm.Food;

public abstract class Food {
    protected Integer quantity;

    public Food(int quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }
}

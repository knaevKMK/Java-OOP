package onlineShop.core.Reposiytory;

public interface Repository<T> {
    void isExist(int id);

    void addProduct(T product);

    T getProductById(int id);

    void isInvalid();

    String removeProduct(String typeType);


    String buyBestComputer(double budget);
}

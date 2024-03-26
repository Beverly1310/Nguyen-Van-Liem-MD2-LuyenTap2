package ra.design;

import java.util.Scanner;

public interface IProduct extends IGeneric{
    int findById(String inputId);
    void sortProduct();
    void searchProduct(Scanner scanner);
    void searchWithin(Scanner scanner);

}

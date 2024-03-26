package ra.design;

import java.util.Scanner;

public interface ICategories extends IGeneric {


    int findById(int inputId);

    void changeStatus(Scanner scanner);
}

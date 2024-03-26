package ra.design;

import java.text.ParseException;
import java.util.Scanner;

public interface IGeneric {
    void createData(Scanner scanner) throws ParseException;
    void readData();
    void updateData(Scanner scanner) throws ParseException;
    void deleteData(Scanner scanner);

}

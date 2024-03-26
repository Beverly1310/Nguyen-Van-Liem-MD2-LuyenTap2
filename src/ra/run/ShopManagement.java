package ra.run;

import java.text.ParseException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ShopManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("******************SHOP MENU*******************\n" +
                    "1. Quản lý danh mục sản phẩm\n" +
                    "2. Quản lý sản phẩm\n" +
                    "3. Thoát");
            System.out.println("Moi nhap lua chon");
            byte choice=Byte.parseByte(scanner.nextLine());
            switch (choice){
                case 1:
                    try {
                        CategoriesManagement.categoriesManager();
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    ProductManagement.productManager();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Moi nhap lai");
            }
        }
    }
}
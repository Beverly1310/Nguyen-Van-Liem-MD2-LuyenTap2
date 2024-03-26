package ra.run;

import ra.business.CategoriesImplement;
import ra.design.ICategories;

import java.text.ParseException;
import java.util.Scanner;

public class CategoriesManagement {
    public static void categoriesManager() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        ICategories categories = new CategoriesImplement();
        while (true) {
            System.out.println("********************CATEGORIES MENU***********\n" +
                    "1. Nhập thông tin các danh mục\n" +
                    "2. Hiển thị thông tin các danh mục\n" +
                    "3. Cập nhật thông tin danh mục\n" +
                    "4. Xóa danh mục\n" +
                    "5. Cập nhật trạng thái danh mục\n" +
                    "6. Thoát");
            System.out.println("Moi nhap lua chon");
            byte choice = Byte.parseByte(scanner.nextLine());
            switch (choice) {
                case 1:
                    categories.createData(scanner);
                    break;
                case 2:
                    categories.readData();
                    break;
                case 3:
                    categories.updateData(scanner);
                    break;
                case 4:
                    categories.deleteData(scanner);
                    break;
                case 5:
                    categories.changeStatus(scanner);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Moi nhap lai");
            }
        }
    }

}

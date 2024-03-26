package ra.run;

import ra.business.ProductsImplement;
import ra.design.IProduct;

import java.text.ParseException;
import java.util.Scanner;

public class ProductManagement {
    public static void productManager()  {
        Scanner scanner = new Scanner(System.in);
        IProduct product =new ProductsImplement();
        while (true){
            System.out.println("*******************PRODUCT MANAGEMENT*****************\n" +
                    "1. Nhập thông tin các sản phẩm\n" +
                    "2. Hiển thị thông tin các sản phẩm\n" +
                    "3. Sắp xếp các sản phẩm theo giá\n" +
                    "4. Cập nhật thông tin sản phẩm theo mã sản phẩm\n" +
                    "5. Xóa sản phẩm theo mã sản phẩm\n" +
                    "6. Tìm kiếm các sản phẩm theo tên sản phẩm\n" +
                    "7. Tìm kiếm sản phẩm trong khoảng giá a – b (a,b nhập từ bàn \n" +
                    "phím)\n" +
                    "8. Thoát");
            System.out.println("Moi nhap lua chon");
            byte choice=Byte.parseByte(scanner.nextLine());
            switch (choice){
                case 1:
                    try {
                        product.createData(scanner);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    product.readData();
                    break;
                case 3:
                    product.sortProduct();
                    break;
                case 4:
                    try {
                        product.updateData(scanner);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 5:
                    product.deleteData(scanner);
                    break;
                case 6:
                    product.searchProduct(scanner);
                    break;
                case 7:
                    product.searchWithin(scanner);
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Moi nhap lai");
            }

        }
    }

}

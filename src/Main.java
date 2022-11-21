import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> productslist = new ArrayList<>();
        while (true) {
            System.out.println("Введите номер операции или end: ");
            System.out.println("1. Операция 'добавить'");
            System.out.println("2. Операция 'показать'");
            System.out.println("3. Операция 'удалить'");
            String operation = scanner.nextLine();
            if (operation.equals("end")) {
                System.out.println("Программа завершена.");
                System.out.println(productslist);
                break;
            }
            switch (operation) {
                case "1":
                    System.out.println("Какую покупку хотите добавить?");
                    String product = scanner.nextLine();
                    productslist.add(product);
                    System.out.println("Итого в списке покупок " + productslist.size() + " позиций");
                    break;
                case "2":
                    System.out.println("Ваш список покупок:");
                    int i = 0;
                    for (String s : productslist)
                        System.out.println((++i) + ". " + s);
                    break;
                case "3":
                    System.out.println("Какой продукт вы хотите удалить. Введите номер или название");
                    String removeItem = scanner.nextLine();
                    if (isNumeric(removeItem)) {
                        int number = Integer.parseInt(removeItem);
                        System.out.println("Продукт " + productslist.get(number - 1) + " удален из списка покупок");
                        productslist.remove(number - 1);
                    } else {
                        productslist.remove(removeItem);
                        System.out.println(removeItem + " удален из списка");
                    }
                    System.out.println(productslist);
                    break;
                default:
                    System.out.println("Неверна выбрана операция");
            }
        }
    }

    private static boolean isNumeric(String removeItem) {
        try {
            Integer.parseInt((removeItem));
            return true;
        } catch (Exception E) {
            return false;
        }
    }
}
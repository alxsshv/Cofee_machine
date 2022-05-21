import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws IOException {
        System.out.println("Кофе-машина");

        System.out.println("Введите сумму денег: ");
        int moneyAmount = new Scanner(System.in).nextInt();

        List<String> lines = null;
        try {
            lines = Files.readAllLines(Path.of("drinks.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Product> products = new ArrayList<>();
        int price;
        String[] items;
        for (String line: lines) {
           try {
                items = line.split("\s+");
                price  = Integer.parseInt(items[1]);
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
                continue;
            } products.add(new Product(price, items[0]));
        }

        System.out.println("Loaded "+ Product.getCount() + " products");

        boolean canBuyAnything = false;


        for (Product product: products) {
            if (moneyAmount >= product.getPrice()) {
                System.out.println("Вы можете купить " + product.getName());
                canBuyAnything = true;
            }
        }

        if (!canBuyAnything) {
            System.out.println("Недостаточно средств :( Изучайте Java и зарабатывайте много!");
        }
    }
}

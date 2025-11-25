package work31SimplesystemLiberary;
import java.io.*;
import java.util.*;

public class LibraryTest {
    private static final List<Book> books = new ArrayList<>();
    private static final String FILE = "books.txt";
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        loadBooks();
        int opt;
        do {
            System.out.print("\n1-添加 2-查看 3-借书 4-还书 5-保存 0-退出\n选择：");
            opt = sc.nextInt();
            sc.nextLine(); // 关键：吞换行
            switch (opt) {
                case 1:
                    addBook();
                    break;
                case 2:
                    listBooks();
                    break;
                case 3:
                    borrowBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    saveBooks();
                    break;
                case 0:
                    System.out.println("已退出！");
                    break;
                default:
                    System.out.println("无效选择！");
            }
        } while (opt != 0);
    }

    private static void addBook() {
        System.out.print("ISBN 书名 作者 库存：");
        String[] arr = sc.nextLine().trim().split("\\s+");
        books.add(new Book(arr[0], arr[1], arr[2], Integer.parseInt(arr[3])));
        System.out.println("添加成功！");
    }

    private static void listBooks() {
        if (books.isEmpty()) { System.out.println("暂无图书"); return; }
        Collections.sort(books);
        books.forEach(System.out::println);
    }

    private static void borrowBook() {
        System.out.print("借书 ISBN：");
        String isbn = sc.nextLine();
        Book b = findBook(isbn);
        if (b == null) { System.out.println("未找到该图书！"); return; }
        if (b.getStock() > 0) {
            b.setStock(b.getStock() - 1);
            System.out.println("借书成功！剩余库存：" + b.getStock());
        } else {
            System.out.println("库存不足！");
        }
    }

    private static void returnBook() {
        System.out.print("还书 ISBN：");
        String isbn = sc.nextLine();
        Book b = findBook(isbn);
        if (b == null) { System.out.println("未找到该图书！"); return; }
        b.setStock(b.getStock() + 1);
        System.out.println("还书成功！当前库存：" + b.getStock());
    }

    private static void saveBooks() {
        try (PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(FILE), "UTF-8"))) {
            for (Book b : books) {
                pw.printf("%s,%s,%s,%d%n", b.getIsbn(), b.getTitle(), b.getAuthor(), b.getStock());
            }
        } catch (IOException e) {
            System.out.println("保存失败：" + e.getMessage());
        }
        System.out.println("已保存到 " + FILE);
    }

    private static void loadBooks() {
        File f = new File(FILE);
        if (!f.exists()) return;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(FILE), "UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                books.add(new Book(arr[0], arr[1], arr[2], Integer.parseInt(arr[3])));
            }
        } catch (IOException e) {
            System.out.println("加载失败：" + e.getMessage());
        }
    }

    private static Book findBook(String isbn) {
        for (Book b : books) if (b.getIsbn().equals(isbn)) return b;
        return null;
    }
}
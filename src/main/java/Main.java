import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<Recommendation> recommendations = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Recommendation original = new Recommendation("Young Adults");
        original.addBook(new Novel("1984", "George Orwell", "Dystopian", 1949));
        original.addBook(new Comics("Spider-Man", "Stan Lee", "Superhero", 1962));
        recommendations.add(original);

        while (true) {
            System.out.println("\n--- Book Recommendation System ---");
            System.out.println("1. View all recommendations");
            System.out.println("2. Clone a recommendation");
            System.out.println("3. Modify a recommendation");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    viewRecommendations();
                    break;
                case 2:
                    cloneRecommendation(scanner);
                    break;
                case 3:
                    modifyRecommendation(scanner);
                    break;
                case 4:
                    System.out.println("Exiting system...");
                    return;
                default:
                    System.out.println("Invalid input.");
            }
        }
    }

    private static void viewRecommendations() {
        if (recommendations.isEmpty()) {
            System.out.println("No recommendations available.");
            return;
        }
        for (int i = 0; i < recommendations.size(); i++) {
            System.out.println("\n--- Recommendation " + (i + 1) + " ---");
            System.out.println(recommendations.get(i));
        }
    }

    private static void cloneRecommendation(Scanner scanner) {
        viewRecommendations();
        System.out.print("Enter the number of the recommendation to clone: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        if (index >= 0 && index < recommendations.size()) {
            Recommendation clone = recommendations.get(index).clone();
            System.out.print("Enter new target audience: ");
            String audience = scanner.nextLine();
            clone.setTargetAudience(audience);
            recommendations.add(clone);
            System.out.println("Cloned successfully.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    private static void modifyRecommendation(Scanner scanner) {
        viewRecommendations();
        System.out.print("Enter the number of the recommendation to modify: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        if (index >= 0 && index < recommendations.size()) {
            Recommendation rec = recommendations.get(index);
            System.out.println("1. Add Book\n2. Remove Book\n3. Change Target Audience");
            int modChoice = Integer.parseInt(scanner.nextLine());

            switch (modChoice) {
                case 1:
                    System.out.print("Enter book type (novel/comic): ");
                    String type = scanner.nextLine();
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Year: ");
                    int year = Integer.parseInt(scanner.nextLine());

                    if (type.equalsIgnoreCase("novel")) {
                        rec.addBook(new Novel(title, author, genre, year));
                    } else {
                        rec.addBook(new Comics(title, author, genre, year));
                    }
                    break;
                case 2:
                    System.out.print("Enter index of book to remove: ");
                    int bookIndex = Integer.parseInt(scanner.nextLine()) - 1;
                    rec.removeBook(bookIndex);
                    break;
                case 3:
                    System.out.print("Enter new target audience: ");
                    rec.setTargetAudience(scanner.nextLine());
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } else {
            System.out.println("Invalid recommendation.");
        }
    }
}

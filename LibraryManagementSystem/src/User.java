import java.util.ArrayList;
import java.util.List;

public class User {

    String name;
    List<Book> borrowedBooks = new ArrayList<>();

    public User(String name){
        this.name =name;
        this.borrowedBooks = new ArrayList<>();

    }
    public String getName(){
        return name;
    }
    public int noOfBorrowedBooks(){
        return borrowedBooks.size();
    }

    public void userMenu(){

        while(true){
            System.out.println("--- User Menu ---");
            System.out.print("1. BorrowBooks\n2. Return Books\n3.Display ALl Books\n4. Display All Members\n5. Exit\n");

            System.out.print("Enter your Choice:");
            int choice = Main.sc.nextInt();
            Main.sc.nextLine(); // fixing input character buffer

            switch(choice){
                case 1:
                    borrowBook();
                    break;
                case 2:
                    returnbook();
                    break;
                case 3:
                    displayDetails.displayBookDetails();
                    break;
                case 4:
                    displayDetails.displayMemberDetails();
                    break;
                case 5:
                    System.out.println("Exiting User Menu...");
                    return;
                default:
                    System.out.println("Invalid Option !");
            }
        }
    }

    public void borrowBook(){

        if (borrowedBooks.size() >= Main.maxborrowlimit) {
            System.out.println("Maximum Borrowing Limit Reached!");
            return;
        }

        System.out.print("Enter the Title of the Book to Borrow: ");
        String borrowBookTitle = Main.sc.nextLine();

        Book bookToBorrow = null;

        for (Book b : Main.books) {
            if (b.getTitle().equalsIgnoreCase(borrowBookTitle)) {
                bookToBorrow = b;
                break;
            }
        }

        if (bookToBorrow != null) {
            borrowedBooks.add(bookToBorrow);
            Main.books.remove(bookToBorrow);
            System.out.println("Book '" + bookToBorrow.getTitle() + "' borrowed successfully!");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void returnbook(){
        if (borrowedBooks.isEmpty()) {
            System.out.println("You haven't borrowed any books.");
            return;
        }

        System.out.println("Your Borrowed Books:");
        for (Book b : borrowedBooks) {
            System.out.println("• " + b.getTitle() + " by " + b.getAuthor());
        }

        System.out.print("Enter the title of the book to return: ");
        String titleToReturn = Main.sc.nextLine();

        Book bookToReturn = null;

        for (Book b : borrowedBooks) {
            if (b.getTitle().equalsIgnoreCase(titleToReturn)) {
                bookToReturn = b;
                break;
            }
        }

        if (bookToReturn == null) {
            System.out.println("You have not borrowed a book with that title.");
        } else {
            borrowedBooks.remove(bookToReturn);
            Main.books.add(bookToReturn);
            System.out.println("Book '" + bookToReturn.getTitle() + "' returned successfully!");
        }
    }


}

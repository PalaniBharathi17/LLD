public class displayDetails {

    public static void displayMemberDetails(){
        if(Main.users.isEmpty()){
            System.out.println("No current members !");
        }else{
            System.out.println("----Member's List----");
            for (User u  : Main.users){
                System.out.println("UserName :" + u.getName() + "No.of Books borrowed :" + u.noOfBorrowedBooks());
            }
        }
    }

    public static void displayBookDetails(){
        if (Main.books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            System.out.println("--- Book List ---");
            for (Book b : Main.books) {
                System.out.println("Title: " + b.getTitle() + ", Author: " + b.getAuthor() + ", Genre: " + b.getGenre());
            }
        }

    }
}

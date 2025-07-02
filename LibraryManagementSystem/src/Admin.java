public class Admin {




    public void adminMenu(){
        while(true){
            System.out.print("1. Add Book\n2. Update Book\n3. Remove Book\n4.Add Member\n5.Display ALl Books\n6. Display All Members\n7. Exit\n");
            System.out.print("Enter your choice : ");
            int choice = Main.sc.nextInt();
            Main.sc.nextLine();

            switch (choice){
                case 1:
                    addBook();
                    break;
                case 2:
                    updateBooks();
                    break;
                case 3:
                    removeBooks();
                    break;
                case 4:
                    addmember();
                    break;
                case 5:
                    displayDetails.displayBookDetails();
                    break;
                case 6:
                    displayDetails.displayMemberDetails();
                    break;
                case 7:
                    System.out.println("Exiting Admin Menu...");
                    return;

            }
        }
    }
    public void addBook(){
        System.out.print("Enter book title :");
        String booktitle = Main.sc.nextLine();
        System.out.print("Enter book author :");
        String bookauthor = Main.sc.nextLine();
        System.out.print("Enter book genre");
        String bookgenre = Main.sc.nextLine();

        Book book = new Book(booktitle, bookauthor, bookgenre);
        Main.books.add(book);
        System.out.println("New book added successfully !");


    }
    public void updateBooks(){
        if(Main.books.isEmpty()){
            System.out.print("No Books available right now !");
            return;
        }
        System.out.print("Enter the Book Title to Update :");
        String searchTitle = Main.sc.nextLine();

        Book bookToUpdate = null;
        for(Book b : Main.books){
            if(b.getTitle().equalsIgnoreCase(searchTitle)){
                bookToUpdate = b;
                break;
            }
        }

        if(bookToUpdate == null){
            System.out.println("No books as matching title found !");
        }


    }
    public void removeBooks(){
        if(Main.books.isEmpty()){
            System.out.print("No Books available right now !");
            return;
        }

        System.out.print("Enter the Book Title to Rename :");
        String removeTitle = Main.sc.nextLine();

        Book bookToRemove = null;

        for(Book b :Main.books){
            if(b.getTitle().equalsIgnoreCase(removeTitle)){
                bookToRemove = b;
                break;
            }
        }
        if(bookToRemove!=null){
            Main.books.remove(bookToRemove);
            System.out.println("The book"+bookToRemove + "has been removed successfully.");
        }else{
            System.out.println(" Book with title '" + bookToRemove + "' not found.");
        }
    }

    public void addmember(){
        System.out.print("Enter the username :");
        String username = Main.sc.nextLine();

        for(User u : Main.users){
            if(u.getName().equalsIgnoreCase(username))
            {
                System.out.print("Member already exists !");
            }
            break;
        }

        User newUser = new User(username);
        Main.users.add(newUser);
        System.out.println("New member added Successfully !");

    }
}

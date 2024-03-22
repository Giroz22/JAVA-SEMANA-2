import controller.AuthorController;
import controller.BookController;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        String opc = "";
        do {
            try {
                opc = JOptionPane.showInputDialog(null, """
                            ===Chose a option===:
                            1. Menu Authors
                            2. Menu Books
                            3. Salir
                        """);

                switch (opc) {
                    case "1":
                        main.MenuAuthors();
                        break;
                    case "2":
                        main.MenuBooks();
                        break;
                }
            }catch (Exception e){
                opc = "";
            }
        }while (!opc.equals("3"));
    }

    public void MenuAuthors(){
        AuthorController objAuthorController = new AuthorController();
        String opc = "";
        do {
            opc = JOptionPane.showInputDialog(null, """
                        === Authors Menu ===
                        Chose a option:
                        1. List All
                        2. List by id
                        3. Create
                        4. Update
                        5. Delete
                        6. Back
                    """);

            switch (opc){
                case "1":
                    objAuthorController.getAll();
                    break;
                case "2":
                    objAuthorController.getById();
                    break;
                case "3":
                    objAuthorController.create();
                    break;
                case "4":
                    objAuthorController.update();
                    break;
                case "5":
                    objAuthorController.delete();
                    break;
            }
        }while (!opc.equals("6"));
    }

    public void MenuBooks(){
        BookController objBookController = new BookController();
        String opc = "";
        do {
            opc = JOptionPane.showInputDialog(null, """
                        === Books Menu ===
                        Chose a option:
                        1. List All
                        2. List by id
                        3. Create
                        4. Update
                        5. Delete
                        6. Filter by
                        7. Back
                    """);

            switch (opc) {
                case "1":
                    objBookController.getAll();
                    break;
                case "2":
                    objBookController.getById();
                    break;
                case "3":
                    objBookController.create();
                    break;
                case "4":
                    objBookController.update();
                    break;
                case "5":
                    objBookController.delete();
                    break;
                case "6":
                    objBookController.filterBy();
                    break;
            }
        }while (!opc.equals("7"));
    }
}

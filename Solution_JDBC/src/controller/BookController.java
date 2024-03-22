package controller;

import entity.Book;
import model.AuthorModel;
import model.BaseModel;
import model.BookModel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class BookController extends BaseController{

    //Variables
    private BookModel objBookModel = null;

    //Constructor
    public BookController() {
        super(new BookModel());
        this.objBookModel = new BookModel();
    }

    //Override methods
    @Override
    public Object requestData() {
        Object book = null;
        AuthorController objAuthorController = new AuthorController();

        try{
            //Pedimos la info del libro
            String tittle = JOptionPane.showInputDialog(null, "Write the tittle of the book");
            int year = Integer.parseInt(JOptionPane.showInputDialog(null, "Write the year of publication od the book"));
            double price = Double.parseDouble(JOptionPane.showInputDialog(null, "Write the price of the book"));
            int id_Author = objAuthorController.selectIdObject();

            //Validamos si el id es correcto
            if(id_Author == -1) return null; //Validamos si se obtuvo el id correctamente

            //Almacenamos la info
            book = new Book(tittle,year,price,id_Author);
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error request data of the book");
        }

        return book;
    }

    @Override
    public Object requestData(int id) {
        Book objBook = (Book) this.requestData();
        if(objBook == null) return null; //Validamos la info

        objBook.setId(id);
        return objBook;
    }

    //Methods
    public void filterBy(){
        String opc = JOptionPane.showInputDialog(null, """
                Filter the lis of the books for:
                1. Title
                2. Author
                """);

        List<Object> listBooks = new ArrayList<>();
        String strValue = "";

        switch (opc){
            case "1":
                strValue = JOptionPane.showInputDialog(null, "Write the title of the book:");
                listBooks = this.objBookModel.filter("title", strValue);
                break;

            case "2":
                AuthorController objAuthorController = new AuthorController();
                int idAuthor = objAuthorController.selectIdObject();
                if(idAuthor == -1) return; //Validamos si se obtuvo el id correctamente

                strValue += idAuthor;

                listBooks = this.objBookModel.filter("id_author", strValue);
                break;
        }

        //Validamos si hay datos
        if(listBooks.isEmpty()) return;

        //Imprimimos los libros encontrados
        String strListBook = this.getAll(listBooks);
        JOptionPane.showMessageDialog(null, "List books:\n" + strListBook);
    }
}

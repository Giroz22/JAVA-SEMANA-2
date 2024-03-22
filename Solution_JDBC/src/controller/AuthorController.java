package controller;

import entity.Author;
import entity.Book;
import model.AuthorModel;
import model.BaseModel;

import javax.swing.*;
import java.util.List;

public class AuthorController extends BaseController{

    //
    private AuthorModel objAuthorModel = null;

    //Constructor
    public AuthorController() {

        super(new AuthorModel());

        this.objAuthorModel = new AuthorModel();
    }

    //Override methods
    @Override
    public Object requestData() {
        return new Author(
                JOptionPane.showInputDialog(null,"Write name of the author"),
                JOptionPane.showInputDialog(null, "Write nationality of the author")
        );
    }

    @Override
    public Object requestData(int id) {
        Author objAuthor = (Author) this.requestData();
        objAuthor.setId(id);
        return objAuthor;
    }

}

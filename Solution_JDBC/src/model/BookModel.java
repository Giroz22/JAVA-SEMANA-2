package model;

import config.ConfigDB;
import entity.Book;
import entity.Book;
import entity.Book;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookModel extends BaseModel{
    //Constructors
    public BookModel() {
        super("books");
    }

    //Methods BookModel
    public List<Object> filter(String key, String value){
        List<Object> listBooks = new ArrayList<>();

        //  1. Abrimos la conexión
        if(!ConfigDB.openConnection()) return listBooks;

        // 2. Preparamos la consulta
        String sql = "SELECT * FROM books WHERE "+ key +" LIKE '%"+ value +"%';";

        try{
            // 3. Preparamos  el PreparedStatement
            PreparedStatement objPreparedStatement = ConfigDB.objConnection.prepareStatement(sql);

            // 4. Ejecutamos la consulta
            ResultSet objResult = objPreparedStatement.executeQuery();

            while (objResult.next()){
                // 6. Obtenemos la info dependiendo del obj
                Book objBook = (Book) getInfoObject(objResult);
                listBooks.add(objBook);
            }

            //5. Validamos si se encontraron datos
            if(listBooks.isEmpty()){
                JOptionPane.showMessageDialog(null, "Not found data");
            }

        }catch (SQLException e){
            System.err.println("Error findBy in class BookModel\n" + e.getMessage());
        }

        ConfigDB.closeConnection();
        return listBooks;
    }

    //Override

    @Override
    public Object getInfoObject(ResultSet objResult) {
        Book objBook = null;

        try {
            objBook = new Book(
                    objResult.getInt(1),
                    objResult.getString(2),
                    objResult.getInt(3),
                    objResult.getFloat(4),
                    objResult.getInt(5)
            );
        }catch (SQLException e){
            System.out.println("Error in method getInfoObject() class BookModel");
        }
        return objBook;
    }

    @Override
    public PreparedStatement setInfoSave(Object obj) {
        try{
            // Castemos el objeto
            Book objBook = (Book) obj;

            //Preparamos la consulta
            String sql = "INSERT INTO books(title, year_of_publication, price, id_author) VALUES (?,?,?,?)";

            PreparedStatement objPreparedStatement = ConfigDB.objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPreparedStatement.setString(1, objBook.getTittle());
            objPreparedStatement.setInt(2, objBook.getyear_of_publication());
            objPreparedStatement.setDouble(3, objBook.getPrice());
            objPreparedStatement.setInt(4, objBook.getId_author());

            return objPreparedStatement;
        }catch (SQLException e){
            System.err.println("Error setInfoUpdate class BookModel");
            return null;
        }
    }

    @Override
    public PreparedStatement setInfoUpdate(int id, Object obj) {
        try {
            Book objBook = (Book) obj;
            objBook.setId(id);

            // 2. Preparamos la consulta
            String sql = "UPDATE books SET title=?, year_of_publication=?, price=?, id_Author=? WHERE id=?;";

            // 3. Preparamos el PreparedStatement
            PreparedStatement objPreparedStatement = ConfigDB.objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPreparedStatement.setString(1, objBook.getTittle());
            objPreparedStatement.setInt(2, objBook.getyear_of_publication());
            objPreparedStatement.setDouble(3, objBook.getPrice());
            objPreparedStatement.setInt(4, 0);
            objPreparedStatement.setInt(5, id);

            return objPreparedStatement;
        }catch (SQLException e){
            System.err.println("Error setInfoUpdate class BookModel");
            return null;
        }
    }
}

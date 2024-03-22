package model;

import config.ConfigDB;
import entity.Author;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorModel extends BaseModel{
    public AuthorModel() {
        super("authors");
    }

    @Override
    public Object getInfoObject(ResultSet objResult) {

        Author objAuthor = null;

        try {
            objAuthor = new Author(
                    objResult.getInt(1),
                    objResult.getString(2),
                    objResult.getString(3)
            );
        } catch (SQLException e) {
            System.out.println("Error in method parceObject(),class AuthorModel");
        }

        return objAuthor;
    }

    @Override
    public PreparedStatement setInfoSave(Object obj) {
        try{
            // Castemos el objeto
            Author objAuthor = (Author) obj;

            //Preparamos la consulta
            String sql = "INSERT INTO authors(name, nationality) VALUES (?,?);";

            PreparedStatement objPreparedStatement = ConfigDB.objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPreparedStatement.setString(1, objAuthor.getname());
            objPreparedStatement.setString(2, objAuthor.getnationality());

            return objPreparedStatement;
        }catch (SQLException e){
            System.err.println("Error setInfoUpdate class AuthorModel");
            return null;
        }
    }

    @Override
    public PreparedStatement setInfoUpdate(int id, Object obj) {
        try {
            Author objAuthor = (Author) obj;
            objAuthor.setId(id);

            // 2. Preparamos la consulta
            String sql = "UPDATE authors SET name=?, nationality=? WHERE id=?;";
            // 3. Preparamos el PreparedStatement
            PreparedStatement objPreparedStatement = ConfigDB.objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPreparedStatement.setString(1, objAuthor.getname());
            objPreparedStatement.setString(2, objAuthor.getnationality());
            objPreparedStatement.setInt(3, id);

            return objPreparedStatement;
        }catch (SQLException e){
            System.err.println("Error setInfoUpdate class AuthorModel");
            return null;
        }
    }
}

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;


public class ProdusDatabase {
    public void insert(Produs item)
    {
        String insertSql = "insert into items (Id,Name) values (?,?)";
        Connection connection = Database.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(insertSql);
            statement.setInt(1,item.getId());
            statement.setString(2,item.getNume());
            statement.executeUpdate();

        } catch (SQLException e) { e.printStackTrace();
        }
    }

    public Optional<Produs> getById(int id)   {
        String selectSql = "SELECT * FROM Produss b WHERE b.name = ?";
        Connection connection = Database.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(selectSql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            return mapToProdus(resultSet);
        } catch (SQLException e)    {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    private Optional<Produs> mapToProdus(ResultSet resultSet) throws SQLException  {
        if(resultSet.next())    {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            return Optional.of(new Produs(id,name));
        }
        return Optional.empty();
    }
}

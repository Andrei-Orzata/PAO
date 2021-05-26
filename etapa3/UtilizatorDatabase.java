import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;


public class UtilizatorDatabase {
    public void insert(Utilizator user)
    {
        String insertSql = "insert into users (Name,Prename) values (?,?)";
        Connection connection = Database.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(insertSql);
            statement.setString(1,user.getNume());
            statement.setString(2,user.getPrenume());
            statement.executeUpdate();

        } catch (SQLException e) { e.printStackTrace();
        }
    }

    public Optional<Utilizator> getByName(String name)   {
        String selectSql = "SELECT * FROM users u WHERE u.name = ?";
        Connection connection = Database.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(selectSql);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            return mapToUtilizator(resultSet);
        } catch (SQLException e)    {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    private Optional<Utilizator> mapToUtilizator(ResultSet resultSet) throws SQLException  {
        if(resultSet.next())    {
            String name = resultSet.getString(1);
            String prename = resultSet.getString(2);
            return Optional.of(new Utilizator(name, prename));
        }
        return Optional.empty();
    }
}

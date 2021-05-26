import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;


public class BidDatabase {
    public void insert(Bid bid)
    {
        String insertSql = "insert into bids (Name,Prename,Price) values (?,?,?)";
        Connection connection = Database.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(insertSql);
            Utilizator user = bid.getUser();
            statement.setString(1,user.getNume());
            statement.setString(2,user.getPrenume());
            statement.setInt(3, bid.getPrice());
            statement.executeUpdate();




        } catch (SQLException e) { e.printStackTrace();
        }
    }

    public Optional<Bid> getByName(String name)   {
        String selectSql = "SELECT * FROM bids b WHERE b.name = ?";
        Connection connection = Database.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(selectSql);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            return mapToBid(resultSet);
        } catch (SQLException e)    {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    private Optional<Bid> mapToBid(ResultSet resultSet) throws SQLException  {
        if(resultSet.next())    {
            String name = resultSet.getString(1);
            String prename = resultSet.getString(2);
            int price = resultSet.getInt(3);
            return Optional.of(new Bid(new Utilizator(name, prename),price));
        }
        return Optional.empty();
    }
}

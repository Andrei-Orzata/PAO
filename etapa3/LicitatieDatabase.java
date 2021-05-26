import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;


public class LicitatieDatabase {
    public void insert(Bid bid, Produs item)
    {
        String insertSql = "insert into auctions (Name,Prename,Price,Id,Product) values (?,?,?,?,?)";
        Connection connection = Database.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(insertSql);
            Utilizator user = bid.getUser();
            statement.setString(1,user.getNume());
            statement.setString(2,user.getPrenume());
            statement.setInt(3, bid.getPrice());
            statement.setInt(4,item.getId());
            statement.setString(5,item.getNume());
            statement.executeUpdate();




        } catch (SQLException e) { e.printStackTrace();
        }
    }

    public Optional<Licitatie> getById(int id)   {
        String selectSql = "SELECT * FROM auction a WHERE a.id = ?";
        Connection connection = Database.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(selectSql);
            statement.setInt(4, id);
            ResultSet resultSet = statement.executeQuery();
            return mapToLicitatie(resultSet);
        } catch (SQLException e)    {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    private Optional<Licitatie> mapToLicitatie(ResultSet resultSet) throws SQLException  {
        if(resultSet.next())    {
            String name = resultSet.getString(1);
            String prename = resultSet.getString(2);
            int price = resultSet.getInt(3);
            int id = resultSet.getInt(4);
            String item = resultSet.getString(5);

            Licitatie auction = new Licitatie();
            auction.addUtilizatorBid(new Bid (new Utilizator(name, prename),price), new Produs(id,item));
            return Optional.of(auction);
        }
        return Optional.empty();
    }
}

import java.sql.*;

public class SetupData {

    public void createBidTable()   {
        String createTableSql = "CREATE TABLE IF NOT EXISTS Bids" + "(name varchar(40), prename varchar(40),int)";

        Connection connection = Database.getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addBid() {
        String insertSql = "INSERT INTO person(Name, Prename,Price) VALUES ('Irina', 'Dumitru',13)";
        Connection connection = Database.getConnection();

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(insertSql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void getAllBids()    {
        String selectSql = "SELECT * FROM Bids";
        Connection connection = Database.getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);

            while (resultSet.next())    {
                System.out.println("Name: " + resultSet.getString(1));
                System.out.println("Prename: " + resultSet.getString(2));
                System.out.println("Price: " + resultSet.getInt(3));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    public void deleteBid(String name, String prename)
    {
        String insertSql = "DELETE FROM Bids u Where u.name = ? and u.prename = ? ";

        Connection connection = Database.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(insertSql);
            statement.setString(1, name);
            statement.setString(2, prename);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void updateBid(String name, String prename)
    {
        String insertSql = "Update Bids SET Name = 'Irina', Prename = 'Dumitru',Price = 13, u Where u.name = ? and u.prename = ? ";

        Connection connection = Database.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(insertSql);
            statement.setString(1, name);
            statement.setString(2, prename);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void createItemTable()   {
        String createTableSql = "CREATE TABLE IF NOT EXISTS Items" + "(int , prename varchar(40))";

        Connection connection = Database.getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addItem() {
        String insertSql = "INSERT INTO item(Id,Name) VALUES (13, 'carte')";
        Connection connection = Database.getConnection();

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(insertSql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void getAllItems()    {
        String selectSql = "SELECT * FROM Items";
        Connection connection = Database.getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);

            while (resultSet.next())    {
                System.out.println("Id: " + resultSet.getInt(1));
                System.out.println("Name: " + resultSet.getString(2));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    public void deleteItem(int id)
    {
        String insertSql = "DELETE FROM Items i Where i.id = ? ";

        Connection connection = Database.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(insertSql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void updateItem(int id)
    {
        String insertSql = "Update Items i SET Id = 13, Name = 'carte', i Where i.id = ? ";

        Connection connection = Database.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(insertSql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void createUserTable()   {
        String createTableSql = "CREATE TABLE IF NOT EXISTS users" + "(name varchar(40), prename varchar(40))";

        Connection connection = Database.getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addUser() {
        String insertSql = "INSERT INTO person(Name, Prename) VALUES ('Irina', 'Dumitru')";
        Connection connection = Database.getConnection();

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(insertSql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void getAllUsers()    {
        String selectSql = "SELECT * FROM users";
        Connection connection = Database.getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);

            while (resultSet.next())    {
                System.out.println("Name: " + resultSet.getString(1));
                System.out.println("Prename: " + resultSet.getString(2));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    public void deleteUser(String name, String prename)
    {
        String insertSql = "DELETE FROM users u Where u.name = ? and u.prename = ? ";

        Connection connection = Database.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(insertSql);
            statement.setString(1, name);
            statement.setString(2, prename);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void updateUser(String name, String prename)
    {
        String insertSql = "Update users SET Name = 'Irina', Prename = 'Dumitru', u Where u.name = ? and u.prename = ? ";

        Connection connection = Database.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(insertSql);
            statement.setString(1, name);
            statement.setString(2, prename);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void createAuctionTable()   {
        String createTableSql = "CREATE TABLE IF NOT EXISTS Auctions" + "(name varchar(40), prename varchar(40))";

        Connection connection = Database.getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addAuction() {
        String insertSql = "INSERT INTO person(Name, Prename) VALUES ('Irina', 'Dumitru')";
        Connection connection = Database.getConnection();

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(insertSql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void getAllAuctions()    {
        String selectSql = "SELECT * FROM Auctions";
        Connection connection = Database.getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);

            while (resultSet.next())    {
                System.out.println("Name: " + resultSet.getString(1));
                System.out.println("Prename: " + resultSet.getString(2));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    public void deleteAuction(String name, String prename)
    {
        String insertSql = "DELETE FROM Auctions u Where u.name = ? and u.prename = ? ";

        Connection connection = Database.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(insertSql);
            statement.setString(1, name);
            statement.setString(2, prename);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void updateAuction(String name, String prename)
    {
        String insertSql = "Update Auctions SET Name = 'Irina', Prename = 'Dumitru', u Where u.name = ? and u.prename = ? ";

        Connection connection = Database.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(insertSql);
            statement.setString(1, name);
            statement.setString(2, prename);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
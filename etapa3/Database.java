

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {


        private static final String DB_URL = "jdbc:mysql://localhost:";
        private static final String USER = "root";
        private static final String PASSWORD = "";

        private  static Connection dbConnection;

        private Database(){

        }

        public static  Connection getConnection() {
            try{
                if (dbConnection == null || dbConnection.isClosed()){
                    dbConnection = DriverManager.getConnection(DB_URL,USER,PASSWORD);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            return dbConnection;
        }

        public static void closeConnection() {
            try{
                if(dbConnection != null && !dbConnection.isClosed()){
                    dbConnection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


}

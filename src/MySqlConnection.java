import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class MySqlConnection {
    public static void List(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcvideo", "root", "Jr3d8492gz");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from airport_data");
            while(resultSet.next()){
                System.out.println(resultSet.getString("iata") + "    "+ resultSet.getString("state") );
            }

        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public static LinkedList<Airport> generateAirports(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcvideo", "root", "Jr3d8492gz");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from airport_data");
            LinkedList<Airport> airports = new LinkedList<Airport>();
            while(resultSet.next()) {
                Airport aeroporto = new Airport(resultSet.getString("iata"), resultSet.getFloat("latitude"), resultSet.getFloat("longitude"));
                airports.add(aeroporto);
                System.out.println(resultSet.getString("iata") + "    " + resultSet.getString("state"));
            }
            return airports;
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }
    public static void addRequirement(String aeroIn, String aeroOut, String path){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcvideo", "root", "Jr3d8492gz");
            Statement stmt;
            stmt = connection.createStatement();
            stmt.execute("INSERT INTO search (saida,chegada,caminho) "
                    + "VALUES ('Lokesh','Gupta','oi')");

            connection.close();
        } catch(Exception e){
            e.printStackTrace();
        }

    }
}

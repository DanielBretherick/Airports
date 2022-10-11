import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class MySqlConnection {
    static String password = "password";
    static String user = "root";
    public static void List(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcvideo", user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from planilhaAeroportos");
            System.out.printf("%-25s%-25s%-15s\n","Aero", "Estado","Cidade" );
            System.out.println("------------------------------------------------------------");
            while(resultSet.next()){
                System.out.printf("%-25s%-25s%-15s\n",resultSet.getString("initials"), resultSet.getString("state"), resultSet.getString("city") );
            }

        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public static LinkedList<Airport> generateAirports(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcvideo", user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from planilhaAeroportos");
            LinkedList<Airport> airports = new LinkedList<Airport>();
            while(resultSet.next()) {
                Airport aeroporto = new Airport(resultSet.getString("initials"), resultSet.getFloat("latitude"), resultSet.getFloat("longitude"));
                airports.add(aeroporto);
            }
            return airports;
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }
    public static void addRequirement(String aeroIn, String aeroOut, String path){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcvideo", user, password);
            Statement stmt;
            stmt = connection.createStatement();
            stmt.execute("INSERT INTO search (saida,chegada,caminho) "
                    + "VALUES ('"+ aeroIn +"','"+ aeroOut + "','" + path +"')");

            connection.close();
        } catch(Exception e){
            e.printStackTrace();
        }

    }
}

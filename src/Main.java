import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MySqlConnection.List();
        LinkedList<Airport> airports = MySqlConnection.generateAirports();
//        for(int i =0; i< airports.size(); i++){
//            System.out.println(airports.get(i).getLatitude());
//        }
        Graph teste = new Graph(airports);

        System.out.println("Digite o aeroporto de saída:");
        Scanner scanner = new Scanner(System.in);
        String aeroIn = scanner.next();
        System.out.println("Digite o aeroporto de chegada:");
        String aeroOut = scanner.next();
        System.out.println("Saíndo de  " + aeroIn + " ---->" + "Chegando em  " + aeroOut);

        String result = teste.dijkstraAlg(aeroIn, aeroOut);
        MySqlConnection.addRequirement(aeroIn, aeroOut, result);



    }
}

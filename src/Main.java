import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MySqlConnection.List();
        LinkedList<Airport> airports = MySqlConnection.generateAirports();

        Graph teste = new Graph(airports);

        System.out.println("Digite o aeroporto de saida:");
        Scanner scanner = new Scanner(System.in);
        String aeroIn = scanner.next();
        System.out.println("Digite o aeroporto de chegada:");
        String aeroOut = scanner.next();
        System.out.println("Saíndo de  " + aeroIn + " ---->" + " Chegando em  " + aeroOut);

        String result = teste.dijkstraAlg(aeroIn, aeroOut);
        MySqlConnection.addRequirement(aeroIn, aeroOut, result);

    }
}

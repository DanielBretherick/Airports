import org.jgrapht.alg.interfaces.ShortestPathAlgorithm;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.*;

import java.util.*;

import static java.lang.Math.*;

public class Graph {
    SimpleWeightedGraph<String, DefaultWeightedEdge> airportGraph;

    public double airportWeight(Airport aeroInicial, Airport aeroFinal){
        double long_final = aeroFinal.getLongitude();
        double lat_final = aeroFinal.getLatitude();

        double long_inicial = aeroInicial.getLongitude();
        double lat_inicial = aeroInicial.getLatitude();


        double d2r = 0.017453292519943295769236;

        double dlong = (long_final - long_inicial) * d2r;
        double dlat = (lat_final - lat_inicial) * d2r;

        double temp_sin = sin(dlat/2.0);
        double temp_cos = cos(lat_inicial * d2r);
        double temp_sin2 = sin(dlong/2.0);

        double a = (temp_sin * temp_sin) + (temp_cos * temp_cos) * (temp_sin2 * temp_sin2);
        double c = 2.0 * atan2(sqrt(a), sqrt(1.0 - a));

        return 6368.1 * c;
    }

    public  Graph(LinkedList<Airport> aeroportos) {
        SimpleWeightedGraph<String, DefaultWeightedEdge> directedGraph =
                new SimpleWeightedGraph<String, DefaultWeightedEdge>(DefaultWeightedEdge.class);

        for (int i = 0; i < aeroportos.size(); i++) {
            directedGraph.addVertex(aeroportos.get(i).getNome());
        }
        for (int i = 0; i < aeroportos.size(); i++) {
            for (int j = 1; j < aeroportos.size(); j++) {
                if(i != j) {
                    double weight = airportWeight(aeroportos.get(i), aeroportos.get(j));
                    directedGraph.addEdge(aeroportos.get(i).getNome(), aeroportos.get(j).getNome());
                    directedGraph.setEdgeWeight(aeroportos.get(i).getNome(), aeroportos.get(j).getNome(), weight);
                }
            }
        }
        airportGraph = directedGraph;
        System.out.println();

    }
    public String dijkstraAlg( String aeroIn, String aeroOut){
        System.out.println("Menor caminho de "+ aeroIn+ "para " + aeroOut);
        double weight = airportGraph.getEdgeWeight(airportGraph.getEdge(aeroIn,aeroOut));
        airportGraph.removeEdge(aeroIn, aeroOut);
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraAlg =
                new DijkstraShortestPath<>(airportGraph);
        ShortestPathAlgorithm.SingleSourcePaths<String, DefaultWeightedEdge> iPaths = dijkstraAlg.getPaths(aeroIn);
        System.out.println(iPaths.getPath(aeroOut) + "\n");
        airportGraph.addEdge(aeroIn,aeroOut);
        airportGraph.setEdgeWeight(aeroIn,aeroOut, weight);


        return iPaths.getPath(aeroOut) + "\n";
    }
}

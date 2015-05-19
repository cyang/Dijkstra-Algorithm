import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by ChrisYang on 5/18/15.
 */
public class HW8 {
    private static int inf = Integer.MAX_VALUE;

    public static void main(String[] args) {

        int[][] graph = createTestGraph1();

//        for (int i = 0; i < 6; i++) {
//            for (int j = 0; j < 6; j++) {
//                System.out.print(graph[i][j] + " ");
//            }
//            System.out.println();
//        }

        Vertex A = new Vertex(0, 'A');
        Vertex B = new Vertex(1, 'B');
        Vertex C = new Vertex(2, 'C');
        Vertex D = new Vertex(3, 'D');
        Vertex E = new Vertex(4, 'E');
        Vertex F = new Vertex(5, 'F');


        Vertex[] verticesList = {A, B, C, D, E, F};

        dijkstrasAlgorithm(graph, A, verticesList);

    }

    public static int[][] createTestGraph1(){

        int[][] graph = new int[][]{
                {0, 7, 9, inf, inf, 14},
                {7, 0, 10, 15, inf, inf},
                {9, 10, 0, 11, inf, 2},
                {inf, 15, 11, 0, 6, inf},
                {inf, inf, inf, 6, 0, 9},
                {14, inf, 2, inf, 9, 0}
        };

        return graph;
    }

    public static Vertex[] dijkstrasAlgorithm(int[][] graph, Vertex source, Vertex[] verticesList){
//        ArrayList<Integer> weightsList = new ArrayList<Integer>();
        source.setWeight(0);
        source.setExpanded(true);

        int row = source.getIndex();

        boolean status = needsExpanding(verticesList);
        while(status == true) {


            for (int column = 0; column < graph.length; column++) {
                if ((graph[row][column] != 0 && graph[row][column] != inf && verticesList[column].isExpanded() == false)) {
                    if (graph[row][column] + verticesList[row].getWeight() < verticesList[column].getWeight()) {
                        verticesList[column].setWeight(graph[row][column] + verticesList[row].getWeight());
                        verticesList[column].setParent(verticesList[row].getName());
                    }
                }
            }

            int min = inf;
            int mincolumn = -1;
            for(Vertex element: verticesList){
                if (element.isExpanded() == false && element.getWeight() < min) {
                    min = element.getWeight();
                    mincolumn = element.getIndex();
                }
            }

            verticesList[mincolumn].setExpanded(true);
            row  = mincolumn;
            status = needsExpanding(verticesList);
        }
        return verticesList;
    }

    public static boolean needsExpanding (Vertex[] verticesList){
        for(Vertex element: verticesList){
            if (element.isExpanded() == false)
                return true;
        }

        return false;
    }

    public static int getMin(int a, int b){
        if (a < b)
            return a;
        else
            return b;

    }

}



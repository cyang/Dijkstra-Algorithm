/**
 * @author      Christopher Yang <cyang001@citymail.cuny.edu>
 * @version     1.0
 * @since       2015-05-19
 */

public class HW8 {
    // infinity
    private static int inf = Integer.MAX_VALUE;

    public static void main(String[] args) {
        testCase1();
        testCase2();
    }

    public static void dijkstrasAlgorithm(int[][] graph, Vertex source, Vertex[] verticesList,
                                          int[][] shortestPairsWeights, char[][] shortestPairsParents){
        // Start by expanding from the source
        source.setWeight(0);
        source.setExpanded(true);

        // Check the neighbors in the adjacency matrix
        int row = source.getIndex();

        boolean status = needsExpanding(verticesList);

        // Keep doing this until all the vertices are expanded
        while(status) {

            for (int column = 0; column < graph.length; column++) {
                // If the neighbors are not zero and not infinity and have not yet been expanded
                if ((graph[row][column] != 0 && graph[row][column] != inf && !verticesList[column].isExpanded())) {
                    // If the weight of the edge plus the cumulative distance is less than the weight found before
                    if (graph[row][column] + verticesList[row].getWeight() < verticesList[column].getWeight()) {
                        // make this the new weight for the vertex and set the parent to be the path
                        verticesList[column].setWeight(graph[row][column] + verticesList[row].getWeight());
                        verticesList[column].setParent(verticesList[row].getName());
                    }
                }
            }

            // Check all the vertices that have not been expanded to get the min weight to travel to
            int min = inf;
            int minColumn = -1;
            for(Vertex element: verticesList){
                if (!element.isExpanded() && element.getWeight() < min) {
                    min = element.getWeight();
                    minColumn = element.getIndex();
                }
            }

            // Once we know where to travel to we expand that vertex and beging checking through the neighbors of
            // that row of the vertex in the graph
            verticesList[minColumn].setExpanded(true);
            row  = minColumn;

            // Check the status to see if the vertices are not all expanded
            status = needsExpanding(verticesList);
        }


        // Storing the shortest weights between all pairs and its parents in the corresponding
        // row according to the source
        for (int i = 0; i < verticesList.length; i++) {
            shortestPairsWeights[source.getIndex()][i] = verticesList[i].getWeight();
            shortestPairsParents[source.getIndex()][i] = verticesList[i].getParent();

            // Reset all the vertices before repeating the algorithm for other sources
            verticesList[i].reset();
        }

    }

    public static boolean needsExpanding (Vertex[] verticesList){
        for(Vertex element: verticesList){
            if (!element.isExpanded())
                return true;
        }

        return false;
    }

    public static void testCase1() {

        int[][] graph = createTestGraph1();
        int size = graph.length;

        int[][] shortestPairsWeights = new int[size][size];
        char[][] shortestPairsParents = new char[size][size];

        Vertex A = new Vertex(0, 'A');
        Vertex B = new Vertex(1, 'B');
        Vertex C = new Vertex(2, 'C');
        Vertex D = new Vertex(3, 'D');
        Vertex E = new Vertex(4, 'E');
        Vertex F = new Vertex(5, 'F');


        Vertex[] verticesList = {A, B, C, D, E, F};

        for (Vertex element: verticesList)
            dijkstrasAlgorithm(graph, element, verticesList, shortestPairsWeights, shortestPairsParents);


        System.out.println("TestCase1:");
        System.out.println("Matrix for the weights of the shortest path between pairs;");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(shortestPairsWeights[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nMatrix for the parents of the shortest path between pairs;");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(shortestPairsParents[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    public static int[][] createTestGraph1(){

        return new int[][]{
                {0, 7, 9, inf, inf, 14},
                {7, 0, 10, 15, inf, inf},
                {9, 10, 0, 11, inf, 2},
                {inf, 15, 11, 0, 6, inf},
                {inf, inf, inf, 6, 0, 9},
                {14, inf, 2, inf, 9, 0}
        };
    }

    public static void testCase2() {
        int[][] graph = createTestGraph2();
        int size = graph.length;

        int[][] shortestPairsWeights = new int[size][size];
        char[][] shortestPairsParents = new char[size][size];

        Vertex A = new Vertex(0, 'A');
        Vertex B = new Vertex(1, 'B');
        Vertex C = new Vertex(2, 'C');
        Vertex D = new Vertex(3, 'D');
        Vertex E = new Vertex(4, 'E');
        Vertex F = new Vertex(5, 'F');
        Vertex G = new Vertex(6, 'G');
        Vertex H = new Vertex(7, 'H');


        Vertex[] verticesList = {A, B, C, D, E, F, G, H};
        for (Vertex element: verticesList)
            dijkstrasAlgorithm(graph, element, verticesList, shortestPairsWeights, shortestPairsParents);


        System.out.println("TestCase2");
        System.out.println("Matrix for the weights of the shortest path between pairs;");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(shortestPairsWeights[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nMatrix for the parents of the shortest path between pairs;");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(shortestPairsParents[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    public static int[][] createTestGraph2(){

        return new int[][]{
                {0, 3, 3, 4, inf, inf, inf, inf},
                {3, 0, inf, 8, inf, 1, inf, inf},
                {3, inf, 0, inf, 6, 8, inf, inf},
                {4, 8, inf, 0, inf, 5, inf, inf},
                {inf, inf, 6, inf, 0, inf, inf, 8},
                {inf, 1, 8, 5, inf, 0, 7, inf},
                {inf, inf, inf, inf, inf, 7, 0, inf},
                {inf, inf, inf, inf, 8, inf, inf, 0}
        };
    }



}



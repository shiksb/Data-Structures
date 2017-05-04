import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class Graph {

  // Keep a fast index to nodes in the map
  private Map<Integer, Vertex> vertexNames;

  /**
   * Construct an empty Graph with a map. The map's key is the name of a vertex
   * and the map's value is the vertex object.
   */
  public Graph() {
    vertexNames = new HashMap<>();
  }

  /**
   * Adds a vertex to the graph. Throws IllegalArgumentException if two vertices
   * with the same name are added.
   * 
   * @param v
   *          (Vertex) vertex to be added to the graph
   */
  public void addVertex(Vertex v) {
    if (vertexNames.containsKey(v.name))
      throw new IllegalArgumentException("Cannot create new vertex with existing name.");
    vertexNames.put(v.name, v);
  }

  /**
   * Gets a collection of all the vertices in the graph
   * 
   * @return (Collection<Vertex>) collection of all the vertices in the graph
   */
  public Collection<Vertex> getVertices() {
    return vertexNames.values();
  }

  /**
   * Gets the vertex object with the given name
   * 
   * @param name
   *          (String) name of the vertex object requested
   * @return (Vertex) vertex object associated with the name
   */
  public Vertex getVertex(int name) {
    return vertexNames.get(name);
  }

  /**
   * Adds a directed edge from vertex u to vertex v
   * 
   * @param nameU
   *          (String) name of vertex u
   * @param nameV
   *          (String) name of vertex v
   * @param cost
   *          (double) cost of the edge between vertex u and v
   */
  public void addEdge(int nameU, int nameV, Double cost) {
    if (!vertexNames.containsKey(nameU))
      throw new IllegalArgumentException(nameU + " does not exist. Cannot create edge.");
    if (!vertexNames.containsKey(nameV))
      throw new IllegalArgumentException(nameV + " does not exist. Cannot create edge.");
    Vertex sourceVertex = vertexNames.get(nameU);
    Vertex targetVertex = vertexNames.get(nameV);
    Edge newEdge = new Edge(sourceVertex, targetVertex, cost);
    sourceVertex.addEdge(newEdge);
  }

  /**
   * Adds an undirected edge between vertex u and vertex v by adding a directed
   * edge from u to v, then a directed edge from v to u
   * 
   * @param name
   *          (String) name of vertex u
   * @param name2
   *          (String) name of vertex v
   * @param cost
   *          (double) cost of the edge between vertex u and v
   */
  public void addUndirectedEdge(int name, int name2, double cost) {
    addEdge(name, name2, cost);
    addEdge(name2, name, cost);
  }


  /**
   * Computes the euclidean distance between two points as described by their
   * coordinates
   * 
   * @param ux
   *          (double) x coordinate of point u
   * @param uy
   *          (double) y coordinate of point u
   * @param vx
   *          (double) x coordinate of point v
   * @param vy
   *          (double) y coordinate of point v
   * @return (double) distance between the two points
   */
  public double computeEuclideanDistance(double ux, double uy, double vx, double vy) {
    return Math.sqrt(Math.pow(ux - vx, 2) + Math.pow(uy - vy, 2));
  }

  /**
   * Computes euclidean distance between two vertices as described by their
   * coordinates
   * 
   * @param u
   *          (Vertex) vertex u
   * @param v
   *          (Vertex) vertex v
   * @return (double) distance between two vertices
   */
  public double computeEuclideanDistance(Vertex u, Vertex v) {
    return computeEuclideanDistance(u.x, u.y, v.x, v.y);
  }

  /**
   * Calculates the euclidean distance for all edges in the map using the
   * computeEuclideanCost method.
   */
  public void computeAllEuclideanDistances() {

    for (Vertex u : getVertices())
      for (Edge uv : u.adjacentEdges) {
        Vertex v = uv.target;
        uv.distance = computeEuclideanDistance(u.x, u.y, v.x, v.y);
      }
  }



  // STUDENT CODE STARTS HERE

  public void generateRandomVertices(int n) {
    this.vertexNames = new HashMap<>(); // reset the vertex hashmap
    Random rand = new Random(); // random object

    // iterating through the number of vertices
    for(int i = 0; i < n; i++){
      // defining the x and y coordinates
      int randIntX = (int) (rand.nextFloat()*100);
      int randIntY = (int) (rand.nextFloat()*100);
      // adding a vertex to a hashmap
      vertexNames.put(i, new Vertex(i, randIntX, randIntY));
      // adding every possible undirected edge
      if(i != 0){
        for(int j = 0; j < i; j++){
          addUndirectedEdge(j, i, 0.0);
        }
      }
    }
    computeAllEuclideanDistances(); // compute distances of edges
  }

  public List<Edge> nearestNeighborTsp() {

    LinkedList<Edge> nnBestPath = new LinkedList<>();
    double nnBestCost = Double.MAX_VALUE;


    for(int startingName = 0; startingName < vertexNames.size(); startingName++){

        // initializing the path linkedlist and the the list of 
          // verticies to visit
        LinkedList<Edge> path = new LinkedList<>();
        ArrayList<Vertex> toVisit = new ArrayList<>(getVertices());

        double cost = 0.0; // initializing the total cost to 0
        // getting the source vertex 

        // getting the sourceVertex and removing it from the 
            // toVisit list 
        Vertex sourceVertex = getVertex(startingName);
        toVisit.remove(sourceVertex);

        // defining nextVertex, the vertex to be visited next, as
            // the source vertex
        Vertex nextVertex = sourceVertex;
        // break out of the loop when all vertices have been visited
        while(toVisit.size() > 0) {
          // getting the smallest adjacent edge of nextVertex
          Edge smallestEdge = findSmallestEdge(toVisit, nextVertex);
          toVisit.remove(smallestEdge.target); // removing the visited vertex
          path.add(smallestEdge); // adding the edge to the path
          cost += smallestEdge.distance; // updating the cost
          //setting the next vertex to be visited to the edge target
          nextVertex = smallestEdge.target; 
        }

        //the last edge to be added is the current vertex --> source vertex
        Edge backToSource = new Edge(nextVertex, sourceVertex, 
                computeEuclideanDistance(nextVertex, sourceVertex));
        path.add(backToSource);
        // adding the last edge to the cost
        cost += backToSource.distance;

        // if the cost was less than the best cost,
          // update the best cost
        if(cost < nnBestCost){
          // reset the nnBestPath list
          nnBestPath = new LinkedList<>();
          // copying over the edges
          for(Edge e : path){
            nnBestPath.addLast(e);
          } 
          // updating the best cost
          nnBestCost = cost;
        }
    }
    // printing the path and cost
    System.out.println("Path: " + nnBestPath);
    System.out.println("Cost: " + nnBestCost);
    return nnBestPath; 
  }

  // this method returns the smallest edge in toVisit from vertex u
  private Edge findSmallestEdge(ArrayList<Vertex> toVisit, Vertex u){
      Edge nearest = new Edge(null, null, Double.MAX_VALUE);
      // iterating through every edge in u's adjacentEdges
      for(Edge e : u.adjacentEdges){
        if(toVisit.contains(e.target) && e.distance < nearest.distance){
          nearest = e;
        }
      }
      // returning nearest edge
      return nearest;
  }

  // the instance variables for the brute force algorithm
  private double bfBestCost;
  private int[] bfBestPath;

  public List<Edge> bruteForceTsp() {
    // getting the number of vertices
    int n = vertexNames.size();

    // defining the path as an arraylist of edges
    ArrayList<Edge> path = new ArrayList<>();

    // initializing the best path and best cost
    bfBestCost = Double.MAX_VALUE;
    bfBestPath = new int[n + 1];

    // creating an initial permutation
    int[] permutation = new int[n];
    for(int i = 0; i < n; i++)
      permutation[i] = i;

    // running the recursive combination method
    combination(permutation, 0, n - 1);

    // creating the shortest path
    for(int i = 0; i < bfBestPath.length - 1; i++) {
      Vertex u = getVertex(bfBestPath[i]);
      Vertex v = getVertex(bfBestPath[i + 1]);
      path.add(new Edge(u, v, computeEuclideanDistance(u, v)));
    }

    // printing the path and cost
    System.out.println("Path: " + path);
    System.out.println("Cost: " + this.bfBestCost);

    return path; 
  }

  // this method recursively creates different combinations 
      // and saves the best one
  private void combination(int[] combo, int begin, int end) {
    // end conidition
    if (begin == end) {
      double totalCost = 0.0; // setting the total cost to 0
      // iterating through the corresponding vertices to add cost
      for(int name = 0; name < combo.length - 1; name++){
        totalCost += computeEuclideanDistance(getVertex(combo[name]), 
                                              getVertex(combo[name + 1]));
      }
      // the last vertex is the starting vertex
      totalCost += computeEuclideanDistance(getVertex(combo[combo.length - 1]), 
                                            getVertex(combo[0]));

      // if the calculated cost is better than the best cost
          // then update the best cost and the best path
      if(totalCost < bfBestCost){
        // copying over the current path
        for(int i = 0; i < combo.length; i++){
          bfBestPath[i] = combo[i];
        }
        // adding the starting vertex 
        bfBestPath[combo.length] = combo[0];
        bfBestCost = totalCost; // updating best cost
      }
    } else {
        // iterate through the vertices
        for(int i = begin; i < end + 1; i++) {
            // exchanging the starting vertex and current vertex
            combo = exchange(combo, begin, i);
            // recursive call, sending the an incremented starting vertex
            combination(combo, begin + 1, end);
            // exchanging the starting vertex and current vertex
            combo = exchange(combo, begin, i);
        }
    }
  }
  
  // the exchange method, which swaps two references of the num array
  private int[] exchange(int[] num, int i, int j){
    int temp = num[i];
    num[i] = num[j];
    num[j] = temp;
    return num;
  }

  // STUDENT CODE ENDS HERE



  /**
   * Prints out the adjacency list of the graph for debugging
   */
  public void printAdjacencyList() {
    for (int u : vertexNames.keySet()) {
      StringBuilder sb = new StringBuilder();
      sb.append(u);
      sb.append(" -> [ ");
      for (Edge e : vertexNames.get(u).adjacentEdges) {
        sb.append(e.target.name);
        sb.append("(");
        sb.append(e.distance);
        sb.append(") ");
      }
      sb.append("]");
      System.out.println(sb.toString());
    }
  }
}

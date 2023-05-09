public class Main {
    public static void main(String[] args) {
        Node n1= new Node("n1");
        Node n2= new Node("n2");
        Node n3= new Node("n3");
        Node n4= new Node("n4");
        Node n5= new Node("n5");
        n1.link(n2,2);
        n1.link(n3,7);
        n2.link(n3, 5);
        n2.link(n4, 2);
        n3.link(n4, 3);
        n4.link(n5,6);
        Dijkstra dijkstra= new Dijkstra();
        dijkstra.add(n1);
        dijkstra.add(n2);
        dijkstra.add(n3);
        dijkstra.add(n4);
        dijkstra.add(n5);
        dijkstra.algoritmo(n1,n5);
        System.out.println(n5.getPath());

    }


}

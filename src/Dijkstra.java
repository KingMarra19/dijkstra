import java.util.PriorityQueue;
import java.util.Vector;

public class Dijkstra {

    private Vector<Node> Tnode;
    public Dijkstra(){
        Tnode=new Vector<>();
    }
    public void add(Node node){
        Tnode.add(node);
    }
    public Node remove(){
        return Tnode.remove(0);
    }
    public void algoritmo(Node inizio,Node arrivo){
        for (Node tmp:Tnode
             ) {
            tmp.setWeight(Integer.MAX_VALUE);              // setto la distanza infinito
        }
        inizio.setWeight(0);                               // setto la distanza del primo nodo a 0
        PriorityQueue<Node> Novisited= new PriorityQueue<>((a, b) -> a.getWeight() - b.getWeight());
        Novisited.addAll(Tnode);// aggiungo ai nodi non visitati tutti i nodi
        Node current=null;
        while (!Novisited.isEmpty() && arrivo!=current){                      // continuo finche non è vuoto
            current=Novisited.remove();               // tolgo il nodo con la distanza minore per confrontarlo
            for (Node collegato:current.getLinks().keySet()
                 ) {
                if(current.weightTo(collegato)< collegato.getWeight()){   // controllo se facendo questa strada la dimensione diminuisce
                    collegato.setWeight(current.weightTo(collegato));    // se si cambio i dati sulla distanza
                    collegato.setPrev(current);                          // dico ch il nodo corrente sarà il prossimo precendente
                }
            }
        }

    }

}

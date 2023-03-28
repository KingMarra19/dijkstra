import java.util.TreeMap;

public class Node {
    private String label;
    private int weight = Integer.MAX_VALUE;
    private TreeMap<Node, Integer> links;
    private Node prev = null;

    public Node(String label) {
        this.label = label;
        links = new TreeMap<>((a, b) -> a.label.compareTo(b.label));
    }

    public void link(Node node2, Integer weight) {
        links.put(node2, weight);
        node2.links.put(this, weight);
    }

    public int weightTo(Node node) {
        return weight + links.get(node);
    }

    public String getPath() {
        String weight = "";
        if (this.weight < Integer.MAX_VALUE)
            weight += this.weight;
        else
            weight = "inf";
        String out = "(" + label + "-" + weight + ")";
        if (prev != null) {
            out = prev.getPath() + "-" + prev.links.get(this) + "->" + out;
        }
        return out;
    }
    public String getLabel() {
        return label;
    }

    public int getWeight() {
        return weight;
    }

    public TreeMap<Node, Integer> getLinks() {
        return links;
    }

    public Node getPrev() {
        return prev;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setLinks(TreeMap<Node, Integer> links) {
        this.links = links;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}
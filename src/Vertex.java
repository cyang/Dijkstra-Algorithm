/**
 * Created by ChrisYang on 5/18/15.
 */
public class Vertex {

    private int index;
    private boolean expanded;
    private int weight;
    private char name;
    private char parent;


    public Vertex(int index, char name){
        this.name = name;
        this.index = index;
        expanded = false;
        weight = Integer.MAX_VALUE;
        parent = ' ';
    }

    public void reset(){
        expanded = false;
        weight = Integer.MAX_VALUE;
        parent = ' ';
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public char getParent() {
        return parent;
    }

    public void setParent(char parent) {
        this.parent = parent;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }
}


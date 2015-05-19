/**
 * @author      Christopher Yang <cyang001@citymail.cuny.edu>
 * @version     1.0
 * @since       2015-05-19
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
        parent = '_';
    }

    public void reset(){
        expanded = false;
        weight = Integer.MAX_VALUE;
        parent = '_';
    }

    public int getIndex() {
        return index;
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
}


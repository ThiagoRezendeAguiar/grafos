public class Edge {
    private int origin;
    private int destiny;

    public Edge(int origin, int destiny) {
        this.origin = origin;
        this.destiny = destiny;
    }

    public int getOrigin() {
        return this.origin;
    }

    public void setOrigin(int origin) {
        this.origin = origin;
    }

    public int getDestiny() {
        return this.destiny;
    }

    public void setDestiny(int destiny) {
        this.destiny = destiny;
    }


    @Override
    public String toString() {
        return "{" + getOrigin() + "," + getDestiny() + "}";
    }


}

package sample;

public class Relationship {
    public Student id;
    public Integer weight;

    public Relationship(Student id, Integer weight) {
        this.id = id;
        this.weight = weight;
    }

    public String toString(){
        return "[" + id + "," + weight + "]";
    }
}

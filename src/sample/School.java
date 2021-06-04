package sample;

import java.util.ArrayList;

public class School {
    private Graph<Student> students;
    private int size;

    public School(){
        students = new Graph<Student>();
        size = students.size;
    }

    public School(Graph<Student> students) {
        this.students = students;
        this.size = students.size;
    }

    public Graph<Student> getStudents(){
        return students;
    }

    public School(ArrayList<Student> students){
        this.students = new Graph<Student>();
        for(Student s : students){
            addStudent(s);
        }
        size = students.size();
    }

    public ArrayList<Relationship> getRelationships(Integer st){
        Student student = new Student(st);
        return students.getEdgeWeights(student);
    }

    public boolean addStudent(Student st){
        return students.addVertex(st);
    }

    public boolean addRelation(Integer st1, Integer st2, int rep1, int rep2){
        return students.addUndirectedEdge(new Student(st1),new Student(st2),rep1,rep2);
    }

    public int getSize(){
        return size;
    }
}

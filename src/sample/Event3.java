package sample;

import java.util.ArrayList;
import java.util.Scanner;

public class Event3 {
    private final School school;
    private String updates;

    public Event3(School school){
        this.school = school;
        this.updates = "";
    }

    public String startEvent(){
//        Scanner input = new Scanner(System.in);
//        String in = "";
//        while(!in.equalsIgnoreCase("q")){
//            update();
//            System.out.println("Press Enter to continue to next day, 'q' to quit ");
//            in = input.nextLine();
//        }
        update();
        return updates;
    }

    private void update(){
        updates = "";
        for(int i = 0; i < school.getSize(); i++){
            Student thisStudent = school.getStudents().getVertex(i);
            ArrayList<Relationship> relationships = school.getRelationships(thisStudent.getStudentID());
            sortByLunchTime(relationships,0,relationships.size()-1);
            haveLunch(thisStudent, relationships);
        }
        updates += "\n";
    }

    private void haveLunch(Student st, ArrayList<Relationship> rel){
        int currentTime = 1100;
        for(Relationship r : rel){
            Student st2 = r.id;
            if(st.getLunchTime() > st2.getLunchTime() &&
            st.getLunchTime() < st2.getLunchEndTime() ||
            st.getLunchEndTime() > st2.getLunchEndTime() &&
            st.getLunchTime() < st2.getLunchTime()) continue;
            if(currentTime < st2.getLunchEndTime()) {
                if(currentTime > st2.getLunchTime()){
                    updates += "Student " + st + " has lunch with student " + st2 + " at " + currentTime + "\n";
                }else{
                    updates += "Student " + st + " has lunch with student " + st2 + " at " + st2.getLunchTime() + "\n";
                }
                currentTime = startLunch(st, st2);
            }
        }
    }

    private int startLunch(Student st1, Student st2){
        school.getStudents().setEdgeWeight(st1, st2, school.getStudents().getEdgeWeight(st1, st2) + 1);
        return st2.getLunchEndTime();
    }

    private void merge(ArrayList<Relationship> arr, int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        Relationship L[] = new Relationship[n1];
        Relationship R[] = new Relationship[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr.get(l + i);
        for (int j = 0; j < n2; ++j)
            R[j] = arr.get(m + 1 + j);

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].id.getLunchTime() <= R[j].id.getLunchTime()) {
                arr.set(k, L[i]);
                i++;
            }
            else {
                arr.set(k,R[j]);
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr.set(k,L[i]);
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr.set(k,R[j]);
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sortByLunchTime(ArrayList<Relationship> arr, int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;

            // Sort first and second halves
            sortByLunchTime(arr, l, m);
            sortByLunchTime(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    /* A utility function to print array of size n */


}

package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

import javax.swing.text.html.ImageView;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Controller {
    @FXML private Label lunchUpdates;
    @FXML private javafx.scene.image.ImageView graphImage;

    private School school;
    private Event3 event3;

    public Controller(){
        ArrayList<Student> students = new ArrayList<>(Arrays.asList(new Student(1),
                new Student(2), new Student(3), new Student(4), new Student(5),
                new Student(6), new Student(7), new Student(8), new Student(9),
                new Student(10)));

        school = new School(students);
        school.addRelation(1, 7, 3, 7);
        school.addRelation(1, 2, 8, 5);
        school.addRelation(2, 5, 2, 6);
        school.addRelation(2, 3, 5, 5);
        school.addRelation(2, 6, 7, 9);
        school.addRelation(4, 8, 10, 7);
        school.addRelation(4, 10, 7, 7);
        school.addRelation(9, 10, 6, 5);

        event3 = new Event3(school);
    }

    public void pressButton(ActionEvent event) throws IOException {
        lunchUpdates.setText(event3.startEvent());
        Main.gvFileCreator(school);
        Main.gvDotRunner();
        File file = new File("C:\\WIA1002\\Sociopath\\src\\sample\\file.png");
        Image image = new Image(file.toURI().toString());
        graphImage.setImage(image);
    }
}

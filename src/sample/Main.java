package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Event 3");
        primaryStage.setScene(new Scene(root, 850, 650));
        primaryStage.show();
    }

    public static void gvDotRunner() throws IOException {
        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", "cd \"C:\\WIA1002\\Sociopath\\src\\sample\" && " +
                "\"C:\\Program Files\\Graphviz\\bin\\dot.exe\" -Tpng -Gsize=12,13\\! -Gdpi=100 g.gv -o file.png");
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while (true) {
            line = r.readLine();
            if (line == null) { break; }
            System.out.println(line);
        }
    }

    public static void gvFileCreator(School school){
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("C:\\WIA1002\\Sociopath\\src\\sample\\g.gv"), "utf-8"))) {
            writer.write(school.getStudents().gvEdgePrinter());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneBuilderMainTest extends Application
{
   final static String SceneBuilderTest = "SceneBuilderTest"; // internal name
   //final static String SceneBuilderTest = "SceneBuilderTest";

   /**
   The public method start of type void throws and Exception and
   it passes the parameter stage. The purpose of this method
   is to set the stage for the FXML file by loading it.
   @param stage of type Stage is passed as an argument into the
   method start.
   */

   public void start(Stage stage) throws Exception
   {
      Parent parent = FXMLLoader.load(
                  getClass().getResource(SceneBuilderTest + ".fxml") );

      Scene scene = new Scene(parent);

      stage.setTitle( SceneBuilderTest );
      stage.setScene(scene);
      stage.show();
   }

   public static void main(String[] args)
   {
      launch(SceneBuilderTest);
   }


}
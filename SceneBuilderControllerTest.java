import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import java.util.*;

public class SceneBuilderControllerTest
{
   @FXML private TextField getAge, getHeight, getWeight, displayIntake,
   getActivityLevel, getSex;
   @FXML private Button btnCalcIntake, btnClearCalc;

   public void btnCalcIntake()
   {
         int age;
         double weight, height, calorieTotal;
         String sex, activitySMA;

         age = Integer.parseInt(getAge.getText());
         weight = Double.parseDouble(getWeight.getText());
         height = Double.parseDouble(getHeight.getText());
         sex = getSex.getText();
         activitySMA = getActivityLevel.getText();

         double bmrFemale, bmrMale, sedentary, moderate, active;

         bmrFemale = (655 + (4.35 * weight) )+ ((4.7 * height) - (4.7 * (double) age));
         bmrMale = (66 + (6.23 * weight) )+ ((12.7 * height) - (6.8 * (double)age));
         sedentary = 1.2;
         moderate =  1.55;
         active = 1.725;


         calorieTotal = 0.0;

         if (sex.equals("M")  && activitySMA.equals("Sedentary") )
         {
            calorieTotal = bmrMale * sedentary;
         }
         else if (sex .equals("M")  && activitySMA .equals("Moderate"))
         {
            calorieTotal = bmrMale * moderate;
         }
         else if (sex .equals("M") && activitySMA .equals( "Active"))
         {
            calorieTotal = bmrMale * active;
         }
         else if (sex.equals("F") && activitySMA.equals("Sedentary") )
         {
            calorieTotal = bmrFemale * sedentary;
         }
         else if (sex.equals( "F") && activitySMA.equals("Moderate") )
         {
            calorieTotal = bmrFemale * moderate;
         }
         else if (sex.equals("F") && activitySMA.equals("Active"))
         {
             calorieTotal = bmrFemale * active;
         }
         displayIntake.setText(String.format("%.2f", calorieTotal));

   }

   //method to clear all of the fields
   public void btnClearCalc()
   {
      getAge.clear();
      getHeight.clear();
      getWeight.clear();
      displayIntake.clear();
      getActivityLevel.clear();
      getSex.clear();
   }

   private void error_alert(String prog, String title, String msg)
   {
      Alert alert = new Alert( Alert.AlertType.WARNING);
      alert.setTitle( prog );
      alert.setHeaderText( title );
      alert.setContentText( msg );
      alert.showAndWait();
   }
}
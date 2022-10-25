package dashboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class DashboardManagerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void doAboutDeveloper(ActionEvent event)
    {
    	
    }

    @FXML
    void doFeeCollector(MouseEvent event)
    {
    	try{
    		//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("chkradio/ChkRadView.fxml")); 
    		Parent root=FXMLLoader.load(getClass().getResource("/feecollector/Collector.fxml")); 
			Scene scene = new Scene(root);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }

    @FXML
    void doShowAllBatches(MouseEvent event) 
    {
    	try{
    		//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("chkradio/ChkRadView.fxml")); 
    		Parent root=FXMLLoader.load(getClass().getResource("/allbatches/matchManagerView.fxml")); 
			Scene scene = new Scene(root);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }

    @FXML
    void doShowAllStudents(MouseEvent event) 
    {
    	try{
    		//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("chkradio/ChkRadView.fxml")); 
    		Parent root=FXMLLoader.load(getClass().getResource("/allstudents/StudentManager.fxml")); 
			Scene scene = new Scene(root);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }

    @FXML
    void doShowBatch(MouseEvent event) 
    {
    	try{
    		//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("chkradio/ChkRadView.fxml")); 
    		Parent root=FXMLLoader.load(getClass().getResource("/BatchMaster/Batches.fxml")); 
			Scene scene = new Scene(root);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }

    @FXML
    void doShowFeeStatus(MouseEvent event) 
    {
    	try{
    		//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("chkradio/ChkRadView.fxml")); 
    		Parent root=FXMLLoader.load(getClass().getResource("/feestatus/FeeManage.fxml")); 
			Scene scene = new Scene(root);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }

    @FXML
    void doShowNewAddmission(MouseEvent event)
    {
    	try{
    		//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("chkradio/ChkRadView.fxml")); 
    		Parent root=FXMLLoader.load(getClass().getResource("/newadmission/Admission.fxml")); 
			Scene scene = new Scene(root);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }

    @FXML
    void doStudentGoogler(MouseEvent event) 
    {
    	try{
    		//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("chkradio/ChkRadView.fxml")); 
    		Parent root=FXMLLoader.load(getClass().getResource("/studentgoogler/Googler.fxml")); 
			Scene scene = new Scene(root);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }
    
    @FXML
    void doPmodeGoogler(MouseEvent event) 
    {
    	try{
    		//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("chkradio/ChkRadView.fxml")); 
    		Parent root=FXMLLoader.load(getClass().getResource("/payment/PaymentMode.fxml")); 
			Scene scene = new Scene(root);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }

    @FXML
    void initialize() 
    {
    	try {
//          Desktop.getDesktop().browse(new URI("http://www.realJavaOnline.com"));
//          Desktop.getDesktop().mail();
//          Desktop.getDesktop().open(new File("C:\\Python27\\news.txt"));
//  		Desktop.getDesktop().open(new File("C:\\Users\\Rajesh K. Bansal\\Dropbox\\data structure learning plan.docx"));
          
  	} catch (Exception e1) 
  	{
          e1.printStackTrace();
      }
    }

}

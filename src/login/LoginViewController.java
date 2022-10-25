package login;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

public class LoginViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtID;

    @FXML
    private PasswordField txtPassword;
    
    void showMsg(String msg)
    {
		// TODO Auto-generated method stub
    	Alert ms = new Alert(AlertType.CONFIRMATION);
       	ms.setTitle("Choises are : ");
       	ms.setContentText(msg);
       	ms.show();
		
	}

    @FXML
    void dologin(MouseEvent event) 
    {
    	if (txtID.getText().equals("Sunny") && txtPassword.getText().equals("7890"))
    	{
    		
    		try{
        		Parent root=FXMLLoader.load(getClass().getResource("/dashboard/DashboardManager.fxml")); 
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
    	else
    	{
    		showMsg("error");
    	}
    		
    }

    @FXML
    void initialize() 
    {
    	
    }

}

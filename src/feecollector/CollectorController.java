package feecollector;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import BatchMaster.ConnectToMysql;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class CollectorController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> ComboID;

    @FXML
    private AnchorPane anchor;

    @FXML
    private TextField txtBal;

    @FXML
    private TextField txtCourse;

    @FXML
    private TextField txtFee;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPaid;

    @FXML
    private TextField txtRec;

    @FXML
    private TextField txtTime;

    @FXML
    void doSearch(ActionEvent event) 
    {
    	try {
			pst = con.prepareStatement("select  * from trainees where tid=?");
			pst.setString(1, ComboID.getEditor().getText());
			ResultSet tbl = pst.executeQuery();
			
			boolean j = false;
			while(tbl.next())
			{
				j= true;
				String nm = tbl.getString("name");
				String tc = tbl.getString("tech");
				String tm = tbl.getString("btime");
				int tf = tbl.getInt("totalfee");
				int af = tbl.getInt("adv");
				float bl = tbl.getFloat("bal");
				
				System.out.println("   "+nm+"    "+tc+"  "+tm+" "+tf+" "+af+" "+bl);
				txtName.setText(nm);
				txtCourse.setText(tc);
				txtTime.setText(tm);
				txtFee.setText(String.valueOf(tf));
				txtPaid.setText(String.valueOf(af));
				txtBal.setText(String.valueOf(bl));
			}
			
			if(j==false)
			{
				showMsg("Not found");
			}
		    } 
    	catch (SQLException e)
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    void showMsg(String msg)
    {
		// TODO Auto-generated method stub
    	Alert ms = new Alert(AlertType.CONFIRMATION);
       	ms.setTitle("Choises are : ");
       	ms.setContentText(msg);
       	ms.show();
		
	}

	@FXML
    void doUpdate(ActionEvent event)
    {
    	try
    	{
    		pst = con.prepareStatement("update trainees set adv=adv+?, bal=bal-? where tid=?");
    		pst.setInt(1,Integer.parseInt(txtRec.getText()));
    		pst.setFloat(2, Float.parseFloat(txtRec.getText())); 
    		pst.setString(3, ComboID.getEditor().getText());
    	int count=	pst.executeUpdate();
    	if(count==1)
    	{
    		showMsg("Data Updated Succsessfulyy");
    	}
    	else
    	{
    		showMsg("error");
    	}
    	}
    	
    	 catch (SQLException e)
   	    {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    
    void doFill()
    {
    	ComboID.getItems().clear();
    	
    	try {
 			pst = con.prepareStatement("select tid from trainees");
 			ResultSet tbl= pst.executeQuery();
 			
 			while(tbl.next())
 			{
 				String str = tbl.getString("tid");
 				ComboID.getItems().add(str);
 			}
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
     }
    

    @FXML
    void initialize()
    {
    	 con=ConnectToMysql.doConnect();
    	 doFill();
    }
    
    PreparedStatement pst;
    Connection con;

}

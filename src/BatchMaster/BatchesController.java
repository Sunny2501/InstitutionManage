package BatchMaster;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.sql.Date;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

public class BatchesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> ComboBatch;

    @FXML
    private AnchorPane anchor;

    @FXML
    private TextField txtbokseats;

    @FXML
    private DatePicker txtdate;

    @FXML
    private TextField txtfee;

    @FXML
    private TextField txtseats;
    
    @FXML
    private ImageView imgpic;

    @FXML
    private ComboBox<String> txttime;
    
    @FXML
    void doNew(ActionEvent event)
    {
    	txtbokseats.setText("");
        //ComboBatch.selectionModel.selecteditems("");
    	txtfee.setText("");
    	txtseats.setText("");
    	//txttime.setText("");

    }

    @FXML
    void doBrowse(ActionEvent event)
    {
    	FileChooser fx = new FileChooser();
        fx.setTitle("Choose a file");
        Stage stg = (Stage)anchor.getScene().getWindow();
       
       java.io.File show = fx.showOpenDialog(stg);
       
       if(show!=null)
       {
      	 Image ymg = new javafx.scene.image.Image(show.toURI().toString());
      	 imgpic.setImage(ymg);
       } 
   
    }
    
    
    @FXML
    void DoUpdate(ActionEvent event)
    {
   	    try {
			pst = con1.prepareStatement("update batchess set Sdate=? ,Stime=?, Tseats=?,Booked=?, Fee=? where B_name=?   ");
			pst.setString(6, ComboBatch.getEditor().getText());
			LocalDate lcl = txtdate.getValue();
			pst.setDate(1, java.sql.Date.valueOf(lcl));
			pst.setString(2,  txttime.getEditor().getText());
			pst.setInt(3, Integer.parseInt(txtseats.getText()));
           pst.setInt(4, Integer.parseInt(txtbokseats.getText()));
           pst.setFloat(5, Float.parseFloat(txtfee.getText()));
           int count= pst.executeUpdate();
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
   	ComboBatch.getItems().clear();
   	txttime.getItems().clear();
   	
   	try {
			pst = con1.prepareStatement("select distinct B_name from batchess");
			ResultSet tbl= pst.executeQuery();
			
			while(tbl.next())
			{
				String str = tbl.getString("B_name");
				ComboBatch.getItems().add(str);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void doDelete(ActionEvent event)
    {
    	doFill();
   	 try {
				pst = con1.prepareStatement("delete from batchess where B_name =?");
				 pst.setString(1, ComboBatch.getEditor().getText());
				 int c = pst.executeUpdate();
				 
				 showMsg(c+"Record Deleted");
		 }
   	 catch (SQLException e) 
   	 {
				// TODO Auto-generated catch block
				e.printStackTrace();
	 }

   }
    
   void showMsg(String msg)
   {
   	Alert ms = new Alert(AlertType.CONFIRMATION);
   	ms.setTitle("Choises are : ");
   	ms.setContentText(msg);
   	ms.show();
   }
   PreparedStatement pst;
    Connection con1;

    @FXML
    void doSave(ActionEvent event)
    {
    	doFill();
    	try {
    	pst = con1.prepareStatement("insert into batchess values (?,?,?,?,?,?)");
		pst.setString(1,ComboBatch.getEditor().getText());
		LocalDate lcl = txtdate.getValue();
		pst.setDate(2, java.sql.Date.valueOf(lcl));
		pst.setString(3, txttime.getEditor().getText());
		pst.setInt(4, Integer.parseInt(txtseats.getText()));
		pst.setInt(5, Integer.parseInt(txtbokseats.getText()));
		pst.setInt(6, Integer.parseInt(txtfee.getText()));
		pst.executeUpdate();
		showMsg("Data Submitted Succsessfulyy ");
    	}
	 catch (SQLException e)
    	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
    }

    @FXML
    void doSearch(ActionEvent event)
    {
    	try {
			pst = con1.prepareStatement("select  * from batchess where B_name=?");
			pst.setString(1, ComboBatch.getEditor().getText());
			ResultSet tbl = pst.executeQuery();
			
			boolean j = false;
			while(tbl.next())
			{
				j= true;
				String roll = tbl.getString("B_name");
				Date db = tbl.getDate("Sdate");
				String s = tbl.getString("Stime");
				int Seat = tbl.getInt("Tseats");
				int Bseat = tbl.getInt("Booked");
				Float fee = tbl.getFloat("Fee");
				
																																																																																																																																																																																																					System.out.println(roll+"   "+db.toString()+"    "+s+"   "+Seat+"  "+Bseat+"  "+fee);
				txtdate.setValue(db.toLocalDate());
				txttime.setValue(s);
				txtseats.setText(String.valueOf(Seat));
				txtbokseats.setText(String.valueOf(Bseat));
				txtfee.setText(String.valueOf(fee));
			
				txtdate.setValue(db.toLocalDate());
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
    
  
    @FXML
    void initialize()
    {
        con1=ConnectToMysql.doConnect();
        doFill();

    }

}

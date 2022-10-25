package newadmission;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.ResourceBundle;

import BatchMaster.ConnectToMysql;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;


public class AdmissionController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> ComboBranch;

    @FXML
    private ComboBox<String> ComboCollege;

    @FXML
    private ComboBox<String> ComboSem;
    
    @FXML
    private ComboBox<String> Combotech;
    
    @FXML
    private ComboBox<String> ComboMode;
    
    @FXML
    private AnchorPane anchor;

    @FXML
    private ImageView imgpic;

    @FXML
    private TextField txtAdvFee;

    @FXML
    private TextField txtDate;

    @FXML
    private TextField txtMobile;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtTime;

    @FXML
    private TextField txtTotFee;

    @FXML
    void doClear(ActionEvent event) 
    {
    	txtAdvFee.setText("");
    	txtDate.setText("");
    	txtMobile.setText("");
    	txtName.setText("");
    	txtTime.setText("");
    	txtTotFee.setText("");
    	//ComboBranch.selectionModelProperty().selecteditems("");
    	//ComboCollege.selectionModelProperty().selecteditems("");
    	//ComboSem.selectionModelProperty().selecteditems("");

    }

    
    String getid()
    {
    	Random rnd=new Random();
    	 
    		int r = rnd.nextInt(1000);
    	//System.out.println(r);
    	
    	String name = txtName.getText();
    	String name1 = name.substring(0, 3);
    	String num = txtMobile.getText();
    	String num1 = num.substring(num.length()-2, num.length());
    	System.out.println(num1+"    "+name1);
    	
    	StringBuilder str  = new StringBuilder();
    	str.append(name1).append(String.valueOf(r)).append(num1);
    	
    	return str.toString();
    }
    
    void showMsg(String msg)
    {
    	Alert ms = new Alert(AlertType.CONFIRMATION);
    	ms.setTitle("Choises are : ");
    	ms.setContentText(msg);
    	ms.show();
    }
    
    Connection con1;

    @FXML
    void doSave(ActionEvent event)
    {
    	String str = getid();
    	try {
			pst = con.prepareStatement("INSERT into trainees values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,current_date())");
			pst.setString(1,str);
			pst.setString(2, txtName.getText());
			pst.setString(3, txtMobile.getText());
			pst.setString(4, ComboCollege.getEditor().getText());
			pst.setString(5, ComboSem.getSelectionModel().getSelectedItem());
			pst.setString(6, ComboBranch.getSelectionModel().getSelectedItem());
			pst.setString(7,Combotech.getSelectionModel().getSelectedItem());
			pst.setString(8, txtDate.getText());
			pst.setString(9, txtTime.getText());
			pst.setInt(10, Integer.parseInt(txtTotFee.getText()));
			pst.setInt(11, Integer.parseInt(txtAdvFee.getText()));
			float bal =Float.parseFloat( txtTotFee.getText())-Float.parseFloat(txtAdvFee.getText());
			pst.setFloat(12, Float.parseFloat(String.valueOf(bal)));
			pst.setString(13, ComboMode.getSelectionModel().getSelectedItem());
			pst.setString(14, pic);
			pst.executeUpdate();
			showMsg("Data Submitted Succsessfulyy ");
		} 
    	catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    PreparedStatement pst;

    String pic;
    @FXML
    void doUpload(ActionEvent event)
    {
    	FileChooser fx = new FileChooser();
        fx.setTitle("Choose a file");
        Stage stg = (Stage)anchor.getScene().getWindow();
       
       java.io.File show = fx.showOpenDialog(stg);
       
       pic = show.getAbsolutePath();
    	if(show!=null)
        {
       	 Image ymg = new javafx.scene.image.Image(show.toURI().toString());
       	 imgpic.setImage(ymg);
        }
    }
    
    @FXML
    void showdetails(ActionEvent event) {
             try {
				pst = con.prepareStatement("select Sdate,Stime,Fee from batchess where B_name=?");
				pst.setString(1, Combotech.getSelectionModel().getSelectedItem());
				ResultSet tbl = pst.executeQuery();
				while(tbl.next())
				{
					String db = tbl.getString("Sdate");
					String s = tbl.getString("Stime");
					int fee = tbl.getInt("Fee");
					
					System.out.println("   "+db+"    "+s+"  "+fee);
					txtDate.setText(db);
					txtTime.setText(s);
					txtTotFee.setText(String.valueOf(fee));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
             
    }

    Connection con;
    @FXML
    void initialize()
    {
    	ArrayList<String> ary2 = new ArrayList<String>(Arrays.asList("Cash","Paytm","G-Pay","Bank Transfer","Upi"));
    	ComboMode.getItems().addAll(ary2);
    	
    	ArrayList<String> ary1 = new ArrayList<String>(Arrays.asList("ECE","CSE","ME","CE"));
    	ComboBranch.getItems().addAll(ary1);
        
    	ArrayList<String> ary = new ArrayList<String>(Arrays.asList("1","2","3","4","5","6","7","8","Beginneer","Passout"));
    	ComboSem.getItems().addAll(ary);
    	
      con=ConnectToMysql.doConnect();
      try 
      {
		PreparedStatement	pst = con.prepareStatement("select B_name from batchess");
			ResultSet tbl = pst.executeQuery();
			
			while(tbl.next())
			{
				String str = tbl.getString("B_name");
				System.out.println(str);
				Combotech.getItems().add(str);
			}
		} 
      catch (SQLException e) 
      {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }    

}

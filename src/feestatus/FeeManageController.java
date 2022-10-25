package feestatus;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import allbatches.ConnectToMysql;

public class FeeManageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> ComboTech;

    @FXML
    private TableView<StudentFeeBean> tblview;
    
    @FXML
    private RadioButton balanceradio;

    @FXML
    private RadioButton paidradio;

    
    void doAddCols()
    {
    	TableColumn<StudentFeeBean, String> tid=new TableColumn<StudentFeeBean, String>("ID");
    	tid.setCellValueFactory(new PropertyValueFactory<>("tid"));//same as bean property
    	tid.setMinWidth(100);
    	
    	TableColumn<StudentFeeBean, String> name=new TableColumn<StudentFeeBean, String>("Name");
    	name.setCellValueFactory(new PropertyValueFactory<>("name"));//same as bean property
    	name.setMinWidth(100);
    	
    	TableColumn<StudentFeeBean, String> mobile=new TableColumn<StudentFeeBean, String>("Mobile");
    	mobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));//same as bean property
    	mobile.setMinWidth(100);
    	
    	TableColumn<StudentFeeBean, String> college=new TableColumn<StudentFeeBean, String>("College");
    	college.setCellValueFactory(new PropertyValueFactory<>("college"));//same as bean property
    	college.setMinWidth(100);
    	
    	TableColumn<StudentFeeBean, String> sem=new TableColumn<StudentFeeBean, String>("Semestem");
    	sem.setCellValueFactory(new PropertyValueFactory<>("sem"));//same as bean property
    	sem.setMinWidth(100);
    	
    	TableColumn<StudentFeeBean, String> branch=new TableColumn<StudentFeeBean, String>("Branch");
    	branch.setCellValueFactory(new PropertyValueFactory<>("branch"));//same as bean property
    	branch.setMinWidth(100);
    	
    	TableColumn<StudentFeeBean, String> tech=new TableColumn<StudentFeeBean, String>("Technology");
    	tech.setCellValueFactory(new PropertyValueFactory<>("tech"));//same as bean property
    	tech.setMinWidth(100);
    	
    	TableColumn<StudentFeeBean, Integer> totalfee=new TableColumn<StudentFeeBean, Integer>("TotalFee");
    	totalfee.setCellValueFactory(new PropertyValueFactory<>("totalfee"));//same as bean property
    	totalfee.setMinWidth(100);
    	
    	TableColumn<StudentFeeBean, Integer> adv=new TableColumn<StudentFeeBean, Integer>("AdvanceFee");
    	adv.setCellValueFactory(new PropertyValueFactory<>("adv"));//same as bean property
    	adv.setMinWidth(100);
    	
    	TableColumn<StudentFeeBean, Float> bal=new TableColumn<StudentFeeBean, Float>("Balance");
    	bal.setCellValueFactory(new PropertyValueFactory<>("bal"));//same as bean property
    	bal.setMinWidth(100);
    	
    	TableColumn<StudentFeeBean, String> pmode=new TableColumn<StudentFeeBean, String>("Payment Mode");
    	pmode.setCellValueFactory(new PropertyValueFactory<>("pmode"));//same as bean property
    	pmode.setMinWidth(100);
    	
    	TableColumn<StudentFeeBean, String> picpath=new TableColumn<StudentFeeBean, String>("Picture");
    picpath.setCellValueFactory(new PropertyValueFactory<>("picpath"));//same as bean property
    	picpath.setMinWidth(100);
    	
    	tblview.getColumns().addAll(tid,name,mobile,college,sem,branch,tech,totalfee,adv,bal,pmode,picpath);
    	
    }
    
    @FXML
    void doshow(ActionEvent event) 
    
    {
    	tblview.getItems().clear();
    	
    	if(paidradio.isSelected()==true)
    	{
    		 ObservableList<StudentFeeBean> clg1=FXCollections.observableArrayList();
    	       	
    	     	try {
    	     				
    	     				per=con.prepareStatement("select * from  trainees where tech=? and bal=0");//0 or 1 records
    	     				per.setString(1,ComboTech.getValue());
    	     				
    	     				ResultSet tableInMem= per.executeQuery();
    	     				
    	     				while(tableInMem.next())
    	     				{
    	     					
    	     					String tid=tableInMem.getString("tid");
    	     					String name= tableInMem.getString("name");
    	     					String mobile=tableInMem.getString("mobile");
    	     					String college=tableInMem.getString("college");
    	     					String sem=tableInMem.getString("sem");
    	     					String branch=tableInMem.getString("branch");
    	     					String tech=tableInMem.getString("tech");
    	     					int totalfee = tableInMem.getInt("totalfee");
    	     					int adv = tableInMem.getInt("adv");
    	     					float bal = tableInMem.getFloat("bal");
    	     					String pmode= tableInMem.getString("pmode");
    	     					String picpath=tableInMem.getString("picpath");
    	     					
    	     				   StudentFeeBean arry=new StudentFeeBean(tid, name, mobile, college, sem, branch, tech, totalfee, adv, bal, pmode, picpath);
    	     				   clg1.add(arry);
    	     					tblview.setItems(clg1);	
    	     				}
    	     			} 
    	     	    	catch (SQLException e) {
    	     				// TODO Auto-generated catch block
    	     				e.printStackTrace();
    	     			}
    	}
    	
    	else	 if(balanceradio.isSelected()==true)
    	{
    		 ObservableList<StudentFeeBean> clg2=FXCollections.observableArrayList();
    	       	System.out.println(balanceradio);
    	     	try {
    	     				
    	     				per=con.prepareStatement("select * from  trainees where tech=? and bal!=0");//0 or 1 records
    	     				per.setString(1,ComboTech.getValue());
    	     				
    	     				ResultSet tableInMem= per.executeQuery();
    	     				
    	     				while(tableInMem.next())
    	     				{
    	     					
    	     					String tid=tableInMem.getString("tid");
    	     					String name= tableInMem.getString("name");
    	     					String mobile=tableInMem.getString("mobile");
    	     					String college=tableInMem.getString("college");
    	     					String sem=tableInMem.getString("sem");
    	     					String branch=tableInMem.getString("branch");
    	     					String tech=tableInMem.getString("tech");
    	     					int totalfee = tableInMem.getInt("totalfee");
    	     					int adv = tableInMem.getInt("adv");
    	     					float bal = tableInMem.getFloat("bal");
    	     					String pmode= tableInMem.getString("pmode");
    	     					String picpath=tableInMem.getString("picpath");
    	     					
    	     				   StudentFeeBean arry=new StudentFeeBean(tid, name, mobile, college, sem, branch, tech, totalfee, adv, bal, pmode, picpath);
    	     				   clg2.add(arry);
    	     					tblview.setItems(clg2);	
    	     				}
    	     			} 
    	     	    	catch (SQLException e) {
    	     				// TODO Auto-generated catch block
    	     				e.printStackTrace();
    	     			}
    	}
    	
    	
    }
    
    void dofilltech() {
   	 try {
   			
   			per=con.prepareStatement("select distinct tech  from  trainees");//0 or 1 records
   			
   			ResultSet tableInMem= per.executeQuery();
   			
   			while(tableInMem.next())
   			{
   				String tech=tableInMem.getString("tech");
   				ComboTech.getItems().add(tech);
   			}
   		} 
    	catch (SQLException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}

    }

    @FXML
    void initialize() 
    {
    	con=ConnectToMysql.doConnect();
        doAddCols();
        dofilltech();
    }
    
    Connection con;
    PreparedStatement per;

}






package payment;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import studentgoogler.ConnectToMysql;
import studentgoogler.StudentBean;

public class PaymentModeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> ComboMode;

    @FXML
    private TableView<PaymentBean> tblview;

    @FXML
    void doSearch(ActionEvent event)
    {
        ObservableList<PaymentBean> clg=FXCollections.observableArrayList();
      	
    	try {
    				
    				per=con.prepareStatement("select * from  trainees where pmode=?");//0 or 1 records
    				per.setString(1,ComboMode.getValue());
    				
    				
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
    					String pmode= tableInMem.getString("pmode");
    					
    					PaymentBean arry=new PaymentBean(tid, name, mobile, college, sem, branch, tech, 0, 0, 0, pmode);
    					clg.add(arry);
    					tblview.setItems(clg);
    				}
    				
    				
    			} 
    	    	catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    }
    
    void doAddCols()
    {
    	TableColumn<PaymentBean, String> tid=new TableColumn<PaymentBean, String>("ID");
    	tid.setCellValueFactory(new PropertyValueFactory<>("tid"));//same as bean property
    	tid.setMinWidth(100);
    	
    	TableColumn<PaymentBean, String> name=new TableColumn<PaymentBean, String>("Name");
    	name.setCellValueFactory(new PropertyValueFactory<>("name"));//same as bean property
    	name.setMinWidth(100);
    	
    	TableColumn<PaymentBean, String> mobile=new TableColumn<PaymentBean, String>("Mobile");
    	mobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));//same as bean property
    	mobile.setMinWidth(100);
    	
    	TableColumn<PaymentBean, String> college=new TableColumn<PaymentBean, String>("College");
    	college.setCellValueFactory(new PropertyValueFactory<>("college"));//same as bean property
    	college.setMinWidth(100);
    	
    	TableColumn<PaymentBean, String> sem=new TableColumn<PaymentBean, String>("Semestem");
    	sem.setCellValueFactory(new PropertyValueFactory<>("sem"));//same as bean property
    	sem.setMinWidth(100);
    	
    	TableColumn<PaymentBean, String> branch=new TableColumn<PaymentBean, String>("Branch");
    	branch.setCellValueFactory(new PropertyValueFactory<>("branch"));//same as bean property
    	branch.setMinWidth(100);
    	
    	TableColumn<PaymentBean, String> tech=new TableColumn<PaymentBean, String>("Technology");
    	tech.setCellValueFactory(new PropertyValueFactory<>("tech"));//same as bean property
    	tech.setMinWidth(100);
    	
    	TableColumn<PaymentBean, String> pmode=new TableColumn<PaymentBean, String>("Payment Mode");
    	pmode.setCellValueFactory(new PropertyValueFactory<>("pmode"));//same as bean property
    	pmode.setMinWidth(100);
    	
            tblview.getColumns().addAll(tid,name,mobile,college,sem,branch,tech,pmode);
    	
    }
    
        ObservableList<PaymentBean> 
        
fetchalldata() 
        {
    	
    	ObservableList<PaymentBean> obj=FXCollections.observableArrayList();
      	
    	try {
    				
    				per=con.prepareStatement("select * from  trainees");//0 or 1 records
    				
    				
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
    					String pmode= tableInMem.getString("pmode");
    					    				
    					PaymentBean arry=new PaymentBean(tid, name, mobile, college, sem, branch, tech, 0, 0, 0, pmode);
    					obj.add(arry);
    				}
    				
    				
    			} 
    	    	catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    	return obj;

    }
        
    void dofillMode() {
       	 try {
       			
       			per=con.prepareStatement("select distinct pmode  from  trainees");//0 or 1 records
       			
       			ResultSet tableInMem= per.executeQuery();
       			
       			while(tableInMem.next())
       			{
       				String pmode=tableInMem.getString("pmode");
       				ComboMode.getItems().add(pmode);
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
        dofillMode();
    }
    Connection con;
    PreparedStatement per;

}

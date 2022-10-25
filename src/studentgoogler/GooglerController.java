package studentgoogler;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class GooglerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> ComboCollege;

    @FXML
    private ComboBox<String> ComboTechnologies;

    @FXML
    private AnchorPane anchor;

    @FXML
    private TableView<StudentBean> tblview;

    @FXML
    void doFind(ActionEvent event) 
    {
        ObservableList<StudentBean> clg=FXCollections.observableArrayList();
      	
    	try {
    				
    				per=con.prepareStatement("select * from  trainees where college=?");//0 or 1 records
    				per.setString(1,ComboCollege.getValue());
    				
    				
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
    					String picpath=tableInMem.getString("picpath");
    					
    					StudentBean arry=new StudentBean(tid, name, mobile, college, sem, branch, tech, picpath);
    					clg.add(arry);
    					tblview.setItems(clg);
    				}
    				
    				
    			} 
    	    	catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    }

    @FXML
    void doGetAll(ActionEvent event) 
    {
        ObservableList<StudentBean> clg=FXCollections.observableArrayList();
      	
    	try {
    				
    				per=con.prepareStatement("select * from  trainees where tech=?");//0 or 1 records
    				per.setString(1,ComboTechnologies.getValue());
    				
    				
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
    					String picpath=tableInMem.getString("picpath");
    					
    				   StudentBean arry=new StudentBean(tid, name, mobile, college, sem, branch, tech, picpath);
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
    	TableColumn<StudentBean, String> tid=new TableColumn<StudentBean, String>("ID");
    	tid.setCellValueFactory(new PropertyValueFactory<>("tid"));//same as bean property
    	tid.setMinWidth(100);
    	
    	TableColumn<StudentBean, String> name=new TableColumn<StudentBean, String>("Name");
    	name.setCellValueFactory(new PropertyValueFactory<>("name"));//same as bean property
    	name.setMinWidth(100);
    	
    	TableColumn<StudentBean, String> mobile=new TableColumn<StudentBean, String>("Mobile");
    	mobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));//same as bean property
    	mobile.setMinWidth(100);
    	
    	TableColumn<StudentBean, String> college=new TableColumn<StudentBean, String>("College");
    	college.setCellValueFactory(new PropertyValueFactory<>("college"));//same as bean property
    	college.setMinWidth(100);
    	
    	TableColumn<StudentBean, String> sem=new TableColumn<StudentBean, String>("Semestem");
    	sem.setCellValueFactory(new PropertyValueFactory<>("sem"));//same as bean property
    	sem.setMinWidth(100);
    	
    	TableColumn<StudentBean, String> branch=new TableColumn<StudentBean, String>("Branch");
    	branch.setCellValueFactory(new PropertyValueFactory<>("branch"));//same as bean property
    	branch.setMinWidth(100);
    	
    	TableColumn<StudentBean, String> tech=new TableColumn<StudentBean, String>("Technology");
    	tech.setCellValueFactory(new PropertyValueFactory<>("tech"));//same as bean property
    	tech.setMinWidth(100);
    	
    	TableColumn<StudentBean, String> picpath=new TableColumn<StudentBean, String>("Picture");
    picpath.setCellValueFactory(new PropertyValueFactory<>("picpath"));//same as bean property
    	picpath.setMinWidth(100);
    	
            tblview.getColumns().addAll(tid,name,mobile,college,sem,branch,tech,picpath);
    	
    }
    
        ObservableList<StudentBean> 
        
fetchalldata() 
        {
    	
    	ObservableList<StudentBean> obj=FXCollections.observableArrayList();
      	
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
    					String pic=tableInMem.getString("picpath");
    					    				
    				StudentBean arry=new StudentBean(tid, name, mobile, college, sem, branch, tech, pic);
    					obj.add(arry);
    				}
    				
    				
    			} 
    	    	catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    	return obj;

    }
 
 void dofillcollege() {
	 try {
			
			per=con.prepareStatement("select distinct college  from  trainees");//0 or 1 records
			per2=con.prepareStatement("select distinct tech  from  trainees");
			
			ResultSet tableInMem= per.executeQuery();
			ResultSet tableIntech= per2.executeQuery();
			
			while(tableInMem.next())
			{
				
				
				String college=tableInMem.getString("college");
				ComboCollege.getItems().add(college);
			}
			
			while(tableIntech.next())
			{
				String tech=tableIntech.getString("tech");
				ComboTechnologies.getItems().add(tech);
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
        dofillcollege();
    }
    Connection con;
    PreparedStatement per;
    PreparedStatement per2;
}

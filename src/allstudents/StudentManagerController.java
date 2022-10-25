package allstudents;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import allbatches.ConnectToMysql;
import allbatches.batchBean;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class StudentManagerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<StudentBean> tblview;

    @FXML
    void doFetchall(ActionEvent event)
    {
    	ObservableList<StudentBean> ary=getAll();
    	System.out.println("ethheeeeeeee aaa"+ary.get(0).getAdv());
    	tblview.setItems(ary);
    }
    
    void doAddCols()
    {
    	TableColumn<StudentBean, String> tidCol=new TableColumn<StudentBean, String>("Student ID");
    	tidCol.setCellValueFactory(new PropertyValueFactory<>("tid"));//same as bean property
    	tidCol.setMinWidth(100);
    	
    	TableColumn<StudentBean, String> nameCol=new TableColumn<StudentBean, String>("Name");
    	nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));//same as bean property
    	nameCol.setMinWidth(100);
    	
    	TableColumn<StudentBean, String> mobileCol=new TableColumn<StudentBean, String>("Mobile");
    	mobileCol.setCellValueFactory(new PropertyValueFactory<>("mobile"));//same as bean property
    	mobileCol.setMinWidth(100);
    	
    	TableColumn<StudentBean, String> collegeCol=new TableColumn<StudentBean, String>("College");
    	collegeCol.setCellValueFactory(new PropertyValueFactory<>("college"));//same as bean property
    	collegeCol.setMinWidth(100);
    	
    	TableColumn<StudentBean, String> semCol=new TableColumn<StudentBean, String>("Semester");
    	semCol.setCellValueFactory(new PropertyValueFactory<>("sem"));//same as bean property
    	semCol.setMinWidth(100);
    	
    	TableColumn<StudentBean, String> branchCol=new TableColumn<StudentBean, String>("Branch");
    	branchCol.setCellValueFactory(new PropertyValueFactory<>("branch"));//same as bean property
    	branchCol.setMinWidth(100);
    	
    	TableColumn<StudentBean, String> techCol=new TableColumn<StudentBean, String>("Technology");
    	techCol.setCellValueFactory(new PropertyValueFactory<>("tech"));//same as bean property
    	techCol.setMinWidth(100);
    	
    	TableColumn<StudentBean, Integer> totalfeeCol=new TableColumn<StudentBean, Integer>("TotalFee");
    	totalfeeCol.setCellValueFactory(new PropertyValueFactory<>("totalfee"));//same as bean property
    	totalfeeCol.setMinWidth(100);
    	
    	TableColumn<StudentBean, Integer> advCol=new TableColumn<StudentBean, Integer>("AdvanceFee");
    	advCol.setCellValueFactory(new PropertyValueFactory<>("adv"));//same as bean property
    	advCol.setMinWidth(100);
    	
    	TableColumn<StudentBean, Float> balCol=new TableColumn<StudentBean, Float>("Balance");
    	balCol.setCellValueFactory(new PropertyValueFactory<>("bal"));//same as bean property
    	balCol.setMinWidth(100);
    	
    	TableColumn<StudentBean, String> pmodeCol=new TableColumn<StudentBean, String>("Payment Mode");
    	pmodeCol.setCellValueFactory(new PropertyValueFactory<>("pmode"));//same as bean property
    	pmodeCol.setMinWidth(100);
    	
    	TableColumn<StudentBean, String> picpathCol=new TableColumn<StudentBean, String>("PicPath");
    	picpathCol.setCellValueFactory(new PropertyValueFactory<>("picpath"));//same as bean property
    	picpathCol.setMinWidth(100);
    	
    	tblview.getColumns().addAll(tidCol,nameCol,mobileCol,collegeCol,semCol,branchCol,techCol,totalfeeCol,advCol,balCol,pmodeCol,picpathCol);
    	
    }
    
    Connection con;
    
    ObservableList<StudentBean>
    
    getAll()
    {    	
    	ObservableList<StudentBean> ary=FXCollections.observableArrayList();
    	try
    	{	
			PreparedStatement pst=con.prepareStatement("select * from  trainees");
			ResultSet tableInMem= pst.executeQuery();
			
			while(tableInMem.next())
			{
				
				String tid = tableInMem.getString("tid");
				String name = tableInMem.getString("name");
				String mobile = tableInMem.getString("mobile");
				String college = tableInMem.getString("college");
				String sem = tableInMem.getString("sem");
				String branch = tableInMem.getString("branch");
				String tech = tableInMem.getString("tech");
				int totalfee = tableInMem.getInt("totalfee");
				int adv = tableInMem.getInt("adv");
				float bal = tableInMem.getFloat("bal");
				String pmode = tableInMem.getString("pmode");
				String picpath = tableInMem.getString("picpath");
				
				StudentBean obj=new StudentBean(tid,name,mobile,college,sem,branch,tech,totalfee,adv,bal,pmode,picpath);
				ary.add(obj);
				System.out.println(tid+" "+name+" "+mobile+" "+college+" "+sem+" "+branch+" "+tech+" "+totalfee+" "+adv+" "+bal+" "+pmode+" "+picpath);
				
			}
			
			
		} 
    	catch (SQLException e)
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ary;
    	
    }

    @FXML
    void initialize()
    {
    	con = ConnectToMysql.doConnect();
    	doAddCols();
    }

}

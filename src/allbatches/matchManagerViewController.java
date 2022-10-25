package allbatches;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Collections;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class matchManagerViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<batchBean> tblview;

    @FXML
    void doFetchall(ActionEvent event)
    {
    	ObservableList<batchBean> ary=getAll();
    	tblview.setItems(ary);
    }
    
    void doAddCols()
    {
    	TableColumn<batchBean, String> B_nameCol=new TableColumn<batchBean, String>("Batch Name");
    	B_nameCol.setCellValueFactory(new PropertyValueFactory<>("B_name"));//same as bean property
    	B_nameCol.setMinWidth(100);
    	
    	TableColumn<batchBean, String> SdateCol=new TableColumn<batchBean, String>("Date");
    	SdateCol.setCellValueFactory(new PropertyValueFactory<>("Sdate"));//same as bean property
    	SdateCol.setMinWidth(100);
    	
    	TableColumn<batchBean, Integer> StimeCol=new TableColumn<batchBean, Integer>("Time");
    	StimeCol.setCellValueFactory(new PropertyValueFactory<>("Stime"));//same as bean property
    	StimeCol.setMinWidth(100);
    	
    	TableColumn<batchBean, Integer> TseatsCol=new TableColumn<batchBean, Integer>("Total Seats");
    	TseatsCol.setCellValueFactory(new PropertyValueFactory<>("Tseats"));//same as bean property
    	TseatsCol.setMinWidth(100);
    	
    	TableColumn<batchBean, Integer> BookedCol=new TableColumn<batchBean, Integer>("Booked Seats");
    	BookedCol.setCellValueFactory(new PropertyValueFactory<>("Booked"));//same as bean property
    	BookedCol.setMinWidth(100);
    	
    	TableColumn<batchBean, String> FeeCol=new TableColumn<batchBean, String>("Fees");
    	FeeCol.setCellValueFactory(new PropertyValueFactory<>("Fee"));//same as bean property
    	FeeCol.setMinWidth(100);
    	
    	tblview.getColumns().addAll(B_nameCol,SdateCol,StimeCol,TseatsCol,BookedCol,FeeCol);
    	
    	
    }
    
    Connection con;
   
    ObservableList<batchBean> ary=FXCollections.observableArrayList();
    
    ObservableList<batchBean>
    
    getAll()
    {    	
    	
    	try
    	{	
			PreparedStatement pst=con.prepareStatement("select * from  batchess");
			ResultSet tableInMem= pst.executeQuery();
			
			while(tableInMem.next())
			{
				String B_name= tableInMem.getString("B_name");
				String Sdate=tableInMem.getString("Sdate");
				String Stime=tableInMem.getString("Stime");
				int Tseats=tableInMem.getInt("Tseats");
				int Booked=tableInMem.getInt("Booked");
				String Fee=tableInMem.getString("Fee");
				
				batchBean obj=new batchBean(B_name,Sdate.toString(),Stime,Tseats,Booked,Fee);
				ary.add(obj);
				System.out.println(B_name+" "+Sdate.toString()+" "+Stime+" "+Tseats+" "+Booked+" "+Fee);
				
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
    void doExportToExcel(ActionEvent event) {
	   try {
	   writeExcel();
	   }
	   catch(Exception exp) {}
	   
    }
   public void writeExcel() throws Exception {
        Writer writer = null;
        try {
        	File file = new File("Users.csv");
            writer = new BufferedWriter(new FileWriter(file));
            String text="pid,pname,price,dop\n";
            writer.write(text);
            for (batchBean p : ary)
            {
				text = p.getB_name()+ "," + p.getSdate()+ "," + p.getStime()+ "," + p.getTseats()+"," + p.getBooked()+"," + p.getFee();
                writer.write(text);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
           
            writer.flush();
             writer.close();
        }
    }
    

    @FXML
    void initialize() 
    {
    	con = ConnectToMysql.doConnect();
    	doAddCols();
    }

}

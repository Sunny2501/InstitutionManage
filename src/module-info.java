module InstMan {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires javafx.graphics;
	requires javafx.base;
	
	opens application to javafx.graphics, javafx.fxml;
	opens BatchMaster to javafx.graphics, javafx.fxml;
	opens newadmission to javafx.graphics, javafx.fxml,javafx.base;
	opens allbatches to javafx.graphics, javafx.fxml ,javafx.base ;
	opens studentgoogler to javafx.graphics, javafx.fxml ,javafx.base ;
	opens allstudents to javafx.graphics, javafx.fxml ,javafx.base ;
	opens feecollector to javafx.graphics, javafx.fxml ,javafx.base ;
	opens feestatus to javafx.graphics, javafx.fxml ,javafx.base ;
	opens dashboard to javafx.graphics, javafx.fxml ,javafx.base ;
	opens login to javafx.graphics, javafx.fxml ,javafx.base ;
	opens payment to javafx.graphics, javafx.fxml ,javafx.base ;
}

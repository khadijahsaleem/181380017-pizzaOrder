package sample;

import com.sun.javafx.charts.ChartLayoutAnimator;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;



import java.util.concurrent.Flow;


public class Main extends Application {

    //customer name , address , phone textField
    private TextField customerNameTf , customerPhoneTf , customerAddressTf;

    //Size of radio Buttons
    private RadioButton smallRadioButton , largeRadioButton , mediumRadioButton;

    //Size of crust buttons
    private RadioButton thinRadioButton , thickRadioBtn;

    //Topping Radio button
    private CheckBox  pepperoniFlavour , sausageFlavour , linguicaFlavour ,
            olivesFlavour , mushroomsFlavour , tomatoesFlavour , anchoviesFlavour;



    @Override
    public void start(Stage primaryStage) throws Exception{
        // ----- Create the top pane -----
        Label textHeading = new Label("Order Your Pizza Now!");
        HBox paneTop = new HBox(20,textHeading);
        paneTop.setPadding(new Insets(20));


        //Customer fields and labels
        Label  cName = new Label("Name : ");
        customerNameTf = new TextField();
        customerNameTf.setPrefColumnCount(20);
        customerNameTf.setPromptText("Enter the customer's name here");
        customerNameTf.setMaxWidth(Double.MAX_VALUE);
        //HBox paneName = new HBox(cName , customerNameTf);
        //customer phone fields and table
        Label cPhone = new Label("Phone Number : " + " ");
       cPhone.setPrefWidth(100);
        customerPhoneTf = new TextField();
        customerPhoneTf.setPrefColumnCount(20);
        customerPhoneTf.setPromptText("Enter the customer's phone number here");
        customerPhoneTf.setMaxWidth(Double.MAX_VALUE);
        //HBox panePhone = new HBox(cPhone , customerPhoneTf);

        // Create the address label and text field
        Label cAddress = new Label("Address : ");
        cAddress.setPrefWidth(100);
        customerAddressTf = new TextField();
        customerAddressTf.setPrefColumnCount(20);
        customerAddressTf.setPromptText("Enter the customer's address here");
        //HBox paneAddress = new HBox(cAddress , customerPhoneTf);

        // Create the customer pane
        //VBox paneCustomer = new VBox(10, paneName,
                //panePhone, paneAddress);
        VBox labelField=new VBox(13,cName,cPhone,cAddress);
        VBox textField=new VBox(5,customerNameTf,customerPhoneTf,customerAddressTf);
        HBox pane=new HBox(labelField,textField);
        //create size radio button pane
        Label lSize = new Label("Size ");
        smallRadioButton = new RadioButton("Small ");
        mediumRadioButton = new RadioButton("Medium");
        largeRadioButton = new RadioButton("Large");
        mediumRadioButton.setSelected(true);
        ToggleGroup groupSize = new ToggleGroup();
        smallRadioButton.setToggleGroup(groupSize);
        mediumRadioButton.setToggleGroup(groupSize);
        largeRadioButton.setToggleGroup(groupSize);


        VBox paneSize = new VBox(lSize , smallRadioButton , mediumRadioButton , largeRadioButton);
        paneSize.setSpacing(10);

        //create crustPane
        Label lCurst = new Label("Crust");
        thinRadioButton = new RadioButton("Thin");
        thickRadioBtn = new RadioButton("Thick");
        thinRadioButton.setSelected(true);
        ToggleGroup groupCrust = new ToggleGroup();
        thinRadioButton.setToggleGroup(groupCrust);
        thickRadioBtn.setToggleGroup(groupCrust);

        VBox paneCrust = new VBox(lCurst , thinRadioButton , thickRadioBtn);
        paneCrust.setSpacing(10);


        //create Topping pane
        Label lTopping  = new Label("Toppings");
        pepperoniFlavour = new CheckBox("Pepperoni");
        sausageFlavour = new CheckBox("Sausage");
        linguicaFlavour = new CheckBox("Linguica");
        olivesFlavour = new CheckBox("Olives");
        mushroomsFlavour = new CheckBox("Mushrooms");
        tomatoesFlavour = new CheckBox("Tomatoes");
        anchoviesFlavour = new CheckBox("Anchovies");

        FlowPane paneToppings = new FlowPane(Orientation.VERTICAL ,
                pepperoniFlavour , sausageFlavour , linguicaFlavour ,
                olivesFlavour , mushroomsFlavour , tomatoesFlavour , anchoviesFlavour);
        paneToppings.setPadding(new Insets(10,0,10,0));
        paneToppings.setHgap(20);
        paneToppings.setVgap(10);
        paneToppings.setPrefWrapLength(100);

        VBox paneTopping = new VBox(lTopping , paneToppings);

        //add size , crust , tooping pane to order pane
        HBox paneOrder = new HBox(50 , paneSize , paneCrust ,
                paneTopping);

        //Create center pane
        VBox paneCenter = new VBox(20, pane, paneOrder);
        paneCenter.setPadding(new Insets(0,10, 0, 10));
        // ---------- Create the bottom pane ----------
        Button btnOK = new Button("OK");
        btnOK.setPrefWidth(80);
        btnOK.setOnAction(e -> btnOK_Click() );
        Button btnCancel = new Button("Cancel");
        btnCancel.setPrefWidth(80);
        btnCancel.setOnAction(e ->
            primaryStage.close()
         );
        Region spacer = new Region();
        HBox paneBottom = new HBox(10, spacer, btnOK, btnCancel);
        paneBottom.setHgrow(spacer, Priority.ALWAYS);
        paneBottom.setPadding(new Insets(20, 10, 20, 10));
        // ---------- Finish the scene ----------
        BorderPane paneMain = new BorderPane();
        paneMain.setTop(paneTop);
        paneMain.setCenter(paneCenter);
        paneMain.setBottom(paneBottom);
// Create the scene and the stage
        Scene scene = new Scene(paneMain);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Pizza Order");
        primaryStage.show();


    }




    private void btnOK_Click() {
        // Create a message string with the customer information
        String msg = "Customer:\n\n";
        msg += "\t" + customerNameTf.getText() + "\n";
        msg += "\t" + customerAddressTf.getText() + "\n";
        msg += "\t" + customerPhoneTf.getText() + "\n\n";
        msg += "You have ordered a ";
        // Add the pizza size
        if (smallRadioButton.isSelected())
            msg += "small ";
        if (mediumRadioButton.isSelected())
            msg += "medium ";
        if (largeRadioButton.isSelected())
            msg += "large ";
        // Add the crust style
        if (thinRadioButton.isSelected())
            msg += "thin crust pizza with ";
        if (thickRadioBtn.isSelected())
            msg += "thick crust pizza with ";

        //add toppings
        String toppings = "";
        toppings = buildToppings(pepperoniFlavour,toppings);
        toppings = buildToppings(sausageFlavour,toppings);
        toppings = buildToppings(linguicaFlavour,toppings);
        toppings = buildToppings(olivesFlavour,toppings);
        toppings = buildToppings(tomatoesFlavour,toppings);
        toppings = buildToppings(mushroomsFlavour,toppings);
        toppings = buildToppings(anchoviesFlavour,toppings);


        if (toppings.equals(""))
            msg += "no toppings.";
        else
            msg += "the following toppings:\n"
                    + toppings;

        // Display the message
        Alert alert = new Alert(Alert.AlertType.INFORMATION ,"Order Details ");
        alert.setContentText(msg);
        alert.show();
    }

    public String buildToppings(CheckBox chk, String msg)
    {
        // Helper method for displaying the list of toppings
        if (chk.isSelected())
        {
            if (!msg.equals(""))
            {
                msg += ", ";
            }
            msg += chk.getText();
        }
        return msg;
    }

    public void btnCancel_Click()
    {

    }




    public static void main(String[] args) {
        launch(args);
    }
}

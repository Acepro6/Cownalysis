package com.example.demo.Views;

import com.example.demo.DataClasses.Cow;
import com.example.demo.Enums.Icon;
import com.example.demo.Icons.IconGetter;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class CowListCell extends Pane {
    public CowListCell(Cow cow) {
//        InputStream stream = null;
//        try {
//            stream = new FileInputStream("src/main/java/com/example/demo/BullIcon.png");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        Image icon = new Image(stream);
//        //Creating the image view
//        ImageView iconView = new ImageView();
//        //Setting image to the image view
//        iconView.setImage(icon);
//        //Setting the image view parameters
//        iconView.setX(0);
//        iconView.setY(0);
//        iconView.setFitWidth(24);
//        iconView.setPreserveRatio(true);
        IconGetter iconGetter = new IconGetter(Icon.BULL, 24);
        ImageView iconView = iconGetter.getImageView();
        Label ID = new Label(cow.getID());
        Label category = new Label(cow.getCategoryString());
        Label age = new Label("Age: " + cow.getAge());


        Label weight = new Label("Weight: " + cow.getCurrentWeightString());




        //If we have a weight, show it, if not, show nothing
        if(cow.getCurrentWeightString().equals("No Weight Data")){
            weight = new Label();
        }
        HBox cellHBox = new HBox(iconView, ID, category, age, weight);
        cellHBox.setAlignment(Pos.CENTER_LEFT);
        cellHBox.setSpacing(10);
        this.getChildren().add(cellHBox);
    }
}

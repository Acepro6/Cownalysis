package com.example.demo.Icons;

import com.example.demo.Enums.Icon;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class IconGetter {
    private ImageView imageView;
    public  IconGetter(Icon iconName, int size) {
        InputStream stream = null;
        try {
            stream = new FileInputStream("src/main/java/com/example/demo/Icons/" + getIconFileName(iconName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image = new Image(stream);
        //Creating the image view
        ImageView iconView = new ImageView();
        //Setting image to the image view
        iconView.setImage(image);
        //Setting the image view parameters
        iconView.setX(0);
        iconView.setY(0);
        iconView.setFitWidth(size);
        iconView.setPreserveRatio(true);
        imageView = iconView;
    }
    public ImageView getImageView() {
        return imageView;
    }
    private String getIconFileName(Icon iconName) {
        switch (iconName) {
            case AGE:
                return "icons8-age-90.png";
            case GENEOLOGY:
                return "icons8-genealogy-90.png";
            case ID:
                return "icons8-identification-documents-90.png";
            case TAG:
                return "icons8-dog-tag-90.png";
            case GENDER:
                return "icons8-gender-90.png";
            case LOCATION:
                return "icons8-map-pin-90.png";
            case WEIGHT:
                return "icons8-weight-90.png";
            case MEDICAL:
                return "icons8-medical-history-90.png";
            case BULL:
                return "icons8-cow-90.png";
            case FULLCOW:
                return "icons8-cow-breed-90.png";
            case BIRTH:
                return "icons8-birthday-90.png";
            case DEATH:
                return "icons8-headstone-90.png";

        }
        return "";
    }
}

package com.example.demo.Views.AddOrEditWidgets;

import com.example.demo.Enums.Category;
import com.example.demo.Enums.Gender;
import com.example.demo.Enums.Icon;
import com.example.demo.Views.CardView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class AddOrEditRadioButtons extends CardView {

    ToggleGroup toggleGroup;
    ArrayList<RadioButton> buttons;
    public AddOrEditRadioButtons(Icon icon, int iconSize, String title, ArrayList<String> buttonTitles) {
        super(icon, iconSize, title);
        VBox radioButtons = new VBox();
        radioButtons.setSpacing(10);
        toggleGroup = new ToggleGroup();
        buttons = new ArrayList<>();
        for (String buttonTitle: buttonTitles) {
            RadioButton button = new RadioButton(buttonTitle);
            buttons.add(button);
            button.setToggleGroup(toggleGroup);
            radioButtons.getChildren().add(button);
        }
        addContent(radioButtons);
    }

    public Category getCategory() {
        RadioButton radioButton = (RadioButton) toggleGroup.getSelectedToggle();
        if (radioButton != null) {
            String toggleName = radioButton.getText();

            switch (toggleName) {
                case ("Bull"):
                    return Category.BULL;
                case ("Cow"):
                    return Category.COW;
                case ("Heifer"):
                    return Category.HEIFER;
                case ("Steer"):
                    return Category.STEER;
            }
        }
        return null;
    }

    public Gender getGender() {
        RadioButton radioButton = (RadioButton) toggleGroup.getSelectedToggle();
        if (radioButton != null) {
            String toggleName = radioButton.getText();

            switch (toggleName) {
                case ("Male"):
                    return Gender.MALE;
                case ("Female"):
                    return Gender.FEMALE;
            }
        }
        return null;
    }

    public void setCategoryButton(Category category) {
        if (category != null) {
            switch (category) {
                case BULL -> {
                    toggleGroup.selectToggle(buttons.get(0));
                }
                case COW -> {
                    toggleGroup.selectToggle(buttons.get(1));
                }
                case HEIFER -> {
                    toggleGroup.selectToggle(buttons.get(2));
                }
                case STEER -> {
                    toggleGroup.selectToggle(buttons.get(3));
                }
            }
        }
    }
    public void setGenderButton(Gender gender) {
        if (gender != null) {
            switch (gender) {
                case MALE -> {
                    toggleGroup.selectToggle(buttons.get(0));
                } case FEMALE ->  {
                    toggleGroup.selectToggle(buttons.get(1));
                }
            }
        }
    }
}

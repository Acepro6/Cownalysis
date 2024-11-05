package com.example.demo.Delete;

import com.example.demo.Models.CattleModel;
import com.example.demo.Views.ExportCowCSVView;
import com.example.demo.Views.ExportMedProcView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
////        TopBar topBar = new TopBar("Cows", "Filter");
//        MainViewListView mainViewListView = new MainViewListView();
//        Animal one = new Animal("Animal one", "30/18/4000", "male");
//        Animal two = new Animal("Animal two", "30/18/4000", "male");
//        ArrayList<Animal> testList = new ArrayList<>();
//        testList.add(one);
//        testList.add(two);
////        mainViewListView.updateList(testList);
//        GeneologyViewWidget testWidget1 = new GeneologyViewWidget("38475", "48847");
//
//        UIController controller = new UIController();
//        MainView root = new MainView();
//        root.listView.setController(controller);
////        root.listView.updateList(testList);
//        SingleFieldWithDescriptor test = new SingleFieldWithDescriptor(Icon.AGE, "Age", "Birthdate: 29/03/3838", 4.0);
//        FieldValueView test2 = new FieldValueView("Field", "value");
//        ArrayList<PassableFieldValuePair> temp3list = new ArrayList<>();
//        temp3list.add(new PassableFieldValuePair("Age", "4"));
//        temp3list.add(new PassableFieldValuePair("Birthdate", "29/29/2934"));
//        temp3list.add(new PassableFieldValuePair("Deathdate", "94/29/4822"));
//        DataFieldsView test3 = new DataFieldsView("Age", Icon.AGE, temp3list );
//        PassableFieldValuePair test45 = new PassableFieldValuePair("Hello", "Goodbye");
//        DataFieldWithButtonView test84 = new DataFieldWithButtonView("Age", Icon.AGE, test45, "See history");

        CattleModel model = new CattleModel();
       ExportMedProcView root = new ExportMedProcView(stage);
       root.setModel(model);
//
//        FileChooser fc = new FileChooser();
//        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
//
//
//        root.chooseFileButton.setOnAction(e -> {
//            File file = fc.showOpenDialog(stage);
//            //CowCSVImporter reader = new CowCSVImporter();
//            List<Cow> test = CowCSVImporter.readCowsFromCSV(file.getAbsolutePath());
//            System.out.println(file.getAbsolutePath());
////            for (int t = 0; t < test.size(); t++) {
////                System.out.println(test.get(t).getID());
////                System.out.println(test.get(t).getFarmTag());
////                System.out.println(test.get(t).getDateOfBirth());
////                System.out.println(test.get(t).getCurrentWeight());
////                System.out.println("\n");
////            }
//        });
//
//        Scene scene = new Scene(root);
//        stage.setTitle("Cows!");
//        stage.setScene(scene);
//        stage.show();
//
//        System.out.println("Hello");
//
//        // Create Top Level Files
//        // Models
//        CattleModel cattleModel = new CattleModel();
//        InteractionModel interactionModel = new InteractionModel();
//        // Controller
//        CattleController cattleController = new CattleController();
//        // View
////        TestView root = new TestView();
//        //Filter Creator
//        FilterCreator filterCreator = new FilterCreator();
//
//        // Connect
//        // Filter Creator
//        filterCreator.setInteractionModel(interactionModel);
//        // Controller
//        cattleController.setCattleModel(cattleModel);
//        cattleController.setInteractionModel(interactionModel);
//        cattleController.setFilterCreator(filterCreator);
//        // View
////        root.setController(cattleController);
////        root.setCattleModel(cattleModel);
////        root.setInteractionModel(interactionModel);
//        // Models
////        cattleModel.addCattleModelSubscriber(root);
////        cattleModel.setInteractionModel(interactionModel); // needed to iterate through filters
////        interactionModel.addSubscriber(cattleModel);
//
//        //Load Initial Cow Data
////        root.cattleModelChanged(); // this will load the initial filter of cows (Alive)
//
//
//        FilterSearchView testView = new FilterSearchView();
//        testView.setController(cattleController);
//        testView.setInteractionModel(interactionModel);
//        interactionModel.addSubscriber(testView);
////        testView.testUpdateListView();
//        testView.updateListView();
////        FilterAgeView test3 = new FilterAgeView();
        Scene scene = new Scene(root);
        stage.setTitle("Cows!");
        stage.setScene(scene);
       stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
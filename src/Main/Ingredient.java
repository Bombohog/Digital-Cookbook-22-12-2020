/********************************************
 * Project description
 *
 * Created by: Lasse J. Kongsdal
 * Date: 21-12-2020
 *
 * Description of program
 ********************************************/

package Main;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.io.Serializable;

// EKSEMPEL Klasser og objekter
public class Ingredient implements Serializable {

    private String amount; // Amount of the ingredient, 15g, 1 tbsp, 1 tbs, and so on...
    private String name; // Name of ingredient
    private String measure; // crushed, finely chopped, diced, and so on...

    //<editor-fold-desc="FXML in view mode">
    @FXML
    HBox container;
    @FXML
    Label labelAmount;
    @FXML
    Label labelName;
    @FXML
    Label labelMeasure;
    //</editor-fold>
    //<editor-fold-desc="FXML in edit mode">
    @FXML
    HBox newContainer;
    @FXML
    TextField newAmount;
    @FXML
    TextField newName;
    @FXML
    TextField newMeasure;
    //</editor-fold>

    public Ingredient() {
        createIngredientContainer();
    }

    // EKSEMPEL GUI
    public void createIngredientContainer() {

        newAmount = new TextField();
        newAmount.setMinSize(100, 25);
        newAmount.setPrefSize(100, 25);
        newAmount.setMaxSize(100, 25);

        newName = new TextField();
        newName.setMinSize(163, 25);
        newName.setPrefSize(163, 25);
        newName.setMaxSize(163, 25);

        newMeasure = new TextField();
        newMeasure.setMinSize(155, 25);
        newMeasure.setPrefSize(155, 25);
        newMeasure.setMaxSize(155, 25);

        newContainer = new HBox(newAmount, newName, newMeasure);
        newContainer.setMinSize(430, 25);
        newContainer.setPrefSize(430, 25);
        newContainer.setMaxSize(430, 25);
        newContainer.setMargin(newAmount, new Insets(0, 5, 0 ,0));
        newContainer.setMargin(newName, new Insets(0, 5, 0 ,0));

    }

    public void updateViewIngredient() {

        labelAmount = new Label(amount);
        labelAmount.setMinSize(100, 25);
        labelAmount.setPrefSize(100, 25);
        labelAmount.setMaxSize(100, 25);

        labelName = new Label(" " + name);
        labelName.setMinSize(163, 25);
        labelName.setPrefSize(163, 25);
        labelName.setMaxSize(163, 25);

        labelMeasure = new Label(measure);
        labelMeasure.setMinSize(155, 25);
        labelMeasure.setPrefSize(155, 25);
        labelMeasure.setMaxSize(155, 25);

        container = new HBox(labelAmount, labelName, labelMeasure);
        container.setMinSize(430, 25);
        container.setPrefSize(430, 25);
        container.setMaxSize(430, 25);
        container.setMargin(labelAmount, new Insets(0, 5, 0 ,0));
        container.setMargin(labelName, new Insets(0, 5, 0 ,0));

    }

    // EKSEMPEL Getters and setters
    //<editor-fold-desc="Getters'n'Setters">
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public HBox getContainer() {
        return container;
    }

    public void setContainer(HBox container) {
        this.container = container;
    }

    public Label getLabelAmount() {
        return labelAmount;
    }

    public void setLabelAmount(Label labelAmount) {
        this.labelAmount = labelAmount;
    }

    public Label getLabelName() {
        return labelName;
    }

    public void setLabelName(Label labelName) {
        this.labelName = labelName;
    }

    public Label getLabelMeasure() {
        return labelMeasure;
    }

    public void setLabelMeasure(Label labelMeasure) {
        this.labelMeasure = labelMeasure;
    }

    public HBox getNewContainer() {
        return newContainer;
    }

    public void setNewContainer(HBox newContainer) {
        this.newContainer = newContainer;
    }

    public TextField getNewAmount() {
        return newAmount;
    }

    public void setNewAmount(TextField newAmount) {
        this.newAmount = newAmount;
    }

    public TextField getNewName() {
        return newName;
    }

    public void setNewName(TextField newName) {
        this.newName = newName;
    }

    public TextField getNewMeasure() {
        return newMeasure;
    }

    public void setNewMeasure(TextField newMeasure) {
        this.newMeasure = newMeasure;
    }
    //</editor-fold>

}

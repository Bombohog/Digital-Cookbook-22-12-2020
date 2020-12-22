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
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Recipe implements Serializable {

    // EKSEMPEL Variabler
    private String name; // Name of the dish
    private String description; // Some text to describe what it is or something
    private String method; // The way to make the recipe into reality
    private String time; // Cooking time
    private ArrayList<Ingredient> ingredients; // List of all ingredients

    //<editor-fold-desc="FXML Elements">
    @FXML
    HBox recipeContainer;
    @FXML
    Image img;
    @FXML
    ImageView imageView;
    @FXML
    VBox childContainer;
    @FXML
    Label recipeName;
    @FXML
    Label recipeDescription;
    @FXML
    Label recipeTime;
    //</editor-fold>

    // EKSEMPEL GUI
    public void createContainer() {

        Separator separator1 = new Separator(Orientation.VERTICAL);
        Separator separator2 = new Separator(Orientation.VERTICAL);

        imageView = new ImageView(img);
        imageView.setFitWidth(128);
        imageView.setFitHeight(128);

        recipeName = new Label(name);
        recipeName.setFont(new Font("Calibri Bold", 14));
        recipeName.setMinSize(578, 20);
        recipeName.setPrefSize(578, 20);
        recipeName.setMaxSize(578, 20);

        recipeDescription = new Label(description);
        recipeDescription.setMinSize(575, 106);
        recipeDescription.setPrefSize(575, 106);
        recipeDescription.setMaxSize(575, 106);
        recipeDescription.setAlignment(Pos.TOP_LEFT);
        recipeDescription.setWrapText(true);

        recipeTime = new Label(getTime());
        recipeTime.setFont(new Font("Calibri Bold", 14));
        recipeTime.setMinSize(201, 128);
        recipeTime.setPrefSize(201, 128);
        recipeTime.setMaxSize(201, 128);
        recipeTime.setAlignment(Pos.CENTER);

        childContainer = new VBox(recipeName, recipeDescription);
        childContainer.setMinSize(578, 128);
        childContainer.setPrefSize(578, 128);
        childContainer.setMaxSize(578, 128);
        childContainer.setMargin(recipeName, new Insets(0, 0, 5, 0));

        recipeContainer = new HBox(imageView, separator1, childContainer, separator2, recipeTime);
        recipeContainer.setMinSize(925, 128);
        recipeContainer.setPrefSize(925, 128);
        recipeContainer.setMaxSize(925, 128);
        recipeContainer.setMargin(separator1, new Insets(0, 0, 0, 3));
        recipeContainer.setMargin(separator2, new Insets(0, 0, 0, 3));

    }

    // EKSEMPEL GUI
    public void updateIngredientListGUI(VBox ingredientVBoxList) {

        for (Ingredient currentIngredient : ingredients) {
            currentIngredient.updateViewIngredient();
        }

        ArrayList<Object> recipeObjects = new ArrayList<>();

        for (int i = 0; i < ingredients.size(); i++) {

            recipeObjects.add(ingredients.get(i).getContainer());

        }

        List list = recipeObjects;
        ingredientVBoxList.getChildren().clear();
        ingredientVBoxList.getChildren().addAll(list);

    }

    // EKSEMPEL Getters and setters
    //<editor-fold-desc="Getters'n'Setters">
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public HBox getRecipeContainer() {
        return recipeContainer;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public VBox getChildContainer() {
        return childContainer;
    }

    public Label getRecipeName() {
        return recipeName;
    }

    public Label getRecipeDescription() {
        return recipeDescription;
    }

    public Label getRecipeTime() {
        return recipeTime;
    }
    //</editor-fold>

}

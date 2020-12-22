package Main;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    public ArrayList<Object> recipeArrayList = new ArrayList<>();

    // EKSEMPEL GUI
    // TabPane
    @FXML
    TabPane main;

    // Main GUI Tab
    @FXML
    VBox cookbookList;

    //<editor-fold-desc="Recipe Tab FXML">
    @FXML
    Tab recipeTab;
    @FXML
    ImageView imageView;
    @FXML
    Label name;
    @FXML
    Label time;
    @FXML
    Label description;
    @FXML
    Label method;
    @FXML
    VBox ingredients;
    //</editor-fold>
    //<editor-fold-desc="Create Recipe Tab FXML">
    @FXML
    TextField newRecipeName;
    @FXML
    TextField newRecipeTime;
    @FXML
    TextArea newRecipeDescription;
    @FXML
    TextArea newRecipeMethod;
    @FXML
    VBox newRecipeIngredientList;
    @FXML
    Tab newRecipeTab;

    ArrayList<Ingredient> newIngredientList = new ArrayList<>();
    //</editor-fold>

    // EKSEMPEL ArrayList + Kontrolstruktur
    public void updateRecipeList() {

        ArrayList<Object> recipeObjects = new ArrayList<>();

        for (int i = 0; i < recipeArrayList.size(); i++) {

            recipeObjects.add(RecipeArchive.getRecipes().get(i).getRecipeContainer());

        }

        List list = recipeObjects;
        cookbookList.getChildren().clear();
        cookbookList.getChildren().addAll(list);

    }

    public void openRecipe(Recipe recipe) {

        name.setText(recipe.getName());
        time.setText(recipe.getTime());
        description.setText(recipe.getDescription());
        method.setText(recipe.getMethod());
        recipe.updateIngredientListGUI();
        SingleSelectionModel<Tab> selectionModel = main.getSelectionModel(); // stores all the tabs from main into a list
        selectionModel.select(recipeTab); // Select recipe tab

    }

    // Handles everything for making a new Recipe
    //<editor-fold-desc="New Recipe">
    public void newRecipe() {

        newIngredientList = new ArrayList<Ingredient>();
        newRecipeName.clear();
        newRecipeDescription.clear();
        newRecipeMethod.clear();
        newRecipeTime.clear();
        newRecipeIngredientList.getChildren().clear();
        SingleSelectionModel<Tab> selectionModel = main.getSelectionModel(); // stores all the tabs from main into a list
        selectionModel.select(newRecipeTab); // selects the tab to open, either with object or index

    }

    public void saveRecipe() {

        if (!newRecipeName.getText().equals("") && !newRecipeMethod.getText().equals("") && !newIngredientList.isEmpty()) {
            // Creates/Instantiates new recipe object/instance
            Recipe newRecipe = new Recipe();

            // Sets the information/details of recipe
            newRecipe.setName(newRecipeName.getText());
            newRecipe.setDescription(newRecipeDescription.getText());
            newRecipe.setMethod(newRecipeMethod.getText());
            newRecipe.setTime(newRecipeTime.getText());
            newRecipe.setIngredients(newIngredientList);
            newRecipe.createContainer();

            // Places the correct on mouse click method to GUI elements
            newRecipe.getRecipeContainer().setOnMouseClicked(e -> openRecipe(newRecipe));
            newRecipe.getChildContainer().setOnMouseClicked(e -> openRecipe(newRecipe));
            newRecipe.getRecipeName().setOnMouseClicked(e -> openRecipe(newRecipe));
            newRecipe.getRecipeDescription().setOnMouseClicked(e -> openRecipe(newRecipe));
            newRecipe.getRecipeTime().setOnMouseClicked(e -> openRecipe(newRecipe));
            newRecipe.getImageView().setOnMouseClicked(e -> openRecipe(newRecipe));

            // Adds the new recipe to archive and updates GUI
            RecipeArchive.addRecipe(newRecipe);
            updateRecipeList();

            // Clears the new recipe tab
            newRecipeName.clear();
            newRecipeDescription.clear();
            newRecipeMethod.clear();
            newRecipeTime.clear();
            newRecipeIngredientList.getChildren().clear();
            newRecipeName.clear();
            newRecipeDescription.clear();
            newRecipeMethod.clear();
            newRecipeTime.clear();
            newRecipeIngredientList.getChildren().clear();

            // Select recipe tab
            SingleSelectionModel<Tab> selectionModel = main.getSelectionModel(); // stores all the tabs from main into a list
            selectionModel.select(recipeTab); // selects the tab to open, either with object or index

        }

    }

    public void addNewIngredient() {

        Ingredient newIngredient = new Ingredient();
        newIngredient.getNewAmount().setOnAction(e -> newIngredient.setAmount(newIngredient.getNewAmount().getText()));
        newIngredient.getNewName().setOnAction(e -> newIngredient.setName(newIngredient.getNewName().getText()));
        newIngredient.getNewMeasure().setOnAction(e -> newIngredient.setMeasure(newIngredient.getNewMeasure().getText()));
        newRecipeIngredientList.getChildren().add(newIngredient.getNewContainer());
        newIngredientList.add(newIngredient);

    }
    //</editor-fold>

    // EKSEMPEL Persistens
    // Saving and reading of recipes
    //<editor-fold-desc="Saving'n'Loading">
    public static void saveArchive() {

        // EKSEMPEL Exceptions
        try
        {
            FileOutputStream fos = new FileOutputStream("archiveData");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(RecipeArchive.getRecipes());

            oos.close();
            fos.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }

    }

    public static void loadArchive() {

        // EKSEMPEL Exceptions
        try
        {
            FileInputStream fis = new FileInputStream("archiveData");
            ObjectInputStream ois = new ObjectInputStream(fis);

            RecipeArchive.setRecipes((ArrayList) ois.readObject());

            ois.close();
            fis.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
            return;
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }

        new Controller().updateRecipeList(); // TODO

    }
    //</editor-fold>


}

/********************************************
 * Project description
 *
 * Created by: Lasse J. Kongsdal
 * Date: 22-12-2020
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

public class RecipeFXML {

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

    public void createContainer(String name, String description, String time) {

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

        recipeTime = new Label(time);
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

}

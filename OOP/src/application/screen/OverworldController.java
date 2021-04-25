package application.screen;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class OverworldController {

    // Untuk ganti scene
    private Stage stage;
    private Scene scene;
    private Parent root;

    // Untuk "Player"
    @FXML private Circle object; // Cocokkan nama variabel dengan fx:id dan tipenya
    @FXML private Circle follower;
    private Double startingX;
    private Double startingY;
    private Double deltaMove = 15d; // Ubah sesuai tampilan

    // Bounds dihitung dari titik awal saja
    // Misal titik awal 100 mau batasin di 150 di sb X, cukup masukin 50
    private Double xBounds = 350d;
    private Double yBounds = 210d;

    // Dijalankan saat scene dibuat
    @FXML
    private void initialize() {
        startingX = object.getCenterX();
        startingY = object.getCenterY();
    }

    // Tombol Up
    public void UpButton(ActionEvent event) {
        Double y = object.getCenterY();
        // Batas
        if (y > startingY - yBounds) {
            object.setCenterY(y -= deltaMove);
            follower.setCenterX(object.getCenterX());
            follower.setCenterY(object.getCenterY()-5); // Note: entah kenapa harus getCenterY()-25 baru pas di posisi object
        }
    }

    // Tombol Down
    public void DownButton(ActionEvent event) {
        Double y = object.getCenterY();
        // Batas
        if (y < startingY + yBounds) {
            object.setCenterY(y += deltaMove);
            follower.setCenterX(object.getCenterX());
            follower.setCenterY(object.getCenterY()-50);
        }
    }

    // Tombol Right
    public void RightButton(ActionEvent event) {
        Double x = object.getCenterX();
        // Batas
        if (x < startingX + xBounds) {
            object.setCenterX(x += deltaMove);
            follower.setCenterX(object.getCenterX()-25);
            follower.setCenterY(object.getCenterY()-25);
        }
    }

    // Tombol Left
    public void LeftButton(ActionEvent event) {
        Double x = object.getCenterX();
        // Batas
        if (x > startingX - xBounds) {
            object.setCenterX(x -= deltaMove);
            follower.setCenterX(object.getCenterX()+25);
            follower.setCenterY(object.getCenterY()-25);
        }
    }

    // Tombol Exit
    public void handleExitButton(ActionEvent event) throws IOException {
        // Untuk mengganti scene
        // Jika ingin digunakan merujuk ke scene lain, ganti isi getResource()
        ScreenController.activate("MainMenu");
    }

    // Tombol Breeding
    public void handleBreedButton(ActionEvent event) throws IOException {
        // Untuk mengganti scene
        // Jika ingin digunakan merujuk ke scene lain, ganti isi getResource()
        root = FXMLLoader.load(getClass().getResource("/Scenes/BreedScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // Tombol Engimon Inventory
    public void handleEngimonInventoryButton(ActionEvent event) throws IOException {
        // Untuk mengganti scene
        // Jika ingin digunakan merujuk ke scene lain, ganti isi getResource()
//        System.out.println("asdsad");
        Stage legendWindow = new Stage();
        Parent legend = FXMLLoader.load(getClass().getResource("window/EngimonInventory.fxml"));
        legendWindow.setTitle("Engimon Inventory"); // Pasang judul
        legendWindow.initModality(Modality.APPLICATION_MODAL);
        Scene legendScene = new Scene(legend);
        legendWindow.setScene(legendScene);
        legendWindow.show();
    }

    // Tombol Skill Inventory
    public void handleSkillInventoryButton(ActionEvent event) throws IOException {
        // Untuk mengganti scene
        // Jika ingin digunakan merujuk ke scene lain, ganti isi getResource()
        root = FXMLLoader.load(getClass().getResource("/Scenes/SkillInventory.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // Tombol Battle
    public void handleBattleButton(ActionEvent event) throws IOException {
        // Untuk mengganti scene
        // Jika ingin digunakan merujuk ke scene lain, ganti isi getResource()
        root = FXMLLoader.load(getClass().getResource("/Scenes/Battle.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void handleLegendButton(ActionEvent event) throws IOException {
        Stage legendWindow = new Stage();
        Parent legend = FXMLLoader.load(getClass().getResource("window/Legend.fxml"));
        legendWindow.setTitle("Legend"); // Pasang judul

        Scene legendScene = new Scene(legend);
        legendWindow.setScene(legendScene);
        legendWindow.show();
    }
}
package application.screen;

import application.classes.*;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class OverworldController implements Initializable {
    //Map
    public TilePane Map;
    public TilePane invent;
    // Untuk ganti scene
    private Stage stage;
    private Scene scene;
    private Parent root;

    // Untuk "Player"
    private Player p;
    //Peta
    private Peta map;

    // Tombol Up
    public void UpButton(ActionEvent event) {
        int oldX = p.getPosition().getX();
        int oldY = p.getPosition().getY();
        p.moveUP();
        map.setCellContent(new Position(oldX,oldY), Content.air);
        map.setCellContent(p.getPosition(), Content.player);
        Map.getChildren().clear();
        loadImageMap();
    }

    // Tombol Down
    public void DownButton(ActionEvent event) {
        int oldX = p.getPosition().getX();
        int oldY = p.getPosition().getY();
        p.moveDOWN();
        map.setCellContent(new Position(oldX,oldY), Content.air);
        map.setCellContent(p.getPosition(), Content.player);
        Map.getChildren().clear();
        loadImageMap();
    }

    // Tombol Right
    public void RightButton(ActionEvent event) {
        int oldX = p.getPosition().getX();
        int oldY = p.getPosition().getY();
        p.moveRIGHT();
        map.setCellContent(new Position(oldX,oldY), Content.air);
        map.setCellContent(p.getPosition(), Content.player);
        Map.getChildren().clear();
        loadImageMap();
    }

    // Tombol Left
    public void LeftButton(ActionEvent event) {
        int oldX = p.getPosition().getX();
        int oldY = p.getPosition().getY();
        p.moveLEFT();
        map.setCellContent(new Position(oldX,oldY), Content.air);
        map.setCellContent(p.getPosition(), Content.player);
        Map.getChildren().clear();
        loadImageMap();
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
        ScreenController.callPopupWindow("BreedScene", "Breed");
    }

    // Tombol Engimon Inventory
    public void handleEngimonInventoryButton(ActionEvent event) throws IOException {
        // Untuk mengganti scene
        // Jika ingin digunakan merujuk ke scene lain, ganti isi getResource()
//        System.out.println("asdsad");
        ScreenController.callPopupWindow("EngimonInventory", "Engimon Inventory");
    }

    public void handleLegendButton(ActionEvent event) throws IOException {
        System.out.println(GameManagement.player.getInventoryEngimon().getInventory().size());
       ScreenController.callPopupWindow("Legend", "Legend");
    }

    public void handleInteractionButton(ActionEvent event) throws  IOException{
        System.out.println(p.getActiveEngimon().get_deskripsi());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Setting inventory
        invent.setPrefColumns(10);
        invent.setPrefRows(10);
        invent.setPrefTileHeight(18);
        invent.setPrefTileWidth(18);
        invent.setVgap(20);
        invent.setHgap(20);
        //Setting Map
        Map.setPrefColumns(25);
        Map.setPrefRows(10);
        Map.setPrefTileHeight(35);
        Map.setPrefTileWidth(35);
        Map.setVgap(5);
        Map.setHgap(5);
        Map.setAlignment(Pos.CENTER);
        Map.setOrientation(Orientation.VERTICAL);
        //Inisialisasi
        map = GameManagement.getPeta();
        p = GameManagement.getPlayer();
//        System.out.println(p.getActiveEngimonPosition().getX()+ p.getActiveEngimonPosition().getY());
        System.out.println(p.getPosition().getX() + p.getPosition().getY());
        loadImageMap();
        loadEngimon();

    }

//    private void loadImage(){
////        System.out.println("Load Image");
//        String pathAssets = "application/assets/";
//        for (int i = 0; i < map.getSizeX(); i++){
//            for(int j = 0; j < map.getSizeY(); j++){
//                Image cell;
//                switch (map.getCell(i,j).getCellType()){
//                    case sea -> {
//                        cell = new Image("application/assets/sea.png");;
//                        break;
//                    }
//                    case tundra -> {
//                        cell = new Image("application/assets/tundra.png");;
//                        break;
//                    }
//                    case mountain -> {
//                        cell = new Image("application/assets/mountain.png");
//                        break;
//                    }
//                    default -> {
//                        cell = new Image("application/assets/grass.png");
//                        break;
//                    }
//                }
//                ImageView im = new ImageView(cell);
//                im.fitHeightProperty().bind(Map.tileHeightProperty());
//                im.fitWidthProperty().bind(Map.tileWidthProperty());
//                StackPane s = new StackPane();
//                s.getChildren().add(im);
//                Map.getChildren().add(s);
//                if(map.getCellContent(i,j) == Content.engimon){
//                    Image engi = new Image("application/assets/1.png");
//                    ImageView im1 = new ImageView(engi);
//                    im1.fitHeightProperty().bind(Map.tileHeightProperty());
//                    im1.fitWidthProperty().bind(Map.tileWidthProperty());
//                    s.getChildren().add(im1);
//                }else if (map.getCellContent(i,j) == Content.player){
//                    Image player = new Image("application/assets/player.png");
//                    ImageView im1 = new ImageView(player);
//                    im1.fitHeightProperty().bind(Map.tileHeightProperty());
//                    im1.fitWidthProperty().bind(Map.tileWidthProperty());
//                    s.getChildren().add(im1);
//                }
//            }
//        }
//    }

    public void loadImageMap()
    {
        try
        {
//            System.out.println("Load Image Map");
            String pathAssets = "application/assets/";
            for (int i = 0; i < map.getSizeX(); i++){
                for(int j = 0; j < map.getSizeY(); j++){

                    String typePath = GameManagement.peta.getCell(i, j).getCharCellType();
                    Image cell = new Image(pathAssets + typePath);
                    ImageView im = new ImageView(cell);
                    im.fitHeightProperty().bind(Map.tileHeightProperty());
                    im.fitWidthProperty().bind(Map.tileWidthProperty());
                    StackPane s = new StackPane();
                    s.getChildren().add(im);
                    Map.getChildren().add(s);

                    String contentPath = GameManagement.peta.getCell(i, j).getCharCellContent();

                    if (!contentPath.equals("air"))
                    {
                        Image content = new Image(pathAssets + contentPath);
                        ImageView im1 = new ImageView(content);
                        im1.fitHeightProperty().bind(Map.tileHeightProperty());
                        im1.fitWidthProperty().bind(Map.tileWidthProperty());
                        s.getChildren().add(im1);
                    }
//                    System.out.println("type:" + typePath + " content:" + contentPath);
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Exception in LoadImageMap Overworl!");
            System.out.println(e.getMessage());
        }

    }

    public void loadEngimon(){
        invent.getChildren().clear();
        Image engi = new Image("application/assets/1.png");
        for(int i = 0; i < p.getInventoryEngimon().getInventory().size();i++){
            Button b = new Button();
            b.setMaxSize(18,18);
            ImageView im = new ImageView(engi);
            im.setFitWidth(15);
            im.setFitHeight(15);
            b.setGraphic(im);
            if(p.getInventoryEngimon().getInventory(i).get_engimon_elements().contains(new Element("Fire"))){
                b.setStyle("-fx-border-color: red");
            }else if(p.getInventoryEngimon().getInventory(i).get_engimon_elements().contains(new Element("Water"))){
                b.setStyle("-fx-border-color: blue");
            }else if(p.getInventoryEngimon().getInventory(i).get_engimon_elements().contains(new Element("Electric"))){
                b.setStyle("-fx-border-color: yellow");
            }else if(p.getInventoryEngimon().getInventory(i).get_engimon_elements().contains(new Element("Ground"))){
                b.setStyle("-fx-border-color: brown");
            }else if(p.getInventoryEngimon().getInventory(i).get_engimon_elements().contains(new Element("Ice"))){
                b.setStyle("-fx-border-color: white");
            }
            invent.getChildren().add(b);
        }
    }
    public void loadSkill(){
        invent.getChildren().clear();
        Image item = new Image("application/assets/1254995-middle.png");
        for(int i = 0; i < p.getInventorySkill().getInventory().size();i++){
            Button b = new Button();
            b.setMaxSize(18,18);
            ImageView im = new ImageView(item);
            im.setFitWidth(15);
            im.setFitHeight(15);
            b.setGraphic(im);
            invent.getChildren().add(b);
        }
    }

//    public void callPopupWindow(String name, String title)
//    {
//        String path = "window/";
//        try
//        {
//            Parent pane = FXMLLoader.load(getClass().getResource( path + name));
//            Stage window = new Stage();
//            window.setTitle(title); // Pasang judul
//
//            Scene scene = new Scene(pane);
//            window.setScene(scene);
//            window.show();
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//
//    }
}

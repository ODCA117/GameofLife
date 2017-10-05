package graphics;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class TileBoard{

    private Tile tiles[][];
    private GridPane gridPane;
    private int heigth;
    private int widht;

    public TileBoard(int height, int width, MainApplication mainApplication){
        this.heigth = height;
        this.widht = width;
        tiles = new Tile[height][width];

        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                tiles[i][j] = new Tile();
                final int x = i;
                final int y = j;
                tiles[x][y].setOnMouseClicked(e -> clicked(mainApplication, x, y));
            }
        }
    }

    private void clicked(MainApplication mainApplication, int x, int y){
        mainApplication.changeTile(x,y);
    }

    public GridPane getAsGridPane(){
        if(gridPane == null) {

            gridPane = new GridPane();
            for (int i = 0; i < heigth; i++) {
                for (int j = 0; j < widht; j++) {
                    gridPane.add(tiles[i][j], i, j);
                }
            }
            gridPane.setGridLinesVisible(true);
        }

        return gridPane;
    }

    public void updateTilecolors(Color[][] colors){
        for(int i = 0; i < heigth; i++){
            for(int j = 0; j < widht; j++){
                tiles[i][j].changeColor(colors[i][j]);
            }
        }
    }
}

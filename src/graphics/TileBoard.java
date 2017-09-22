package graphics;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class TileBoard{

    private Tile tiles[][];
    private int side;
    private GridPane gridPane;

    public TileBoard(int side, MainApplication mainApplication){
        this.side = side;
        tiles = new Tile[side][side];

        for(int i = 0; i < side; i++){
            for(int j = 0; j < side; j++){
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
            for (int i = 0; i < side; i++) {
                for (int j = 0; j < side; j++) {
                    gridPane.add(tiles[i][j], i, j);
                }
            }
            gridPane.setGridLinesVisible(true);
        }

        return gridPane;
    }

    public void updateTilecolors(Color[][] colors){
        for(int i = 0; i < side; i++){
            for(int j = 0; j < side; j++){
                tiles[i][j].changeColor(colors[i][j]);
            }
        }
    }
}

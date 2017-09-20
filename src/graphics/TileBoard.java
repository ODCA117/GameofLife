package graphics;


import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class TileBoard{
    private GridPane gridPane;
    private int side;

    public TileBoard(int side, MainApplication mainApplication){
        this.side = side;
        gridPane = new GridPane();
        Tile[][] tiles = createTileBoard(side, mainApplication);
        for(int i = 0; i < side; i++){
            for(int j = 0; j < side; j++){
                gridPane.add(tiles[i][j], j, i);
            }
        }
        gridPane.setGridLinesVisible(true);
    }

    private Tile[][] createTileBoard(int side, MainApplication mainApplication){

        Tile[][] tiles = new Tile[side][side];
        for(int i = 0; i < side; i++){
            for(int j = 0; j < side; j++){
                tiles[i][j] = new Tile();
                final int x = i;
                final int y = j;
                tiles[i][j].setOnMouseClicked(e -> clicked(mainApplication,x,y));
            }
        }
        return tiles;
    }

    private void clicked(MainApplication mainApplication, int x, int y){
        mainApplication.changeTile(x,y);
    }

    public GridPane getGridPane(){
        return gridPane;
    }

    public void updateTilecolors(Color[][] colors){
        Tile[][] tiles = getGridPaneTiles();
        for(int i = 0; i < side; i++){
            for(int j = 0; j < side; j++){
                tiles[i][j].changeColor(colors[i][j]);
            }
        }
    }

    private Tile[][] getGridPaneTiles(){
        Tile[][] nodes = new Tile[side][side];
        for(Node n: gridPane.getChildren()){
            if(n instanceof Tile){

                int col = GridPane.getColumnIndex(n);
                int row = GridPane.getRowIndex(n);
                nodes[col][row] = (Tile)n;
            }
        }

        return nodes;
    }

}

/**
 * Created by ol6803ax-s on 30/08/17.
 *
 * //class representing the board viewed
 */
public class Board {

    private Tile[][] tiles;


    public Board (int x, int y) {
        tiles = new Tile[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {

                tiles[i][j] = createTile();

            }
        }
    }

    public Tile createTile(){
        Tile tile = new Tile();


    }



}

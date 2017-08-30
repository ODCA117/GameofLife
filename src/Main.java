/**
 * Created by ol6803ax-s on 30/08/17.
 */
public class Main {

    public static void main(String[] args){
        int[] size = getIntValues(args);

        Board board = new Board(size[1], size[2]);

    }

    private static int[] getIntValues(String[] args){
        int[] numbers = new int[args.length];
        int counter = 0;
        for(String arg : args){
            try{
                numbers[counter] = Integer.parseInt(arg);
                counter++;
            }
            catch (NumberFormatException e){
                System.out.println("Argument was not a number");
                System.exit(0);
            }

        }

        return numbers;
    }
}

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;

public class PrintFile {

    public static void printShips()
    {
        try {
            PrintWriter printWriter = new PrintWriter("file.txt");

            Ship.ships.sort((ship1, ship2)
                    -> ship1.getName().compareTo(
                    ship2.getName()));

            for (Ship s : Ship.ships)
            {
                printWriter.println(s);
                /*
                s.containers.sort((cont1, cont2)
                        -> cont1.brutto_weight.compareTo(
                        cont2.brutto_weight));
                        
                 */

            }

            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}

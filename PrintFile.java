
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collections;


public class PrintFile
{



    public static void printShips()
    {
        try {
            PrintWriter printWriter = new PrintWriter("file.txt");

            Collections.sort(Ship.ships,
                    Ship.ShipCompare);


            for (Ship s : Ship.ships)
            {
                int counter=1;
                printWriter.println(s);
                printWriter.println("Contents of ship: "+s.getName());
                Collections.sort(s.containers, Ship.ContainerCompare);
                for (Standard_Container c : s.containers)
                {
                    printWriter.print(counter++ +". ");
                    printWriter.println(c);
                }
            }

            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
/*
Containers stored in the warehouse should be sorted in descending order according to thestorage start date
 (from the longest stored to the shortest),
 and if the storage time is thesame, the next sorting criterion is the sender’s name.

 such as data ofsenders, ships, warehouse, containers and the complete set of information about them
 */
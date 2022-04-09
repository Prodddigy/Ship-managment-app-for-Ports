
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;




public class WareHouse
{

    int MaxExp=14;
    int MaxTP=10;
    int MaxTL=5;
    //if container.name == -||- then max --
    //if container.name == -||- anc max.container.name =0 then dont add simple enought


    static ArrayList<Standard_Container> storage = new ArrayList<>();
//Capacity :EXP =14, ToxicP = 10, ToxicL =5. !!!!!

    public static void moveContainerShip_WareHouse(String shipName)
    {

        Scanner scan = new Scanner(System.in);

        System.out.println("Which container to move ?\n");
        System.out.println("Choose by entering ID: ");
        int contID = scan.nextInt();
        if(Ship.compareContainer(shipName,contID))
        {
            moveToWareHouse(shipName,Ship.findContainer(shipName,contID));
        }
        else
            System.out.println("sorry, container not found :/");


    }

   public static void moveToWareHouse(String shipName,Standard_Container cont)
   {
       if(cont != null)
       {
           storage.add(cont);

           Seaport.findShip(shipName).containers.remove(cont);
       }
       else
           System.out.println("no such container in: "+shipName+"ship :/");
    }

    public static void showWareHouse()
    {
        for(Standard_Container cont : WareHouse.storage)
        {
            System.out.println(cont.toString());
            System.out.println("\n");
        }
    }
    /*
    public static void moveContainerWareHouse_Ship(String shipName)
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Which container to move ?\n");
        System.out.println("Choose by entering ID: ");
        int contID = scan.nextInt();
        if(Ship.compareContainer(shipName,contID))
        {
            moveToWareHouse(shipName,Ship.findContainer(shipName,contID));
        }
        else
            System.out.println("sorry, container not found :/");
    }
*/

    public static Standard_Container whichContFromWareHouse(int contID)
    {
        for (int i = 0; i < storage.size(); i++)
        {
            if(Objects.equals(contID, storage.get(i).container_ID))
            {
                return storage.get(i);
            }
        }
        return null;
    }
}

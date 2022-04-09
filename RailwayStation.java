import java.util.ArrayList;
import java.util.Scanner;

public class RailwayStation {


    static ArrayList<Standard_Container> train = new ArrayList<>(10);

    public static void moveToTrain()
    {

        Scanner scan = new Scanner(System.in);
        System.out.println("Contents of WareHouse");
        WareHouse.showWareHouse();

        System.out.println("Enter ID of a container: \n");
        int contID = scan.nextInt();
        if (WareHouse.whichContFromWareHouse(contID)!=null)
        {
            train.add(WareHouse.whichContFromWareHouse(contID));

            WareHouse.storage.remove(WareHouse.whichContFromWareHouse(contID));
        }
        else
            System.out.println("no such container in WareHouse :/ \n");


        if(train.size() == 10)
        {
            deprature();
        }
    }

    public static void deprature()
    {
        //wait 30 secs and clear
            train.clear();
    }
}

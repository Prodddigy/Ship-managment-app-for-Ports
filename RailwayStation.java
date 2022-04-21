import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class RailwayStation
{
    static ArrayList<Standard_Container> train = new ArrayList<>();

    public static void moveToTrain() throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Contents of WareHouse");
        WareHouse.showWareHouse();

        System.out.println("Enter ID of a container: \n");
        int contID = scan.nextInt();

        Standard_Container cont= WareHouse.whichContFromWareHouse(contID);

        if (cont!=null)
        {
            WareHouse.storage.remove(cont);
            if(Objects.equals(cont.container_type,"Toxic_Powder_Container")
            || Objects.equals(cont.container_type,"Toxic_Liquid")
            || Objects.equals(cont.container_type,"Explosive_Container"))
            {
                cancelExpiration(cont);
            }
            train.add(cont);
        }
        else
            System.out.println("no such container in WareHouse :/ \n");

        if(train.size() == 1)
        {
            departure();
        }
    }

    public static void cancelExpiration(Standard_Container cont)
    {
        cont.expirationDoc.interrupt();
    }

    public static void departure() throws InterruptedException {
        //wait 30 secs and clear
        Thread TrainDep = new Thread(() -> {

                try {

                    System.out.println("Train is waiting to departure...2");
                    Thread.sleep(30000);
                   // System.out.println("Train is gone to the void :)");
                    train.clear();
                    /*
                    if you want to add cont to train check capacity of a train array
                     */
                } catch (InterruptedException e) {
                    return;
                }
                //sender interrupt

        });
        TrainDep.start();
       // Thread.sleep(30000);
       // System.out.println("Train is gone to the void :)");
      //  TrainDep.interrupt();

    }
}

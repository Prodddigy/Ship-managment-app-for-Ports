import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

public class Ship {

    String name;
    String home_port;
    String transport_origin;
    String destination;

    int MAX_CAPACITY;
    int MAX_WEIGHT;

    int max_tox_or_exp=3;
    int max_heavy;
    int max_electro;

    int MAX_CAPACITY_counter=0;
    int MAX_WEIGHT_counter=0;

    int max_tox_or_exp_counter=0;
    int max_heavy_counter=0;
    int max_electro_counter=0;



    int ship_ID= 0;
   static  int ship_counter=0;
   static ArrayList<Ship> ships = new ArrayList<>();

   ArrayList<Standard_Container> containers;

    public Ship()
    {

        this.ship_ID =ship_counter++;

         this.containers = new ArrayList<>();

         ships.add(this);

    }//data structures SET

    public  int getShip_ID() {
        return ship_ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHome_port(String home_port) {
        this.home_port = home_port;
    }

    public void setTransport_origin(String transport_origin) {
        this.transport_origin = transport_origin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setMAX_CAPACITY(int MAX_CAPACITY) {
        this.MAX_CAPACITY = MAX_CAPACITY;
    }

    public void setMAX_WEIGHT(int MAX_WEIGHT) {
        this.MAX_WEIGHT = MAX_WEIGHT;
    }

    public void setMax_tox_or_exp(int max_tox_or_exp) {
        this.max_tox_or_exp = max_tox_or_exp;
    }

    public void setMax_heavy(int max_heavy) {
        this.max_heavy = max_heavy;
    }

    public void setMax_electro(int max_electro) {
        this.max_electro = max_electro;
    }

    public String getName() {
        return name;
    }

    public static String whichShipShow()
    {
        System.out.println("Which Ship you want to see?: \n");

        for (Ship obj : Ship.ships)
        {
            System.out.println("-------------------------------");
            System.out.println("Name: "+obj.name+"\n");
            System.out.println("ID: "+obj.getShip_ID()+"\n");
            System.out.println("Heavy max: "+obj.max_heavy_counter+"/"+obj.max_heavy+"\n");
            System.out.println("Electric Max: "+obj.max_electro_counter+"/"+obj.max_electro+"\n");
            System.out.println("Toxic/Exp: "+obj.max_tox_or_exp_counter+"/"+obj.max_tox_or_exp+"\n");
            System.out.println("Weight: "+obj.MAX_WEIGHT_counter+"/"+obj.MAX_WEIGHT+"\n");
            System.out.println("Capacity: "+obj.MAX_CAPACITY_counter+"/"+obj.MAX_CAPACITY+"\n");
            System.out.println("-------------------------------");
        }
        Scanner scan = new Scanner(System.in);

        System.out.println("Type the name of it: ");

        String shipName = scan.nextLine();

        if( Seaport.compareShip(shipName))
        {
            System.out.println("Display contents of ship: "+shipName);
            contentsOfShip(Seaport.findShip(shipName));
        }
        else
        {
            System.out.println("Sorry, name not found");
            shipName =null;
        }
        return shipName;
    }

    public static void contentsOfShip(Ship ship)
    {
        Ship tmp = ship;
        for(Standard_Container cont : tmp.containers)
        {
            System.out.println(cont.toString());
            System.out.println("\n");
        }
    }

    public static Standard_Container findContainer(String shipName,int contID)
    {
        for (int i = 0; i < Seaport.findShip(shipName).containers.size(); i++)
        {
            if(Objects.equals(contID, Seaport.findShip(shipName).containers.get(i).container_ID))
            {
                return Seaport.findShip(shipName).containers.get(i);
            }
        }
        return null;
    }

    public static boolean compareContainer(String shipName,int contID) {

        boolean compare = false;
        for (int i = 0; i < Seaport.findShip(shipName).containers.size(); i++)
        {
            if (Objects.equals(contID, Seaport.findShip(shipName).containers.get(i).container_ID))
            {
                compare = true;
                break;
            }
        }
        return compare;
    }

    public static Comparator<Ship> ShipCompare = (s1, s2) -> {

        String shipName1
                = s1.name;
        String shipName2
                = s2.name;

        // ascending order
        //return shipName1.compareTo(
          //      shipName2);

        // descending order
         return shipName2.compareTo(shipName1);
    };

    public static Comparator<Standard_Container> ContainerCompare = (cont1, cont2) ->
    {

        int weight1 = cont1.brutto_weight;
        int weight2 = cont2.brutto_weight;

        // For ascending order
        return weight1 - weight2;

        // For descending order
        // weight2-weight1;
    };
public String toString()
{
    return "-------------------------------\n"+
   "Name: "+this.name+"\n"+
   "ID: "+this.getShip_ID()+"\n"+
    "Heavy max: "+this.max_heavy_counter+"/"+this.max_heavy+"\n"+
    "Electric Max: "+this.max_electro_counter+"/"+this.max_electro+"\n"+
    "Toxic/Exp: "+this.max_tox_or_exp_counter+"/"+this.max_tox_or_exp+"\n"+
    "Weight: "+this.MAX_WEIGHT_counter+"/"+this.MAX_WEIGHT+"\n"+
    "Capacity: "+this.MAX_CAPACITY_counter+"/"+this.MAX_CAPACITY+"\n"+
    "-------------------------------";
}


    /*Write an application that will be used to manage the logistics of a seaport in terms of a
transhipment terminal for container ships. The application will be used to unload and load containers
from/to the ship. In case of unloading, the containers can be transferred to the warehouse
or directly to the railway transport carriage.
Each ship has a different capacity and deadweight defined by:
• the maximum number of containers with toxic or explosive cargo that can be loaded within
the ship
• the maximum number of heavy containers
• the maximum number of containers requiring connection to the electricity network
• the maximum number of all containers
• the maximum weight load
Each ship stores basic information about itself (unique identification number assigned automatically
when creating the object, name, home port, transport origin and destination).
In the case of load capacity of containers for toxic and explosive cargo - this value is common
for both types of containers. E.g. if the ship has three places for containers with explosive or
toxic cargo, these places can be loaded respectively by:
• 3 containers with explosive cargo
• 2 containers with explosive cargo and 1 container with toxic cargo
• 1 containers with explosive cargo and 2 container with toxic cargo
• 3 container with toxic cargo
     */

}

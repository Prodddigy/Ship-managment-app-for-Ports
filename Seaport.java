import java.util.Objects;
import java.util.Scanner;

public class Seaport {

    public static void Ship_Maker(Ship obj )
    {

        Scanner scan = new Scanner(System.in);

        System.out.println("What's the Name of the Ship?");
        String name = scan.nextLine();

        obj.setName(name);

        System.out.println("What's the name of the home port?");
        String home_port = scan.nextLine();

        obj.setHome_port(home_port);

        System.out.println("What's the transport origin?");
        String transport_origin = scan.nextLine();

        obj.setTransport_origin(transport_origin);

        System.out.println("What's the destination?");
        String destination = scan.nextLine();

        obj.setDestination(destination);

        System.out.println("What's the maximum capacity?");
        int MAX_CAPACITY = scan.nextInt();

        obj.setMAX_CAPACITY(MAX_CAPACITY);

        System.out.println("What's the maximum weight?");
        int MAX_WEIGHT = scan.nextInt();

        obj.setMAX_WEIGHT(MAX_WEIGHT);

        System.out.println("What's the maximum capacity for toxic and explosive containers on ship?");
        int max_tox_or_exp = scan.nextInt();

        obj.setMax_tox_or_exp(max_tox_or_exp);

        System.out.println("What's the maximum capacity for Heavy containers on ship?");
        int max_heavy = scan.nextInt();

        obj.setMax_heavy(max_heavy);

        System.out.println("What's the maximum capacity for containers requiring," +"\n" +
                " connection to the electricity network?");
        int max_electro = scan.nextInt();

        obj.setMax_electro(max_electro);

    }

    public static void whichShip()
    {
        System.out.println("Which Ship ?: ");
        System.out.println("\n");
        for (Ship obj : Ship.ships)
        {
            System.out.println( "Name: "+obj.name+"\n");

        }
        Scanner scan = new Scanner(System.in);

        System.out.println("Type the name of it: ");
        String shipName = scan.nextLine();
        if( compareShip(shipName))
        {
            System.out.println("add containers to this :"+shipName);

          //  container_menu();
        }
        else
        {
            System.out.println("Sorry, name not found");

        }


    }

    public static boolean compareShip(String shipName) {

        boolean compare = false;
        for (int i = 0; i < Ship.ships.size(); i++)
        {
            if (Objects.equals(shipName, Ship.ships.get(i).name))
            {
                compare = true;
                break;
            }

        }
        return compare;
    }



    public static void container_menu() {

        Scanner scan2 = new Scanner(System.in);

        System.out.println("What's the container type?");
        System.out.println("1. Standard cargo");
        System.out.println("2. Heavy cargo");
        System.out.println("3. Refrigerated cargo");
        System.out.println("4. Liquids cargo");
        System.out.println("5. Toxic Liquid cargo");
        System.out.println("6. Toxic Powder cargo");
        System.out.println("7. Explosive cargo");

        int container_type = scan2.nextInt();

        switch (container_type) {
            case 1:
                new Standard_Container();

                break;

            case 2:
                new Heavy_Container();
                break;


            case 3:
                new Refrigerated_Container() ;
                break;


            case 4:
                new Liquid_Container();
                break;


            case 5:
                new Toxic_Liquid_Container();
                break;

            case 6:
                new Toxic_Powder();
                break;


            case 7:
                new Explosive_Container();
                break;


            default:
                System.out.println("Please choose type :)");

        }


    }
}

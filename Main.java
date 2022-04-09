
import java.util.Scanner;
public class Main {


    public static void main(String[] args) {


        Ship ship1  = new Ship();
        Ship ship2  = new Ship();
        Ship ship3  = new Ship();

        ship1.setName("Damian");

        ship1.setMax_electro(3); ship1.setMax_heavy(3);
        ship1.setMAX_WEIGHT(50); ship1.setMAX_CAPACITY(7);
        ship1.setHome_port("Toronto"); ship1.setDestination("Poland"); ship1.setMax_tox_or_exp(3);
        ship1.setTransport_origin("Toronto");

        ship2.setName("Titanic");

        ship2.setMax_electro(3); ship2.setMax_heavy(3);
        ship2.setMAX_WEIGHT(50); ship2.setMAX_CAPACITY(7);
        ship2.setHome_port("New York"); ship2.setDestination("Poland"); ship2.setMax_tox_or_exp(3);
        ship2.setTransport_origin("New York");

        ship3.setName("Red");

        ship3.setMax_electro(3); ship3.setMax_heavy(3);
        ship3.setMAX_WEIGHT(50); ship3.setMAX_CAPACITY(7);
        ship3.setHome_port("Calagari"); ship3.setDestination("Poland"); ship3.setMax_tox_or_exp(3);
        ship3.setTransport_origin("Calagari");
/*
        System.out.println("Standard test \n" );
        Standard_Container cont1 = new Standard_Container(ship1);

        System.out.println("Explosive test \n");
        Explosive_Container cont2 = new Explosive_Container(ship1);
        System.out.println("toxic liquid test \n");

        Toxic_Liquid_Container cont3 = new Toxic_Liquid_Container(ship1);


 */
        Scanner scan = new Scanner(System.in);

        boolean loop = true;
        do {

            System.out.println("1 2 3 4");
            System.out.println("1. Create a ship");
            System.out.println("2. Create container");
            System.out.println("3. Show containers from a certain Ship");
            System.out.println("4. Move containers From Ship To WareHouse");
            System.out.println("5. Move containers From WareHouse To Ship, not working");
            System.out.println("6. Move containers From WareHouse To RailWay Station");
            System.out.println("7. Show contents of WareHouse");
            System.out.println("8. Quit");
            int menu = scan.nextInt();

            switch (menu) {


                case 1: {
                    System.out.println("Loading...");
                    Seaport.Ship_Maker(new Ship());
                    break;
                }


                case 2: {
                    System.out.println("Loading...");
                    Seaport.whichShip();

                    //Seaport.container_menu();
                    break;
                }

                case 3: {
                    System.out.println("Loading...");
                    Ship.whichShipShow();

                    break;
                }

                case 4: {
                    System.out.println("Loading...");
                    WareHouse.moveContainerShip_WareHouse(Ship.whichShipShow());

                    break;
                }

                case 5: {
                    System.out.println("Loading...");
                   // System.out.println("To which Ship you want to move containers");
                   // WareHouse.moveContainerWareHouse_Ship(Ship.whichShipShow());


                    break;
                }

                case 6: {
                    System.out.println("Loading...");
                    RailwayStation.moveToTrain();


                    break;
                }
                case 7: {
                    System.out.println("Loading...");

                    WareHouse.showWareHouse();

                    break;
                }


                case 8: {
                    System.out.println("Bye! Merry Christmas!");
                    scan.close();
                    loop = false;
                    break;
                }


                default: {

                    System.out.println("Wrong choice! :'(");
                    break;
                }
            }
        }while(loop);

    }
}

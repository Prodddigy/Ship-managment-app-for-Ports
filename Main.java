import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
public class Main {


    public static LocalDate localDate = LocalDate.now();

    public static void run()
    {
        localDate =localDate.plusDays(1);
    }

    public static void main(String[] args) throws InterruptedException, IrresponsibleSenderWithDangerousGoods {


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
        ship2.setMAX_WEIGHT(50); ship2.setMAX_CAPACITY(8);
        ship2.setHome_port("New York"); ship2.setDestination("Poland"); ship2.setMax_tox_or_exp(3);
        ship2.setTransport_origin("New York");

        ship3.setName("ARed");

        ship3.setMax_electro(3); ship3.setMax_heavy(3);
        ship3.setMAX_WEIGHT(50); ship3.setMAX_CAPACITY(9);
        ship3.setHome_port("Calagari"); ship3.setDestination("Poland"); ship3.setMax_tox_or_exp(3);
        ship3.setTransport_origin("Calagari");

        Sender sen1 = new Sender("Ola","Bialik","Częstochowa", 2001,"4","26");
        /*

        System.out.println("Standard test \n" );
        Standard_Container cont1 = new Standard_Container(ship1);

        System.out.println("Explosive test \n");
        Explosive_Container cont2 = new Explosive_Container(ship1);
        System.out.println("toxic liquid test \n");
*/
       // Toxic_Liquid_Container cont3 = new Toxic_Liquid_Container(ship1);
//     System.out.println(localDate);


        WareHouse.setWarehouseConstraints();

        Thread changeDate = new Thread(() -> {
            while (!Thread.interrupted()) {
                run();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    return;
                }
            }
        });



      //  changeDate.interrupt();
     //   changeDate.start();



        changeDate.start();




        Scanner scan = new Scanner(System.in);

        boolean loop = true;
        do {

            System.out.println("Current Date: "+localDate);
            System.out.println("1. Create a ship");
            System.out.println("2. Create container");
            System.out.println("3. Show containers from a certain Ship");
            System.out.println("4. Move containers From Ship To WareHouse");
            System.out.println("5. Move containers From WareHouse To Ship");
            System.out.println("6. Move containers From WareHouse To RailWay Station");
            System.out.println("7. Show contents of WareHouse");
            System.out.println("8. Make a departure of a ship");
            System.out.println("9. Print file and save progress");
            System.out.println("10. Quit");
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


                    break;
                }

                case 3: {

                    System.out.println("Loading...");
                   // Collections.sort(ship1.containers, Ship.ContainerCompare);
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

                    WareHouse.moveContainerWareHouse_Ship(Ship.whichShipShow());


                    break;
                }

                case 6: {
                    System.out.println("Loading...");
                    if(RailwayStation.train.size() ==10)
                    {
                        System.out.println("Sorry, The Train hasn't departed yet");
                    }
                    else
                    {
                        RailwayStation.moveToTrain();
                    }

                    break;
                }
                case 7: {
                    System.out.println("Loading...");

                    WareHouse.showWareHouse();

                    break;
                }
                case 8: {
                    System.out.println("Loading...");

                    Seaport.departureOfShip(Ship.whichShipShow());
                    break;
                }


                case 9: {
                    System.out.println("Loading...");
                    PrintFile.printShips();


                    break;
                }


                case 10: {
                    System.out.println("Bye! Merry Christmas!");

                    changeDate.interrupt();
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

        //Thread.sleep(1500000);
      
    }


}

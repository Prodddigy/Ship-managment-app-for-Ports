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

    public static void main(String[] args)  {


        Ship ship1  = new Ship();
        Ship ship2  = new Ship();
        Ship ship3  = new Ship();
        Ship ship4  = new Ship();
        Ship ship5  = new Ship();

        ship1.setName("Damian");

        ship1.setMax_electro(3); ship1.setMax_heavy(3);
        ship1.setMAX_WEIGHT(50); ship1.setMAX_CAPACITY(7);
        ship1.setHome_port("Toronto"); ship1.setDestination("Poland"); ship1.setMax_tox_or_exp(3);
        ship1.setTransport_origin("Toronto");

        ship2.setName("Titanic");

        ship2.setMax_electro(3); ship2.setMax_heavy(3);
        ship2.setMAX_WEIGHT(50); ship2.setMAX_CAPACITY(8);
        ship2.setHome_port("New York"); ship2.setDestination("Poland"); ship2.setMax_tox_or_exp(38);
        ship2.setTransport_origin("New York");

        ship3.setName("ARed");

        ship3.setMax_electro(3); ship3.setMax_heavy(3);
        ship3.setMAX_WEIGHT(50); ship3.setMAX_CAPACITY(9);
        ship3.setHome_port("Calagari"); ship3.setDestination("Poland"); ship3.setMax_tox_or_exp(3);
        ship3.setTransport_origin("Calagari");

        ship4.setName("VeryCoolShipName");

        ship4.setMax_electro(10); ship4.setMax_heavy(3);
        ship4.setMAX_WEIGHT(50); ship4.setMAX_CAPACITY(9);
        ship4.setHome_port("Neverland"); ship4.setDestination("Cuba"); ship4.setMax_tox_or_exp(3);
        ship4.setTransport_origin("Gdańsk");


        ship5.setName("AnotherVeryCoolShipName");

        ship5.setMax_electro(3); ship5.setMax_heavy(30);
        ship5.setMAX_WEIGHT(50); ship5.setMAX_CAPACITY(19);
        ship5.setHome_port("Canada"); ship5.setDestination("Germany"); ship5.setMax_tox_or_exp(13);
        ship5.setTransport_origin("Quebec");


        Sender sen2 = new Sender("Cole","Smith","Warszawa", 1990,"12","1");
        Sender sen3 = new Sender("Max","Kowalski","Kraków", 2003,"7","8");
        Sender sen1 = new Sender("Ola","Bialik","Częstochowa", 2001,"4","26");

        WareHouse.setWarehouseConstraints();

       // System.out.println("Standard test \n" );
        Standard_Container cont1 = new Standard_Container(
                "Ola","stuff","cerificate",5,1,"Standard Cargo");

        Toxic_Liquid_Container cont2 = new Toxic_Liquid_Container(
                "Max","stuff","cerificate",5,1,"Toxic_Liquid");

        Explosive_Container cont3 = new Explosive_Container(
                "Ola","stuff","cerificate",5,1,"Explosive_Container");

        Heavy_Container cont4 = new Heavy_Container(
                "Cole","stuff","cerificate",5,1,"Heavy_Container");

        Refrigerated_Container cont5 = new Refrigerated_Container(
                "Max","stuff","cerificate",5,1,"Refrigerated_Container");

        Toxic_Powder cont8 = new Toxic_Powder(
                "Max","stuff","cerificate",5,1,"Toxic_Powder");

        ship1.containers.add(cont1);
        defaultContents( ship1,  cont1);

        ship2.containers.add(cont2);
        defaultContents( ship2,  cont2);

        ship3.containers.add(cont3);
        defaultContents( ship3,  cont3);

        ship4.containers.add(cont4);
        defaultContents( ship4,  cont4);

        ship5.containers.add(cont5);
        defaultContents( ship5,  cont5);

        ship1.containers.add(cont8);
        defaultContents( ship1,  cont8);


        Liquid_Container cont6 = new Liquid_Container(
                "Cole","stuff","cerificate",5,1,"Liquid_Container");

        Heavy_Container cont7 = new Heavy_Container(
                "Max","stuff","cerificate",5,1,"Heavy_Container");

        WareHouse.storage.add(cont6);
        cont6.arrivalWarehouseDate= localDate;
        WareHouse.checkOutCapacity(cont6);
        WareHouse.storage.add(cont7);
        cont7.arrivalWarehouseDate= localDate;
        WareHouse.checkOutCapacity(cont7);

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

            System.out.println("Current Date: "+localDate+"_________________________________.");
            System.out.println(" 1.| Create a ship                                     .1|");
            System.out.println(" 2.| Create container                                  .2|");
            System.out.println(" 3.| Show containers from a certain Ship               .3|");
            System.out.println(" 4.| Move containers From Ship To WareHouse            .4|");
            System.out.println(" 5.| Move containers From WareHouse To Ship            .5|                                                                                                                                                                  (0) <- my first easter egg!!!    is code good ?:___       ");
            System.out.println(" 6.| Move containers From WareHouse To RailWay Station .6|");
            System.out.println(" 7.| Show contents of WareHouse                        .7|");
            System.out.println(" 8.| Make a departure of a ship                        .8|");
            System.out.println(" 9.| Print file and save progress                      .9|");
            System.out.println("10.| Quit_____________________________________________.10|");
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
                    stopExpiration();
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

    public static void stopExpiration()
    {
        for(Standard_Container s : WareHouse.storage)
        {
            if(s.expirationDoc != null) {
                s.expirationDoc.interrupt();
            }
        }
    }



    public static void defaultContents(Ship ship, Standard_Container cont)
    {
        ship.MAX_CAPACITY_counter += 1;
        ship.MAX_WEIGHT_counter += cont.brutto_weight;

        if(cont.container_type == "Toxic_Powder" || cont.container_type == "Toxic_Liquid")
        {

            ship.max_tox_or_exp_counter++;
            ship.MAX_WEIGHT_counter += cont.brutto_weight;
            ship.MAX_CAPACITY_counter += 1;

        }

        if(cont.getContainer_type() == "Refrigerated_Container" )
        {

            ship.max_electro_counter++;
            ship.MAX_WEIGHT_counter += cont.brutto_weight;
            ship.MAX_CAPACITY_counter += 1;

        }

        if(cont.container_type == "Heavy_Container" )
        {

            ship.max_heavy_counter++;
            ship.MAX_WEIGHT_counter += cont.brutto_weight;
            ship.MAX_CAPACITY_counter += 1;
        }

        if(cont.container_type == "Explosive_Container")
        {
            ship.max_tox_or_exp_counter++;
            ship.MAX_WEIGHT_counter += cont.brutto_weight;
            ship.MAX_CAPACITY_counter += 1;

        }
    }


}

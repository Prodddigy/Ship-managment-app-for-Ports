
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

        Scanner scan = new Scanner(System.in);

        boolean loop = true;
        do {

            System.out.println("1 2 3 4");
            System.out.println("1. Create a ship");
            System.out.println("2. Create container");
            System.out.println("3. Show container");
            System.out.println("4. Quit");
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
                    System.out.println(Standard_Container.containers.get(0).toString());

                    break;
                }

                case 4: {
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









        //System.out.println(test.getShip_ID());



        //  Standard_Container test1 = new Toxic_Container("test", "secure",
        //        "certificate", 5, 1, "standard");



        //   System.out.println("toxic"+test1.container_ID+ " "+ test1.container_type);

    }

}

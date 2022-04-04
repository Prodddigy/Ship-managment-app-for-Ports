
import java.util.Scanner;
public class Main {




    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
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
                }
                break;
                case 2: {
                    System.out.println("Loading...");
                    Seaport.container_menu();
                    break;
                }

                case 3: {
                    System.out.println(Standard_Container.containers.get(0).toString());

                    break;
                }

                case 4: {
                    System.out.println("Bye! Merry Christmas!");
                    scan.close();
                    break;
                }


                default:

                    System.out.println("Wrong choice! :'(");
            }
        }while(true);









        //System.out.println(test.getShip_ID());



        //  Standard_Container test1 = new Toxic_Container("test", "secure",
        //        "certificate", 5, 1, "standard");



        //   System.out.println("toxic"+test1.container_ID+ " "+ test1.container_type);

    }

}

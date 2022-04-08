import java.util.ArrayList;
import java.util.Scanner;

public class Standard_Container {

    /*Each type of container has a different set of attributes (e.g. information about the sender,
 tare, information about the security of the container, net weight, gross weight, information about
 certificates, etc.). Also, each container has its own unique identification number assigned automatically
 when creating the object. For each type of container, you must additionally devise at
 least one unique attribute throughout all container types.
 We have at our disposal, among others:
 • standard container,
 • heavy container, which is a type of standard container,
 • a refrigerated container, which is a type of heavy container, requiring connection to the
 ship’s electrical network,
 • a container for liquids cargo, which is a type of standard container,
 • a container for explosives cargo, which is a type of standard container,
 • a container for toxic cargo, which is a type of heavy container, which is available in two
 versions: a container for toxic powdery cargo and a container for toxic liquid cargo, which
 is not only a kind of heavy container, but also has the features of a container for liquids
 cargo.
  */
    String sender_info;
    String secure_info;
    String certificate;

    int brutto_weight;
    int tare_weight;
    int nettoweight;

    int container_ID;

    String container_type;

    static int num_containers=0;

   // static ArrayList<Standard_Container> containers ;



    public Standard_Container(Ship chosenShip,String check) {

        Scanner scan3 = new Scanner(System.in);

        System.out.println("What's the sender's information ?");
        String sender_info = scan3.nextLine();

        this.sender_info = sender_info;


        System.out.println("What's the information about security?");
        String secure_info = scan3.nextLine();

        this.secure_info = secure_info;

        System.out.println("What's the certificate?");
        String certificate = scan3.nextLine();

        this.certificate = certificate;


        System.out.println("What's the brutto weight?");
        int brutto_weight = scan3.nextInt();

        if(chosenShip.MAX_WEIGHT >= brutto_weight + chosenShip.MAX_WEIGHT_counter
                && chosenShip.MAX_CAPACITY >= 1 + chosenShip.MAX_CAPACITY_counter)
        {
            this.brutto_weight = brutto_weight;

            System.out.println("What's the tare weight?");
            int tare_weight = scan3.nextInt();

            this.tare_weight = tare_weight;

            this.nettoweight = brutto_weight-tare_weight;

            this.container_type = "Standard Cargo";

            this.container_ID =num_containers++;

            chosenShip.containers.add(this);
        }
        else
        {

            System.out.println("sorry too heavy or too many containers already");

        }

        if(check == "Standard_Container")
        {
            chosenShip.MAX_CAPACITY_counter += 1;
            chosenShip.MAX_WEIGHT_counter += this.brutto_weight;
        }

        /*
        if(chosenShip.MAX_CAPACITY >= 1+ chosenShip.MAX_CAPACITY_counter
        && chosenShip.MAX_WEIGHT >= this.brutto_weight+ chosenShip.MAX_CAPACITY_counter
        && chosenShip.max_heavy >= 1+ chosenShip.max_heavy_counter
        && chosenShip.max_electro >= 1+ chosenShip.max_electro_counter
        && chosenShip.max_tox_or_exp >= 1+ chosenShip.max_tox_or_exp_counter
        )
        {

            chosenShip.containers.add(this);
        }
        else
            System.out.println("dont add");
*/

    }

    public String toString()
    {
        return "Type: "+ this.container_type+","+
                " Sender info: "+ this.sender_info+","+
                " Security info: "+ this.secure_info+","+
                " Certificate: "+ this.certificate+","+
                " Gross weight: "+ this.brutto_weight+","+
                " Tare weight: "+ this.tare_weight+","+
                " Net Weight: "+ this.nettoweight+","+
                " Container ID: "+ this.container_ID;
    }

}

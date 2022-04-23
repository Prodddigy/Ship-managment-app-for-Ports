public class Toxic_Liquid_Container extends Heavy_Container implements Liquidable_Container{

    public Toxic_Liquid_Container(Ship chosenShip, String check)
    {
        super(chosenShip,check);

        constructor();

        this.container_type = "Toxic_Liquid";
        if(check == "Toxic_Liquid_Container" && Sender.findSender(sender_info) != null)
        {
            if(chosenShip.max_tox_or_exp < 1+ chosenShip.max_tox_or_exp_counter)
            {
                chosenShip.containers.remove(this);
                System.out.println("Can't add, limit reached");
            }
            else
            {
                chosenShip.max_tox_or_exp_counter++;
                chosenShip.MAX_WEIGHT_counter += this.brutto_weight;
                chosenShip.MAX_CAPACITY_counter += 1;
            }
        }
    }

    public String toString()
    {
        return  "--------------------------------------------------------\n"+
                " Type         : "+ this.container_type+";"+
                "                 Container ID : "+ this.container_ID+";\n"+
                " Security info: "+ this.secure_info+";"+
                "                                   Certificate  : "+ this.certificate+";\n"+
                " Gross weight : "+ this.brutto_weight+";"+
                "                                     Tare weight  : "+ this.tare_weight+";\n"+
                " Net Weight   : "+ this.nettoweight+";"+
                "                                     Sender info  : "+ this.sender_info+";\n";
    }
}
        /*a container for toxic cargo, which is a type of heavy container, which is available in two
versions: a container for toxic powdery cargo and a container for toxic liquid cargo, which
is not only a kind of heavy container, but also has the features of a container for liquids
cargo.
*/

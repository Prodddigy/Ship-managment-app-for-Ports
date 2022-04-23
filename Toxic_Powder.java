public class Toxic_Powder extends Heavy_Container{

    public Toxic_Powder(String sender, String stuff, String cerificate, int brutto, int tare, String cargoname) {
        super(sender,stuff,cerificate,brutto,tare,cargoname);
        this.nettoweight = brutto_weight-tare_weight;
    }

    Toxic_Powder(Ship chosenShip, String check)
    {
        super(chosenShip,check);


        this.container_type = "Toxic_Powder_Container";

        if(check == "Toxic_Powder" && Sender.findSender(sender_info) != null)
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

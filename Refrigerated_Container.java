public class Refrigerated_Container extends Heavy_Container{

    public Refrigerated_Container(Ship chosenShip,String check)
    {
        super(chosenShip,check);

        this.container_type = "Refrigerated_Container";
        System.out.println("this is ref" + check);

        if(check == "Refrigerated_Container" && Sender.findSender(sender_info) != null)
        {
            if(chosenShip.max_electro < 1+ chosenShip.max_electro_counter)
            {
                chosenShip.containers.remove(this);
                System.out.println("Can't add, limit reached");
            }
            else
            {
                chosenShip.max_electro_counter++;
                chosenShip.MAX_WEIGHT_counter += this.brutto_weight;
                chosenShip.MAX_CAPACITY_counter += 1;
            }
        }

        }

    public Refrigerated_Container(String sender, String stuff, String cerificate, int brutto, int tare, String cargoname) {
        super(sender, stuff, cerificate, brutto, tare, cargoname);

        this.nettoweight = brutto_weight-tare_weight;
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

    //connect to network ?

}

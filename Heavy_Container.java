public class Heavy_Container extends Standard_Container{


//• heavy container, which is a type of standard container,


    public Heavy_Container(Ship chosenShip, String check)
    {


        super(chosenShip,check);
        this.container_type = "Heavy_Container";


       // System.out.println("it hit heavy" + check);


        if(check == "Heavy_Container" && Sender.findSender(sender_info) != null)
        {
            if(chosenShip.max_heavy < 1+ chosenShip.max_heavy_counter)
            {
                chosenShip.containers.remove(this);
               System.out.println("Can't add, limit reached");
            }
            else
            {
                chosenShip.max_heavy_counter++;
                chosenShip.MAX_WEIGHT_counter += this.brutto_weight;
                chosenShip.MAX_CAPACITY_counter += 1;
            }
        }


    }

    public Heavy_Container(String sender, String stuff, String cerificate, int brutto, int tare, String cargoname) {
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


}

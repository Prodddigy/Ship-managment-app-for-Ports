public class Liquid_Container extends Standard_Container implements Liquidable_Container{

    public Liquid_Container(Ship chosenShip,String check)
    {
        super(chosenShip,check);
        this.container_type = "Liquid_Container";

        if(check == "Liquid_Container" && Sender.findSender(sender_info) != null)
        {
                chosenShip.MAX_WEIGHT_counter += this.brutto_weight;
                chosenShip.MAX_CAPACITY_counter += 1;
            }
        }

    public Liquid_Container(String sender, String stuff, String cerificate, int brutto, int tare, String cargoname) {
        super(sender,stuff,cerificate,brutto,tare,cargoname);
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

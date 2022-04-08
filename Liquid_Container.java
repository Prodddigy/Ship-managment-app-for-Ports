public class Liquid_Container extends Standard_Container implements Liquidable_Container{

    public Liquid_Container(Ship chosenShip,String check)
    {
        super(chosenShip,check);
        this.container_type = "Liquid_Container";

        if(check == "Liquid_Container")
        {
                chosenShip.MAX_WEIGHT_counter += this.brutto_weight;
                chosenShip.MAX_CAPACITY_counter += 1;
            }
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

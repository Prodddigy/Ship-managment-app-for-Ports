public class Liquid_Container extends Standard_Container implements Liquidable_Container{

    public Liquid_Container(Ship chosenShip)
    {
        super(chosenShip);
        this.container_type = "Liquid_Container";
    }

    public String toString()
    {
        return "Type: "+ this.container_type+
                " Sender info: "+ this.sender_info+
                " Security info: "+ this.secure_info+
                " Certificate: "+ this.certificate+
                " Gross weight: "+ this.brutto_weight+
                " Tare weight: "+ this.tare_weight+
                " Net Weight: "+ this.nettoweight+
                " Container ID: "+ this.container_ID;
    }

}

public class Toxic_Liquid_Container extends Heavy_Container implements Liquidable_Container{

    public Toxic_Liquid_Container(Ship chosenShip)
    {
        super(chosenShip);
        constructor();
        this.container_type = "Toxic_Liquid";

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
        /*a container for toxic cargo, which is a type of heavy container, which is available in two
versions: a container for toxic powdery cargo and a container for toxic liquid cargo, which
is not only a kind of heavy container, but also has the features of a container for liquids
cargo.
*/

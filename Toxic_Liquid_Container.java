public class Toxic_Liquid_Container extends Heavy_Container implements Liquidable_Container{

    public Toxic_Liquid_Container()
    {
        super();
        constructor();
        this.container_type = "Toxic_Liquid";

    }

    public String toString()
    {
    return "Type: "+ this.container_type+
     "Type: "+ this.sender_info+
     "Type: "+ this.secure_info+
     "Type: "+ this.certificate+
     "Type: "+ this.brutto_weight+
     "Type: "+ this.tare_weight+
     "Type: "+ this.nettoweight+
     "Type: "+ this.container_ID+
     "Type: "+ this.container_ID+
     "Type: "+ num_containers;
    }
}
        /*a container for toxic cargo, which is a type of heavy container, which is available in two
versions: a container for toxic powdery cargo and a container for toxic liquid cargo, which
is not only a kind of heavy container, but also has the features of a container for liquids
cargo.
*/

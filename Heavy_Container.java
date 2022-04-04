public class Heavy_Container extends Standard_Container{


//• heavy container, which is a type of standard container,


    public Heavy_Container()
    {
        super();
        this.container_type = "Heavy_Container";


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

public class Explosive_Container extends Standard_Container{

    public Explosive_Container(Ship chosenShip, String check)
    {
        super(chosenShip,check);

        this.container_type = "Explosive_Container";

        if(check == "Explosive_Container")
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

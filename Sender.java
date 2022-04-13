public class Sender {

    String senderName;
    String senderSurname;

    String adress;

    int numOFComplains;
    int DOB;// this should be combined with pesel and use of LocalDate obj
    int pesel;

    Sender(String senderName, String senderSurname,String adress, int pesel)
    {
        this.senderName = senderName;
        this.senderSurname = senderSurname;
        this.pesel = pesel;
        this.adress = adress;

    }

}

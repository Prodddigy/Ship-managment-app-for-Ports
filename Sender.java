import java.util.ArrayList;

public class Sender
{
    String senderName;
    String senderSurname;

    String adress;

    int year;

    String month;
    String day;

    int numOFComplains=0;
    int DOB;// this should be combined with pesel and use of LocalDate obj
    String pesel;

    ArrayList<IrresponsibleSenderWithDangerousGoods> complain = new ArrayList<>(2);

    Sender(String senderName, String senderSurname,String adress )
    {
        this.senderName = senderName;
        this.senderSurname = senderSurname;
        this.adress = adress;

        numOFComplains++;
    }



    public void makePESEL()
    {
        if(year <2000 && month.length()<1)
        {
            month = "0"+month;
        }

        if(month.length() < 1)
        {
            month = month.replace("1","3");
        }
        else
        {
            month = "2"+month;
        }



        pesel =year+month+day;

    }

}

import java.util.ArrayList;
import java.util.Objects;

public class Sender
{
    String senderName;
    String senderSurname;

    String adress;

    int year;

    String Syear ;
    String month;
    String day;

    int numOFComplains;
    //int DOB;// this should be combined with pesel and use of LocalDate obj
    String pesel;

    ArrayList<IrresponsibleSenderWithDangerousGoods> complain = new ArrayList<>(2);

   static ArrayList<Sender> senders = new ArrayList<>();

    Sender(String senderName, String senderSurname,String adress,int year, String month, String day )
    {
        this.senderName = senderName;
        this.senderSurname = senderSurname;
        this.adress = adress;
        this.month= month;
        this.year=year;
        this.day=day;
        this.Syear = this.year+"";
        makePESEL();
        senders.add(this);
        //numOFComplains++;

        //System.out.println(this.senderName+this.pesel+" "+this.Syear);
    }

    public static Sender findSender(String senderInfo)
    {
       Sender sen = null;
        for (int i = 0; i <senders.size() ; i++)
        {
            if (Objects.equals(senderInfo, senders.get(i).senderName))
            {
                sen = senders.get(i);
                break;
            }
        }
        return sen;
    }

    public void makePESEL()
    {
        if(year <2000 && month.length()<2)
        {
            month = "0"+month;
        }

        if( year >= 2000 && month.length() < 2)
        {
            month = month.replace("1","3");
        }

         if(year >=2000)
        {
            month = "2"+month;
        }

        Syear= Syear.substring(2,4);

        pesel =Syear+month+day;
    }
}

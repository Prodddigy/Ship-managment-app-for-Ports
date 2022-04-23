import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;



public class Sender
{
    String senderName;
    String senderSurname;

    String adress;

    int year;

    String Syear ;
    String Smonth;
    String Sday;
    int month;
    int day;
    int numOFComplains;
    LocalDate DOB;// this should be combined with pesel and use of LocalDate obj
    String pesel;

    ArrayList<IrresponsibleSenderWithDangerousGoods> complain = new ArrayList<>(2);

   static ArrayList<Sender> senders = new ArrayList<>();

    Sender(String senderName, String senderSurname,String adress,int year, String month, String day )
    {
        this.senderName = senderName;
        this.senderSurname = senderSurname;
        this.adress = adress;
        this.Smonth= month;
        this.year=year;
        this.Sday=day;
        this.Syear = this.year+"";
        makePESEL();
        senders.add(this);
        //numOFComplains++;

        this.month = Integer.parseUnsignedInt(month);
        this.day = Integer.parseUnsignedInt(day);
        if(month.length()!=2)
        {
            Smonth= "0"+month;
        }

       // this.DOB = of(int year,int month,int day);

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
        if(year <2000 && Smonth.length()<2)
        {
            this.Smonth = "0"+Smonth;
        }

        if( year >= 2000 && Smonth.length() < 2)
        {
            Smonth = Smonth.replace("1","3");
        }

         if(year >=2000)
        {
            Smonth = "2"+Smonth;
        }

        Syear= Syear.substring(2,4);

         int rand= (int) (Math.random()*9999+10000);;

        pesel = Syear + Smonth + Sday + rand;
    }

    @Override
    public String toString() {
        return "----------------------------------------------\n"+
                "Name: " + senderName + '\n' +
                "Surname: " + senderSurname + '\n' +
                "Address: " + adress + '\n' +
                "DOB: " + year+ "."+Smonth+"."+ Sday+"."+ '\n' +
                "PESEL: " + pesel + '\n' +
                "Complains: " + numOFComplains + '\n';
    }
}

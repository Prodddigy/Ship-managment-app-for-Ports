
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collections;


public class PrintFile
{
    public static void printShips()
    {
        try {
            PrintWriter printWriter = new PrintWriter("file.txt");

            Collections.sort(Ship.ships,
                    Ship.ShipCompare);

      printWriter.println("|---Ships and their contents---|");
            for (Ship s : Ship.ships)
            {
                int counter=1;
                printWriter.println(s);
                printWriter.println("Contents of ship: "+s.getName());

                Collections.sort(s.containers, Ship.ContainerCompare);

                for (Standard_Container c : s.containers)
                {
                    printWriter.print(counter++ +". ");
                    printWriter.println(c);
                }
                printWriter.println("|---End of ship:"+s.getName()+"---|\n");
            }
            printWriter.println("|---End of Ships---|\n");

            printWriter.println("|---Warehouse and its contents---|");

            Collections.sort(WareHouse.storage, WareHouse.ContainerCompareWarehouseDate);
            Collections.sort(WareHouse.storage,WareHouse.ContainerCompareWarehouseSender);
            printWriter.println( "-------------------------------\n"+
                    "Heavy : "+WareHouse.MaxHeavy_counter+"/"+WareHouse.MaxHeavy+"\n"+
                    "Electric : "+WareHouse.MaxElec_counter+"/"+WareHouse.MaxElec+"\n"+
                    "Liquid: "+WareHouse.MaxLiq_counter+"/"+WareHouse.MaxLiq+"\n"+
                    "Toxic Liquid: "+WareHouse.MaxTL_counter+"/"+WareHouse.MaxTL+"\n"+
                    "Toxic Powder: "+WareHouse.MaxTP_counter+"/"+WareHouse.MaxTP+"\n"+
                    "Explosive: "+WareHouse.MaxExp_counter+"/"+WareHouse.MaxExp+"\n"+
                    "-------------------------------");
            int counter=1;
            for(Standard_Container c : WareHouse.storage)
            {
                printWriter.print(counter++ +". ");
                printWriter.print("Arrival Date: "+c.arrivalWarehouseDate);
                printWriter.println(c);
            }
            printWriter.println("|---End of Warehouse---|\n");

            printWriter.println("|---Train and its contents---|");

            counter= 1;

            for (Standard_Container c : RailwayStation.train)
            {
                printWriter.print(counter++ +". ");
                printWriter.println(c);

            }
            printWriter.println("|---End of Train---|\n");

            counter=1;
            printWriter.println("|---Senders---|\n");
            for (Sender s : Sender.senders)
            {
                printWriter.print(counter++ +". ");
                printWriter.println(s);
                printWriter.println("|---Expired Containers---|\n");
                    for(IrresponsibleSenderWithDangerousGoods i : s.complain)
                    {
                        printWriter.println(i);
                    }
                printWriter.println("|---End of Expired Containers---|\n");
            }
            printWriter.println("|---End of Senders---|\n");


            printWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
/*
Containers stored in the warehouse should be sorted in descending order according to thestorage start date
 (from the longest stored to the shortest),
 and if the storage time is thesame, the next sorting criterion is the sender’s name.

 such as data ofsenders, ships, warehouse, containers and the complete set of information about them
 */
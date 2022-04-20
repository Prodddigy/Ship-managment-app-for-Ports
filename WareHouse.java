
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class WareHouse
{

   static int MaxExp=14;
    static int MaxTP=10;
    static int MaxTL=5;

    static int MaxElec=10;
    static int MaxHeavy=10;
    static int MaxStandard=10;
    static int MaxLiq=10;

    static int MaxLiq_counter=0;
    static int MaxElec_counter=0;
    static int MaxHeavy_counter=0;
    static int MaxStandard_counter=0;
    static int MaxExp_counter=0;
    static int MaxTP_counter=0;
    static int MaxTL_counter=0;
    //if container.name == -||- then max --
    //if container.name == -||- anc max.container.name =0 then dont add simple enought

    //

    static ArrayList<Standard_Container> storage = new ArrayList<>();
    //Capacity :EXP =14, ToxicP = 10, ToxicL =5. !!!!!


    public static void setWarehouseConstraints()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Maximum of Explosive containers? ");
        MaxExp = scan.nextInt();

        System.out.println("Maximum of Toxic Powder containers? ");
        MaxTP = scan.nextInt();

        System.out.println("Maximum of Toxic Liquid containers? ");
        MaxTL = scan.nextInt();

        System.out.println("Maximum of Electric containers? ");
        MaxElec = scan.nextInt();

        System.out.println("Maximum of Heavy containers? ");
        MaxHeavy = scan.nextInt();

        System.out.println("Maximum of Standard containers? ");
        MaxStandard = scan.nextInt();

        System.out.println("Maximum of Liquid containers? ");
        MaxLiq = scan.nextInt();


    }


    public static void moveContainerShip_WareHouse(String shipName) throws IrresponsibleSenderWithDangerousGoods {

        Scanner scan = new Scanner(System.in);

        System.out.println("Which container to move ?\n");
        System.out.println("Choose by entering ID: ");

        int contID = scan.nextInt();

        if(Ship.compareContainer(shipName,contID))
        {

            Ship.findContainer(shipName,contID).arrivalWarehouseDate = Main.localDate;
            moveToWareHouse(shipName,Ship.findContainer(shipName,contID));
        }
        else
            System.out.println("sorry, container not found :/");
    }

   public static void moveToWareHouse(String shipName,Standard_Container cont) throws IrresponsibleSenderWithDangerousGoods {

       Ship tmpShip = Seaport.findShip(shipName);
       if(cont != null)
       {
           if(checkOutCapacity(cont)) {

               storage.add(cont);

               tmpShip.containers.remove(cont);

               updatePlungedShip(cont,tmpShip);
           }
           else
               System.out.println("can't fit this container in here chief");
       }
       else
           System.out.println("no such container in: "+shipName+"ship :/");
    }

    public static void updatePlungedShip(Standard_Container cont, Ship ship)
    {
        ship.MAX_WEIGHT_counter-=cont.brutto_weight;

        ship.MAX_CAPACITY_counter--;

        if(Objects.equals(cont.getContainer_type(), "Toxic_Powder_Container")
                || Objects.equals(cont.getContainer_type(), "Toxic_Liquid")
                || Objects.equals(cont.getContainer_type(), "Explosive_Container") )
        {
           ship.max_tox_or_exp_counter--;
        }

        if(Objects.equals(cont.getContainer_type(), "Refrigerated_Container"))
        {
            ship.max_electro_counter--;
        }

        if(Objects.equals(cont.getContainer_type(), "Heavy_Container"))
        {
            ship.max_heavy_counter--;
        }
    }

    public static boolean checkOutCapacity(Standard_Container cont) throws IrresponsibleSenderWithDangerousGoods
    {
        if(Objects.equals(cont.getContainer_type(), "Standard Cargo")&& MaxStandard_counter+1 <= MaxStandard)
        {
            MaxStandard_counter++;

            return true;
        }

        if(Objects.equals(cont.getContainer_type(), "Liquid_Container") && MaxLiq_counter+1 <= MaxLiq)
        {
            MaxLiq_counter++;

            return true;
        }

        if(Objects.equals(cont.getContainer_type(), "Refrigerated_Container") && MaxElec_counter+1 <= MaxElec)
        {
            MaxElec_counter++;

            return true;
        }

        if(Objects.equals(cont.getContainer_type(), "Heavy_Container") && MaxHeavy_counter+1 <= MaxHeavy)
        {
            MaxHeavy_counter++;

            return true;
        }

        if(Objects.equals(cont.getContainer_type(), "Toxic_Powder_Container") && MaxTP_counter+1 <= MaxTP) {
            MaxTP_counter++;


            Thread TPDate = new Thread(() -> {
                while (!Thread.interrupted()) {
                    try {
                        Thread.sleep(50000);

                    } catch (InterruptedException e) {

                        return;
                    }//sender interrupt
                    try {
                        throw new IrresponsibleSenderWithDangerousGoods(
                                cont.secure_info, cont.certificate, cont.brutto_weight, cont.tare_weight,
                                cont.nettoweight, cont.container_ID, cont.container_type,
                                cont.arrivalWarehouseDate, cont.expDateTime);


                    }catch (IrresponsibleSenderWithDangerousGoods f){
                        Sender send = Sender.findSender(cont.sender_info);
                        if(send != null)
                        {
                            send.complain.add(f);
                            cont.expDateTime = Main.localDate;
                            storage.remove(cont);
                            MaxTP_counter--;
                            send.numOFComplains++;

                        }

            //cont.sender_info.
                        // complain.add(expCont);
                    }
                }
            });
            //throw new IrresponsibleSenderWithDangerousGoods(cont.secure_info, cont.certificate, cont.brutto_weight, cont.tare_weight, cont.nettoweight, cont.container_ID, cont.container_type);

            TPDate.start();

            cont.expirationDoc =TPDate;

            //remove this and make an obj on IRRS
            //method(cont.sender_info).numbrofcompains++;
           // cont.expirationDate =TPDate;

                return true;
        }

        if(Objects.equals(cont.getContainer_type(), "Toxic_Liquid") && MaxTL_counter +1 <= MaxTL)
        {
            MaxTL_counter++;

            Thread TLDate = new Thread(() -> {
                while (!Thread.interrupted()) {
                    try {
                        Thread.sleep(25000);
                    } catch (InterruptedException e) {
                        return;
                    }
                    try {
                        throw new IrresponsibleSenderWithDangerousGoods(cont.secure_info, cont.certificate, cont.brutto_weight, cont.tare_weight,
                                cont.nettoweight, cont.container_ID, cont.container_type,
                                cont.arrivalWarehouseDate, cont.expDateTime);

                    }catch (IrresponsibleSenderWithDangerousGoods f){
                        Sender send = Sender.findSender(cont.sender_info);
                        if(send != null)
                        {
                            send.complain.add(f);
                            cont.expDateTime = Main.localDate;
                            storage.remove(cont);
                            MaxTL_counter--;
                            send.numOFComplains++;
                        }
                        //cont.sender_info.
                        // complain.add(expCont);
                    }//sender interrupt
                }
            });

            TLDate.start();

            cont.expirationDoc =TLDate;
            return true;
        }

        if(Objects.equals(cont.getContainer_type(), "Explosive_Container") && MaxExp_counter +1 <= MaxExp)
        {
            MaxExp_counter++;

            Thread EXDate = new Thread(() -> {
                while (!Thread.interrupted()) {
                    try {
                        Thread.sleep(70000);
                    } catch (InterruptedException e) {
                        return;
                    }
                    try {
                        throw new IrresponsibleSenderWithDangerousGoods(cont.secure_info, cont.certificate, cont.brutto_weight, cont.tare_weight,
                                cont.nettoweight, cont.container_ID, cont.container_type,
                                cont.arrivalWarehouseDate, cont.expDateTime);

                    }catch (IrresponsibleSenderWithDangerousGoods f){
                        Sender send = Sender.findSender(cont.sender_info);
                        if(send != null)
                        {
                            send.complain.add(f);
                            cont.expDateTime = Main.localDate;
                            storage.remove(cont);
                            MaxExp_counter--;
                            send.numOFComplains++;
                        }
                        //cont.sender_info.
                        // complain.add(expCont);
                    }//sender interrupt
                }
            });
            EXDate.start();

            cont.expirationDoc = EXDate;
            return true;
        }
        return false;
    }

    public static void showWareHouse()
    {
        for(Standard_Container cont : WareHouse.storage)
        {
            System.out.println(cont.toString());
            System.out.println("\n");
        }
    }

    public static void moveContainerWareHouse_Ship(String shipName)
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Which container to move ?\n");
        showWareHouse();
        System.out.println("Choose by entering ID: ");
        int contID = scan.nextInt();

        Standard_Container cont =whichContFromWareHouse(contID);

        if(cont!= null)
        {
           if( checkConstraints(contID,shipName))
           {
                if(cont.getContainer_type() =="Explosive_Container"
                        || cont.getContainer_type() =="Toxic_Liquid"
                        || cont.getContainer_type() =="Toxic_Powder_Container")
                {
                    cont.expirationDoc.interrupt();
                }

               Seaport.findShip(shipName).containers.add(cont);

               storage.remove(cont);
           }
        }
        else
            System.out.println("No Such container in Warehouse :/");
    }

    public static Standard_Container whichContFromWareHouse(int contID)
    {
        for (int i = 0; i < storage.size(); i++)
        {
            if(Objects.equals(contID, storage.get(i).container_ID))
            {
                return storage.get(i);
            }
        }
        return null;
    }

    public static boolean checkConstraints(int contID, String shipName)
    {
        boolean check = false;

        Ship tmpShip= Seaport.findShip(shipName);

        Standard_Container tmpCont = whichContFromWareHouse(contID);

        if(Objects.equals(tmpCont.container_type, "Standard Cargo")
        || Objects.equals(tmpCont.getContainer_type(), "Liquid_Container"))
        {
            if( tmpShip.MAX_CAPACITY_counter + 1 <= tmpShip.MAX_CAPACITY
            && (tmpShip.MAX_WEIGHT_counter +tmpCont.brutto_weight ) <= tmpShip.MAX_WEIGHT)
            {
                tmpShip.MAX_CAPACITY_counter ++;
                tmpShip.MAX_WEIGHT_counter += tmpCont.brutto_weight;

                check = true;
            }
            else
            {
                System.out.println("This will not fit in the " + shipName + " :'-(");
            }
        }

        if(Objects.equals(tmpCont.getContainer_type(), "Refrigerated_Container"))
        {
            if( tmpShip.MAX_CAPACITY_counter + 1 <= tmpShip.MAX_CAPACITY
                    && (tmpShip.MAX_WEIGHT_counter +tmpCont.brutto_weight ) <= tmpShip.MAX_WEIGHT
            && tmpShip.max_electro_counter +1 <= tmpShip.max_electro)
            {
                tmpShip.MAX_CAPACITY_counter ++;
                tmpShip.MAX_WEIGHT_counter += tmpCont.brutto_weight;
                tmpShip.max_electro_counter ++;


                check = true;
            }
            else
            {
                System.out.println("This will not fit in the " + shipName + " :'-(");
            }
        }

        if(Objects.equals(whichContFromWareHouse(contID).getContainer_type(), "Heavy_Container"))
        {
            if( tmpShip.MAX_CAPACITY_counter + 1 <= tmpShip.MAX_CAPACITY
                    && (tmpShip.MAX_WEIGHT_counter +tmpCont.brutto_weight ) <= tmpShip.MAX_WEIGHT
                    && tmpShip.max_heavy_counter +1 <= tmpShip.max_heavy)
            {
                tmpShip.MAX_CAPACITY_counter ++;
                tmpShip.MAX_WEIGHT_counter += tmpCont.brutto_weight;
                tmpShip.max_heavy_counter ++;

                decreaseContCounter(tmpCont);
                check = true;
            }
            else
            {
                System.out.println("This will not fit in the " + shipName + " :'-(");
            }
        }

        if(Objects.equals(tmpCont.getContainer_type(), "Toxic_Powder_Container")
        || Objects.equals(tmpCont.getContainer_type(), "Toxic_Liquid")
        || Objects.equals(tmpCont.getContainer_type(), "Explosive_Container"))
        {
            if( tmpShip.MAX_CAPACITY_counter + 1 <= tmpShip.MAX_CAPACITY
                    && (tmpShip.MAX_WEIGHT_counter +tmpCont.brutto_weight ) <= tmpShip.MAX_WEIGHT
                    && tmpShip.max_tox_or_exp_counter +1 <= tmpShip.max_tox_or_exp)
            {

                tmpShip.MAX_CAPACITY_counter ++;
                tmpShip.MAX_WEIGHT_counter += tmpCont.brutto_weight;
                tmpShip.max_tox_or_exp_counter ++;

                decreaseContCounter(tmpCont);

                check = true;
            }
            else
            {
                System.out.println("This will not fit in the " + shipName + " :'-(");
            }
        }
        return check;
    }

    public static void decreaseContCounter(Standard_Container tmpCont)
    {
        if(Objects.equals(tmpCont.getContainer_type(), "Toxic_Powder_Container"))
        {
            MaxTP_counter--;
        }
        if(Objects.equals(tmpCont.getContainer_type(), "Toxic_Liquid"))
        {
            MaxTL_counter--;
        }
        if(Objects.equals(tmpCont.getContainer_type(), "Explosive_Container"))
        {
            MaxExp_counter--;
        }
        if(Objects.equals(tmpCont.getContainer_type(), "Refrigerated_Container"))
        {
            MaxElec_counter--;
        }
        if(Objects.equals(tmpCont.getContainer_type(), "Refrigerated_Container"))
        {
            MaxHeavy_counter--;
        }
        if(Objects.equals(tmpCont.getContainer_type(), "Standard Cargo"))
        {
            MaxStandard_counter--;
        }
        if(Objects.equals(tmpCont.getContainer_type(), "Liquid_Container"))
        {
            MaxLiq_counter--;
        }
    }
}

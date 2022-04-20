import java.time.LocalDate;

public class IrresponsibleSenderWithDangerousGoods extends Exception
{
    LocalDate arrivalDate;
    LocalDate expirationDate;

    String secure_info;
    String certificate;

    int brutto_weight;
    int tare_weight;
    int nettoweight;

    int container_ID;

    String container_type;

    public IrresponsibleSenderWithDangerousGoods(String secure_info, String certificate, int brutto_weight, int tare_weight, int nettoweight, int container_ID, String container_type) {

        this.arrivalDate =arrivalDate;
        this.expirationDate = expirationDate;
        this.secure_info = secure_info;
        this.certificate = certificate;
        this.brutto_weight = brutto_weight;
        this.tare_weight = tare_weight;
        this.nettoweight = nettoweight;
        this.container_ID = container_ID;
        this.container_type = container_type;
    }


}

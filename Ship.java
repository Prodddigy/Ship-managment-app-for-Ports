import java.util.Scanner;

public class Ship {

       /*Write an application that will be used to manage the logistics of a seaport in terms of a
transhipment terminal for container ships. The application will be used to unload and load containers
from/to the ship. In case of unloading, the containers can be transferred to the warehouse
or directly to the railway transport carriage.
Each ship has a different capacity and deadweight defined by:
• the maximum number of containers with toxic or explosive cargo that can be loaded within
the ship
• the maximum number of heavy containers
• the maximum number of containers requiring connection to the electricity network
• the maximum number of all containers
• the maximum weight load
Each ship stores basic information about itself (unique identification number assigned automatically
when creating the object, name, home port, transport origin and destination).
In the case of load capacity of containers for toxic and explosive cargo - this value is common
for both types of containers. E.g. if the ship has three places for containers with explosive or
toxic cargo, these places can be loaded respectively by:
• 3 containers with explosive cargo
• 2 containers with explosive cargo and 1 container with toxic cargo
• 1 containers with explosive cargo and 2 container with toxic cargo
• 3 container with toxic cargo
     */

    String name;
    String home_port;
    String transport_origin;
    String destination;

    int MAX_CAPACITY;
    int MAX_WEIGHT;

    int max_tox_or_exp;
    int max_heavy;
    int max_electro;

    private static int ship_ID= 0;

    public Ship()
    {

        this.ship_ID = (int) (Math.random()*9999+1000);

    }//data structures SET


    public static int getShip_ID() {
        return ship_ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHome_port(String home_port) {
        this.home_port = home_port;
    }

    public void setTransport_origin(String transport_origin) {
        this.transport_origin = transport_origin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setMAX_CAPACITY(int MAX_CAPACITY) {
        this.MAX_CAPACITY = MAX_CAPACITY;
    }

    public void setMAX_WEIGHT(int MAX_WEIGHT) {
        this.MAX_WEIGHT = MAX_WEIGHT;
    }

    public void setMax_tox_or_exp(int max_tox_or_exp) {
        this.max_tox_or_exp = max_tox_or_exp;
    }

    public void setMax_heavy(int max_heavy) {
        this.max_heavy = max_heavy;
    }

    public void setMax_electro(int max_electro) {
        this.max_electro = max_electro;
    }

}

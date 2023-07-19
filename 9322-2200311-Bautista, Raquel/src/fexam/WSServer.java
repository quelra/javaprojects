
import javax.xml.ws.Endpoint;
import service.BautistaRaquelLuckyService;
public class WSServer {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/luckyservice",
                new BautistaRaquelLuckyService());
    }
}

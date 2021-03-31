import java.util.List;
import java.util.Optional;

public interface LicitatiiInterface {

    void addUtilizatorBid(Bid bid,Produs produs);
    Optional <Bid> getBidFinalProdus(Produs produs);
    List<Bid> getAllBidsProdus(Produs produs);
    List<Produs> getAllBidsUtilizator(Utilizator user);


}


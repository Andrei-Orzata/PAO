import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Licitatie implements LicitatiiInterface {

    public Licitatie() {
        auction = new ConcurrentHashMap<>();
    }

    private final Map <Produs, List<Bid>> auction;

    public Map<Produs,List<Bid>> getCopyAuction() {
        return new HashMap<>(auction);
    }

    @Override
    public void addUtilizatorBid(Bid bid,Produs produs){
        Objects.requireNonNull(bid);
        Objects.requireNonNull(produs);
        addBidProdus(bid,produs);
    }

    private synchronized void addBidProdus(Bid bid,Produs produs){
        auction.computeIfAbsent(produs,nou -> new ArrayList<>()).add(bid);
    }
    @Override
    public List<Bid> getAllBidsProdus(Produs produs){
        Objects.requireNonNull(produs);
        return auction.getOrDefault(produs,new ArrayList<>());

    }
    @Override
    public Optional <Bid> getBidFinalProdus(Produs produs){
        List<Bid> bids = getAllBidsProdus(produs);
        return bids.isEmpty()? Optional.empty():Optional.of(bids.get(bids.size() - 1));

    }
    @Override
    public List<Produs> getAllBidsUtilizator(Utilizator user){
        return auction.entrySet().stream()
                .filter(entry -> contineUserBid(entry.getValue(), user))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private boolean contineUserBid(List<Bid> bids, Utilizator user) {
        Objects.requireNonNull(user);
        return bids.stream().anyMatch(bid -> bid.isSameUser(user));

    }

}

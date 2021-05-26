import java.util.Objects;


public class Bid {
    private  final Utilizator user;
    private  final int price;

    public Bid(Utilizator user, int price){
        this.user = user;
        this.price = price;
    }
    public Utilizator getUser(){
        return user;
    }
    public int getPrice(){
        return price;
    }
    public boolean isSameUser(Utilizator user) {
        return this.user.equals(user);
    }

    @Override
    public String toString() {
        return String.format("Utilizator: %s || Bid price: %d",user,price);
    }

    @Override
    public boolean equals(Object obj) {
        boolean equals = false;
        if (obj == this) {
            equals = true;
        } else if (obj instanceof Bid) {
            Bid bid = (Bid) obj;
            equals = Objects.equals(user, bid.user) && price == bid.price;
        }
        return equals;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user,price);
    }
}


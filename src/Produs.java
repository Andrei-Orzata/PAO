import java.util.Objects;

public class Produs {
    private final int id;
    private final String nume;

    public Produs(int id, String nume){
        this.id = id;
        this.nume = nume;
    }

    @Override
    public String toString() {
        return String.format("ID: %d || Nume: %s",id,nume);
    }

    @Override
    public boolean equals(Object obj) {
        boolean equals = false;
        if (obj == this) {
            equals = true;
        } else if (obj instanceof Produs) {
            Produs produs  = (Produs) obj;
            equals = Objects.equals(id, produs.id) && Objects.equals(nume, produs.nume);
        }
        return equals;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,nume);
    }
}

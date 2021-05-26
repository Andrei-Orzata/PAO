import java.util.Objects;

public class Utilizator {
    private final String nume;
    private final String prenume;

    public Utilizator(String nume, String prenume) {
        this.nume = nume;
        this.prenume = prenume;
    }

    public String getNume() {
        return nume;
    }
    public String getPrenume()
    {
        return prenume;
    }
    @Override
    public String toString() {
        return String.format("Nume: %s %s", nume,prenume);
    }

    @Override
    public boolean equals(Object obj) {
        boolean equals = false;
        if (obj == this) {
            equals = true;
        } else if (obj instanceof Utilizator) {
            Utilizator user = (Utilizator) obj;
            equals = Objects.equals(nume, user.nume) && Objects.equals(prenume, user.prenume);
        }
        return equals;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume,prenume);
    }
}

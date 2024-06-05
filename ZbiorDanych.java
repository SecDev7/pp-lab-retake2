import java.util.ArrayList;
import java.util.List;

public class ZbiorDanych {
    private List<Double> dane;

    public ZbiorDanych() {
        this.dane = new ArrayList<>();
    }

    public void dodaj(double liczba) {
        dane.add(liczba);
    }

    public void usun(double liczba) {
        dane.remove(liczba);
    }

    public List<Double> getDane() {
        return dane;
    }
}

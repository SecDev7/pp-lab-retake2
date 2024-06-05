import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZarzadzajStatystykami implements Statystyki {
    private List<ZbiorDanych> zbioryDanych;

    public ZarzadzajStatystykami() {
        zbioryDanych = new ArrayList<>();
    }

    public void dodajZbior(ZbiorDanych zbiorDanych) {
        zbioryDanych.add(zbiorDanych);
    }

    public void usunZbior(int index) {
        if (index >= 0 && index < zbioryDanych.size()) {
            zbioryDanych.remove(index);
        } else {
            System.out.println("Niepoprawny indeks.");
        }
    }

    public ZbiorDanych getZbior(int index) {
        if (index >= 0 && index < zbioryDanych.size()) {
            return zbioryDanych.get(index);
        } else {
            System.out.println("Niepoprawny indeks.");
            return null;
        }
    }

    public List<ZbiorDanych> getZbiory() {
        return zbioryDanych;
    }

    @Override
    public double obliczSrednia(ZbiorDanych zbiorDanych) {
        List<Double> dane = zbiorDanych.getDane();
        double suma = 0;
        for (double value : dane) {
            suma += value;
        }
        return suma / dane.size();
    }

    @Override
    public double obliczMediane(ZbiorDanych zbiorDanych) {
        List<Double> dane = new ArrayList<>(zbiorDanych.getDane());
        Collections.sort(dane);
        int rozmiar = dane.size();
        if (rozmiar % 2 == 0) {
            return (dane.get(rozmiar / 2 - 1) + dane.get(rozmiar / 2)) / 2.0;
        } else {
            return dane.get(rozmiar / 2);
        }
    }

    @Override
    public double obliczOdchylenieStandardowe(ZbiorDanych zbiorDanych) {
        double srednia = obliczSrednia(zbiorDanych);
        double suma = 0;
        for (double value : zbiorDanych.getDane()) {
            suma += Math.pow(value - srednia, 2);
        }
        return Math.sqrt(suma / zbiorDanych.getDane().size());
    }

    public double obliczSrednia(int index) {
        ZbiorDanych zbiorDanych = getZbior(index);
        if (zbiorDanych != null) {
            return obliczSrednia(zbiorDanych);
        }
        return Double.NaN;
    }

    public double obliczMediane(int index) {
        ZbiorDanych zbiorDanych = getZbior(index);
        if (zbiorDanych != null) {
            return obliczMediane(zbiorDanych);
        }
        return Double.NaN;
    }

    public double obliczOdchylenieStandardowe(int index) {
        ZbiorDanych zbiorDanych = getZbior(index);
        if (zbiorDanych != null) {
            return obliczOdchylenieStandardowe(zbiorDanych);
        }
        return Double.NaN;
    }
}

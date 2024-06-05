import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ZarzadzajStatystykami manager = new ZarzadzajStatystykami();
        ZbiorDanych zbior1 = new ZbiorDanych();
        zbior1.dodaj(4.5);
        zbior1.dodaj(6.0);
        zbior1.dodaj(3.0);
        manager.dodajZbior(zbior1);

        ZbiorDanych zbior2 = new ZbiorDanych();
        zbior2.dodaj(4.5);
        zbior2.dodaj(5.0);
        zbior2.dodaj(6.0);
        manager.dodajZbior(zbior2);

        ZbiorDanych zbior3 = new ZbiorDanych();
        zbior3.dodaj(7.0);
        zbior3.dodaj(8.0);
        zbior3.dodaj(9.0);
        manager.dodajZbior(zbior3);

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        while (true) {
            System.out.println("Wybierz opcję:");
            System.out.println("1. Dodaj nowy zbiór danych");
            System.out.println("2. Usuń istniejący zbiór danych");
            System.out.println("3. Wyświetl średnią arytmetyczną");
            System.out.println("4. Wyświetl medianę");
            System.out.println("5. Wyświetl odchylenie standardowe");
            System.out.println("6. Dodaj wartość do istniejącego zbioru");
            System.out.println("7. Wyjdź");
            System.out.print("Twój wybór: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    ZbiorDanych newZbior = new ZbiorDanych();
                    System.out.println("Podaj liczby do zbioru danych (pamiętaj podaj je w formie z kropką np. 1.5 i od nowej linii, zakończ wprowadzanie wpisując 'done'):");
                    while (true) {
                        String input = scanner.next();
                        if (input.equals("done")) {
                            break;
                        }
                        try {
                            newZbior.dodaj(Double.parseDouble(input));
                        } catch (NumberFormatException e) {
                            System.out.println("Niepoprawna liczba, spróbuj ponownie.");
                        }
                    }
                    manager.dodajZbior(newZbior);
                    System.out.println("Nowy zbiór danych został dodany.");
                    break;
                case 2:
                    System.out.println("Podaj indeks zbioru danych do usunięcia:");
                    for (int i = 0; i < manager.getZbiory().size(); i++) {
                        System.out.println(i + ". " + manager.getZbiory().get(i).getDane());
                    }
                    int indexToRemove = scanner.nextInt();
                    manager.usunZbior(indexToRemove);
                    System.out.println("Zbiór danych został usunięty.");
                    break;
                case 3:
                    System.out.println("Podaj indeks zbioru danych:");
                    for (int i = 0; i < manager.getZbiory().size(); i++) {
                        System.out.println(i + ". " + manager.getZbiory().get(i).getDane());
                    }
                    int indexForMean = scanner.nextInt();
                    if (manager.getZbior(indexForMean) != null) {
                        System.out.println("Średnia arytmetyczna: " + manager.obliczSrednia(indexForMean));
                    }
                    break;
                case 4:
                    System.out.println("Podaj indeks zbioru danych:");
                    for (int i = 0; i < manager.getZbiory().size(); i++) {
                        System.out.println(i + ". " + manager.getZbiory().get(i).getDane());
                    }
                    int indexForMedian = scanner.nextInt();
                    if (manager.getZbior(indexForMedian) != null) {
                        System.out.println("Mediana: " + manager.obliczMediane(indexForMedian));
                    }
                    break;
                case 5:
                    System.out.println("Podaj indeks zbioru danych:");
                    for (int i = 0; i < manager.getZbiory().size(); i++) {
                        System.out.println(i + ". " + manager.getZbiory().get(i).getDane());
                    }
                    int indexForStdDev = scanner.nextInt();
                    if (manager.getZbior(indexForStdDev) != null) {
                        System.out.println("Odchylenie standardowe: " + manager.obliczOdchylenieStandardowe(indexForStdDev));
                    }
                    break;
                case 6:
                    System.out.println("Podaj indeks zbioru danych, do którego chcesz dodać wartość:");
                    for (int i = 0; i < manager.getZbiory().size(); i++) {
                        System.out.println(i + ". " + manager.getZbiory().get(i).getDane());
                    }
                    int indexToAdd = scanner.nextInt();
                    System.out.println("Podaj wartość do dodania:");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Niepoprawna liczba, spróbuj ponownie.");
                        scanner.next(); 
                    }
                    double valueToAdd = scanner.nextDouble();
                    if (manager.getZbior(indexToAdd) != null) {
                        manager.getZbior(indexToAdd).dodaj(valueToAdd);
                        System.out.println("Wartość została dodana.");
                    }
                    break;
                case 7:
                    scanner.close();
                    System.out.println("Do widzenia!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Niepoprawny wybór, spróbuj ponownie.");
                    break;
            }
        }
    }
}
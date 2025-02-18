//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static List<Eveniment> readEvenimentFromTSV(String filePath) {
        List<Eveniment> Evenimente = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true; // To skip the header line

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Skip the header line
                }

                String[] data = line.split("\t"); // Split the line by tab character

                Eveniment eveniment = new Eveniment();
                eveniment.setId(Integer.parseInt(data[0]));
                eveniment.setHeld(data[1]);
                eveniment.setAntagonist(data[2]);
                eveniment.setKonfrontationsTyp(data[3]);
                eveniment.setOrt(data[4]);
                eveniment.setDatum(data[5]);
                eveniment.setGolbalerEingluss(Double.parseDouble(data[6]));

                Evenimente.add(eveniment);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Evenimente;
    }

    public static Set<String> evenimenteWithGlobalerEinfluss(List<Eveniment> eveniments) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the minimum GE: ");
        double minGE = scanner.nextDouble();
        Set<String> result = new HashSet<>();



        for (Eveniment e : eveniments) {
            double gE = e.getGolbalerEingluss();
            if (gE >= minGE) {
                result.add(e.getHeld());
            }
        }

        return result;
    }

    public static List<String> filteredEventsAfterConfrontation(String konfrontationstyp, List<Eveniment> evenimente){
        List<Eveniment> filteredEvs = new ArrayList<>();

        for (Eveniment eveniment : evenimente) {
            if (eveniment.getKonfrontationsTyp().equals(konfrontationstyp)) {
                filteredEvs.add(eveniment);
            }
        }

        // Sort by date
        filteredEvs.sort(Comparator.comparing(Eveniment::getDatum));
        List<String> result = new ArrayList<>();

        for (Eveniment eveniment : filteredEvs) {
            result.add(eveniment.getDatum() + ": " + eveniment.getHeld() + " vs " + eveniment.getAntagonist() + " - " + eveniment.getOrt());
        }

        return result;
    }

    public static void main(String[] args) {
        String filePath = "E:\\Sem3\\MAP\\RESRusuVictor723Aufgabe1\\src\\marvel_konfrontationen.tsv";
        List<Eveniment> evenimente = readEvenimentFromTSV(filePath);

//        for(Eveniment eveniment: evenimente) {
//            System.out.println(eveniment);
//        }

//        Set<String> evenimenteHeldFiltered = evenimenteWithGlobalerEinfluss(evenimente);
//        for (String s : evenimenteHeldFiltered) {
//            System.out.println(s);
//        }

        List<String>filteredEventsAfterKT = filteredEventsAfterConfrontation("Galaktisch", evenimente);

        for (String s : filteredEventsAfterKT) {
            System.out.println(s);
        }





    }
}
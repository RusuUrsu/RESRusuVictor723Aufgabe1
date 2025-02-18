//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    public static void main(String[] args) {

    }
}
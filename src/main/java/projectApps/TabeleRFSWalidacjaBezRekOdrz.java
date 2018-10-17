package projectApps;

import java.io.*;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.*;

import javax.swing.*;


public class TabeleRFSWalidacjaBezRekOdrz {
    JPanel panel2 = new JPanel();
    //Parametry i zmienne
    int wartoscPoczatkowa = 1;
    int wartoscKoncowa;
    String nazwaPliku;
    String skroconaNazwa;
    String skroconaNazwaProjektu;
    String data = "2018.06.30";


    int numerKolumnyPierwszej=16;
    int numerKolumnyDrugiej=17;
    int numerKolumnyTrzeciej=15;
    int numerKolumnyCzwartej=14;
    /*Standardowy nr kolumny*/
    String inputFile;
    String outputFile;



    //Pozostałe zmienne
    String nazwaPola;
    String nazwaPolaDwa;
    String nazwaPolaTrzy;
    String nazwaPolaCzwartego;
    String nazwaKolejnegoPola;
    int iloscPol = wartoscKoncowa - (wartoscPoczatkowa-1);
    String komunikatPodsumowujący = "Ilość wszystkich pol, dla których zostały wygenerowane Test Casy: " + iloscPol;   /*komunikat podsumowujący*/

    int numer=0;
    int numerDwa=0;
    int numerTrzy=0;
    int numerTymczasowy=0;
    int numerTymczasowyDwa=1;


    String parametr_S = "TABELE EKSPORTOWE";    /**** FILL!!****/

    TabeleRFSWalidacjaBezRekOdrz(String paramsPlikWsadowy, String paramsTrzyliterowySkrot ,  String paramsNazwaDokumentu, String paramsPlanowanaData , String paramsKatalogDocelowy)
    {
        try {
            inputFile = paramsPlikWsadowy;
            nazwaPliku = paramsNazwaDokumentu;
            //wartoscKoncowa =  paramsIloscPol;
            data = paramsPlanowanaData;
            skroconaNazwaProjektu = paramsTrzyliterowySkrot;
            outputFile = paramsKatalogDocelowy + "\\Pliki_RFS_Walidacja_Sum_Kont_Bez_Rek_Odrz_" + nazwaPliku +".xls";


            File src = new File(inputFile);

            FileInputStream fis = new FileInputStream(src);

            Workbook wb= WorkbookFactory.create(new File(inputFile));
            HSSFSheet sh1 = (HSSFSheet) wb.getSheetAt(0);




//            String nazwaPierwszejTabeliLubZakladki = sh1.getRow(1).getCell(params.numerKolumny).getStringCellValue();


            int i;
            int six =6;
            int eight = 8;
            int nine = 9;
            int ten= 10;
            int eleven =11;
            int twelve =12;
            int thirteen =13;
            int seven = 7;
            int three = 3;
            int four =4;
            int five = 5;
            int numer=0;



            //Nagłówki szablonu DMT
            sh1.getRow(0).createCell(4).setCellValue(nazwaPliku);
            sh1.getRow(0).createCell(3).setCellValue(skroconaNazwaProjektu);
            sh1.getRow(0).createCell(5).setCellValue("PORTLAND_TESTERS");
            //sh1.getRow(0).createCell(3).setCellValue(params.nazwaPrzykladowa);

            //S
            sh1.getRow(2).createCell(2).setCellValue("Weryfikacja sum kontrolnych");



            /*****************************Formatting**********************************/


            sh1.setColumnWidth(3,20000);
            sh1.setColumnWidth(2,16000);
            sh1.setColumnWidth(1,2500);


            /*****************************Firnatting*********************************/

            for (i = wartoscPoczatkowa; i <= 10000; i++)
            {

                numer = i;
                numerDwa = numer+1;
                nazwaPola = sh1.getRow(numer).getCell(numerKolumnyPierwszej).getStringCellValue();
                nazwaPolaDwa = sh1.getRow(numer).getCell(numerKolumnyDrugiej).getStringCellValue();
                nazwaPolaTrzy = sh1.getRow(numer).getCell(numerKolumnyTrzeciej).getStringCellValue();
                nazwaPolaCzwartego = sh1.getRow(numer).getCell(numerKolumnyCzwartej).getStringCellValue();
                //       params.nazwaKolejnegoPola = sh1.getRow(params.numerDwa).getCell(params.numerKolumny).getStringCellValue();

                if(nazwaPola.equalsIgnoreCase("Koniec"))
                    break;

                //Z1
                sh1.getRow(three).createCell(1).setCellValue("Z1");
                sh1.getRow(three).createCell(2).setCellValue("Walidacja Sum Kontrolnych bez rekordów odrzuconych");
                sh1.getRow(three).createCell(3).setCellValue(nazwaPliku + " -> "  + "Walidacje Sum Kontrolnych");


                //P1
                sh1.getRow(four).createCell(1).setCellValue("P" + i);
                sh1.getRow(four).createCell(2).setCellValue("Zakładka: " + "Walidacje Sumy Kontrolnych.\n"
                        + "ID walidacji: " + nazwaPolaTrzy);
                sh1.getRow(four).createCell(6).setCellValue("1");
                sh1.getRow(four).createCell(5).setCellValue("T");
                sh1.getRow(four).createCell(7).setCellValue("N");
                sh1.getRow(four).createCell(3).setCellValue
                        ("Suma walidowana poprawnie.\n Wynik Zgodny z wartością w konsoli rekoncyliacji");

                sh1.getRow(four).createCell(4).setCellValue
                        ("1. Ilość rekordów odrzuconych=0\n" +
                                "2. Tester ma dostęp do konsoli rekoncyliacji.\n" +
                                "3. Tester ma dostęp do dokumentu " + nazwaPliku +
                                "4. Tester ma dostęp do bazy danych.\n" +
                                "5. Tester ma wygenerowane sumy kontrolne na podstawie bazy danych i algorytmów w dokumencie " +
                                nazwaPliku);

                sh1.getRow(four).createCell(9).setCellValue(data);


                //Krok 1 [Wiersz 5]
                sh1.getRow(five).createCell(2).setCellValue("Porównaj " + nazwaPola +  " " + nazwaPolaCzwartego + " " + nazwaPolaDwa);

                sh1.getRow(five).createCell(1).setCellValue(1);
                sh1.getRow(five).createCell(3).setCellValue("Warunek porównania spełniony.");
                sh1.getRow(five).createCell(6).setCellValue("1");
                sh1.getRow(five).createCell(7).setCellValue("N");



                //Krok 2 [Wiersz 6]
                sh1.getRow(six).createCell(2).setCellValue("Porównaj wynik z konsolą rekoncyliacji.");
                sh1.getRow(six).createCell(3).setCellValue("Wynik zgodny z wartością w konsoli rekoncylacji.");
                sh1.getRow(six).createCell(6).setCellValue("1");
                sh1.getRow(six).createCell(7).setCellValue("N");
                sh1.getRow(six).createCell(1).setCellValue(2);



                //Krok 3 [Wiersz 7]
                // sh1.getRow(seven).createCell(2).setCellValue("W następnych krokach porównaj zgodność parametrów pola "
                //       + "ze specyfikacją DMT " + params.nazwaPliku);
                //   sh1.getRow(seven).createCell(1).setCellValue("3");
                //   sh1.getRow(seven).createCell(3).setCellValue("BRAK");
                //   sh1.getRow(seven).createCell(6).setCellValue("1");
                //   sh1.getRow(seven).createCell(7).setCellValue("N");




                //Krok 4 [Wiersz 8]
                // sh1.getRow(eight).createCell(2).setCellValue("Zweryfikuj Opis dla " + params.nazwaPola);
                // sh1.getRow(eight).createCell(1).setCellValue("4");
                // sh1.getRow(eight).createCell(3).setCellValue("Wartość jest zgodna z  kolumną 'Description Opis'");
                // sh1.getRow(eight).createCell(6).setCellValue("1");
                // sh1.getRow(eight).createCell(7).setCellValue("N");



                //Krok 5 [Wiersz 9]
                //sh1.getRow(six).createCell(2).setCellValue("Zweryfikuj wymagalność dla " + params.nazwaPola);
                //sh1.getRow(six).createCell(1).setCellValue("2");
                //sh1.getRow(six).createCell(3).setCellValue("Wartość jest zgodna z kolumną  'REQ (Y/N)'");
                // sh1.getRow(six).createCell(6).setCellValue("1");
                // sh1.getRow(six).createCell(7).setCellValue("N");



                //Krok 6 [Wiersz 10]
                //sh1.getRow(seven).createCell(2).setCellValue("Zweryfikuj Maksymalną długość dla " + params.nazwaPola);
                // sh1.getRow(seven).createCell(1).setCellValue("3");
                // sh1.getRow(seven).createCell(3).setCellValue("Wartość jest zgodna z  kolumną 'Max. Len Max. Dług'");
                // sh1.getRow(seven).createCell(6).setCellValue("1");
                // sh1.getRow(seven).createCell(7).setCellValue("N");



                //Krok 7 [Wiersz 11]
                // sh1.getRow(eight).createCell(2).setCellValue("Zweryfikuj Typ danych dla " + params.nazwaPola);
                // sh1.getRow(eight).createCell(1).setCellValue("4");
                //sh1.getRow(eight).createCell(3).setCellValue("Wartość jest zgodna z kolumną 'Type Typ Danych'");
                // sh1.getRow(eight).createCell(6).setCellValue("1");
                // sh1.getRow(eight).createCell(7).setCellValue("N");



                //Krok 8 [Wiersz 12]
                //sh1.getRow(nine).createCell(2).setCellValue("Zweryfikuj Format danych dla " + params.nazwaPola);
                //sh1.getRow(nine).createCell(1).setCellValue("5");
                // sh1.getRow(nine).createCell(3).setCellValue("Wartość jest zgodna z kolumną 'Format Danych'");
                // sh1.getRow(nine).createCell(6).setCellValue("1");
                //sh1.getRow(nine).createCell(7).setCellValue("N");



                //Krok 9 [Wiersz 13]
                //  sh1.getRow(ten).createCell(2).setCellValue("Zweryfikuj dostępność wartości Słowni kowych dla  " + params.nazwaPola);
                //  sh1.getRow(ten).createCell(1).setCellValue("6");
                //  sh1.getRow(ten).createCell(3).setCellValue("Wartość jest zgodna z kolumną Wartości zgodne ze słownikiem' (nazwa słownika lub N/D)");
                // sh1.getRow(ten).createCell(6).setCellValue("1");
                //  sh1.getRow(ten).createCell(7).setCellValue("N");
                //

/*
                if (params.nazwaKolejnegoPola.length() > 3)
                {

                    params.numerTrzy = (numer*7)+4+params.numerTymczasowy;

                    System.out.println("nr" + params.numerTrzy);
                    System.out.println(params.nazwaKolejnegoPola);

                    sh1.getRow(params.numerTrzy).createCell(2).setCellValue("Tabela/plik " + params.nazwaKolejnegoPola );
                    sh1.getRow(params.numerTrzy).createCell(1).setCellValue("Z"+ (params.numerTymczasowyDwa+1));
                    sh1.getRow(params.numerTrzy).createCell(3).setCellValue(params.nazwaPliku + " -> "  +"Struktura " + params.parametr_S);


                    five++;
                    thirteen++;
                    twelve++;
                    eleven++;
                    ten++;
                    nine++;
                    eight++;
                    six++;
                    seven++;
                    four++;
                    params.numerTymczasowy++;
                    params.numerTymczasowyDwa++;
                }

*/
                five += 3;
                thirteen += 3;
                twelve += 3;
                eleven += 3;
                ten += 3;
                nine += 3;
                eight += 3;
                six += 3;
                seven += 3;
                four += 3;

                FileOutputStream fout = new FileOutputStream(outputFile);

                wb.write(fout);
                fout.close();

            }
            System.out.println(komunikatPodsumowujący);


        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog( panel2,"Wystąpił BŁĄD! Plik nie został " +
                    "wygenerowany poprawnie. Inny proces korzysta z pliku wsadowego lub docelowego. Zamknij pliki i spróbuj ponownie. ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }

    }
}
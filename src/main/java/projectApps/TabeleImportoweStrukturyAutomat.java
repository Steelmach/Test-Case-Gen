package projectApps;

import java.awt.*;
import java.io.*;

import net.bytebuddy.description.modifier.ParameterManifestation;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;


public class TabeleImportoweStrukturyAutomat {

    JPanel panel2 = new JPanel();

    //Parametry i zmienne
    int wartoscPoczatkowa = 1;        /*Pierwsze pole listy*/

    int wartoscKoncowa;
    String nazwaPliku;
    String skroconaNazwa;
    String skroconaNazwaProjektu;
    String data;


    int numerKolumnyPierwszej = 14;    /*Standardowy nr kolumny*/
    int numerKolumny = 15;             /*Standardowy nr kolumny*/
    String inputFile;                  //"C:\\Users\\Dell\\Documents\\Automation Test Portland\\wsadTabImport.xlsx";
    String outputFile;                //"C:\\Users\\Dell\\Documents\\Automation Test Portland\\" +
                     //"Struktury w Systemie Źródłowym - tabele eksportowe\\Tabele importowe_" + skroconaNazwa + ".xlsx";


    //Pozostałe zmienne
    String nazwaPola;
    String nazwaKolejnegoPola;
    int iloscPol = wartoscKoncowa - (wartoscPoczatkowa - 1);
    String komunikatPodsumowujący = "Ilość wszystkich pol, dla których zostały wygenerowane Test Casy: " + iloscPol;

    int numer=0;
    int numerDwa = 0;
    int numerTrzy = 0;
    int numerTymczasowy = 0;
    int numerTymczasowyDwa = 1;


    String parametr_S = "TABELE IMPORTOWE";

    /**
     * Przykładowe wartości
     * 1. TABELE EKSPORTOWE
     * 2. TABELE IMPORTOWE
     **/




    TabeleImportoweStrukturyAutomat(String paramsPlikWsadowy, String paramsTrzyliterowySkrot,
                                    String paramsNazwaDokumentu, String paramsPlanowanaData, String paramsKatalogDocelowy)
    {
        try {

            inputFile = paramsPlikWsadowy;
            nazwaPliku = paramsNazwaDokumentu;
            //wartoscKoncowa =  paramsIloscPol;
            data = paramsPlanowanaData;
            skroconaNazwaProjektu = paramsTrzyliterowySkrot;
            outputFile = paramsKatalogDocelowy + "\\Tabele_Importowe_Struktury_" + nazwaPliku +".xls";



            File src = new File(inputFile);
            FileInputStream fis = new FileInputStream(src);

            Workbook wb= WorkbookFactory.create(new File(inputFile));
            HSSFSheet sh1 = (HSSFSheet) wb.getSheetAt(0);



            String nazwaPierwszejTabeliLubZakladki = sh1.getRow(1).getCell(numerKolumny).getStringCellValue();

            int i;
            int six = 6;
            int eight = 8;
            int nine = 9;
            int ten = 10;
            int eleven = 11;
            int twelve = 12;
            int thirteen = 13;
            int seven = 7;
            int three = 3;
            int four = 4;
            int five = 5;

            numer=0;


            sh1.setColumnWidth(3, 20000);
            sh1.setColumnWidth(2, 16000);
            sh1.setColumnWidth(1, 2500);


            //Nagłówki szablonu DMT
            sh1.getRow(0).createCell(4).setCellValue(nazwaPliku);
            sh1.getRow(0).createCell(3).setCellValue(skroconaNazwaProjektu);
            sh1.getRow(0).createCell(5).setCellValue("PORTLAND_TESTERS");
            //S
            sh1.getRow(2).createCell(2).setCellValue(parametr_S + " - weryfikacja struktur");


            for (i = wartoscPoczatkowa; i <= 10000; i++) {

                numer = i;
                numerDwa = numer + 1;
                nazwaPola = sh1.getRow(numer).getCell(numerKolumnyPierwszej).getStringCellValue();
                nazwaKolejnegoPola = sh1.getRow(numerDwa).getCell(numerKolumny).getStringCellValue();



                if(nazwaPola.equalsIgnoreCase("Koniec") )
                    break;

                //Z1
                sh1.getRow(3).createCell(2).setCellValue("Zakładka " + nazwaPierwszejTabeliLubZakladki);
                sh1.getRow(3).createCell(1).setCellValue("Z1");
                sh1.getRow(3).createCell(3).setCellValue(nazwaPliku + " -> " + nazwaPierwszejTabeliLubZakladki + " ->   Struktura " + parametr_S);


                //P1
                sh1.getRow(four).createCell(2).setCellValue("Weryfikacja struktur dla pola " + nazwaPola);
                sh1.getRow(four).createCell(1).setCellValue("P" + i);
                sh1.getRow(four).createCell(6).setCellValue("1");
                sh1.getRow(four).createCell(5).setCellValue("T");
                sh1.getRow(four).createCell(7).setCellValue("N");
                sh1.getRow(four).createCell(3).setCellValue
                        ("Struktury pól w Tabelach Importowych są zgodne ze specyfikacją:  " + nazwaPliku);

                sh1.getRow(four).createCell(4).setCellValue
                        ("1. Użytkownik ma dostęp do przekonwertowanych danych\n" +
                                "2. Użytkownik ma dostęp do dokumentu: " + nazwaPliku);
                sh1.getRow(four).createCell(9).setCellValue(data);

                //Krok 1 [Wiersz 5]
                // sh1.getRow(five).createCell(2).setCellValue("Sprawdź checksumy w konsoli rekoncyliacji");
                // sh1.getRow(five).createCell(1).setCellValue("1");
                // sh1.getRow(five).createCell(3).setCellValue("Checksumy OK");
                // sh1.getRow(five).createCell(6).setCellValue("1");
                //sh1.getRow(five).createCell(7).setCellValue("N");


                //Krok 2 [Wiersz 6]
                sh1.getRow(five).createCell(2).setCellValue("Zapytanie SQL wywołujące pole " + nazwaPola);
                sh1.getRow(five).createCell(1).setCellValue(1);
                sh1.getRow(five).createCell(3).setCellValue("Dane pojawiają się");
                sh1.getRow(five).createCell(7).setCellValue("N");


                // Krok 3 [Wiesz 7]
                // sh1.getRow(seven).createCell(2).setCellValue("W następnych krokach porównaj zgodność parametrów pola " +
                //       "ze specyfikacją DMT" + params.nazwaPliku);
                // sh1.getRow(seven).createCell(1).setCellValue("3");
                // sh1.getRow(seven).createCell(3).setCellValue("BRAK");
                // sh1.getRow(seven).createCell(6).setCellValue("1");
                //  sh1.getRow(seven).createCell(7).setCellValue("N");


                //Krok 4 {Wiersz 8]
                // sh1.getRow(eight).createCell(2).setCellValue("Zweryfikuj Opis dla " + params.nazwaPola);
                // sh1.getRow(eight).createCell(1).setCellValue("4");
                // sh1.getRow(eight).createCell(3).setCellValue("Wartość jest zgodna z  kolumną 'Description Opis'");
                // sh1.getRow(eight).createCell(6).setCellValue("1");
                //  sh1.getRow(eight).createCell(7).setCellValue("N");


                //Krok 5 [Wiersz 9]
                sh1.getRow(six).createCell(2).setCellValue("Zweryfikuj wymagalność dla " + nazwaPola);
                sh1.getRow(six).createCell(1).setCellValue(2);
                sh1.getRow(six).createCell(3).setCellValue("Wartość jest zgodna z kolumną  'REQ (Y/N)'");
                sh1.getRow(six).createCell(7).setCellValue("N");


                //Krok 6 [Wiersz 10]
                sh1.getRow(seven).createCell(2).setCellValue("Zweryfikuj Maksymalną długość dla " + nazwaPola);
                sh1.getRow(seven).createCell(1).setCellValue(3);
                sh1.getRow(seven).createCell(3).setCellValue("Wartość jest zgodna z  kolumną 'Max. Len Max. Dług'");
                sh1.getRow(seven).createCell(7).setCellValue("N");


                //Krok 7 [Wiersz 11]
                sh1.getRow(eight).createCell(2).setCellValue("Zweryfikuj Typ danych dla " + nazwaPola);
                sh1.getRow(eight).createCell(1).setCellValue(4);
                sh1.getRow(eight).createCell(3).setCellValue("Wartość jest zgodna z kolumną 'Type Typ Danych'");
                sh1.getRow(eight).createCell(7).setCellValue("N");


                //Krok 8 [Wiersz 12]
                sh1.getRow(nine).createCell(2).setCellValue("Zweryfikuj Format danych dla " + nazwaPola);
                sh1.getRow(nine).createCell(1).setCellValue(5);
                sh1.getRow(nine).createCell(3).setCellValue("Wartość jest zgodna z kolumną 'Format Danych'");
                sh1.getRow(nine).createCell(7).setCellValue("N");


                //Krok 9 [Wiersz 13]
                sh1.getRow(ten).createCell(2).setCellValue("Zweryfikuj dostępność wartości Słownikowych dla  " + nazwaPola);
                sh1.getRow(ten).createCell(1).setCellValue(6);
                sh1.getRow(ten).createCell(3).setCellValue("Wartość jest zgodna z kolumną Wartości zgodne ze słownikiem' (nazwa słownika lub N/D)");
                sh1.getRow(ten).createCell(7).setCellValue("N");
                //


                if (nazwaKolejnegoPola.length() > 2) {

                    numerTrzy = (numer * 7) + 4 + numerTymczasowy;

                    System.out.println("nr" + numerTrzy);
                    System.out.println(nazwaKolejnegoPola);

                    sh1.getRow(numerTrzy).createCell(2).setCellValue("Tabela/plik " + nazwaKolejnegoPola);
                    sh1.getRow(numerTrzy).createCell(1).setCellValue("Z" + (numerTymczasowyDwa++));
                    sh1.getRow(numerTrzy).createCell(3).setCellValue(nazwaPliku + " -> " + "Struktura " + parametr_S);

                    three++;
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
                    numerTymczasowy++;
                    numerTymczasowyDwa++;
                }


                five += 7;
                thirteen += 7;
                twelve += 7;
                eleven += 7;
                ten += 7;
                nine += 7;
                eight += 7;
                six += 7;
                seven += 7;
                four += 7;



                FileOutputStream fout = new FileOutputStream(outputFile);

                wb.write(fout);
                fout.close();

            }
            System.out.println(komunikatPodsumowujący);


        } catch (FileNotFoundException e) {

            JOptionPane.showMessageDialog(panel2,"Wystąpił BŁĄD! Plik nie został " +
                    "wygenerowany poprawnie. Inny proces korzysta z pliku wsadowego lub docelowego. Zamknij pliki i spróbuj ponownie. ");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }

    }
}

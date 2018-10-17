package projectApps;

import java.io.*;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;

public class TabeleImportoweRegulyAutomat {

    JPanel panel2 = new JPanel();


    //Parametry i zmienne
    int wartoscPoczatkowa = 1;

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


    TabeleImportoweRegulyAutomat(String paramsPlikWsadowy, String paramsTrzyliterowySkrot , String paramsNazwaDokumentu, String paramsPlanowanaData ,String paramsKatalogDocelowy)
    {

        try {

            inputFile = paramsPlikWsadowy;
            nazwaPliku = paramsNazwaDokumentu;
           // wartoscKoncowa =  paramsIloscPol;
            data = paramsPlanowanaData;
            skroconaNazwaProjektu = paramsTrzyliterowySkrot;
            outputFile = paramsKatalogDocelowy + "\\Tabele_Importowe_Reguly_" + nazwaPliku +".xls";



            File src = new File(inputFile);
            FileInputStream fis = new FileInputStream(src);


            Workbook wb= WorkbookFactory.create(new File(inputFile));
            HSSFSheet sh1 = (HSSFSheet) wb.getSheetAt(0);


            String nazwaPierwszejTabeliLubZakladki = sh1.getRow(1).getCell(numerKolumny).getStringCellValue();

            int i;
            int six =6;
            int seven = 7;
            int three = 3;
            int four =4;
            int five = 5;

            numer=0;

            sh1.setColumnWidth(3,20000);
            sh1.setColumnWidth(2,16000);
            sh1.setColumnWidth(1,2500);

            //Nagłówki szablonu DMT
            sh1.getRow(0).createCell(4).setCellValue(nazwaPliku);
            sh1.getRow(0).createCell(3).setCellValue(skroconaNazwaProjektu);
            sh1.getRow(0).createCell(5).setCellValue("PORTLAND_TESTERS");

            //S
            sh1.getRow(2).createCell(2).setCellValue(parametr_S + " - weryfikacja reguł mapowania");

            for (i = wartoscPoczatkowa; i <= 10000; i++)
            {

                numer = i;
                numerDwa = numer+1;
                nazwaPola = sh1.getRow(numer).getCell(numerKolumnyPierwszej).getStringCellValue();
                nazwaKolejnegoPola = sh1.getRow(numerDwa).getCell(numerKolumny).getStringCellValue();

                if(nazwaPola.equalsIgnoreCase("Koniec") )
                    break;

                //Z1
                sh1.getRow(3).createCell(2).setCellValue("Zakładka " + nazwaPierwszejTabeliLubZakladki );
                sh1.getRow(3).createCell(1).setCellValue("Z1" );
                sh1.getRow(3).createCell(3).setCellValue(nazwaPliku + " -> " + nazwaPierwszejTabeliLubZakladki + " -> " +
                        " Struktury importowe w Systemie Docelowym");



                //P1
                sh1.getRow(four).createCell(2).setCellValue("Weryfikacja mapowania dla pola " + nazwaPola);
                sh1.getRow(four).createCell(1).setCellValue("P" + i);
                sh1.getRow(four).createCell(6).setCellValue("1");
                sh1.getRow(four).createCell(5).setCellValue("T");
                sh1.getRow(four).createCell(7).setCellValue("N");
                sh1.getRow(four).createCell(3).setCellValue
                        ("Weryfikacja czy Pola w Strukturach Importowych zostały przekonwertowane  z regułami konwersji" +
                                " w specyfikacji " + nazwaPliku + " Struktury Importowe w Systemie Docelowym");

                sh1.getRow(four).createCell(4).setCellValue
                        ("1. Użytkownik ma dostęp do przekonwertowanych danych\n" +
                                "2. Użytkownik ma dostęp do dokumentu: " + nazwaPliku);

                sh1.getRow(four).createCell(9).setCellValue(data);




                //Krok 1 [Wiersz 5]
                // sh1.getRow(five).createCell(2).setCellValue("Sprawdź checksumy w konsoli rekoncyliacji");
                //  sh1.getRow(five).createCell(1).setCellValue("1");
                // sh1.getRow(five).createCell(3).setCellValue("Checksumy OK");
                // sh1.getRow(five).createCell(6).setCellValue("1");
                //sh1.getRow(five).createCell(7).setCellValue("N");



                //Krok 2  [Wiersz 6]
                sh1.getRow(five).createCell(2).setCellValue("Sprawdź ścieżkę pozytywną SQL porównując wartości  pola: " + nazwaPola +
                        " z regułami konwersji w specyfikacji DMT w Struktury Importowe w Systemie Docelowym");

                sh1.getRow(five).createCell(1).setCellValue(1);
                sh1.getRow(five).createCell(3).setCellValue("Wynik zgodny ze specyfikacją");
                sh1.getRow(five).createCell(6).setCellValue("1");
                sh1.getRow(five).createCell(7).setCellValue("N");




                //Krok 3  [Wiersz 7]
                sh1.getRow(six).createCell(2).setCellValue("Sprawdź ścieżkę negatywną SQL wywołując wartości: " + nazwaPola +
                        " inne niż okreslone w regułach konwersji w specyfikacji DMT w Struktury Importowe w Systemie Docelowym");
                sh1.getRow(six).createCell(1).setCellValue(2);
                sh1.getRow(six).createCell(3).setCellValue("Lista reguł pusta");
                sh1.getRow(six).createCell(6).setCellValue("1");
                sh1.getRow(six).createCell(7).setCellValue("N");


                if (nazwaKolejnegoPola.length() > 2)
                {

                    numerTrzy = (numer*3)+4+numerTymczasowy;

                    System.out.println("nr" + numerTrzy);
                    System.out.println(nazwaKolejnegoPola);

                    sh1.getRow(numerTrzy).createCell(2).setCellValue("Tabela/plik " + nazwaKolejnegoPola );
                    sh1.getRow(numerTrzy).createCell(1).setCellValue("Z"+ (numerTymczasowyDwa+1));
                    sh1.getRow(numerTrzy).createCell(3).setCellValue(nazwaPliku + " -> "  +"Struktura " + parametr_S);

                    three++;
                    five++;
                    six++;
                    seven++;
                    four++;
                    numerTymczasowy++;
                    numerTymczasowyDwa++;
                }


                three += 3;
                four += 3;
                five += 3;
                six += 3;
                seven += 3;





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
        }
        catch (NullPointerException e) {
            e.printStackTrace();
          //  JOptionPane.showMessageDialog(MainActivity.panel2, "Sprawdz kolumny!");
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }

    }
}

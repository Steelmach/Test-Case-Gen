package projectApps;

import java.awt.*;

/**
 * Created by Tomasz on 27.06.2018.
 */
public class Location {

                                    /****************LoginWindow*****************/
    GridBagConstraints locationLabelNameApplication = new GridBagConstraints();
    GridBagConstraints locationLabelNameSubtitle = new GridBagConstraints();
    GridBagConstraints locationLabelLogin = new GridBagConstraints();
    GridBagConstraints locationLabelPassword = new GridBagConstraints();
    GridBagConstraints locationFieldLogin = new GridBagConstraints();
    GridBagConstraints locationFieldPassword = new GridBagConstraints();
    GridBagConstraints locationButtonLogin = new GridBagConstraints();
    GridBagConstraints locationButtonReset = new GridBagConstraints();
    GridBagConstraints locationAppVersion = new GridBagConstraints();
    GridBagConstraints locationCopyRight = new GridBagConstraints();
    GridBagConstraints locationLabelMessageLoginFiled = new GridBagConstraints();
    GridBagConstraints locationImageFlagEngland = new GridBagConstraints();
    GridBagConstraints locationImageFlagPoland = new GridBagConstraints();

    GridBagConstraints locationImageFlagEnglandMainActivity = new GridBagConstraints();
    GridBagConstraints locationImageFlagPolandMainActivity = new GridBagConstraints();

                                /*********************MainActivity*****************/

    //Field 1
    GridBagConstraints gbcLabelTemplate = new GridBagConstraints();
    GridBagConstraints gbcTemplateList = new GridBagConstraints();

    //Field 2
    GridBagConstraints gbcLabelBatchFile = new GridBagConstraints();
    GridBagConstraints gbcButtondBatchFile = new GridBagConstraints();


    //Field 3
    GridBagConstraints gbcLabelDocName = new GridBagConstraints();
    GridBagConstraints gbcFieldDocName = new GridBagConstraints();



    //Field 5
    GridBagConstraints gbcLabelFinishDate = new GridBagConstraints();
    GridBagConstraints gbcFieldFinishDate = new GridBagConstraints();

    //Field6
    GridBagConstraints gbcLabelShortNameTeam = new GridBagConstraints();
    GridBagConstraints gbcFieldShortNameTeam = new GridBagConstraints();

    //Field7
    GridBagConstraints gbcLabelFileEndPath = new GridBagConstraints();
    GridBagConstraints gbcButtonFileEndPath = new GridBagConstraints();

    GridBagConstraints gbcButtonWyczysc= new GridBagConstraints();

    GridBagConstraints gbcFieldBatchFile = new GridBagConstraints();
    GridBagConstraints gbcFieldEndFile = new GridBagConstraints();

    GridBagConstraints gbcSeparatorFirst = new GridBagConstraints();
    GridBagConstraints gbcSeparatorTwice = new GridBagConstraints();

    //Field 8
    GridBagConstraints gbcLabelTemplateDescription = new GridBagConstraints();

    //Field 9
    GridBagConstraints gbcTabeleEksportoweStruktury = new GridBagConstraints();

    //Field 10
    GridBagConstraints gbcTabeleImportoweStruktury = new GridBagConstraints();

    //Field 11
    GridBagConstraints gbcTabeleImportoweReguly = new GridBagConstraints();

    //Field 12
    GridBagConstraints gbcPlikiOrin = new GridBagConstraints();

    //Field 13
    GridBagConstraints gbcRFSFieldToField = new GridBagConstraints();

    //Field 14
    GridBagConstraints gbcRFSSumyKontrolne = new GridBagConstraints();

    //Field 15
    GridBagConstraints gbcRFSWalidacjaBez = new GridBagConstraints();

    //Field 16
    GridBagConstraints gbcRFSWalidacjaZ= new GridBagConstraints();

    //Field 17 - Generate
    GridBagConstraints gbcGenerate= new GridBagConstraints();



    GridBagConstraints locationAppVersionMain = new GridBagConstraints();
    GridBagConstraints locationCopyRightMain = new GridBagConstraints();



    /**************************************************************************/

    GridBagConstraints gbcLabelQuestionMarkBatchFile= new GridBagConstraints();
    GridBagConstraints gbcLabelQuestionMarkNameDoc= new GridBagConstraints();
    GridBagConstraints gbcLabelMarkEndDateTest = new GridBagConstraints();
    GridBagConstraints gbcLabelMarkShortName = new GridBagConstraints();
    GridBagConstraints gbcLabelMarkEndFile = new GridBagConstraints();




    public Location(){
                                  /*****************LoginWindow*********************/
        locationLabelNameApplication.insets =   new Insets(-450,100,0,0);
        locationLabelNameSubtitle.insets =      new Insets(-220,-450,0,0);
        locationLabelLogin.insets =             new Insets(-100,-900,0,0);
        locationLabelPassword.insets =          new Insets(0,-900,0,0);
        locationFieldLogin.insets =             new Insets(-100,-400,0,0);
        locationFieldPassword.insets =          new Insets(0,-400,0,0);
        locationButtonLogin.insets =            new Insets(100,-620,0,0);
        locationButtonReset.insets =            new Insets(100,-180,0,0);
        locationAppVersion.insets =             new Insets(650,180,0,-450);
        locationCopyRight.insets =              new Insets(650,-1400,0,0);
        locationLabelMessageLoginFiled.insets = new Insets(200,-410,0,0);
        locationImageFlagPoland.insets =       new Insets(-640,-1690,0,0);
        locationImageFlagEngland.insets =       new Insets(-640,-1630,0,0);
        locationImageFlagPolandMainActivity.insets =       new Insets(-670,-2150,0,0);
        locationImageFlagEnglandMainActivity.insets =       new Insets(-670,-2090,0,0);



                                /***************MainActivity*****************/

        //Field 1 - label and field
        gbcLabelTemplate.insets =               new Insets(-640,400,0,0);
        gbcTemplateList.insets =                new Insets(-550,-300,0,0);

        //Separator First
        gbcSeparatorFirst.insets =              new Insets(-480,-700,0,0);
        gbcSeparatorTwice.insets =              new Insets(330,-900,0,0);
                        //Field 2 - label and field
        gbcLabelBatchFile.insets =              new Insets(-350,-1230,0,0);
        gbcButtondBatchFile.insets =            new Insets(-350,-410,0,0);
        gbcFieldBatchFile.insets =              new Insets(-350,-800,0,0);
        gbcLabelQuestionMarkBatchFile.insets =  new Insets(-350,-1070,0,0);


        //Field 3 - label and field
        gbcLabelDocName.insets =                new Insets(-210,-1390,2,0);
        gbcFieldDocName.insets =                new Insets(-210,-800,2,0);
        gbcLabelQuestionMarkNameDoc.insets =    new Insets(-210,-1070,2,0);


        //Field 5 - label and field
        gbcLabelFinishDate.insets =             new Insets(-60,-1360,0,0);
        gbcFieldFinishDate.insets =             new Insets(-60,-800,0,0);
        gbcLabelMarkEndDateTest.insets =        new Insets(-60,-1070,0,0);

        //Field 6 - label and field
        gbcLabelShortNameTeam.insets =          new Insets(90,-1290,0,0);
        gbcFieldShortNameTeam.insets =          new Insets(90,-800,0,0);
        gbcLabelMarkShortName.insets =          new Insets(90,-1070,0,0);


        //Field 7 - label and field
        gbcLabelFileEndPath.insets =            new Insets(240,-1330,0,0);
        gbcButtonFileEndPath.insets =           new Insets(240,-410,0,0);
        gbcFieldEndFile.insets =                new Insets(240,-800,0,0);
        gbcLabelMarkEndFile.insets =            new Insets(240,-1070,0,0);

        //Field 17 - Generate
        gbcGenerate.insets =                    new Insets(430,-800,0,0);
        //gbcButtonWyczysc.insets =               new Insets(400,-570,2,0);

        //Common information
        locationAppVersionMain.insets =             new Insets(-670,0,0,-50);
        locationCopyRightMain.insets =              new Insets(530,-1830,0,0);


        //Field 8 - label
        gbcLabelTemplateDescription.insets =    new Insets(-350,0,2,-500);

        //Field 9 - field
        gbcTabeleEksportoweStruktury.insets =   new Insets(-250,0,2,-500);
        //Field 10 - field
        gbcTabeleImportoweStruktury.insets =    new Insets(-180,-240,2,-740);
        //Field 11 - field
        gbcTabeleImportoweReguly.insets =       new Insets(-110,0,2,-500);
        //Field 12 - field
        gbcPlikiOrin.insets =                   new Insets(-40,0,2,-500);
        //Field 13 - field
        gbcRFSFieldToField.insets =             new Insets(30,0,2,-500);
        //Field 14 - field
        gbcRFSSumyKontrolne.insets =            new Insets(100,0,2,-500);
        //Field 15 - field
        gbcRFSWalidacjaBez.insets =             new Insets(170,0,2,-500);
        //Field 16 - field
        gbcRFSWalidacjaZ.insets =               new Insets(240,0,2,-500);





    }

}

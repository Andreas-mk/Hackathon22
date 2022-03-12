/* Stein - Saks - Papir og TIC TAC TOE
   To veldig enkle spill, 
   AMK - MARS 22
*/

import static java.lang.System.*;
import static javax.swing.JOptionPane.*;
import static java.lang.Math.*;
import static java.lang.Integer.*;
import java.util.*;


public class Hackathon22 extends EasyGraphics {

  public static void main(String[] args) {
    launch(args);
  }

  public void run() {


    // Lager vinduet med fast størrelse
    final int VINDU = 500;
      setFont("Arial", 24);
    makeWindow("EG SPILL", VINDU, VINDU);

    String txt = "Hvilket spill vil du spille" + "\n" + "[1] Stein, Saks, Papir" + "\n" + "[2] Tic, Tac, Toe";
    int hvilkeSpill = lesHeltall(1,2, txt);

    if (hvilkeSpill == 1){

    // Setter navn på spillerne
    int mangeSpillere = lesHeltall(1,2, "Hvor mange skal spille?");
    String spiller1 = showInputDialog("Hvem er spiller 1");
    String spiller2 = "";

      if(mangeSpillere == 2)
        spiller2 = showInputDialog("Hvem er spiller 2?");
      else
        spiller2 = "Computer";
    // Skriver navnet på spilleren i toppen
    drawString("" + spiller1, VINDU/20, 30);
    drawString("" + spiller2, VINDU - 130, 30);

    int trekk1 = 0;
    int trekk2 = 0;
    int p1 = 0;
    int p2 = 0;
    boolean vinner = true;


    String utføring1 = "";
    String utføring2 = "";

    //Gjennomfører spillet
    do{
      boolean ok = false;
      // Resetter brettet
      setColor(255,255,255);
      // Setter en pause så vi ser utfallet
      pause(1250);
      fillRectangle(0,100, VINDU, VINDU);

      // Setter farge tilbake til svart
      setColor(0,0,0);
      // Velger hva som spilles - Med krav om fra 1 til 3
      do{
      trekk1 = parseInt(getText("Spiller 1 |" +  "Stein[1] - Saks[2] - Papir[3]"));
      if (trekk1 < 0 || trekk1 >3){
        ok = true;
        showMessageDialog(null, "Ugyldig trekk!");
      }
      else
        ok = false;
    }while(ok);
      // teksten for hva som velges
      switch (trekk1){
        case 1: utføring1 = "STEIN";   break;
        case 2: utføring1 = "SAKS";    break;
        case 3: utføring1 = "PAPIR";   break;
      }
      // Skriver hva spiller 1 valgte
      setFont("Arial", 24);
      // spiller 2 velger hva som spilles
      if(mangeSpillere == 2)
        do{
          trekk2 = parseInt(getText("Spiller 2 |" + "Stein[1] - Saks[2] - Papir[3]"));
          if (trekk2 < 0 || trekk2 >3){
            ok = true;
            showMessageDialog(null, "Ugyldig trekk!");
        }
      
          else
            ok = false;
        }while(ok);
      else
        trekk2 = trekkTall(1,3);

      switch (trekk2){
        case 1: utføring2 = "STEIN";   break;
        case 2: utføring2 = "SAKS";    break;
        case 3: utføring2 = "PAPIR";   break;
      }
      // Skriver ut hva spiller to velger
      setColor(0,0,0);
      drawString("" + utføring1, VINDU/20, VINDU/2);
      drawString("" + utføring2, VINDU-100, VINDU/2);


      // håndtering om hvem som vinner runden
      if (trekk1 == 1 && trekk2 == 2)
        p1++;
      if (trekk1 == 2 && trekk2 == 1)
        p2++;
      if (trekk1 == 1 && trekk2 == 3)
        p2++;
      if (trekk1 == 3 && trekk2 == 1)
        p1++;
      if (trekk1 == 3 && trekk2 == 2)
        p2++;
      if (trekk1 == 2 && trekk2 == 3)
        p1++;


      // Finner ut når vi har funnet en vinner
      if (p1 == 3)
        vinner = false;
      if (p2 == 3)
        vinner = false;





      //  Skriver ut poengsum på begge spillerne
      drawString("" + p1, 10, VINDU-100);
      drawString("" + p2, VINDU-100, VINDU-100);




    }while (vinner);




    if (p1 == 3)
      showMessageDialog(null, "VINNER" +"\n" + spiller1);
    if (p2 == 3)
      showMessageDialog(null, "Vinner" + "\n" + spiller2);



  }else{

  out.println("HER KOMMER NESTE SPILL!!");

  int play2 = lesHeltall(1,2, "Hvor mange skal spille?");

   int i =1;
      int x = VINDU/20;
      int flytt = 1;
      // Lager brettet
    while (i != 4){
      drawRectangle(x*flytt, VINDU/35, VINDU/4, VINDU/4);
      drawRectangle(x*flytt, VINDU/3, VINDU/4, VINDU/4);
      drawRectangle(x*flytt, VINDU-180, VINDU/4, VINDU/4);
      flytt += 5;
      i++;
    }

    int r = VINDU/12;

    // En spiller setter inn et tall fra 1-9 som settes opp med 123 er første rad og 456 er neste osv.

    int ferdig = 0;
    boolean vinner = false;
    int trekkS1 = 0;
    int s2 = 0;
    int [] spillet = new int [9];

    for (int l = 0; l<spillet.length; l++)
      spillet[l] = l;

    spillet[1] = 11;


      fillCircle(VINDU - 50, 30,r/2);
      setFont("Arial",12);
      drawString("" + "Spiller 1",VINDU - 70, 100);

      setColor(255,0,0);
      fillCircle(VINDU - 50, VINDU - 50,r/2);
      setFont("Arial",12);
      drawString("" + "Spiller 2",VINDU - 70, VINDU - 100);





    do{

    int s1 = parseInt(getText("Spiller 1"));


      setColor(0,0,0);
      switch (s1){
        case 1: fillCircle(x*3,x*3,r);   spillet [0] = 1;     break;
        case 2: fillCircle(x*8,x*3,r);   spillet [1] = 1;     break;
        case 3: fillCircle(x*13,x*3,r);  spillet [2] = 1;     break;
        case 4: fillCircle(x*3,x*9,r);   spillet [3] = 1;     break;
        case 5: fillCircle(x*8,x*9,r);   spillet [4] = 1;     break;
        case 6: fillCircle(x*13,x*9,r);  spillet [5] = 1;     break;
        case 7: fillCircle(x*3,x*15,r);  spillet [6] = 1;     break;
        case 8: fillCircle(x*8,x*15,r);  spillet [7] = 1;     break;
        case 9: fillCircle(x*13,x*15,r); spillet [8] = 1;     break;
      
      }

      out.println(Arrays.toString(spillet));

      // Setter en ny farge på spiller 2
    if (play2 == 2){
      s2 = parseInt(getText("Spiller 2"));
  } else
      s2 = trekkTall(1,9);

      setColor(255,0,0);


      switch (s2){
        case 1: fillCircle(x*3,x*3,r);  spillet[0] = 2;     break;
        case 2: fillCircle(x*8,x*3,r);  spillet[1] = 2;     break;
        case 3: fillCircle(x*13,x*3,r); spillet[2] = 2;     break;
        case 4: fillCircle(x*3,x*9,r);  spillet[3] = 2;     break;
        case 5: fillCircle(x*8,x*9,r);  spillet[4] = 2;     break;
        case 6: fillCircle(x*13,x*9,r); spillet[5] = 2;     break;
        case 7: fillCircle(x*3,x*15,r); spillet[6] = 2;     break;
        case 8: fillCircle(x*8,x*15,r); spillet[7] = 2;     break;
        case 9: fillCircle(x*13,x*15,r);spillet[8] = 2;     break;
       
      }


      // for (int  j=0; i<=spillet.length; i++ ){
      //   påRad = spillet[j];
      // }

      ferdig++;

      // Vinner på vannrett
      if (spillet[0] == spillet[1] && spillet[1] == spillet[2]){
        showMessageDialog(null, "Spiller "+ spillet[0] + " VINNER!");
        ferdig = 9;
      }
      if (spillet[4] == spillet[5] && spillet[6] == spillet[5]){
        showMessageDialog(null, "Spiller "+ spillet[0] + " VINNER!");
        ferdig = 9;
      }
      if (spillet[7] == spillet[8] && spillet[9] == spillet[8]){
        showMessageDialog(null, "Spiller "+ spillet[9] + " VINNER!");
        ferdig = 9;
      }

      // Vinner loddrett

      if (spillet[0] == spillet[3] && spillet[6] == spillet[3]){
        showMessageDialog(null, "Spiller "+ spillet[0] + " VINNER!");
        ferdig = 9;
      }
      if (spillet[1] == spillet[4] && spillet[7] == spillet[4]){
        showMessageDialog(null, "Spiller "+ spillet[7] + " VINNER!");
        ferdig = 9;
      }
      if (spillet[2] == spillet[5] && spillet[8] == spillet[5]){
        showMessageDialog(null, "Spiller "+ spillet[8] + " VINNER!");
        ferdig = 9;
      }

      // Vinner på skrå

      if (spillet[0] == spillet[4] && spillet[8] == spillet[4]){
        showMessageDialog(null, "Spiller "+ spillet[0] + " VINNER!");
        ferdig = 9;
      }
      if (spillet[2] == spillet[4] && spillet[6] == spillet[4]){
        showMessageDialog(null, "Spiller "+ spillet[7] + " VINNER!");
        ferdig = 9;
      }
  



    }while (ferdig != 9);

  }


  }


    public static int trekkTall(int min, int max) {
    return min + (int)( random()*(max-min+1) );
  }

  public static int lesHeltall(int min, int max, String ledetekst) {
    int tall=0;
    do {
      String tallTekst = showInputDialog(ledetekst + " ("+min+"-"+max+"): ");
      tall = parseInt(tallTekst);
      if ( tall < min || tall > max )
        showMessageDialog(null,"Ulovlig verdi!");
    } while (tall < min || tall > max);
    return tall;
  }


}
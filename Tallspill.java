import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;


public class Tallspill {

    public int nyttTall() {
        // Trekker og returnerer et slumptall mellom 0 og 200.
        return (int) (Math.random() * 201);
    }

    public void visMelding(String melding) {
        // Viser paramterens innhold i en meldingsboks
        showMessageDialog(null, melding);
    }

    public void forLite(int tall) {
        /*Viser melding om at tallet er for lite
         og at man skal prøve igjen*/
        visMelding("Tallet " + tall + " er for lavt. Gjett igjen.");
    }

    public void forStort(int tall){
        /*Viser melding om at tallet er for stort
          og at man skal prøve igjen*/
        visMelding("Tallet " + tall + " er for stort. Gjett igjen.");
    }

    public void avsluttRunde(int antall, int gjetning){
        /*Viser melding om det ble gjettet riktig tall og
          gjetninger som ble brukt*/
        showMessageDialog(null, "Du klarte det! \n" +
        "Riktig tall var " + gjetning + ". Du brukte " + antall + " forsøk.  \n");
    }

    public void kjørSpill(){
        /*Kjører en spillerunde ved å trekke et tall,
          nullstille tellevariabel, innhente gjentatte gjetninger
          fra bruker inntil det gjettes riktig.*/

        int inputVerdi = 0;
        int tall = nyttTall();
        int teller = 0;
        int lavestTall = 0;
        int høyestTall = 200;
        boolean spillKjører = true;

        while (spillKjører){

            String input = showInputDialog(null, "Gjett et tall mellom " + lavestTall + " og " + høyestTall);

            try {
                inputVerdi = Integer.parseInt(input);
                teller++;
                if (inputVerdi < tall){
                    forLite(inputVerdi);
                } else if (inputVerdi > tall) {
                    forStort(inputVerdi);
                } else {
                    avsluttRunde(teller, inputVerdi);
                    spillKjører = false;
                }
            }
            catch (Exception e){
                visMelding("Skriv inn et tall mellom " + lavestTall + " og " + høyestTall);
            }

        }

    }

}

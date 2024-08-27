package fattura;

public class Fattura {

    // Attributi privati della classe
    private Intestatario intestatario;
    private String data;          
    private double ammontare;    
    private String modalita;  

    public Fattura(Intestatario i, String data, double ammontare, String modalita) {
        intestatario = new Intestatario(i.getNome(),i.getCognome(),i.getAzienda(),i.getIdentita());
        this.data = data;
        this.ammontare = ammontare;
        this.modalita = modalita;
    }
    
    public static class SequenzialeUnivoco {
        private static int counter = 0;

        public static String prossimoNumero() {
            String numeroUnivoco = String.format("%06d", counter);
            counter++;
            return numeroUnivoco;
        }
    }
    
    public boolean isNegativo() {
        return this.ammontare < 0;
    }
    
    public boolean isNotOk() {
        return !modalita.equals("B") && !modalita.equals("C") && !modalita.equals("A");
    }
    
    @Override
    public String toString() {
        return "Fattura di: " + intestatario.getNome() + " "  + intestatario.getCognome() 
                + " Data: " + data 
                + " Ammontare: " + (isNegativo() ? "Non Valido" : "€ " + ammontare)
                + " Modalità: " + (isNotOk() ? "Non Valido" : modalita)
                + " Identità: " + intestatario.isPiva();
    }

}
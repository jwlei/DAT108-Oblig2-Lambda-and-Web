package oppg2;


public class Ansatt {

    private String forNavn;
    private String etterNavn;
    private oppg2.Kjonn kjonn;
    private String stilling;
    private int aarslonn;

    public Ansatt(String forNavn, String etterNavn, oppg2.Kjonn kjonn, String stilling, int aarslonn) {
        this.forNavn = forNavn;
        this.etterNavn = etterNavn;
        this.kjonn = kjonn;
        this.stilling = stilling;
        this.aarslonn = aarslonn;
    }

    public String getForNavn() {
        return forNavn;
    }

    public void setForNavn(String forNavn) {
        this.forNavn = forNavn;
    }

    public String getEtterNavn() {
        return etterNavn;
    }

    public void setEtterNavn(String etterNavn) {
        this.etterNavn = etterNavn;
    }

    public boolean erMann() {
        return kjonn == oppg2.Kjonn.MANN;
    }

    public String getStilling() {
        return stilling;
    }

    public void setStilling(String stilling) {
        this.stilling = stilling;
    }

    public int getAarslonn() {
        return aarslonn;
    }

    public void setAarslonn(int aarslonn) {
        this.aarslonn = aarslonn;
    }

    @Override
    public String toString() {
        return "Ansatt [Fornavn=" + forNavn + ", Etternavn="
                + etterNavn+ ", Kjønn=" + kjonn + ", Stilling=" + stilling + ", Årslønn="+ aarslonn + "]";
    }

    }


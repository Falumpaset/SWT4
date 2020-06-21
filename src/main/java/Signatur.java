import java.util.regex.Pattern;

public final class Signatur {

    // Format -> int 3Char int -> 01 AWE 1129 https://www.bib.uni-wuppertal.de/de/a-z-seiten/signatur.html
    private final String singatur;

    private Signatur(String singatur) {
        assert isValidSignatur(singatur);

        this.singatur = singatur;
    }

    public static Signatur get(String singatur)
    {
        assert isValidSignatur(singatur);

        return new Signatur(singatur);
    }

    public static boolean isValidSignatur(String signatur) {

        var signaturePattern = Pattern.compile("([0-9]){3}([\\s])([\\D]){3}([\\d]+)");

        return signatur.matches(signaturePattern.pattern());
    }

    public String getSingatur() {
        return singatur;
    }

    public int getForlaufendeNummer()
    {
        return Integer.parseInt(this.singatur.substring(singatur.lastIndexOf(' ') + 1));
    }

    public int getStandort()
    {
        return Integer.parseInt(this.singatur.substring(0, singatur.indexOf(' ' - 1)));
    }

    public String getSachgruppe()
    {
        return this.singatur.substring(singatur.indexOf(' ') + 1,
                this.singatur.lastIndexOf(' ') - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Signatur signatur = (Signatur) o;

        return getSingatur().equals(signatur.getSingatur());
    }

    @Override
    public int hashCode() {
        return getSingatur().hashCode();
    }
}

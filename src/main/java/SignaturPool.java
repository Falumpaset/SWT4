import java.util.HashSet;
import java.util.Set;

public class SignaturPool {

    private static final Set<Signatur> signaturPool = new HashSet<>();

    public static Signatur createSignatur(String signaturString) {

        var newSignatur = Signatur.get(signaturString);

        return signaturPool.stream().filter(signature -> signature.equals(newSignatur)).findFirst().orElse(addSignatur(newSignatur));
    }

    private static Signatur addSignatur(Signatur signatur) {
        signaturPool.add(signatur);
        return signatur;
    }

}

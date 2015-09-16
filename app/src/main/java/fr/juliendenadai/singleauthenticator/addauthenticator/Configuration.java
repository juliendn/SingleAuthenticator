package fr.juliendenadai.singleauthenticator.addauthenticator;

import fr.juliendenadai.singleauthenticator.models.Algorithm;
import fr.juliendenadai.singleauthenticator.models.Digits;

/**
 * Created by Julien De Nadai<julien.denadai@gmail.com> on 12/09/15.
 */
public enum Configuration {
    GOOGLE("Google", "@gmail.com", Digits.SIX, Algorithm.MD5, 30),
    FACEBOOK("Facebook", "prenom.nom", Digits.EIGHT, Algorithm.SHA1, 20),
    MICROSOFT("Microsoft", "@hotmail.com", Digits.EIGHT, Algorithm.SHA256, 25);

    private final String mName;

    private final String mIssuer;

    private final Digits mDigits;

    private final Algorithm mAlgorithm;

    private final int mInterval;

    Configuration(String name, String issuer, Digits digits, Algorithm algorithm, int interval) {
        mName = name;
        mIssuer = issuer;
        mDigits = digits;
        mAlgorithm = algorithm;
        mInterval = interval;
    }

    public String getName() {
        return mName;
    }

    public String getIssuer() {
        return mIssuer;
    }

    public Digits getDigits() {
        return mDigits;
    }

    public Algorithm getAlgorithm() {
        return mAlgorithm;
    }

    public int getInterval() {
        return mInterval;
    }
}
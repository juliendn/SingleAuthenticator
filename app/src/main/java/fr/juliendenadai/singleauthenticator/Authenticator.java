package fr.juliendenadai.singleauthenticator;

import fr.juliendenadai.singleauthenticator.common.models.Entity;

/**
 * Created by Julien De Nadai<julien.denadai@gmail.com> on 13/09/15.
 */
public class Authenticator extends Entity {

    private String issuerInt;
    private String issuerExt;
    private String issuerAlt;
    private String label;
    private String labelAlt;
    private String image;
    private String imageAlt;
    private Type type;
    private String algo;
    private byte[] secret;
    private int digits;
    private long counter;
    private int period;

    public String getIssuerInt() {
        return issuerInt;
    }

    public void setIssuerInt(String issuerInt) {
        this.issuerInt = issuerInt;
    }

    public String getIssuerExt() {
        return issuerExt;
    }

    public void setIssuerExt(String issuerExt) {
        this.issuerExt = issuerExt;
    }

    public String getIssuerAlt() {
        return issuerAlt;
    }

    public void setIssuerAlt(String issuerAlt) {
        this.issuerAlt = issuerAlt;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabelAlt() {
        return labelAlt;
    }

    public void setLabelAlt(String labelAlt) {
        this.labelAlt = labelAlt;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageAlt() {
        return imageAlt;
    }

    public void setImageAlt(String imageAlt) {
        this.imageAlt = imageAlt;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getAlgo() {
        return algo;
    }

    public void setAlgo(String algo) {
        this.algo = algo;
    }

    public byte[] getSecret() {
        return secret;
    }

    public void setSecret(byte[] secret) {
        this.secret = secret;
    }

    public int getDigits() {
        return digits;
    }

    public void setDigits(int digits) {
        this.digits = digits;
    }

    public long getCounter() {
        return counter;
    }

    public void setCounter(long counter) {
        this.counter = counter;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public enum Type {
        HOTP,
        TOTP,
        BATTLENET
    }
}

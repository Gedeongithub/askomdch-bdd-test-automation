package domain_objects;

public class BillingDetails {
    private String billingFirstName;
    private String billingLastName;
    private String billingStreetAddress;
    private String billingCity;
    private String billingZipCode;
    private String billingPhone;
    private String billingEmail;


    public BillingDetails(String billingFirstName, String billingLastName,
                          String billingStreetAddress,
                          String billingCity, String billingZipCode,
                          String billingPhone,
                          String billingEmail) {
        this.billingFirstName = billingFirstName;
        this.billingLastName = billingLastName;
        this.billingStreetAddress = billingStreetAddress;
        this.billingCity = billingCity;
        this.billingZipCode = billingZipCode;
        this.billingPhone = billingPhone;
        this.billingEmail = billingEmail;
    }

    //-----------------GETTERS AND SETTERS SECTION-------------
    public String getBillingStreetAddress() {
        return billingStreetAddress;
    }

    public void setBillingStreetAddress(String billingStreetAddress) {
        this.billingStreetAddress = billingStreetAddress;
    }

    public String getBillingFirstName() {
        return billingFirstName;
    }

    public void setBillingFirstName(String billingFirstName) {
        this.billingFirstName = billingFirstName;
    }

    public String getBillingLastName() {
        return billingLastName;
    }

    public void setBillingLastName(String billingLastName) {
        this.billingLastName = billingLastName;
    }


    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }
    public String getBillingZipCode() {
        return billingZipCode;
    }

    public void setBillingZipCode(String billingZipCode) {
        this.billingZipCode = billingZipCode;
    }
    public String getBillingPhone() {
        return billingPhone;
    }

    public void setBillingPhone(String billingPhone) {
        this.billingPhone = billingPhone;
    }

    public String getBillingEmail() {
        return billingEmail;
    }

    public void setBillingEmail(String billingEmail) {
        this.billingEmail = billingEmail;
    }
    //------------GETTERS AND SETTERS END----------------

}

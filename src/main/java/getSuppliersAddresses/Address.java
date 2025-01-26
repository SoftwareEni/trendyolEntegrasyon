package getSuppliersAddresses;
public class Address {
    private int id;
    private String addressType;
    private String country;
    private String city;
    private int cityCode;
    private String district;
    private int districtId;
    private String postCode;
    private String address;
    private boolean isReturningAddress;
    private String fullAddress;
    private boolean isShipmentAddress;
    private boolean isInvoiceAddress;
    private boolean isDefault;

    // Getter ve Setter Metotları

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCityCode() {
        return cityCode;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isReturningAddress() {
        return isReturningAddress;
    }

    public void setReturningAddress(boolean returningAddress) {
        isReturningAddress = returningAddress;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public boolean isShipmentAddress() {
        return isShipmentAddress;
    }

    public void setShipmentAddress(boolean shipmentAddress) {
        isShipmentAddress = shipmentAddress;
    }

    public boolean isInvoiceAddress() {
        return isInvoiceAddress;
    }

    public void setInvoiceAddress(boolean invoiceAddress) {
        isInvoiceAddress = invoiceAddress;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    // toString() metodu (isteğe bağlı)
    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", addressType='" + addressType + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", cityCode=" + cityCode +
                ", district='" + district + '\'' +
                ", districtId=" + districtId +
                ", postCode='" + postCode + '\'' +
                ", address='" + address + '\'' +
                ", isReturningAddress=" + isReturningAddress +
                ", fullAddress='" + fullAddress + '\'' +
                ", isShipmentAddress=" + isShipmentAddress +
                ", isInvoiceAddress=" + isInvoiceAddress +
                ", isDefault=" + isDefault +
                '}';
    }
}

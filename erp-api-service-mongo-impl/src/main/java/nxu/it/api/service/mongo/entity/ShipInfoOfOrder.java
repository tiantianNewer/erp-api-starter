package nxu.it.api.service.mongo.entity;

public class ShipInfoOfOrder {
    protected Float freight;
    protected SimpleShipperEntity shipper;
    protected String phone;
    protected String shipAddress;
    protected String shipProvince;
    protected String shipCity;
    protected String shipRegion;
    protected String contact;

    public Float getFreight() {
        return freight;
    }

    public void setFreight(Float freight) {
        this.freight = freight;
    }

    public SimpleShipperEntity getShipper() {
        return shipper;
    }

    public void setShipper(SimpleShipperEntity shipper) {
        this.shipper = shipper;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getShipProvince() {
        return shipProvince;
    }

    public void setShipProvince(String shipProvince) {
        this.shipProvince = shipProvince;
    }

    public String getShipCity() {
        return shipCity;
    }

    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    public String getShipRegion() {
        return shipRegion;
    }

    public void setShipRegion(String shipRegion) {
        this.shipRegion = shipRegion;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}

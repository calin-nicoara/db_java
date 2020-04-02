package ro.cni.course.dbcourse.prepared.hibernate;

import javax.persistence.*;
import java.lang.annotation.Target;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "client_order")
public class ClientOrder {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "total_order_value")
    private BigDecimal totalOrderValue;

    @Column(name = "delivery_id")
    private Integer deliveryId;

    @Column(name = "is_domestic")
    private Boolean isDomestic;

    @Override
    public String toString() {
        return "ClientOrder{" +
                "id=" + id +
                ", clientName='" + clientName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", totalOrderValue=" + totalOrderValue +
                ", deliveryId=" + deliveryId +
                ", isDomestic=" + isDomestic +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientOrder that = (ClientOrder) o;
        return Objects.equals(clientName, that.clientName) &&
                Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(totalOrderValue, that.totalOrderValue) &&
                Objects.equals(deliveryId, that.deliveryId) &&
                Objects.equals(isDomestic, that.isDomestic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientName, phoneNumber, totalOrderValue, deliveryId, isDomestic);
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(final String clientName) {
        this.clientName = clientName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public BigDecimal getTotalOrderValue() {
        return totalOrderValue;
    }

    public void setTotalOrderValue(final BigDecimal totalOrderValue) {
        this.totalOrderValue = totalOrderValue;
    }

    public Integer getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(final Integer deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Boolean getDomestic() {
        return isDomestic;
    }

    public void setDomestic(final Boolean domestic) {
        isDomestic = domestic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }
}

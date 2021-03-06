package com.upgrad.FoodOrderingApp.service.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="customer_address")
@NamedQueries({
        @NamedQuery(name = "customerAddressByCustomerId" , query = "select c from CustomerAddressEntity c where c.customerId.id =:customerId"),
        @NamedQuery(name = "customerAddressByAddressId" , query = "select c from CustomerAddressEntity c where c.addressId.id =:addressId")
})
public class CustomerAddressEntity implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private CustomerEntity customerId;

    @OneToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="address_id")
    private  AddressEntity addressId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CustomerEntity getCustomerId() {
        return customerId;
    }

    public void setCustomerId(CustomerEntity customerId) {
        this.customerId = customerId;
    }

    public AddressEntity getAddressId() {
        return addressId;
    }

    public void setAddressId(AddressEntity addressId) {
        this.addressId = addressId;
    }
}

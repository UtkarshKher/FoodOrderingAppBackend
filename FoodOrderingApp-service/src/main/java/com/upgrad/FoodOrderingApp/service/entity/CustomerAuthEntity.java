package com.upgrad.FoodOrderingApp.service.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Entity
@Table(name="customer_auth")
@NamedQueries({
        @NamedQuery(name = "customerAuthByCustomerId" , query = "select c from CustomerAuthEntity c where c.customer =:customer"),
        @NamedQuery(name = "customerAuthByAccessToken" , query = "select c from CustomerAuthEntity c where c.accessToken =:accessToken")
})
public class CustomerAuthEntity implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "UUID")
    @NotNull
    @Size(max=200)
    private String uuid;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private CustomerEntity customer;

    @Column(name="access_token")
    @NotNull
    @Size(max = 500)
    private String accessToken;

    @Column(name="login_at")
    @NotNull
    private ZonedDateTime loginAt;

    @Column(name="logout_at")
    private ZonedDateTime logoutAt;

    @Column(name="expires_at")
    @NotNull
    private ZonedDateTime expiresAt;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public ZonedDateTime getLoginAt() {
        return loginAt;
    }

    public void setLoginAt(ZonedDateTime loginAt) {
        this.loginAt = loginAt;
    }

    public ZonedDateTime getLogoutAt() {
        return logoutAt;
    }

    public void setLogoutAt(ZonedDateTime logoutAt) {
        this.logoutAt = logoutAt;
    }

    public ZonedDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(ZonedDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }
}

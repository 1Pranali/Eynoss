package com.ex.eynos.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum
{
    public Datum() {
    }

    public Datum(String emailAddress, String password) {
        this.emailAddress = emailAddress;
        this.password = password;
    }

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email_address")
    @Expose
    private String emailAddress;
    @SerializedName("password")
    @Expose
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

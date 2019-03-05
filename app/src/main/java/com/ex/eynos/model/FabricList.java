package com.ex.eynos.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FabricList
{
    @SerializedName("fab_id")
    @Expose
    private Integer fabId;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("stock")
    @Expose
    private String stock;
    @SerializedName("availability")
    @Expose
    private String availability;
    @SerializedName("vendor")
    @Expose
    private String vendor;
    @SerializedName("date")
    @Expose
    private String date;

    public Integer getFabId() {
        return fabId;
    }

    public void setFabId(Integer fabId) {
        this.fabId = fabId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

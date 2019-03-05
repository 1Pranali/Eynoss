package com.ex.eynos.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DesignList
{
    @SerializedName("design_id")
    @Expose
    private Integer designId;
    @SerializedName("designer")
    @Expose
    private String designer;
    @SerializedName("image")
    @Expose
    private String image;

    public Integer getDesignId() {
        return designId;
    }

    public void setDesignId(Integer designId) {
        this.designId = designId;
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

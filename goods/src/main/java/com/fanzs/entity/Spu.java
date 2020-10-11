package com.fanzs.entity;

public class Spu {
    private Long id;
    private Long spuCode;
    private String spuName;
    private Short valid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpuName() {
        return spuName;
    }

    public void setSpuName(String spuName) {
        this.spuName = spuName;
    }

    public Long getSpuCode() {
        return spuCode;
    }

    public void setSpuCode(Long spuCode) {
        this.spuCode = spuCode;
    }

    public Short getValid() {
        return valid;
    }

    public void setValid(Short valid) {
        this.valid = valid;
    }
}

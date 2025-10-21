package com.mcp.mymcpserver.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class InOrderRev implements Serializable {
    /**
     * 入库队列
     * {
     * "MsgId":"1907631081691787265"
     * "PalletId":"1913156875709321216",
     * "InventoryCode":"16002",
     * "InventoryCost":"0.00000000000000",
     * "Type":"InboundInfo",
     * "InventoryName":"精料补充料(25%裂壶藻粉)",
     * "BatchNo":"B20250403C",
     * "PlcTime":“2025-04-15 17:23:15”,
     * "BoxNums":40,
     * "PalletWeight":800,
     * }
     */

    @JsonProperty("MsgId")
    private String msgId;

    @JsonProperty("PalletId")
    private String palletId;

    @JsonProperty("InventoryCode")
    private String inventoryCode;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("InventoryName")
    private String inventoryName;

    @JsonProperty("BatchNo")
    private String batchNo;

    @JsonProperty("PlcTime")
    private String plcTime;

    @JsonProperty("BoxNums")
    private String boxNums;

    @JsonProperty("PalletWeight")
    private String palletWeight;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getPalletId() {
        return palletId;
    }

    public void setPalletId(String palletId) {
        this.palletId = palletId;
    }

    public String getInventoryCode() {
        return inventoryCode;
    }

    public void setInventoryCode(String inventoryCode) {
        this.inventoryCode = inventoryCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInventoryName() {
        return inventoryName;
    }

    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getPlcTime() {
        return plcTime;
    }

    public void setPlcTime(String plcTime) {
        this.plcTime = plcTime;
    }

    public String getBoxNums() {
        return boxNums;
    }

    public void setBoxNums(String boxNums) {
        this.boxNums = boxNums;
    }

    public String getPalletWeight() {
        return palletWeight;
    }

    public void setPalletWeight(String palletWeight) {
        this.palletWeight = palletWeight;
    }
}

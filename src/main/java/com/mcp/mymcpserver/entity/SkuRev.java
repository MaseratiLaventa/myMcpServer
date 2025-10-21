package com.mcp.mymcpserver.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class SkuRev implements Serializable {
    /**
     "MsgId":"1912457117524762626",
     "Type":"add",
     "Code":"16002",
     Name":"精料补充料(25%裂壶藻粉)"
     Type为类型，物料消息有：add新增，update修改，del删除三种消息属性
     */

    @JsonProperty("MsgId")
    private String msgId;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("Code")
    private String skuNo;

    @JsonProperty("Name")
    private String skuName;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSkuNo() {
        return skuNo;
    }

    public void setSkuNo(String skuNo) {
        this.skuNo = skuNo;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }
}

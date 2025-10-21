package com.mcp.mymcpserver.mcp;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mcp.mymcpserver.entity.InOrderRev;
import com.mcp.mymcpserver.entity.SkuRev;
import com.mcp.mymcpserver.entity.User;
import com.mcp.mymcpserver.util.HttpUtil;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

@Service
public class McpService {


    @Tool(description = "新增物料")
    public String addSku(@ToolParam(description = "物料类型") String Type,
                         @ToolParam(description = "物料编码") String Code,
                         @ToolParam(description = "物料名称") String Name) throws JsonProcessingException {

        SkuRev skuRev = new SkuRev();
        skuRev.setType(Type);
        skuRev.setSkuNo(Code);
        skuRev.setSkuName(Name);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(skuRev);
        String result = HttpUtil.post("http://localhost:8081/mcp/addSku", json);
        return "新增物料成功";
    }

    @Tool(description = "查询物料")
    public String querySku(@ToolParam(description = "物料编码") String code,
                           @ToolParam(description = "物料名称") String name) throws JsonProcessingException {
        SkuRev skuRev = new SkuRev();
        skuRev.setSkuNo(code);
        skuRev.setSkuName(name);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(skuRev);
        String result = HttpUtil.post("http://localhost:8081/mcp/querySku", json);
        return result;
    }

    @Tool(description = "查询所有物料")
    public String querySkuAll() throws JsonProcessingException {
        SkuRev skuRev = new SkuRev();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(skuRev);
        String result = HttpUtil.post("http://localhost:8081/mcp/querySkuAll", json);
        return result;
    }

    @Tool(description = "新增入库单")
    public String addIn(@ToolParam(description = "托盘号") String palletId,
                        @ToolParam(description = "物料编码") String Code,
                        @ToolParam(description = "物料名称") String Name,
                        @ToolParam(description = "批号") String BatchNo,
                        @ToolParam(description = "袋数") String BoxNums,
                        @ToolParam(description = "数量") String PalletWeight) throws JsonProcessingException {

        InOrderRev inOrderRev = new InOrderRev();
        inOrderRev.setPalletId(palletId);
        inOrderRev.setInventoryCode(Code);
        inOrderRev.setInventoryName(Name);
        inOrderRev.setBatchNo(BatchNo);
        inOrderRev.setBoxNums(BoxNums);
        inOrderRev.setPalletWeight(PalletWeight);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(inOrderRev);
        String result = HttpUtil.post("http://localhost:8081/mcp/addIn", json);
        return "新增物料成功";
    }


    @Tool(description = "创建用户")
    public String createUser(@ToolParam(description = "用户名") String name) throws JsonProcessingException {
        User user = new User();
        user.setName(name);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);
        HttpUtil.post("http://localhost:9091/testMcp/createUser",json);
        return "调用创建用户接口成功";
    }
}

package com.mcp.mymcpserver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mcp.mymcpserver.mcp.McpService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyMcpServerApplicationTests {

    @Autowired
    McpService mcpService;
    @Test
    void contextLoads() throws JsonProcessingException {
      //  mcpService.addSku("1", "1", "1");
    }

}

package com.mcp.mymcpserver.util;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;

/**
 * RestTemplate 工具类
 *
 * @author: linjinp
 * @create: 2019-06-05 14:06
 **/
public class HttpUtil {
    private static class SingletonRestTemplate {
        private static final RestTemplate INSTANCE = new RestTemplate();
    }

    private HttpUtil() {
    }

    public static RestTemplate getInstance() {
        return SingletonRestTemplate.INSTANCE;
    }

    /**
     * post 请求
     *
     * @param url   请求路径
     * @param data  body数据
     * @param token JWT所需的Token，不需要的可去掉
     * @return
     */
    public static String post(String url, String data, String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json");
        headers.add("Content-Encoding", "UTF-8");
        headers.add("Content-Type", "application/json; charset=UTF-8");
        if (token != null) {
            headers.add("Authorization", token);
        }
        headers.set("Cookie", "");
        HttpEntity<String> requestEntity = new HttpEntity<>(data, headers);
        return HttpUtil.getInstance().postForObject(url, requestEntity, String.class);
    }

    /**
     * post 请求
     *
     * @param url  请求路径
     * @param data body数据
     * @return
     */
    public static String post(String url, String data) {
        return post(url, data, null);
    }

    /**
     * get 请求
     *
     * @param url   请求路径
     * @param token JWT所需的Token，不需要的可去掉
     * @return
     */
    public static String get(String url, String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json");
        headers.add("Content-Encoding", "UTF-8");
        headers.add("Content-Type", "application/json; charset=UTF-8");
        if (token != null) {
            headers.add("Authorization", token);
        }
        headers.set("Cookie", "");
        HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = HttpUtil.getInstance().exchange(url, HttpMethod.GET, requestEntity, String.class);
        String responseBody = response.getBody();
        return responseBody;
    }

    /**
     * Auth鉴权
     *
     * @return
     */
    public static String authentication(String url, String session) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json");
        headers.add("Content-Encoding", "UTF-8");
        headers.add("Content-Type", "application/json; charset=UTF-8");
        if (session != null) {
            headers.add("Cookie", "auth_session_id=" + session);
        }
        HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = HttpUtil.getInstance().exchange(url, HttpMethod.GET, requestEntity, String.class);
        String responseBody = response.getBody();
        return responseBody;
    }

    /**
     * 发送文件请求
     *
     * @param url
     * @param token
     * @return
     */
    public static String file(String url, File file, String token) {
        String result = null;
        // 保存为文件
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        headers.setContentType(MediaType.parseMediaType("multipart/form-data;charset=UTF-8"));
        if (token != null) {
            headers.add("Authorization", token);
        }
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        FileSystemResource resource = new FileSystemResource(file);
        param.add("file", resource);
        HttpEntity<MultiValueMap<String, Object>> formEntity = new HttpEntity<>(param, headers);
        result = HttpUtil.getInstance().postForObject(url, formEntity, String.class);
        return result;
    }


    /**
     * delete 请求
     *
     * @param url   请求路径
     * @param data  body数据
     * @param token JWT所需的Token，不需要的可去掉
     * @return
     */
    public static String delete(String url, String data, String token) {
       // log.info("http delete请求，url: {}，data: {}", url, data);
        HttpHeaders headers = buildHttpHeaders(token);
        HttpEntity<String> requestEntity = new HttpEntity<>(data, headers);
        String response = HttpUtil.getInstance().exchange(url, HttpMethod.DELETE, requestEntity, String.class).getBody();
       // log.info("http delete请求，url: {}，data: {}，response: {}", url, data, response);
        return response;
    }

    public static String delete(String url, String data) {
        return delete(url, data, null);
    }

    /**
     * patch 请求
     * @param url
     * @param data
     * @param token
     * @return
     */
    public static String patch(String url, String data, String token) {

        HttpHeaders headers = buildHttpHeaders(token);
        HttpEntity<String> requestEntity = new HttpEntity<>(data, headers);
        String response = HttpUtil.getInstance().patchForObject(url, requestEntity, String.class);

        return response;
    }


    public static HttpHeaders buildHttpHeaders(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json");
        headers.add("Content-Encoding", "UTF-8");
        headers.add("Content-Type", "application/json; charset=UTF-8");
        if (token != null) {
            headers.add("Authorization", token);
        }
        headers.set("Cookie", "");
        return headers;
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.api.baseController;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BaseResource {

    @JsonIgnore
    private Integer status;

    private String message;

    private Object data;

    public ApiResponse success(Integer status,String message, Object data) {
        ApiResponse response = new ApiResponse();
        response.setMessage(message);
        response.setData(data);
        response.setStatus(status);
        return response;
    }

    public ApiResponse error(Integer status,String message, Object data) {
        ApiResponse response = new ApiResponse();
        response.setMessage(message);
        response.setData(data);
        response.setStatus(status);
        return response;
    }
}

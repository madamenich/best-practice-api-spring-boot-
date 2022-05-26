package com.hrd.basic.myprojectapi.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.LinkedHashMap;

public class UnauthorizedExceptionHandler extends BaseApiException  {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss",timezone = "Asia/Phnom_Penh")
    private Date timestamp =  new Date();

    public UnauthorizedExceptionHandler(HttpStatus httpStatus, String errorMessage) {
        super(httpStatus, errorMessage);
    }

//    @Override
//    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
//        LinkedHashMap<String, String> map = new LinkedHashMap<>(2);
//        final String expired = (String) request.getAttribute("expired");
//        map.put("code", "401");
//        map.put("message", (expired!=null)? expired.substring(0,expired.indexOf(".")-1) :"Unauthorized Access!");
//        map.put("timestamp", timestamp.toString());
//        map.put("path", request.getRequestURI());
//        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        response.setCharacterEncoding("utf-8");
//        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//        ObjectMapper objectMapper = new ObjectMapper();
//        String resBody = objectMapper.writeValueAsString(map);
//        PrintWriter printWriter = response.getWriter();
//        printWriter.print(resBody);
//        printWriter.flush();
//        printWriter.close();
//    }
}

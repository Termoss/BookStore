package com.termos.config;

import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import javax.naming.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class AuthEntryPoint extends BasicAuthenticationEntryPoint {

    private String realmName;


    public void commence(HttpServletRequest httprequest, HttpServletResponse httpresponse,
                         AuthenticationException httpauthenticationException
    )throws IOException, ServletException {
        httpresponse.addHeader("WWW-Authenticate",
                "Basic realm=\"" + this.realmName + "\"");
        httpresponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        PrintWriter writer = httpresponse.getWriter();
        writer.println("HTTP Status 401 - " + httpauthenticationException.getMessage());
    }


    public void afterPropertiesSet() throws Exception {

        setRealmName("cannot login");
        super.afterPropertiesSet();
    }

}


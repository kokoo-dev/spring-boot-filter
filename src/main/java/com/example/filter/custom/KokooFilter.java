package com.example.filter.custom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

public class KokooFilter implements Filter {
    Logger logger = LogManager.getLogger(KokooFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("Init KokooFilter!");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Enumeration<String> enumeration = request.getParameterNames();

        if(request instanceof HttpServletRequest){
            ModifyRequest modifyRequest = new ModifyRequest((HttpServletRequest) request);

            while(enumeration.hasMoreElements()){
                String name = enumeration.nextElement();
                String param = request.getParameter(name);

                modifyRequest.setParameter(name, param.concat("kokoo"));
            }

            chain.doFilter(modifyRequest, response);
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        logger.info("Init KokooFilter!");
    }
}

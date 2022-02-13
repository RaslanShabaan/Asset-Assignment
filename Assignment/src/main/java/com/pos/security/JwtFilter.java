package com.pos.security;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.SignatureException;



@Component
public class JwtFilter extends GenericFilterBean{

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private CustomUserDetailsService service;
    private final List<String> allowedOrigins = (List<String>) Arrays.asList("http://localhost:3001","http://localhost:3000","http://192.168.1.117:3000","http://10.1.1.51:3000","http://10.1.1.51:8080", "http://localhost:8080");

    @Override
    public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain) throws IOException, ServletException {

        System.out.println("INSIDE JWT FILTER");

        final HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;


        // Access-Control-Allow-Origin
     //   String origin = request.getHeader("Origin");
        response.setHeader("Access-Control-Allow-Origin", "*");

        response.setHeader("Vary", "Origin");

        // Access-Control-Max-Age
        response.setHeader("Access-Control-Max-Age", "3600");

        // Access-Control-Allow-Credentials
        response.setHeader("Access-Control-Allow-Credentials", "true");

        // Access-Control-Allow-Methods
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");

        // Access-Control-Allow-Headers
        response.setHeader("Access-Control-Allow-Headers",
                "Origin, Authorization, myheader, X-Requested-By, X-Requested-With, Content-Type, Accept, " + "X-CSRF-TOKEN");
        
        if ( request.getMethod().equals("OPTIONS")) {
            response.flushBuffer();
        }else{
  
        	if ( request.getRequestURI().contains("authenticate")) {
        		 chain.doFilter(req, res);
        		 
        		 
        	}else {
            final String authHeader = request.getHeader("Authorization");
            String reqHdr = request.getHeader("X-Requested-By");
            String myHdr = request.getHeader("myheader");

            System.out.println("=====================================================");
            System.out.println("Auth header = "+authHeader);
            System.out.println("requested by header = "+reqHdr);
            System.out.println("my header = "+myHdr);
            System.out.println("=====================================================");

           
            
            
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                System.out.println("JwtFilter.doFilter -> auth header is null or token does not start with Bearer");
                throw new ServletException("Missing or invalid Authorization header.");
            }

            final String token = authHeader.substring(7); // The part after "Bearer "
            String userName = jwtUtil.extractUsername(token);
            System.err.println(userName);
            try {
					UserDetails userDetails = service.loadUserByUsername(userName);
            	  if (jwtUtil.validateToken(token, userDetails)) {

                      UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                              new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                      usernamePasswordAuthenticationToken
                              .setDetails(new WebAuthenticationDetailsSource().buildDetails((HttpServletRequest) req));
                      SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                  }
                 
                 
            	
              
            }
            catch (final SignatureException e) {
                System.out.println("JwtFilter.doFilter -> Signature Exception, invalid token = "+e.getMessage());
                throw new ServletException("Invalid token.");
            }

            chain.doFilter(req, res);

        }

        }
    }

	
}
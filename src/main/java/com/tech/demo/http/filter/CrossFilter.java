package com.tech.demo.http.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tech.demo.model.Employee;
import com.tech.demo.repository.EmployeeRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.IOException;

@Component
public class CrossFilter implements Filter{
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain)throws IOException,ServletException{
		HttpServletResponse response=(HttpServletResponse) res;
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST,DELETE,PUT,OPTIONS");
		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization, type");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.addIntHeader("Access-Control-Max-Age", 180);
		
		try {
				HttpServletRequest request=(HttpServletRequest)req;
				
				System.out.println(request.getHeader("Authorization"));
				
				String url=request.getRequestURL().toString();
				
				if(request.getHeader("Authorization")!=null) {
					String id=Jwts.parser().setSigningKey("unique").parseClaimsJws(request.getHeader("Authorization")).getBody().getSubject();
					long employeeId=Long.parseLong(id);
					Employee employee=employeeRepository.findById(employeeId).get();
					if(employee!=null)
					{
						req.setAttribute("id", employeeId);
						chain.doFilter(req, res);
					}
					else {
						throw new Exception("Invalid");
					}
				}
				else if(url.equals("http://localhost:8080/api1/login")) {
					chain.doFilter(req, res);
				}
				else {
					//response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
					response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid");
					//response.setStatus(HttpServletResponse.SC_UNAUTHORIZED, "Invalid");
					throw new Exception("Invalid");
					//chain.doFilter(req, res);
				}
		}
		catch (Exception e) {
			
			System.out.println(e);
		}
	}

}

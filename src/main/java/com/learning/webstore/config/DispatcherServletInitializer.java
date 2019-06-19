package com.learning.webstore.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer; 

class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer { 

     @Override 
     protected Class<?>[] getRootConfigClasses() { 
          return new Class[] {RootApplicationContextConfig.class}; 
     } 

     @Override 
     protected Class<?>[] getServletConfigClasses() { 
          return new Class[] {WebApplicationContextConfig.class }; 
     } 

     @Override 
     protected String[] getServletMappings() { 
          return new String[] { "/" }; 
     } 
}

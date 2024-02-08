package com.soapwsapp.config;


import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public Jaxb2Marshaller jaxb2Marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.soapwsapp.model_loan"); // Package where your JAXB-annotated classes are located
        return marshaller;
    }

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "loanEligibility")
    public DefaultWsdl11Definition loanEligibilityWsdlDefinition(XsdSchema loanEligibilitySchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("LoanEligibilityIndicator");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://www.soapwsapp.com/model_loan");
        wsdl11Definition.setSchema(loanEligibilitySchema);
        return wsdl11Definition;
    }

    @Bean(name = "adlogin")
    public DefaultWsdl11Definition otherServiceWsdlDefinition(XsdSchema otherServiceSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("OtherServicePort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://www.soapwsapp.com/model");
        wsdl11Definition.setSchema(otherServiceSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema loanEligibilitySchema() {
        return new SimpleXsdSchema(new ClassPathResource("LoanEligibility.xsd"));
    }

    @Bean
    public XsdSchema otherServiceSchema() {
        return new SimpleXsdSchema(new ClassPathResource("userAttributes.xsd"));
    }
}

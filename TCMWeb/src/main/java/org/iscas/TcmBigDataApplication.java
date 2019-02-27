package org.iscas;


import static java.util.Collections.singletonList;
import org.iscas.controller.BookEntityController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

@SpringBootApplication
@EnableNeo4jRepositories
//@EnableAutoConfiguration(exclude = {FreeMarkerAutoConfiguration.class})
public class TcmBigDataApplication {
	public TcmBigDataApplication(FreeMarkerConfigurer freeMarkerConfigurer) {
        freeMarkerConfigurer.getTaglibFactory().setClasspathTlds(singletonList("/META-INF/security.tld"));
    }
	public static void main(String[] args) {
		
		
		SpringApplication.run(TcmBigDataApplication.class, args);
	}
}

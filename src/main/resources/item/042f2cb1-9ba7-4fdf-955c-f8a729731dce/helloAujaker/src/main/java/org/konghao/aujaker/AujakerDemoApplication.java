package org.konghao.aujaker;
import org.konghao.reposiotry.base.BaseRepositoryFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableJpaRepositories(basePackages = {"org.konghao.aujaker"},
	repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class//指定自己的工厂
)
@SpringBootApplication
public class AujakerDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(AujakerDemoApplication.class,args);
	}

	@Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return new EmbeddedServletContainerCustomizer(){
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                container.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST, "/400"));
                container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500"));
                container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404"));
            }
        };
    }
}

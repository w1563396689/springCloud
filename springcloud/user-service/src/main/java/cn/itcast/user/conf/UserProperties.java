package cn.itcast.user.conf;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "byd")
public class UserProperties {

    private String loginTemplate;

    private String url;
}

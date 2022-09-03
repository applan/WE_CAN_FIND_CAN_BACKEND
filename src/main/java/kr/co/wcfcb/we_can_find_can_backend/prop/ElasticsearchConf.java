package kr.co.wcfcb.we_can_find_can_backend.prop;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "wcfc.elasticsearch")
public class ElasticsearchConf {

    private String host;
    private Integer port;

}

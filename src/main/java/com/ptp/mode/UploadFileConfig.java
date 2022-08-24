package com.ptp.mode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;



@Data
@Component
@ConfigurationProperties(prefix = "upload")
public class UploadFileConfig {
    private String filePath;
    private String fileMaxSize;
    private String fileCount;
    private String fileEncoding;
    private String fileType;
}

package com.ptp.web.advice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemoException extends RuntimeException {
    private String code;
    private String msg;

}

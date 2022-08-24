package com.ptp.mode;

import lombok.*;

import javax.xml.ws.soap.Addressing;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class RestResponse {
    String code;
    String msg;
    Object data;
}

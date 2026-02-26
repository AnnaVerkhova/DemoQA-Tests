package org.api.data.account;

import lombok.Data;

@Data
public class GenerateTokenResponse {
    private String token;
    private String expires;
    private String status;
    private String result;
}

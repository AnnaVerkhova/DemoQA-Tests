package org.api.data.account;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GenerateTokenRequest {
    private String userName;
    private String password;
}

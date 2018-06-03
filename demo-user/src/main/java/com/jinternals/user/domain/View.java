package com.jinternals.user.domain;

public interface View {
    public static interface V1 {
        String VND_USER_API_V1 = "application/vnd.user.api.v1+json";
    }
    public static interface V2 extends V1 {
        String VND_USER_API_V2 = "application/vnd.user.api.v2+json";

    }
}

package com.matrix.common.constant.config;

/**
 * @author liuweizhong
 * @since 2025-07-15 13:58
 */
public interface MaHttpHeaders {

    String X_XSS_PROTECTION = "X-XSS-Protection";

    String X_XSS_PROTECTION_V = "1; mode=block";

    String X_CONTENT_TYPE_OPTIONS = "X-Content-Type-Options";

    String X_CONTENT_TYPE_OPTIONS_V = "nosniff";

}

package org.xdove.webtest;

import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;

import java.io.Serializable;
import java.util.Map;

public interface IDFetch {

    Serializable fetch(String url, Map<String, String> headers);
}

package com.zcswl.spring.feign.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.zcswl.spring.feign.interf.ScheduleServiceHi;
import feign.Request;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.GZIPOutputStream;

import static feign.Util.*;
import static feign.Util.CONTENT_LENGTH;

/**
 * @author zhoucg
 * @date 2019-11-19 15:46
 */
@RestController
@AllArgsConstructor
public class HiController {

    private final ScheduleServiceHi scheduleServiceHi;

    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name) {
        return scheduleServiceHi.sayProvider( name );
    }


    /**
     * Local test connection
     */
    public static void main(String[] args) throws IOException {


        String url = "http://127.0.0.1:8763/provider";
        Map<String, Collection<String>> headers = Maps.newHashMap();
        headers.put("Content-Length",Lists.newArrayList("6"));
        headers.put("Content-Type",Lists.newArrayList("text/plain;charset=UTF-8"));
        Request.Body body = Request.Body.encoded("zhoucg".getBytes(), Charset.defaultCharset());

        Request request = Request.create(Request.HttpMethod.GET,url, headers, body);

        final HttpURLConnection connection =
                (HttpURLConnection) new URL(request.url()).openConnection();
        connection.setConnectTimeout(6000);
        connection.setReadTimeout(6000);
        connection.setAllowUserInteraction(false);
        connection.setInstanceFollowRedirects(true);
        connection.setRequestMethod(request.httpMethod().name());

        Collection<String> contentEncodingValues = request.headers().get(CONTENT_ENCODING);
        boolean gzipEncodedRequest =
                contentEncodingValues != null && contentEncodingValues.contains(ENCODING_GZIP);
        boolean deflateEncodedRequest =
                contentEncodingValues != null && contentEncodingValues.contains(ENCODING_DEFLATE);

        boolean hasAcceptHeader = false;
        Integer contentLength = null;
        for (String field : request.headers().keySet()) {
            if (field.equalsIgnoreCase("Accept")) {
                hasAcceptHeader = true;
            }
            for (String value : request.headers().get(field)) {
                if (field.equals(CONTENT_LENGTH)) {
                    if (!gzipEncodedRequest && !deflateEncodedRequest) {
                        contentLength = Integer.valueOf(value);
                        connection.addRequestProperty(field, value);
                    }
                } else {
                    connection.addRequestProperty(field, value);
                }
            }
        }
        // Some servers choke on the default accept string.
        if (!hasAcceptHeader) {
            connection.addRequestProperty("Accept", "*/*");
        }

        if (request.requestBody().asBytes() != null) {
            if (contentLength != null) {
                connection.setFixedLengthStreamingMode(contentLength);
            } else {
                connection.setChunkedStreamingMode(8196);
            }
            connection.setDoOutput(true);
            OutputStream out = connection.getOutputStream();
            if (gzipEncodedRequest) {
                out = new GZIPOutputStream(out);
            } else if (deflateEncodedRequest) {
                out = new DeflaterOutputStream(out);
            }
            try {
                out.write(request.requestBody().asBytes());
            } finally {
                try {
                    out.close();
                } catch (IOException suppressed) { // NOPMD
                }
            }
        }

    }
}

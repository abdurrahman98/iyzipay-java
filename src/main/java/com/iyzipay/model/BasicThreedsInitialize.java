package com.iyzipay.model;

import com.google.gson.annotations.SerializedName;
import com.iyzipay.DigestHelper;
import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.CreateBasicPaymentRequest;

public class BasicThreedsInitialize extends IyzipayResource {

    @SerializedName("threeDSHtmlContent")
    private String htmlContent;

    public static BasicThreedsInitialize create(CreateBasicPaymentRequest request, Options options) {
        String path = "/payment/3dsecure/initialize/basic";
        BasicThreedsInitialize response = HttpClient.create().post(options.getBaseUrl() + path,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                BasicThreedsInitialize.class);
        if (response != null) {
            response.setHtmlContent(DigestHelper.decodeString(response.getHtmlContent()));
        }
        return response;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }
}

package com.iyzipay.model;

import java.util.List;

import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.RetrieveInstallmentInfoRequest;

public class InstallmentInfo extends IyzipayResource {

    private List<InstallmentDetail> installmentDetails;

    public static InstallmentInfo retrieve(RetrieveInstallmentInfoRequest request, Options options) {
        String path = "/payment/iyzipos/installment";
        return HttpClient.create().post(options.getBaseUrl() + path,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                InstallmentInfo.class);
    }

    public List<InstallmentDetail> getInstallmentDetails() {
        return installmentDetails;
    }

    public void setInstallmentDetails(List<InstallmentDetail> installmentDetails) {
        this.installmentDetails = installmentDetails;
    }
}

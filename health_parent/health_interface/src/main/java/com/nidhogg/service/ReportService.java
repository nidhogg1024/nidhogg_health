package com.nidhogg.service;

import java.util.Map;

/**
 * Created by Nidhogg on 2021/8/22.
 */
public interface ReportService {
    Map<String,Object> getBusinessReport() throws Exception;
}

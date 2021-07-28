package com.changgou.search.service;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public interface SkuService {
    /***
     * 导入SKU数据
     */
    void importSku();

    /***
     * 搜索
     * @param searchMap
     * @return
     */
    Map search(Map<String, String> searchMap);
}

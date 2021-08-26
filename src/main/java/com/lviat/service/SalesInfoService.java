package com.lviat.service;

import com.lviat.model.SalesInfo;


import java.util.List;

/**
 * 用户 service.
 *
 * @author LviatYi
 * @version QwQ_1
 * @interfaceName SalesInfoService
 * @date 2021/8/26
 */
public interface SalesInfoService {
    /**
     * 增加销售记录.
     *
     * @param salesInfo 新增销售记录.
     * @return service status.
     */
    SalesInfoServiceStatus addSalesInfo(SalesInfo salesInfo);

    /**
     * 删除销售记录.
     *
     * @param salesInfoId 删除用销售记录 id.
     * @return service status.
     */
    SalesInfoServiceStatus delSalesInfo(long salesInfoId);


    /**
     * 获取销售信息.
     *
     * @param salesInfo  传入形参 销售信息.
     * @param salesInfoId SalesInfo  ID.
     * @return service status.
     */
    SalesInfoServiceStatus getSalesInfo(SalesInfo salesInfo,long salesInfoId);

    /**
     * 获取所有销售信息.
     * 具有尾增特性.
     *
     * @param salesInfos    传入形参 销售信息.
     * @param page  分页页码.
     * @return service status.
     */
    SalesInfoServiceStatus getSalesInfo(List<SalesInfo> salesInfos, int page);

    /**
     * 获取所有销售
     * 具有尾增特性.
     *
     * @param salesInfos 传入形参 用户.
     * @param page  分页页码.
     * @param size  单页显示数量.
     * @return service status.
     */
    SalesInfoServiceStatus getSalesInfo(List<SalesInfo> salesInfos, int page, int size);

    /**
     * 获取销售数量.
     *
     * @return 所有销售数量.
     */
    long getSalesInfoCount();
    /**
     * 修改销售信息.
     * 通过 salesinfo 指定销售对象
     *
     * @param salesInfo 新的销售信息.
     * @return service status.
     */
    SalesInfoServiceStatus modifySalesInfo (SalesInfo salesInfo);

}

package com.lviat.service;

import com.lviat.model.Consumer;

import java.util.List;

public interface ConsumerService {
    /**
     * 增加消费者.
     *
     * @param consumer 新增消费者.
     * @return service status.
     */
    ConsumerServiceStatus addConsumer(Consumer consumer);

    /**
     * 删除消费者.
     *
     * @param consumerId 删除消费者 id.
     * @return service status.
     */
    ConsumerServiceStatus delConsumer(long consumerId);

    /**
     * 获取消费者.
     *
     * @param consumer   传入形参 消费者.
     * @param consumerId Consumer ID.
     * @return service status.
     */
    ConsumerServiceStatus getConsumer(Consumer consumer, long consumerId);

    /**
     * 获取所有消费者.
     * 具有尾增特性.
     *
     * @param consumers 传入形参 消费者.
     * @param page  分页页码.
     * @return service status.
     */
    ConsumerServiceStatus getConsumer(List<Consumer> consumers, int page);

    /**
     * 获取所有消费者.
     * 具有尾增特性.
     *
     * @param consumers 传入形参 消费者.
     * @param page  分页页码.
     * @param size  单页显示数量.
     * @return service status.
     */
    ConsumerServiceStatus getConsumer(List<Consumer> consumers, int page, int size);

    /**
     * 获取消费者数量.
     *
     * @return 所有消费者数量.
     */
    long getConsumerCount();

    /**
     * 修改消费者信息.
     * 通过 medicine 指定消费者对象.
     *
     * @param consumer 新的消费者信息.
     * @return service status.
     */
    ConsumerServiceStatus modifyConsumer(Consumer consumer);

}

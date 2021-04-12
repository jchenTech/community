package com.jchen.community.dao.elasticsearch;

import com.jchen.community.entity.DiscussPost;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * elasticsearch组件
 * @Auther: jchen
 * @Date: 2021/04/02/10:24
 */
@Repository
public interface DiscussPostRepository extends ElasticsearchRepository<DiscussPost, Integer> {

}

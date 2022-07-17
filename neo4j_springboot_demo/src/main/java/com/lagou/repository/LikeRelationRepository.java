package com.lagou.repository;

import com.lagou.bean.LikeRelation;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface LikeRelationRepository extends Neo4jRepository<LikeRelation,Long> {

    /**
     * 查询关系
     * @return
     */
    @Query("match p = (n)-[r:Like]->(b) return p")
    List<LikeRelation> getLikes();


    /**
     * 为两个已经存在的节点添加关系
     * @param startNodeID -- 起始节点
     * @param endNodeID   -- 终止节点
     * @param rID         -- 关系的ID
     * @param year        -- 关系的开始年限
     * @param reason	  -- 关系产生的原因
     * @return
     */
    @Query("match(a),(b) where a.uid={0} and b.uid = {1}"
            + " create p = (a)-[r:Like{relationID:{2},since:{3},reason:{4}}]->(b) return p ")
    List<LikeRelation> createLikes(Long startNodeID, Long endNodeID, Integer rID, Integer year, String reason);

}

package com.hch.fivechess.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hch.fivechess.domain.Rank;
import com.hch.fivechess.domain.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RecordMapper extends BaseMapper<Record> {
    @Select("SELECT l.login as id,l.`name`,COUNT(r.win) as wins " +
            "FROM `user` l,record r " +
            "WHERE l.id = r.win " +
            "GROUP BY r.win " +
            "ORDER BY wins DESC")
    List<Rank> getRankList();
}

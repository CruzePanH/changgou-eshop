package com.changgou.content.dao;
import com.changgou.content.pojo.Content;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

/****
 * @Author:shenkunlin
 * @Description:Content的Dao
 * @Date 2019/6/14 0:12
 *****/
@Component
public interface ContentMapper extends Mapper<Content> {
}

package com.liuyu7177.sgusercenter.repository;


import com.liuyu7177.sgdata.pojo.UserInfo;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by libiyan on 2019/10/27.
 * @author
 */
@Repository
public interface UserInfoRepository extends PagingAndSortingRepository<UserInfo, Long> {
}

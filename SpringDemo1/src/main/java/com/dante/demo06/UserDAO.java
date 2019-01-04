package com.dante.demo06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//@Component("b")
@Repository("zd")
public class UserDAO {

    @Autowired
    DBUtils dbUtils;
    public DBUtils dbUtils(){
        return dbUtils;
    }
}

package com.techelevator.dao;

import com.techelevator.model.Restaurant;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class JdbcRestaurantDaoTests extends FinalCapstoneDaoTests {

    private JdbcRestaurantDao sut;

    @Before
    public void setup() {
        DataSource dataSource = this.getDataSource();
        sut = new JdbcRestaurantDao(dataSource);
    }


}

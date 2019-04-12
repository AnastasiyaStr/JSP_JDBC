package com.softserve.academy.dao.impl;

import com.softserve.academy.dao.GuideDao;
import com.softserve.academy.db.Database;
import com.softserve.academy.entity.GuideEntity;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class GuideDaoImpl implements GuideDao {
    @Override
    public boolean saveGuide(GuideEntity guide) {

        try (PreparedStatement insertToGuide = Database.getInstance()
                .getConnection()
                .prepareStatement("INSERT INTO guide(id_position,firstname,lastname)" +
                        "VALUES(?,?,?)")
        ) {
            insertToGuide.setInt(1, 2);
            insertToGuide.setString(2, guide.getFirstname());
            insertToGuide.setString(3, guide.getLastname());
            insertToGuide.execute();
            System.out.println("Successfully added new guide: " + guide.getFirstname() + " " + guide.getLastname());
        } catch (SQLException e) {
            System.out.println("Oh...");
            return false;
        }
        return true;
    }

    @Override
    public List<GuideEntity> readAllGuides() {
        return null;
    }

    @Override
    public int updateGuide(GuideEntity guide) {
        return 0;
    }

    @Override
    public int deleteGuide(int id_guide) {
        return 0;
    }
}

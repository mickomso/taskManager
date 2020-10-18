package com.company.taskManager.mapper;

import com.company.taskManager.domain.Task;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskRowMapper implements RowMapper<Task> {

    @Override
    public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
        Task task = new Task();
        task.setId(rs.getInt("id"));
        task.setTitle(rs.getString("title"));
        task.setDescription(rs.getString("description"));
        task.setCreated_on(rs.getDate("created_on"));
        task.setUpdated_on(rs.getDate("updated_on"));
        task.setCompleted(rs.getBoolean("completed"));
        return task;
    }
}

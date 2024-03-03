package com.MeowerTech.Meower.Todos;

import java.util.Date;

import com.MeowerTech.Meower.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TodoModel {
    private Long id;
    private String desc;
    private Date date;
    private boolean done;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}

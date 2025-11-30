package com.nk.todoApp.TodoApplication.Utility;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

import java.util.Date;



@Entity
@Data
@Getter
@Setter
public class TodoDTO {

    @Id
    @GeneratedValue
    private long id;

    private String taskName;

    private String priority;

    private Date targetDate;

}

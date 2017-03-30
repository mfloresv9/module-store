package com.mxi.maintsuite.to;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by marcelo on 27-03-17.
 */
@JsonRootName(value = "ScheduleDate")
@ApiModel(value = "ScheduleDate", description = "Schedule date associated to the task list ")
@Getter
@Setter
@ToString
@XmlRootElement
public class ScheduleDate implements Serializable{

    @NotNull
    @ApiModelProperty(value = "Date of defined limit for execution of task", required = true)
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd hh:mm:ss")
    @Getter @Setter
    public Date from;

    @NotNull
    @ApiModelProperty(value = "Date of defined limit for execution of task", required = true)
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd hh:mm:ss")
    @Getter @Setter
    public Date to;
}

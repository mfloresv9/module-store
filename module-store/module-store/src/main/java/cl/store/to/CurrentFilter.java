package com.mxi.maintsuite.to;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

/**
 * Created by marcelo on 29-03-17.
 */
@JsonRootName(value = "CurrentFilter")
@ApiModel(value = "CurrentFilter", description = "Information associated to an CurrentFilter")
@Getter
@Setter
@ToString
@XmlRootElement
public class CurrentFilter implements Serializable{

    private static final long serialVersionUID = 1L;

    @NotNull
    @ApiModelProperty(value = "Identifier of a task in the product Line Planning", required = true)
    @Getter @Setter
    public Long id;

    @ApiModelProperty(value = "filterType", required = false)
    private FilterType filterType;

    @NotNull
    @JsonProperty("userId")
    @ApiModelProperty(value = "Identifier for user", required = true)
    @Getter @Setter
    public Long userId;

    @NotNull
    @ApiModelProperty(value = "Date of current filter update", required = true)
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd hh:mm:ss")
    @Getter @Setter
    public Date update;

    @NotNull
    @JsonProperty("data")
    @ApiModelProperty(value = "Data of the filter", required = true)
    @Getter @Setter
    public Blob data;
}

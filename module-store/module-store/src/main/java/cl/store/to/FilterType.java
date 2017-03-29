package com.mxi.maintsuite.to;

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

/**
 * Created by marcelo on 29-03-17.
 */
@JsonRootName(value = "FilterType")
@ApiModel(value = "FilterType", description = "Information associated to an FilterType")
@Getter
@Setter
@ToString
@XmlRootElement
public class FilterType implements Serializable{

    private static final long serialVersionUID = 1L;

    @NotNull
    @ApiModelProperty(value = "Identifier of filter type in the product Line Planning")
    @Getter @Setter
    public Long id;

    @NotNull
    @JsonProperty("type")
    @ApiModelProperty(value = "Identifier for filter type", required = true)
    @Getter @Setter
    public Long type;
}

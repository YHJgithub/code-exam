package com.spzx.domain;

import com.spzx.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * 品牌
 */
@Data
@Schema(description = "品牌")
public class Brand extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Schema(description = "品牌名称")
    @NotBlank(message = "品牌名称不能为空")
    @Size(min = 0, max = 64, message = "品牌名称长度不能超过64个字符")
    private String name;

    @Schema(description = "品牌图标")
    @NotBlank(message = "品牌图标不能为空")
    @Size(min = 0, max = 200, message = "品牌图标长度不能超过200个字符")
    private String logo;

}

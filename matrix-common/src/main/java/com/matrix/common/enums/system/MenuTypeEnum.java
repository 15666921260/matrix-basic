package com.matrix.common.enums.system;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 菜单枚举类
 * @author liuweizhong
 * @since 2024-04-04
 */
@Getter
@AllArgsConstructor
public enum MenuTypeEnum {

    /**
     *
     */
    DIRECTORY(1, "目录", "1775806060151427073"),
    MENU(2, "菜单", "1775806105957421058"),
    AUTHOR(3, "权限(按钮)", "1775806184999079937")
    ;

    private final Integer menuType;

    private final String typeName;

    private final String typeId;

    /**
     * 根据type获取枚举数据
     * @param menuType type值
     * @return 返回结果集
     */
    public static MenuTypeEnum getMenuByType(Integer menuType) {
        for (MenuTypeEnum menuTypeEnum : values()) {
            if (menuTypeEnum.getMenuType().equals(menuType)) {
                return menuTypeEnum;
            }
        }
        return null;
    }

}

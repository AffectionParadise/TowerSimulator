package net.doge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.doge.constant.IconKey;

@Data
@AllArgsConstructor
public class Account {
    // 名称
    private String name;
    // 头像
    private IconKey avatar;
}

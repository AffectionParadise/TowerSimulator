package net.doge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.doge.constant.IconKey;
import net.doge.ui.widget.color.GColor;

import java.util.Objects;

@Data
@AllArgsConstructor
public class Noble {
    // 名称
    private String name;
    // 图标 key
    private IconKey iconKey;
    // 强调颜色
    private GColor highlightColor;
    // 要求物品
    private Item itemRequired;
    // 要求数量
    private int numRequired;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Noble noble = (Noble) o;
        return hashCode() == noble.hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, iconKey);
    }
}

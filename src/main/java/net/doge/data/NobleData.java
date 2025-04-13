package net.doge.data;

import net.doge.constant.IconKey;
import net.doge.model.Noble;
import net.doge.ui.widget.color.GColor;

import java.util.LinkedList;
import java.util.List;

/**
 * 贵族数据
 */
public class NobleData {
    // 贵族
    public static List<Noble> nobles = new LinkedList<>();

    static {
        initData();
    }

    private static void initData() {
        nobles.add(new Noble("星1", IconKey.NOBLE1, GColor.DEFAULT, ItemData.ADVANCED_COIN, 16000));
        nobles.add(new Noble("星2", IconKey.NOBLE1, GColor.DEFAULT, ItemData.ADVANCED_COIN, 32000));
        nobles.add(new Noble("星3", IconKey.NOBLE1, GColor.DEFAULT, ItemData.ADVANCED_COIN, 48000));
        nobles.add(new Noble("星4", IconKey.NOBLE1, GColor.DEFAULT, ItemData.ADVANCED_COIN, 64000));
        nobles.add(new Noble("星5", IconKey.NOBLE1, GColor.DEFAULT, ItemData.ADVANCED_COIN, 80000));
        nobles.add(new Noble("圣1", IconKey.NOBLE2, GColor.DEFAULT, ItemData.ADVANCED_COIN, 96000));
        nobles.add(new Noble("圣2", IconKey.NOBLE2, GColor.DEFAULT, ItemData.ADVANCED_COIN, 120000));
        nobles.add(new Noble("圣3", IconKey.NOBLE2, GColor.DEFAULT, ItemData.ADVANCED_COIN, 144000));
        nobles.add(new Noble("圣4", IconKey.NOBLE2, GColor.DEFAULT, ItemData.ADVANCED_COIN, 168000));
        nobles.add(new Noble("圣5", IconKey.NOBLE2, GColor.DEFAULT, ItemData.ADVANCED_COIN, 192000));
        nobles.add(new Noble("仙1", IconKey.NOBLE3, GColor.DEFAULT, ItemData.ADVANCED_COIN, 216000));
        nobles.add(new Noble("仙2", IconKey.NOBLE3, GColor.DEFAULT, ItemData.ADVANCED_COIN, 344000));
        nobles.add(new Noble("仙3", IconKey.NOBLE3, GColor.DEFAULT, ItemData.ADVANCED_COIN, 472000));
        nobles.add(new Noble("仙4", IconKey.NOBLE3, GColor.DEFAULT, ItemData.ADVANCED_COIN, 600000));
        nobles.add(new Noble("仙5", IconKey.NOBLE3, GColor.DEFAULT, ItemData.ADVANCED_COIN, 728000));
        nobles.add(new Noble("尊1", IconKey.NOBLE4, GColor.DEFAULT, ItemData.ADVANCED_COIN, 856000));
        nobles.add(new Noble("尊2", IconKey.NOBLE4, GColor.DEFAULT, ItemData.ADVANCED_COIN, 1176000));
        nobles.add(new Noble("尊3", IconKey.NOBLE4, GColor.DEFAULT, ItemData.ADVANCED_COIN, 1496000));
        nobles.add(new Noble("尊4", IconKey.NOBLE4, GColor.DEFAULT, ItemData.ADVANCED_COIN, 1816000));
        nobles.add(new Noble("尊5", IconKey.NOBLE4, GColor.DEFAULT, ItemData.ADVANCED_COIN, 2136000));
        nobles.add(new Noble("王1", IconKey.NOBLE5, GColor.NOBLE5_HIGHLIGHT, ItemData.ADVANCED_COIN, 2456000));
        nobles.add(new Noble("王2", IconKey.NOBLE5, GColor.NOBLE5_HIGHLIGHT, ItemData.ADVANCED_COIN, 3256000));
        nobles.add(new Noble("王3", IconKey.NOBLE5, GColor.NOBLE5_HIGHLIGHT, ItemData.ADVANCED_COIN, 4056000));
        nobles.add(new Noble("王4", IconKey.NOBLE5, GColor.NOBLE5_HIGHLIGHT, ItemData.ADVANCED_COIN, 4856000));
        nobles.add(new Noble("王5", IconKey.NOBLE5, GColor.NOBLE5_HIGHLIGHT, ItemData.ADVANCED_COIN, 5656000));
        nobles.add(new Noble("皇1", IconKey.NOBLE6, GColor.NOBLE6_HIGHLIGHT, ItemData.ADVANCED_COIN, 7256000));
        nobles.add(new Noble("皇2", IconKey.NOBLE6, GColor.NOBLE6_HIGHLIGHT, ItemData.ADVANCED_COIN, 10456000));
        nobles.add(new Noble("皇3", IconKey.NOBLE6, GColor.NOBLE6_HIGHLIGHT, ItemData.ADVANCED_COIN, 13656000));
        nobles.add(new Noble("皇4", IconKey.NOBLE6, GColor.NOBLE6_HIGHLIGHT, ItemData.ADVANCED_COIN, 16856000));
        nobles.add(new Noble("皇5", IconKey.NOBLE6, GColor.NOBLE6_HIGHLIGHT, ItemData.ADVANCED_COIN, 20056000));
        nobles.add(new Noble("神1", IconKey.NOBLE7, GColor.NOBLE7_HIGHLIGHT, ItemData.ADVANCED_COIN, 26456000));
        nobles.add(new Noble("神2", IconKey.NOBLE7, GColor.NOBLE7_HIGHLIGHT, ItemData.ADVANCED_COIN, 39256000));
        nobles.add(new Noble("神3", IconKey.NOBLE7, GColor.NOBLE7_HIGHLIGHT, ItemData.ADVANCED_COIN, 52056000));
        nobles.add(new Noble("神4", IconKey.NOBLE7, GColor.NOBLE7_HIGHLIGHT, ItemData.ADVANCED_COIN, 64856000));
        nobles.add(new Noble("神5", IconKey.NOBLE7, GColor.NOBLE7_HIGHLIGHT, ItemData.ADVANCED_COIN, 77656000));
        nobles.add(new Noble("神6", IconKey.NOBLE7, GColor.NOBLE7_HIGHLIGHT, ItemData.ADVANCED_COIN, 90456000));
        nobles.add(new Noble("神7", IconKey.NOBLE7, GColor.NOBLE7_HIGHLIGHT, ItemData.ADVANCED_COIN, 108456000));
        nobles.add(new Noble("神8", IconKey.NOBLE7, GColor.NOBLE7_HIGHLIGHT, ItemData.ADVANCED_COIN, 122456000));
    }

    public static int find(Noble noble) {
        int res = -1;
        for (int i = 0, s = nobles.size(); i < s; i++) {
            if (nobles.get(i).equals(noble)) res = i;
        }
        return res;
    }

    public static boolean isLast(Noble noble) {
        return nobles.get(nobles.size() - 1).equals(noble);
    }
}

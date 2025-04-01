//package net.doge;
//
//import java.util.List;
//
//public class TowerTest {
//    public static void main(String[] args) {
//        TowerPrizeGenerator tpg = new TowerPrizeGenerator();
//        tpg.addModel(new PrizeModel("199币", 33, 0.01));
//        tpg.addModel(new PrizeModel("99币", 33, 0.03));
//        tpg.addModel(new PrizeModel("66币", 32, 0.05));
//        tpg.addModel(new PrizeModel("18币", 32, 0.1));
//        tpg.addModel(new PrizeModel("10币", 32, 0.1));
//        tpg.addModel(new PrizeModel("雕像", 32, 0.1));
//        tpg.addModel(new PrizeModel("三塔牌子", 32, 0.08));
//        tpg.addModel(new PrizeModel("2塔牌子", 32, 0.1));
//        tpg.addModel(new PrizeModel("30蘑菇", 32, 0.1));
//        tpg.addModel(new PrizeModel("赠送", 32, 0.1));
//
//        tpg.addModel(new PrizeModel("全屏", 31, 0.008));
//        tpg.addModel(new PrizeModel("传说", 33, 0.01));
//        tpg.addModel(new PrizeModel("300蘑菇", 32, 0.1));
//        tpg.addModel(new PrizeModel("大礼物宝盒", 33, 0.006));
//        tpg.addModel(new PrizeModel("中礼物宝盒", 31, 0.08));
//        tpg.addModel(new PrizeModel("小礼物宝盒", 32, 0.01));
//        tpg.addModel(new PrizeModel("9999金蘑菇", 33, 0.0008));
//        tpg.addModel(new PrizeModel("金", 31, 0.008));
//
//        tpg.addModel(new PrizeModel("黑洞", 35, 0.0005));
//        tpg.addModel(new PrizeModel("辉煌", 35, 0.006));
//        tpg.addModel(new PrizeModel("玫瑰跑车", 35, 0.0005));
//        tpg.addModel(new PrizeModel("天使号", 35, 0.0003));
//        tpg.addModel(new PrizeModel("千机伞", 35, 0.0003));
//        tpg.addModel(new PrizeModel("嘉年华", 35, 0.0001));
//        tpg.addModel(new PrizeModel("骨头", 35, 0.00005));
//        tpg.addModel(new PrizeModel("丘比特", 35, 0.00005));
//        tpg.addModel(new PrizeModel("王子", 35, 0.00005));
//        tpg.addModel(new PrizeModel("公主", 35, 0.00005));
//
//        List<PrizeModel> models = tpg.getModels();
//        double t = 0;
//        for (PrizeModel model : models) {
//            t += model.getProbability();
//        }
//        System.out.println(t);
//
//        int r = 100, c = 100;
//        PrizeModel[][] tower = new PrizeModel[r][c];
//        for (int i = 0; i < r; i++) {
//            for (int j = 0; j < c; j++) {
//                tower[i][j] = tpg.lottery();
//                System.out.printf("\033[%dm%s\033[0m ", tower[i][j].getColor(), tower[i][j].getName());
//            }
//            System.out.println();
//        }
//    }
//}

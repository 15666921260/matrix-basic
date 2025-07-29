package com.matrix.common.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author liuweizhong
 * @since 2025-07-29 09:23
 */
public class RandomCollectionGenerator {

    /**
     * 生成不重复随机整数集合
     * @param size 集合长度（必须满足 size ≤ max - min + 1）
     * @param min 最小值（包含）
     * @param max 最大值（包含）
     * @return List<Integer> 不重复随机整数集合
     */
    public static List<Integer> generate(int size, int min, int max) {
        // 校验参数合法性
        ThrowUtils.throwIf(min > max, "max必须大于min");
        int range = max - min + 1;
        ThrowUtils.throwIf(size > range, "集合长度不能超过整数范围");

        // 生成连续整数序列 [min, max]
        List<Integer> numbers = new ArrayList<>(range);
        for (int i = min; i <= max; i++) {
            numbers.add(i);
        }

        // Fisher-Yates 洗牌算法打乱顺序
        for (int i = range - 1; i > 0; i--) {
            int j = ThreadLocalRandom.current().nextInt(i + 1);
            Collections.swap(numbers, i, j);
        }

        // 截取前 size 个元素
        return numbers.subList(0, size);
    }
}

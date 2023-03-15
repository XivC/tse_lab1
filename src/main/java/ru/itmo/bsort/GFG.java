package ru.itmo.bsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class GFG {
    public static List<Float>[] fillBuckets(List<Float> arr) {
        int n = arr.size();
        if (n == 0) return new List[]{};

        List<Float>[] buckets = new List[n];
        Float min = Collections.min(arr) - 1;
        Float max = Collections.max(arr) + 1;
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (Float aFloat : arr) {
            float idx = ((aFloat - min) / (max - min)) * n;
            buckets[(int) idx].add(aFloat);
        }
        return buckets;
    }
    public static void sortBuckets(List<Float>[] buckets) {
        for (List<Float> bucket : buckets) {
            Collections.sort(bucket);
        }
    }
    public static List<Float> concatBuckets(List<Float>[] buckets) {
        // 4) Concatenate all buckets into arr[]
        List<Float> arr = new ArrayList<>();
        for (List<Float> bucket : buckets) {
            arr.addAll(bucket);
        }
        return arr;
    }
    public static List<Float> sort(List<Float> arr) {
        List<Float>[] buckets = fillBuckets(arr);
        sortBuckets(buckets);
        return concatBuckets(buckets);
    }
}

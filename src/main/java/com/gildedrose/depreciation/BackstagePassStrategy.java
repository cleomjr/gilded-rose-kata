package com.gildedrose.depreciation;

import com.gildedrose.Item;

public class BackstagePassStrategy implements DepreciationStrategy {

    @Override
    public void update(Item item) {
        item.quality++;
        item.sellIn--;

        item.quality = item.sellIn <= 10? item.quality + 1 : item.quality;
        item.quality = item.sellIn <= 5? item.quality + 1 : item.quality;
        item.quality = item.sellIn < 0? 0 : item.quality;

        item.quality = Math.max(item.quality, DEFAULT_LOWER_QUALITY_LEVEL);
        item.quality = Math.min(item.quality, DEFAULT_HIGHER_QUALITY_LEVEL);
    }
}

package com.gildedrose.depreciation;

import com.gildedrose.Item;

public class DefaultStrategy implements DepreciationStrategy{

    @Override
    public void update(Item item) {
        item.quality--;
        item.sellIn--;

        item.quality = item.sellIn < 0? item.quality - 1 : item.quality;
        item.quality = Math.max(item.quality, DEFAULT_LOWER_QUALITY_LEVEL);
        item.quality = Math.min(item.quality, DEFAULT_HIGHER_QUALITY_LEVEL);
    }
}

package com.gildedrose.depreciation;

import com.gildedrose.Item;

public class AgedBrieStrategy implements DepreciationStrategy {

    @Override
    public void update(Item item) {
        item.quality++;
        item.sellIn--;

        item.quality = Math.max(item.quality, DEFAULT_LOWER_QUALITY_LEVEL);
        item.quality = Math.min(item.quality, DEFAULT_HIGHER_QUALITY_LEVEL);
    }
}

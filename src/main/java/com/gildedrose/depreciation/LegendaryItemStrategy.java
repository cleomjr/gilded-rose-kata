package com.gildedrose.depreciation;

import com.gildedrose.Item;

public class LegendaryItemStrategy implements DepreciationStrategy {
    final int LEGENDARY_ITEM_QUALITY_LEVEL = 80;

    @Override
    public void update(Item item) {
        item.quality = LEGENDARY_ITEM_QUALITY_LEVEL;
    }
}

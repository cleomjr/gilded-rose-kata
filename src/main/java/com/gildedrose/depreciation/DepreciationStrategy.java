package com.gildedrose.depreciation;

import com.gildedrose.Item;

/**
 * Depreciation Strategy
 *
 * Provides different quality handling depending on the item type
 */
public interface DepreciationStrategy {
    int DEFAULT_HIGHER_QUALITY_LEVEL = 50;
    int DEFAULT_LOWER_QUALITY_LEVEL = 0;

    void update(Item item);
}

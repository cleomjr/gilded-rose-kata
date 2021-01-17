package com.gildedrose;

import com.gildedrose.depreciation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class QualityUpdater {

    private static final Map<String, Supplier<DepreciationStrategy>> STRATEGY;
    static {
        final Map<String, Supplier<DepreciationStrategy>> strategies = new HashMap<>();
        strategies.put("Aged Brie", AgedBrieStrategy::new);
        strategies.put("Backstage passes to a TAFKAL80ETC concert", BackstagePassStrategy::new);
        strategies.put("Conjured Mana Cake", ConjuredItemStrategy::new);
        strategies.put("Sulfuras, Hand of Ragnaros", LegendaryItemStrategy::new);

        STRATEGY = Collections.unmodifiableMap(strategies);
    }

    public DepreciationStrategy chooseStrategy(String itemName) {
        Supplier<DepreciationStrategy> strategySupplier = STRATEGY.get(itemName);
        strategySupplier = strategySupplier == null? DefaultStrategy::new : strategySupplier;
        return strategySupplier.get();
    }
}

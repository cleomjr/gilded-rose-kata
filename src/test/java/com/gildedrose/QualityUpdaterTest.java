package com.gildedrose;

import com.gildedrose.depreciation.DefaultStrategy;
import com.gildedrose.depreciation.LegendaryItemStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QualityUpdaterTest {

    @Test
    void qualityUpdater_returnsDefaultStrategy_whenItemNameNotFound() {
        Assertions.assertEquals(
                DefaultStrategy.class,
                new QualityUpdater().chooseStrategy("foo").getClass());
    }

    @Test
    void qualityUpdater_returnsLegendaryItemStrategy_whenSulfuras() {
        Assertions.assertEquals(
                LegendaryItemStrategy.class,
                new QualityUpdater().chooseStrategy("Sulfuras, Hand of Ragnaros").getClass());
    }
}

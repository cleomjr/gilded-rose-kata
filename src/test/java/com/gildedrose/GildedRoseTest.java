package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void updateQuality_qualityDegrades() {
        GildedRose app = new GildedRose(new Item[] { new Item("foo", 1, 2) });
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void updateQuality_qualityDegradesTwice_whenAfterDate() {
        GildedRose app = new GildedRose(new Item[] { new Item("foo", 0, 2) });
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void updateQuality_qualityNeverNegative() {
        GildedRose app = new GildedRose(new Item[] { new Item("foo", 2, 0) });
        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void updateQuality_increasesBrieQuality() {
        GildedRose app = new GildedRose(new Item[] { new Item("Aged Brie", 20, 10) });
        app.updateQuality();
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void updateQuality_returnsBrieMaxQuality() {
        GildedRose app = new GildedRose(new Item[] { new Item("Aged Brie", 20, 50) });
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void updateQuality_returnsMaxQuality() {
        GildedRose app = new GildedRose(new Item[] { new Item("foo", 30, 80) });
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void updateQuality_returnsLegendaryQualityAndDateNeverChange_whenLegendary() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 30, -80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(30, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void updateQuality_passQualityIncreases_whenMoreThan10() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 20, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void updateQuality_passQualityIncreasesTwice_whenLessThan10() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void updateQuality_passQualityIncreasesTrice_whenLessThan5() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].quality);
    }

    @Test
    void updateQuality_passQualityIsZero_whenAfterConcert() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void updateQuality_conjuredQualityDegradesTwice_whenBeforeDate() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 3, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void updateQuality_conjuredQualityDegrades4Times_whenAfterDate() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6, app.items[0].quality);
    }

}

package com.gildedrose;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GildedRoseTest {

    @Test
    public void foo() {
        final Item[] items = initItems();
        final Item[] items_copy = initItems();

        GildedRose app = new GildedRose(items);
        OldGildedRose oldApp = new OldGildedRose(items_copy);

        int days = 1000;

        for (int i = 0; i < days; i++) {

            for(int n = 0; n < items.length; n++) {
                assertThat(items[n].name).isEqualTo(items_copy[n].name);
                assertThat(items[n].quality).isEqualTo(items_copy[n].quality);
                assertThat(items[n].sellIn).isEqualTo(items_copy[n].sellIn);
            }

            app.updateQuality();
            oldApp.updateQuality();
        }
    }

    private Item[] initItems() {
        return new Item[]{
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6)};
    }

}

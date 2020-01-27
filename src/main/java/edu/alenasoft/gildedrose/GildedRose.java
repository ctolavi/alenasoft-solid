package edu.alenasoft.gildedrose;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


import static edu.alenasoft.gildedrose.ItemType.*;

public class GildedRose {

    public static List<Item> items = new ArrayList<>();

    private static final int NORMAL_DECREMENT = 1;

    private static final int DOUBLE_DECREMENT = 2;

    private static final int CONJURED_NORMAL_DECREMENT = 2;

    private static final int CONJURED_DOUBLE_DECREMENT = 4;

    private static final int NORMAL_INCREMENT = 1;

    private static final int DOUBLE_INCREMENT = 2;

    private static final int TRIPLE_INCREMENT = 3;

    private static final int LIMIT_TO_DOUBLE_INCREMENT = 10;

    private static final int LIMIT_TO_TRIPLE_INCREMENT = 5;

    private static final int MAX_QUALITY = 50;

    private static final Logger LOGGER = Logger.getLogger(GildedRose.class.getName());

    public static void main(String[] args) {

        items.add(new Item("+5 Dexterity Vest", 10, 20, NORMAL));
        items.add(new Item("Aged Brie", 2, 0, VINTAGE));
        items.add(new Item("Elixir of the Mongoose", 5, 7, NORMAL));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80, LEGENDARY));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20, VINTAGE));
        items.add(new Item("Conjured Mana Cake", 3, 6, CONJURED));

        updateQuality();
    }

    public static void updateQuality() {

        for (Item item : items) {
            switch (item.getItemType()) {
                case NORMAL:
                    decreaseQuality(item, NORMAL_DECREMENT, DOUBLE_DECREMENT);
                    break;
                case VINTAGE:
                    descreaseQualityVintage(item);
                    break;
                case CONJURED:
                    decreaseQuality(item, CONJURED_NORMAL_DECREMENT, CONJURED_DOUBLE_DECREMENT);
                    break;
                case LEGENDARY:
                    LOGGER.log(Level.INFO, "Legendary item {0} does not change its quality", item.getName());
                    break;
                default:
                    LOGGER.log(Level.WARNING, "Item {0} does not have type, skipping the update of quality for this item.", item.getName());
            }
        }
    }

    private static void decreaseQuality(Item item, int normalDecrement, int doubleDecrement) {
        int delta = item.getSellIn() > 0 ? normalDecrement : doubleDecrement;
        item.setQuality((item.getQuality() - delta) <= 1 ? 0 : item.getQuality() - delta);
    }

    private static void descreaseQualityVintage(Item item) {
        int delta;
        if (item.getSellIn() <= 0) {
            item.setQuality(0);
            return;
        } else {
            if (item.getSellIn() <= LIMIT_TO_DOUBLE_INCREMENT) {
                delta = item.getSellIn() <= LIMIT_TO_TRIPLE_INCREMENT ? TRIPLE_INCREMENT : DOUBLE_INCREMENT;
            } else {
                delta = NORMAL_INCREMENT;
            }
        }
        item.setQuality((item.getQuality() + delta) >= MAX_QUALITY ? MAX_QUALITY : item.getQuality() + delta);
    }
}

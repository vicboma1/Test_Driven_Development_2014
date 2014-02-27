package com.akamon.tdd.gildedRoseRefactor.fixture;

import com.akamon.tdd.gildedRoseRefactor.glidedRose.GildedRose;
import com.akamon.tdd.gildedRoseRefactor.glidedRose.IGildedRose;
import com.akamon.tdd.gildedRoseRefactor.item.Item;

import java.util.*;

public class TexttestFixture 
{

	private static final String DEXTERITY_VEST = "+5 Dexterity Vest";
	private static final String AGED_BRIE = "Aged Brie";
	private static final String ELIXIR_OF_THE_MONGOOSE = "Elixir of the Mongoose";
	private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
	private static final String BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
	private static final String CONJURED_MANA_CAKE = "Conjured Mana Cake";
	private static final String NAME_SELL_IN_QUALITY = "name, sellIn, quality";
	private static final String DAY = "-------- day ";
	private static final String STRING = " --------";
	private static final String OMGHAI = "OMGHAI!";
	private static final String VALUE_NULLABLE = "";

	private static IGildedRose app;
	private static List<Item> items;

	private static int days = 2;

	public static void main(String[] args)
    {
	    obtainDays(args);
	    initialize();
	    updateQuality();
	    printDayItems();
    }

	private static void printDayItems()
	{
		print(OMGHAI);

		for (int i = 0; i < days; i++)
	    {
		    print(DAY + i + STRING);
		    print(NAME_SELL_IN_QUALITY);
		    printItems();
		    print(VALUE_NULLABLE);
		    updateQuality();
	    }
	}

	private static void printItems()
	{
		for (Item item : items)
		{
			print(item);
		}
	}

	private static void obtainDays(String[] args)
	{
		if (args.length > 0)
		{
		    days = Integer.parseInt(args[0]) + 1;
		}
	}

	private static void updateQuality()
	{
		for(int i = 0; i<items.size(); i++)
			   app.updateQuality(items.get(i));
	}

	private static void initialize()
	{
		items();
		gildedRose();
	}

	private static void gildedRose()
	{
		app = GildedRose.create();
	}

	private static void items()
	{
		items = new ArrayList<Item>()
		    {
			    {
				    add( new Item(DEXTERITY_VEST, 10, 20));
				    add( new Item(AGED_BRIE, 2, 0));
				    add( new Item(ELIXIR_OF_THE_MONGOOSE, 5, 7));
				    add( new Item(SULFURAS_HAND_OF_RAGNAROS, 0, 80));
				    add( new Item(SULFURAS_HAND_OF_RAGNAROS, -1, 80));
				    add( new Item(BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT, 15, 20));
				    add( new Item(BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT, 10, 49));
				    add( new Item(BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT, 5, 49));
					add( new Item(CONJURED_MANA_CAKE, 3, 6));
			    }
		    };
	}

	private static void print(Object value)
	{
		System.out.println(value);
	}

}

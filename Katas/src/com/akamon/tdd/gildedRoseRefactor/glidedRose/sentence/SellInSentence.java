package com.akamon.tdd.gildedRoseRefactor.glidedRose.sentence;

import com.akamon.tdd.gildedRoseRefactor.glidedRose.GildedRose;
import com.akamon.tdd.gildedRoseRefactor.item.Item;

/**
 * Created with IntelliJ IDEA.
 * User: vicboma
 * Date: 22/02/14
 * Time: 19:59
 * To change this template use File | Settings | File Templates.
 */
public class SellInSentence implements ISentence
{
	@Override
	public void sentence(Item item)
	{
		final boolean isNotSulfuras = !item.name.equals(GildedRose.SULFURAS_HAND_OF_RAGNAROS);

		if (isNotSulfuras)
			item.sellIn--;
	}
}

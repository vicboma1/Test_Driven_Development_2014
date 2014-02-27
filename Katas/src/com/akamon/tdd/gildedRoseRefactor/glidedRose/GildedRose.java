package com.akamon.tdd.gildedRoseRefactor.glidedRose;

import com.akamon.tdd.gildedRoseRefactor.glidedRose.sentence.ISentence;
import com.akamon.tdd.gildedRoseRefactor.glidedRose.sentence.ManipulateAndResetQualitySentence;
import com.akamon.tdd.gildedRoseRefactor.glidedRose.sentence.ManipulateQuailySentence;
import com.akamon.tdd.gildedRoseRefactor.glidedRose.sentence.SellInSentence;
import com.akamon.tdd.gildedRoseRefactor.item.Item;

import java.util.*;

public class GildedRose{

	public static final int QUALITY_UPPER_LIMIT = 50;
	public static final int QUALITY_LOWER_LIMIT = 0;
	public static final int QUALITY_RESET_LIMIT = QUALITY_LOWER_LIMIT;

	public static final String AGED_BRIE = "Aged Brie";
	public static final String BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
	public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

	public static IGildedRose create()
    {
	    return new GildedRoseImpl(new ArrayList<ISentence>()
		    {
			    {
				    add(new ManipulateQuailySentence());
				    add(new SellInSentence());
				    add(new ManipulateAndResetQualitySentence());

			    }
		    }
	    );
    }

}
class GildedRoseImpl implements IGildedRose
{
	private List<ISentence> sentenceList;

	public GildedRoseImpl(List<ISentence> sentenceList)
	{
		this.sentenceList = sentenceList;
	}

	public void updateQuality(Item item)
    {
        for(ISentence sentence : sentenceList)
        {
	        sentence.sentence(item);
        }
    }

}

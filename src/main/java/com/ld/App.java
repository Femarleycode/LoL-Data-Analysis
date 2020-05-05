package com.ld;

import java.util.List;

import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Queue;
import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.championmastery.ChampionMasteries;
import com.merakianalytics.orianna.types.core.championmastery.ChampionMastery;
import com.merakianalytics.orianna.types.core.championmastery.ChampionMasteryScore;
import com.merakianalytics.orianna.types.core.league.League;
import com.merakianalytics.orianna.types.core.league.Leagues;
import com.merakianalytics.orianna.types.core.staticdata.Champion;
import com.merakianalytics.orianna.types.core.staticdata.Champions;
import com.merakianalytics.orianna.types.core.summoner.Summoner;

public class App {
    public static void main(String[] args) {

        Orianna.Configuration config = new Orianna.Configuration();
        Orianna.setDefaultRegion(Region.NORTH_AMERICA);

        Summoner summoner = Orianna.summonerNamed("FatalElement").get();
        System.out.println(summoner.getName() + " is level " + summoner.getLevel() + " on the " + summoner.getRegion() + " server.");

        Champions champions = Orianna.getChampions();
        Champion randomChampion = champions.get((int) (Math.random() * champions.size()));
        System.out.println("He enjoys playing champions such as " + randomChampion.getName());

        League challengerLeague = Orianna.challengerLeagueInQueue(Queue.RANKED_SOLO).get();
        Summoner bestNA = challengerLeague.get(0).getSummoner();
        System.out.println("He's not as good as " + bestNA.getName() + " at League, but probably a better Java programmer!");

        //experimentation below

        //Scarra
        Summoner summoner2 = Orianna.summonerNamed("Scarra").get();

        //Random
        System.out.println(summoner2.getName() + " is on " + summoner2.getRegion() + " and is level " + summoner2.getLevel() + ".");

        //Get rank 2 NA
        Summoner secBestNA = challengerLeague.get(1).getSummoner();
        System.out.println("Rank 2 is " );

        //Print list of challengers in EUW
        League challengerList = League.challengerInQueue(Queue.RANKED_SOLO).withRegion(Region.EUROPE_WEST).get();


        List<Summoner> summoners = Orianna.summonersNamed("FatalElement", "Kalturi").withRegion(Region.NORTH_AMERICA).get();
        List<Champion> champions2 = Orianna.championsNamed("Annie", "Thresh").withRegion(Region.NORTH_AMERICA).get();



        League challenger = League.challengerInQueue(Queue.RANKED_SOLO).withRegion(Region.EUROPE_WEST).get();
        System.out.println("aaaa" + challenger.toString());

        //how to list them?


    }
}

package com.jakelauer.baseballtheater.MlbDataServer.DataStructures;

import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

/**
 * Created by Jake on 1/13/2017.
 */

@Root(name = "game", strict = false)
public class GameSummary implements Serializable {
    @Attribute
    public String id;

    @Attribute(name = "game_pk")
    public int gamePk;

    @Attribute(name = "time_date")
    public String date;

    public DateTime dateObj() {
        DateTimeFormatter f = DateTimeFormat.forPattern("yyyy/MM/dd h:m");
        return f.parseDateTime(date);
    }

    public LocalDateTime localDateObj() {
        DateTimeFormatter f = DateTimeFormat.forPattern("yyyy/MM/dd h:m Z");
        return f.parseDateTime(date + " -0400").toLocalDateTime();
    }

    @Attribute(name = "game_type")
    public String gameType;

    @Attribute(name = "time")
    public String eventTime;

    @Attribute(name = "ampm")
    public String eventTimeAmPm;

    @Attribute(name = "time_zone")
    public String timeZone;

    @Element
    public GameStatus status;

    @Attribute
    public String league;

    @Attribute(name = "away_name_abbrev")
    public String awayTeamNameAbbr;

    @Attribute(name = "away_team_name")
    public String awayTeamName;

    @Attribute(name = "away_file_code")
    public String awayFileCode;

    @Attribute(name = "home_name_abbrev")
    public String homeTeamNameAbbr;

    @Attribute(name = "home_team_name")
    public String homeTeamName;

    @Attribute(name = "home_file_code")
    public String homeFileCode;

    @Attribute(name = "game_data_directory")
    public String gameDataDirectory;

    @Element(required = false)
    public Linescore linescore;

    @Attribute
    public String home_win;

    @Attribute
    public String home_loss;

    @Attribute
    public String away_win;

    @Attribute
    public String away_loss;
}

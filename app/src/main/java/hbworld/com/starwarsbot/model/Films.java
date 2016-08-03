package hbworld.com.starwarsbot.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hbworld_new on 8/3/2016.
 */
public class Films implements Parcelable {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("episode_id")
    @Expose
    private Integer episodeId;
    @SerializedName("opening_crawl")
    @Expose
    private String openingCrawl;
    @SerializedName("director")
    @Expose
    private String director;
    @SerializedName("producer")
    @Expose
    private String producer;
    @SerializedName("release_date")
    @Expose
    private String releaseDate;
    @SerializedName("characters")
    @Expose
    private List<String> characters = new ArrayList<String>();
    @SerializedName("planets")
    @Expose
    private List<String> planets = new ArrayList<String>();
    @SerializedName("starships")
    @Expose
    private List<String> starships = new ArrayList<String>();
    @SerializedName("vehicles")
    @Expose
    private List<Object> vehicles = new ArrayList<Object>();
    @SerializedName("species")
    @Expose
    private List<String> species = new ArrayList<String>();
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("edited")
    @Expose
    private String edited;
    @SerializedName("url")
    @Expose
    private String url;

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The episodeId
     */
    public Integer getEpisodeId() {
        return episodeId;
    }

    /**
     *
     * @param episodeId
     * The episode_id
     */
    public void setEpisodeId(Integer episodeId) {
        this.episodeId = episodeId;
    }

    /**
     *
     * @return
     * The openingCrawl
     */
    public String getOpeningCrawl() {
        return openingCrawl;
    }

    /**
     *
     * @param openingCrawl
     * The opening_crawl
     */
    public void setOpeningCrawl(String openingCrawl) {
        this.openingCrawl = openingCrawl;
    }

    /**
     *
     * @return
     * The director
     */
    public String getDirector() {
        return director;
    }

    /**
     *
     * @param director
     * The director
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     *
     * @return
     * The producer
     */
    public String getProducer() {
        return producer;
    }

    /**
     *
     * @param producer
     * The producer
     */
    public void setProducer(String producer) {
        this.producer = producer;
    }

    /**
     *
     * @return
     * The releaseDate
     */
    public String getReleaseDate() {
        return releaseDate;
    }

    /**
     *
     * @param releaseDate
     * The release_date
     */
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     *
     * @return
     * The characters
     */
    public List<String> getCharacters() {
        return characters;
    }

    /**
     *
     * @param characters
     * The characters
     */
    public void setCharacters(List<String> characters) {
        this.characters = characters;
    }

    /**
     *
     * @return
     * The planets
     */
    public List<String> getPlanets() {
        return planets;
    }

    /**
     *
     * @param planets
     * The planets
     */
    public void setPlanets(List<String> planets) {
        this.planets = planets;
    }

    /**
     *
     * @return
     * The starships
     */
    public List<String> getStarships() {
        return starships;
    }

    /**
     *
     * @param starships
     * The starships
     */
    public void setStarships(List<String> starships) {
        this.starships = starships;
    }

    /**
     *
     * @return
     * The vehicles
     */
    public List<Object> getVehicles() {
        return vehicles;
    }

    /**
     *
     * @param vehicles
     * The vehicles
     */
    public void setVehicles(List<Object> vehicles) {
        this.vehicles = vehicles;
    }

    /**
     *
     * @return
     * The species
     */
    public List<String> getSpecies() {
        return species;
    }

    /**
     *
     * @param species
     * The species
     */
    public void setSpecies(List<String> species) {
        this.species = species;
    }

    /**
     *
     * @return
     * The created
     */
    public String getCreated() {
        return created;
    }

    /**
     *
     * @param created
     * The created
     */
    public void setCreated(String created) {
        this.created = created;
    }

    /**
     *
     * @return
     * The edited
     */
    public String getEdited() {
        return edited;
    }

    /**
     *
     * @param edited
     * The edited
     */
    public void setEdited(String edited) {
        this.edited = edited;
    }

    /**
     *
     * @return
     * The url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     * The url
     */
    public void setUrl(String url) {
        this.url = url;
    }


    protected Films(Parcel in) {
        title = in.readString();
        episodeId = in.readByte() == 0x00 ? null : in.readInt();
        openingCrawl = in.readString();
        director = in.readString();
        producer = in.readString();
        releaseDate = in.readString();
        if (in.readByte() == 0x01) {
            characters = new ArrayList<String>();
            in.readList(characters, String.class.getClassLoader());
        } else {
            characters = null;
        }
        if (in.readByte() == 0x01) {
            planets = new ArrayList<String>();
            in.readList(planets, String.class.getClassLoader());
        } else {
            planets = null;
        }
        if (in.readByte() == 0x01) {
            starships = new ArrayList<String>();
            in.readList(starships, String.class.getClassLoader());
        } else {
            starships = null;
        }
        if (in.readByte() == 0x01) {
            vehicles = new ArrayList<Object>();
            in.readList(vehicles, Object.class.getClassLoader());
        } else {
            vehicles = null;
        }
        if (in.readByte() == 0x01) {
            species = new ArrayList<String>();
            in.readList(species, String.class.getClassLoader());
        } else {
            species = null;
        }
        created = in.readString();
        edited = in.readString();
        url = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        if (episodeId == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(episodeId);
        }
        dest.writeString(openingCrawl);
        dest.writeString(director);
        dest.writeString(producer);
        dest.writeString(releaseDate);
        if (characters == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(characters);
        }
        if (planets == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(planets);
        }
        if (starships == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(starships);
        }
        if (vehicles == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(vehicles);
        }
        if (species == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(species);
        }
        dest.writeString(created);
        dest.writeString(edited);
        dest.writeString(url);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Films> CREATOR = new Parcelable.Creator<Films>() {
        @Override
        public Films createFromParcel(Parcel in) {
            return new Films(in);
        }

        @Override
        public Films[] newArray(int size) {
            return new Films[size];
        }
    };
}

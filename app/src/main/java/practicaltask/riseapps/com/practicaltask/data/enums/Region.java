package practicaltask.riseapps.com.practicaltask.data.enums;

public enum Region {
    AFRICA("Africa", "africa"),
    AMERICAS("Americas", "americas"),
    ASIA("Asia", "asia"),
    EUROPE("Europe", "europe"),
    OCEANIA("Oceania", "oceania");

    private String title;
    private String codeName;

    private Region(String title, String codeName) {
        this.title = title;
        this.codeName = codeName;
    }

    public String getTitle() {
        return title;
    }

    public String getCodeName() {
        return codeName;
    }

    public static Region getByCodeName(String codeName) {
        for(Region region : values()) {
            if(region.getCodeName().equalsIgnoreCase(codeName)){
                return region;
            }
        }
        return null;
    }
}

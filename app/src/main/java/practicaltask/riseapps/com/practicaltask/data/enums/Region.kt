package practicaltask.riseapps.com.practicaltask.data.enums

enum class Region constructor(val title: String, val codeName: String) {
    AFRICA("Africa", "africa"),
    AMERICAS("Americas", "americas"),
    ASIA("Asia", "asia"),
    EUROPE("Europe", "europe"),
    OCEANIA("Oceania", "oceania");


    companion object {

        fun getByCodeName(codeName: String): Region? {
            for (region in values()) {
                if (region.codeName.equals(codeName, ignoreCase = true)) {
                    return region
                }
            }
            return null
        }
    }
}

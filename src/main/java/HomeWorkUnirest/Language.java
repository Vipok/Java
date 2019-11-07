package HomeWorkUnirest;

public enum Language {
    ru("Русский"),
    en("Английский"),
    it("Итальянский"),
    es("Испанский");

    private String languageRus;

    public String getLanguageRus() {
        return languageRus;
    }

    Language(String getLanguageRus) {
        this.languageRus = getLanguageRus;
    }
}

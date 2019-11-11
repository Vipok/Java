package HomeWorkUnirest;

import lombok.Getter;

public enum Language {
    RU("Русский") {
        @Override
        String getLanguage() {
            return "ru";
        }
    },
    EN("Английский") {
        @Override
        String getLanguage() {
            return "en";
        }
    },
    IT("Итальянский") {
        @Override
        String getLanguage() {
            return "it";
        }
    },
    ES("Испанский") {
        @Override
        String getLanguage() {
            return "es";
        }
    };

    @Getter
    private String value;

    abstract String getLanguage();

    Language(String s) {
        value = s;
    }
}

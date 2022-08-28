package com.example.qurandatabaseapp;

public class QuranDisplayModelData {
    String Arabic,Translation;

    public QuranDisplayModelData(String arabic, String translation) {
        Arabic = arabic;
        Translation = translation;
    }

    public String getArabic() {
        return Arabic;
    }

    public void setArabic(String arabic) {
        Arabic = arabic;
    }

    public String getTranslation() {
        return Translation;
    }

    public void setTranslation(String translation) {
        Translation = translation;
    }
}

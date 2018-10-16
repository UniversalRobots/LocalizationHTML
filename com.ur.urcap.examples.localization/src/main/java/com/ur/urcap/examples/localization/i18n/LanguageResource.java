package com.ur.urcap.examples.localization.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageResource {
	private final static String fileName = "com/ur/urcap/examples/localization/impl/i18n/languages/languages";
	private ResourceBundle resource;
	private final String localLanguage;
	private final String localProgrammingLanguage;

	public LanguageResource(Locale locale, String programmingLanguage) {
		locale = locale.equals(LanguagePack.rootLanguageLocale) ? Locale.ROOT : locale;
		resource = ResourceBundle.getBundle(fileName, locale, new UTF8Control());
		localLanguage = (locale == Locale.ROOT) ? LanguagePack.rootLanguageLocale.getLanguage() : locale.getLanguage();
		this.localProgrammingLanguage = programmingLanguage.isEmpty() ? LanguagePack.rootLanguageLocale.getLanguage() : programmingLanguage;
	}

	public String localeLanguage() {
		return getStringByKey(localLanguage);
	}

	public String localeProgrammingLanguage() {
		return getStringByKey(localProgrammingLanguage);
	}

	public String language(String language) {
		return getStringByKey(language);
	}

	private String getStringByKey(String key) {
		try {
			return resource.getString(key);
		} catch (Exception e) {
			return "!"+key;
		}
	}
}

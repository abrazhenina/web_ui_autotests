package data;

import com.google.gson.JsonObject;

public class TestData {
	private String gameTagInput;
	private String heroDropdownTag;
	private String advOptSearchInput;
	private String allGamesDropdownGameName;
	private String dota2OptHeroDropdownOption;
	private String dota2RarityOption;
	private String searchCommunityMarketInputValue;
	private int marketPageSlotNum;

	public TestData (JsonObject testData) {
		gameTagInput = testData.get("gameTagInput").getAsString();
		heroDropdownTag = testData.get("heroDropdownTag").getAsString();
		allGamesDropdownGameName = testData.get("allGamesDropdownGameName").getAsString();
		dota2OptHeroDropdownOption = testData.get("dota2OptHeroDropdownOption").getAsString();
		dota2RarityOption = testData.get("dota2RarityOption").getAsString();
		searchCommunityMarketInputValue = testData.get("searchCommunityMarketInputValue").getAsString();
		marketPageSlotNum = testData.get("marketPageSlotNum").getAsInt();
	}

	public String getGameTagInput() {
		return gameTagInput;
	}

	public String getHeroDropdownTag() {
		return heroDropdownTag;
	}
	public String getAdvOptSearchInput() {
		return advOptSearchInput;
	}
	public String getAllGamesDropdownGameName() {
		return allGamesDropdownGameName;
	}
	public String getDota2OptHeroDropdownOption() {
		return dota2OptHeroDropdownOption;
	}
	public String getDota2RarityOption() {
		return dota2RarityOption;
	}
	public String getSearchCommunityMarketInputValue() {
		return searchCommunityMarketInputValue;
	}
	public int getMarketPageSlotNum() {
		return marketPageSlotNum;
	}
}
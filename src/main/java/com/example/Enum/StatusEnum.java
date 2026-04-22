package com.example.Enum;

/**
 * 進捗状況のENUM宣言
 */
public enum StatusEnum {
	NOT_STARTED("未着手"),
	IN_PROGRESS("進行中"),
	ON_HOLD("保留"),
	DONE("完了");
	
	/**
	 * 日本語表記
	 */
	private final String label;

	StatusEnum(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
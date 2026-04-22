package com.example.Enum;

/**
 * タスク重要度ENUMマスタ
 */
public enum PriorityEnum {
	HIGH("高"),
	MEDIUM("中"),
	LOW("低");
	
	/**
	 * 日本語表記
	 */
	private final String label;

	PriorityEnum(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
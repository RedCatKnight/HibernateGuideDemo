package com.yunfeic.test.entity;

public class Dict implements java.io.Serializable{
	private String dictId;				//字典ID
	private String dictType;			//类别
	private String dictItem;			//条目
	private String dictValue;			//值
	private String dictIsEditable;		//是否可编辑
	
	public Dict(String dictType, String dictItem, String dictValue,
			String dictIsEditable) {
		super();
		this.dictType = dictType;
		this.dictItem = dictItem;
		this.dictValue = dictValue;
		this.dictIsEditable = dictIsEditable;
	}
	
	public Dict(){
		
	}
	
	public String getDictId() {
		return dictId;
	}

	public void setDictId(String dictId) {
		this.dictId = dictId;
	}

	public String getDictType() {
		return dictType;
	}

	public void setDictType(String dictType) {
		this.dictType = dictType;
	}

	public String getDictItem() {
		return dictItem;
	}

	public void setDictItem(String dictItem) {
		this.dictItem = dictItem;
	}

	public String getDictValue() {
		return dictValue;
	}

	public void setDictValue(String dictValue) {
		this.dictValue = dictValue;
	}

	public String getDictIsEditable() {
		return dictIsEditable;
	}

	public void setDictIsEditable(String dictIsEditable) {
		this.dictIsEditable = dictIsEditable;
	}

	
}

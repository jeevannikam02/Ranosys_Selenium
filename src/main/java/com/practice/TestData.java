package com.practice;

public class TestData {

	private String Test_Step;
	private String Fieldname;
	private String Value;
	private String TypofInput;
	private String Compare_Lable;

	public TestData(String Test_Step, String Fieldname, String Value, String TypofInput, String Compare_Lable){
		this.Test_Step = Test_Step;
		this.Fieldname = Fieldname;
		this.Value = Value;
		this.TypofInput = TypofInput;
		this.Compare_Lable = Compare_Lable;
	}

	public String getTest_Step() {
		return Test_Step;
	}

	public void setTest_Step(String test_Step) {
		Test_Step = test_Step;
	}

	public String getFieldname() {
		return Fieldname;
	}

	public void setFieldname(String fieldname) {
		Fieldname = fieldname;
	}

	public String getValue() {
		return Value;
	}

	public void setValue(String value) {
		Value = value;
	}

	public String getTypofInput() {
		return TypofInput;
	}

	public void setTypofInput(String typofInput) {
		TypofInput = typofInput;
	}

	public String getCompare_Lable() {
		return Compare_Lable;
	}

	public void setCompare_Lable(String compare_Lable) {
		Compare_Lable = compare_Lable;
	}

	@Override
	public String toString() {
		return Test_Step + "\n" + Fieldname + "\n" + Value + "\n" + TypofInput + "\n" + Compare_Lable +"\n";
	}
}

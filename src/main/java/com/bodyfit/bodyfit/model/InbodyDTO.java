package com.bodyfit.bodyfit.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InbodyDTO {
	/*인바디 검사 날짜*/
	private LocalDateTime inbodyDate;
	/*사용자 이메일*/
	private String email;
	/*성별*/
	private String gender;
	/*나이*/
	private int age;
	/*키*/
	private double height;
	/*몸무게*/
	private double weight;
	/*현재 체지방률*/
	private double currentFatRate;
	/*목표 체지방률*/
	private double targetFatRate;
	/*다이어트 타입 A,B,C,D*/
	private String dietType;
	/*BMI*/
	private double bmi;
	/*비만도*/
	private double obesity;
	/*골격근량*/
	private double skeletalMuscle;
	/*기초대사량*/
	private double bmr;
	/*권장칼로리*/
	private double targetCalory;
	/*활동대사량*/
	private double amr;
	/*목표기간*/	
	private int period;
	/*평소 운동량*/
	private String exercise;
	
}

package com.sample;

public class userChoice {

	 public enum Choice {
		 Schizo, Anxious, Depressed
	   }
	 
	 public enum Question {
	      Q1, Q2, Q3
	   }
	   
	   private Choice mentalDisorder;
	   private Question typeOfQuestion;
	 
	   
	   public Choice getmentalDisorder() {
		      return mentalDisorder;
		   }
	   
	   public void setmentalDisorder(Choice mentalDisorder) {
	      this.mentalDisorder = mentalDisorder;
	   }
	   
	   public Question getTypeofQuestion() {
		      return typeOfQuestion;
		   }
		   
		   public void setTypeOfQuestion(Question typeOfQuestion) {
		      this.typeOfQuestion = typeOfQuestion;
		   }
	   
	   }
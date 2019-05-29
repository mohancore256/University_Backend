package com.university.studentmicroservice.model;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CARD_ID")
    private Long CardId;

    @Column(name = "CARD_TYPE")
    private String cardType;

    @Column(name = "CARD_COMPANY")
    private String cardCompany;

    @Column(name = "Name_OnCard")
    private String nameOnCard;

    @Column(name = "CARD_NUMBER")
    private Long cardNumber;

    @Column(name = "CARD_EXPIREDATE")
    @JsonFormat(pattern = "MM-dd-yyyy")
    private Date expireDate;

    @Column(name = "CARD_PIN")
    private Integer cardPin;
    
    @ManyToOne
    @JoinColumn
    private Student student;

	public Long getCardId() {
		return CardId;
	}

	public void setCardId(Long cardId) {
		CardId = cardId;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardCompany() {
		return cardCompany;
	}

	public void setCardCompany(String cardCompany) {
		this.cardCompany = cardCompany;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public Long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public Integer getCardPin() {
		return cardPin;
	}

	public void setCardPin(Integer cardPin) {
		this.cardPin = cardPin;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
    
    

}

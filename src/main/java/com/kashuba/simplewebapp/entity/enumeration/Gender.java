package com.kashuba.simplewebapp.entity.enumeration;

public enum Gender {
  MALE("MALE"),
  FEMALE("FEMALE");

  private final String title;

  Gender(String title) {
    this.title = title;
  }
}
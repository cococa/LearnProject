package com.cocoa.pattern.observer.demo3;

public interface Observable{

	void addObserver(Observer observer);

	void deleteObserver(Observer observer);

	void notifyObserver(String context);
}